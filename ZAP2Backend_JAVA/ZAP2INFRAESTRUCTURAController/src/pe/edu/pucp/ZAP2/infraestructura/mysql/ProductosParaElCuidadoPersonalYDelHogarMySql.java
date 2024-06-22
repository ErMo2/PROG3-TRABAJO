/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.infraestructura.dao.ProductosParaElCuidadoPersonalYDelHogarDao;
import pe.edu.pucp.ZAP2.infraestructura.model.ProductosParaElCuidadoPersonalYDelHogar;
import pe.edu.pucp.ZAP2.infraestructura.model.UnidadDeMedida;

/**
 *
 * @author User
 */
public class ProductosParaElCuidadoPersonalYDelHogarMySql implements ProductosParaElCuidadoPersonalYDelHogarDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public int insertar(ProductosParaElCuidadoPersonalYDelHogar productoParaElCuidadoPersonalYDelHogar) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_PCH"
                    +"(?,?,?,?,?)}");
            cs.registerOutParameter("_id_PCH", java.sql.Types.INTEGER);
            cs.setString("_nombre", productoParaElCuidadoPersonalYDelHogar.getNombre());
            cs.setString("_descripcion", productoParaElCuidadoPersonalYDelHogar.getDescripcion());
            cs.setString("_unidad_de_medida", String.valueOf(productoParaElCuidadoPersonalYDelHogar.getUnidadMedida()));
            cs.setString("_tipo", productoParaElCuidadoPersonalYDelHogar.getTipo());
            resultado = cs.executeUpdate();
            productoParaElCuidadoPersonalYDelHogar.setIdProducto(cs.getInt("_id_PCH"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(ProductosParaElCuidadoPersonalYDelHogar productoParaElCuidadoPersonalYDelHogar) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_PCH"
                    +"(?,?,?,?,?)}");
            cs.setInt("_id_producto", productoParaElCuidadoPersonalYDelHogar.getIdProducto());
            cs.setString("_nombre", productoParaElCuidadoPersonalYDelHogar.getNombre());
            cs.setString("_descripcion", productoParaElCuidadoPersonalYDelHogar.getDescripcion());
            cs.setString("_unidad_de_medida", String.valueOf(productoParaElCuidadoPersonalYDelHogar.getUnidadMedida()));
            cs.setString("_tipo", productoParaElCuidadoPersonalYDelHogar.getTipo());
            resultado = cs.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idProducto) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_PRODUCTO(?)}");
            cs.setInt("_id_producto",idProducto);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<ProductosParaElCuidadoPersonalYDelHogar> listarTodos() {
        ArrayList<ProductosParaElCuidadoPersonalYDelHogar> Productos =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_PCH"
                    +"( )}");
            
            rs = cs.executeQuery();
            while(rs.next()){
                ProductosParaElCuidadoPersonalYDelHogar producto = new ProductosParaElCuidadoPersonalYDelHogar();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion")); 
                
               
                
                String tipoUnidad = rs.getString("unidad_de_medida");
                
                UnidadDeMedida unidad = UnidadDeMedida.valueOf(tipoUnidad);
                producto.setUnidadMedida(unidad);
                
                producto.setTipo(rs.getString("tipo")); 
                Productos.add(producto);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return Productos;
        
    }

    @Override
    public ProductosParaElCuidadoPersonalYDelHogar buscarProducto(int idProd) {
        ProductosParaElCuidadoPersonalYDelHogar producto = null;
        try{
            producto = new ProductosParaElCuidadoPersonalYDelHogar();
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call BUSCAR_PRODUCTO_PCH_X_ID"
                    +"(?)}");
            cs.setInt("_id_producto", idProd);
            rs = cs.executeQuery();
            while(rs.next()){
                
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion")); 
                
               
                
                String tipoUnidad = rs.getString("unidad_de_medida");
                
                UnidadDeMedida unidad = UnidadDeMedida.valueOf(tipoUnidad);
                producto.setUnidadMedida(unidad);
                
                producto.setTipo(rs.getString("tipo")); 
                
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return producto;
    }
    
}
