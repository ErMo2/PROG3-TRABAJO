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
import pe.edu.pucp.ZAP2.infraestructura.dao.ProductoPrecioDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Producto;
import pe.edu.pucp.ZAP2.infraestructura.model.ProductoPrecio;
import pe.edu.pucp.ZAP2.infraestructura.model.Sucursal;

/**
 *
 * @author User
 */
public class ProductoPrecioMySql implements ProductoPrecioDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public int insertar(ProductoPrecio productoPrecio) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_PRODUCTOPRECIO"
                    +"(?,?,?,?)}");
            cs.registerOutParameter("_id_producto_precio", java.sql.Types.INTEGER);
            cs.setInt("_fid_producto", productoPrecio.getProducto().getIdProducto());
            cs.setInt("_fid_sucursal", productoPrecio.getSucursal().getId_sucursal());
            cs.setDouble("_precio", productoPrecio.getPrecio());
            resultado = cs.executeUpdate();
            productoPrecio.setIdProductoPrecio(cs.getInt("_id_producto_precio"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(ProductoPrecio productoPrecio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idProductoPrecio) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_PRODUCTO_PRECIO(?)}");
            cs.setInt("_id_producto_precio",idProductoPrecio);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<ProductoPrecio> listarTodos() {
        ArrayList<ProductoPrecio> productosPrecios =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_PRODUCTOPRECIO"
                    +"( )}");
            rs = cs.executeQuery();
            while(rs.next()){
                ProductoPrecio productoPrecio = new ProductoPrecio();
                
                productoPrecio.setIdProductoPrecio(rs.getInt("id_producto_precio"));
                //PRODUCTO ASOCIADO    
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("fid_producto"));                   
                productoPrecio.setProducto(producto);
                //SUCURSAL ASOCIADO
                Sucursal sucursal = new Sucursal();
                sucursal.setId_sucursal(rs.getInt("fid_sucursal"));
                productoPrecio.setSucursal(sucursal);
                //DATOS PROPIOS
                productoPrecio.setPrecio(rs.getDouble("precio"));
                productosPrecios.add(productoPrecio);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return productosPrecios;
       
    }

    @Override
    public ArrayList<ProductoPrecio> listarPreciosProducto(int idProd) {
     
        ArrayList<ProductoPrecio> productosPrecios =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_PRODUCTO_PRECIO_PRODUCTO"
                    +"(?)}");
            cs.setInt("_fid_producto", idProd);
            rs = cs.executeQuery();
            while(rs.next()){
                ProductoPrecio productoPrecio = new ProductoPrecio();
                
                productoPrecio.setIdProductoPrecio(rs.getInt("id_producto_precio"));
                
                //SUCURSAL ASOCIADO
                Sucursal sucursal = new Sucursal();
                sucursal.setId_sucursal(rs.getInt("fid_sucursal"));
                sucursal.setNombre(rs.getString("nombre_sucursal"));
                productoPrecio.setSucursal(sucursal);
                //DATOS PROPIOS
                productoPrecio.setPrecio(rs.getDouble("precio"));
                productoPrecio.setActivo(rs.getInt("activo"));
                productosPrecios.add(productoPrecio);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return productosPrecios;
    }

    @Override
    public ArrayList<ProductoPrecio> listarPreciosProductoDeUnaSucursal(int idsucursal) {
        ArrayList<ProductoPrecio> productosPrecios =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_PRODUCTOS_DE_SUCURSAL_CON_PRECIO"
                    +"(?)}");
            cs.setInt("_id_sucursal", idsucursal);
            rs = cs.executeQuery();
            while(rs.next()){
                ProductoPrecio productoPrecio = new ProductoPrecio();
                
                productoPrecio.setIdProductoPrecio(rs.getInt("id_producto_precio"));
                
                Producto producto = new  Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                //DATOS PROPIOS
                productoPrecio.setPrecio(rs.getDouble("precio"));
                productoPrecio.setProducto(producto);
                productosPrecios.add(productoPrecio);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return productosPrecios;
    }

    
    
}
