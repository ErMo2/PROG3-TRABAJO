/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.infraestructura.dao.ProductoPerecibleDao;
import pe.edu.pucp.ZAP2.infraestructura.model.ProductoPerecible;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoProductoPerecible;
import pe.edu.pucp.ZAP2.infraestructura.model.UnidadDeMedida;

/**
 *
 * @author User
 */
public class ProductoPerecibleMySql implements ProductoPerecibleDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public int insertar(ProductoPerecible productoPerecible) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_PRODUCTOPERECIBLE"
                    +"(?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_productoPerecible", java.sql.Types.INTEGER);
            cs.setString("_nombre",productoPerecible.getNombre());
            cs.setString("_descripcion", productoPerecible.getDescripcion());
            Date fecha1 = new Date(productoPerecible.getFechVencimiento().getTime());
            cs.setDate("_fechaVencimiento", fecha1);
            cs.setString("_tipo_producto_perecible", productoPerecible.getTipo_producto_perecible().toString());
            cs.setString("_unidad_de_medida", productoPerecible.getUnidad_de_medida().toString());
            resultado = cs.executeUpdate();
            productoPerecible.setIdProducto(cs.getInt("_id_productoPerecible"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(ProductoPerecible productoPerecible) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_PRODUCTO_PERECIBLE"
                    +"(?,?,?,?,?,?)}");
            cs.setInt("_id_productoPerecible", productoPerecible.getIdProducto());
            cs.setString("_nombre",productoPerecible.getNombre());
            cs.setString("_descripcion", productoPerecible.getDescripcion());
            Date fecha1 = new Date(productoPerecible.getFechVencimiento().getTime());
            cs.setDate("_fechaVencimiento", fecha1);
            cs.setString("_tipo_producto_perecible", productoPerecible.getTipo_producto_perecible().toString());
            cs.setString("_unidad_de_medida", productoPerecible.getUnidad_de_medida().toString());
            resultado = cs.executeUpdate();
            productoPerecible.setIdProducto(cs.getInt("_id_productoPerecible"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idProdPere) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_PRODUCTO(?)}");
            cs.setInt("_id_productoPerecible",idProdPere);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<ProductoPerecible> listarTodos() {
        ArrayList<ProductoPerecible> Productos =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_PRODUCTOS_PERECIBLES"
                    +"( )}");
            
            rs = cs.executeQuery();
            while(rs.next()){
                ProductoPerecible producto = new ProductoPerecible();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion")); 
                
                Date fechaVencimiento = rs.getDate("fechaVencimiento");
                producto.setFechVencimiento(fechaVencimiento);
                
                // Reemplaza TipoProductoPerecible con el nombre de tu enum
                TipoProductoPerecible tipoProductoPerecible = TipoProductoPerecible.valueOf(rs.getString("tipo_producto_perecible"));
                producto.setTipo_producto_perecible(tipoProductoPerecible);
                
                
                // Reemplaza UnidadMedida con el nombre de tu enum
                UnidadDeMedida unidadMedida = UnidadDeMedida.valueOf(rs.getString("unidad_de_medida"));
                producto.setUnidad_de_medida(unidadMedida);
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
    public ProductoPerecible buscarProducto(int idProdPere) {
        ProductoPerecible producto = null;
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call BUSCAR_PRODUCTO_PERECIBLE_X_ID"
                    +"(?)}");
            cs.setInt("_id_producto", idProdPere);
            rs = cs.executeQuery();
            producto = new ProductoPerecible();
            while(rs.next()){
                
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion")); 
                
                Date fechaVencimiento = rs.getDate("fechaVencimiento");
                producto.setFechVencimiento(fechaVencimiento);
                
                // Reemplaza TipoProductoPerecible con el nombre de tu enum
                TipoProductoPerecible tipoProductoPerecible = TipoProductoPerecible.valueOf(rs.getString("tipo_producto_perecible"));
                producto.setTipo_producto_perecible(tipoProductoPerecible);
                
                
                // Reemplaza UnidadMedida con el nombre de tu enum
                UnidadDeMedida unidadMedida = UnidadDeMedida.valueOf(rs.getString("unidad_de_medida"));
                producto.setUnidad_de_medida(unidadMedida);
                
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
