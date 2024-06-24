/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.infraestructura.dao.AreaDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Area;
import pe.edu.pucp.ZAP2.infraestructura.model.Producto;
import pe.edu.pucp.ZAP2.infraestructura.model.ProductoPrecio;
import pe.edu.pucp.ZAP2.infraestructura.model.Sucursal;

/**
 *
 * @author Alejandro
 */
public class AreaMySql implements AreaDao{
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public int insertar(Area area) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_AREA"
                    +"(?,?,?)}");
            cs.registerOutParameter("_id_area", java.sql.Types.INTEGER);
            cs.setString("_nombre", area.getNombre());
            cs.setInt("_fid_sucursal",area.getSucursal().getId_sucursal());   
            resultado = cs.executeUpdate();
            area.setIdArea(cs.getInt("_id_area"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }
    
    @Override
    public int modificar(Area area) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_AREA (?,?,?)}");
            cs.setInt("_id_area",area.getIdArea());
            cs.setInt("_fid_sucursal",area.getSucursal().getId_sucursal());
            cs.setString("_nombre",area.getNombre());
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idArea) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_AREA(?)}");
            cs.setInt("_id_area",idArea);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<Area> listarTodas() {
        ArrayList<Area> areas =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_AREA"
                    +"( )}");
            
            rs = cs.executeQuery();
            while(rs.next()){
                Area area = new Area();
                Sucursal sucursal = new Sucursal();
                area.setIdArea(rs.getInt("id_area"));
                sucursal.setId_sucursal(rs.getInt("fid_sucursal"));
                area.setSucursal(sucursal);
                area.setNombre(rs.getString("nombre"));
                
                areas.add(area);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return areas;
    }

    @Override
    public Area buscar(int id) {
        Area area = null;
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call BUSCAR_AREA_X_ID"
                    +"(?)}");
            cs.setInt("_id", id);
            rs = cs.executeQuery();
            area = new Area();
            while(rs.next()){
                
                Sucursal sucursal = new Sucursal();
                area.setIdArea(rs.getInt("id_area"));
                sucursal.setId_sucursal(rs.getInt("fid_sucursal"));
                area.setSucursal(sucursal);
                area.setNombre(rs.getString("nombre"));
                
                
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }    
        return area;
    }

    @Override
    public ArrayList<Area> listarTodaDeConSucursal() {
        ArrayList<Area> areas =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_SUCURSALES_MAS_AREAS"
                    +"( )}");
            
            rs = cs.executeQuery();
            while(rs.next()){
                Area area = new Area();
                Sucursal sucursal = new Sucursal();
                area.setIdArea(rs.getInt("id_area"));
                sucursal.setId_sucursal(rs.getInt("id_sucursal"));
                area.setSucursal(sucursal);
                area.setNombre(rs.getString("nombre_Area"));
                
                areas.add(area);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return areas;
    }

    @Override
    public int insertProductoArea(int idarea, int idproducto) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_AREA_PRODUCTO"
                    +"(?,?,?)}");
            cs.registerOutParameter("_id_Out", java.sql.Types.INTEGER);
            cs.setInt("_id_Producto", idproducto);
            cs.setInt("_id_Area",idarea);   
            cs.executeUpdate();           
            resultado = cs.getInt("_id_Out");           
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    
    }

    @Override
    public int eliminarAreaProducto(int idAreaProducto) {
        
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_AREA_PRODUCTO(?)}");
            cs.setInt("_id_AP",idAreaProducto);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public Area ListarProductosDelArea(int idArea) {
        Area area = null;
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_PRODUCTO_AREA"
                    +"(?)}");
            cs.setInt("id_Area", idArea);
            rs = cs.executeQuery();
            area = new Area();
            ArrayList<Producto> productos = new ArrayList();
            while(rs.next()){
                Producto producto = new Producto();
                producto.setIdAreaProducto(rs.getInt("fid_producto"));
                producto.setIdAreaProducto(rs.getInt("id_area_producto"));
                producto.setNombre(rs.getString("Nombre_Descrip"));
                ProductoPrecio productoPrecio = new  ProductoPrecio();
                productoPrecio.setPrecio(rs.getDouble("precio"));
                producto.setProdPrecio(productoPrecio);
                productos.add(producto);
                area.setNombre(rs.getString("nombre"));
            }
            
            area.setProductos(productos);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }    
        
        return area;
    
    }

    @Override
    public Sucursal buscarSucursalPorElIdArea(int idArea) {
        Sucursal sucursal = null;
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call REGRESAR_SUCURSAL_DE_UN_AREA"
                    +"(?)}");
            cs.setInt("_id_Area", idArea);
            rs = cs.executeQuery();
            sucursal = new Sucursal();
            
            while(rs.next()){
                sucursal.setId_sucursal(rs.getInt("id_sucursal"));
                sucursal.setDireccion(rs.getString("direccion"));
                sucursal.setNombre(rs.getString("nombre"));
                sucursal.setTam_metros(rs.getDouble("tam_metros"));
            }
            
           
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }    
        
        return sucursal;
    }

    
}
