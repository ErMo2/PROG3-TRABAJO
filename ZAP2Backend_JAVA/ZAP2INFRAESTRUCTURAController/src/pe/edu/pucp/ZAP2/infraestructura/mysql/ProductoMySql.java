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
import java.util.Date;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.infraestructura.dao.ProductoDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Producto;
import pe.edu.pucp.ZAP2.infraestructura.model.ProductoPrecio;
import pe.edu.pucp.ZAP2.infraestructura.model.Descuento;
/**
 *
 * @author Alejandro
 */
public class ProductoMySql implements ProductoDao{
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;

    @Override
    public ArrayList<Producto> listarProductosConDescuento() {
        ArrayList<Producto> prodConDescuento =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_PRODUCTOS_CON_DESCUENTO"
                    +"()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Producto prod = new Producto();
                prod.setIdProducto(rs.getInt("id_producto"));
                prod.setNombre(rs.getString("nombre"));
                prod.setDescripcion(rs.getString("descripcion"));
                ProductoPrecio prodPre = new ProductoPrecio();
                prodPre.setPrecio(rs.getDouble("precio"));
                
                Descuento desc = new Descuento();
                desc.setDescuentoAplicado(rs.getDouble("descuentoAplicado"));
                Date fechaIni = rs.getDate("fechaInicial");
                Date fechaFin = rs.getDate("fechaFinal");
                desc.setFechaInicial(fechaIni);
                desc.setFechaFinal(fechaFin);
                
                prodPre.setDescuento(desc);
                prod.setProdPrecio(prodPre);
                prodConDescuento.add(prod);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return prodConDescuento;
    }

    @Override
    public ArrayList<Producto> listarProductosConDescuentoEnFecha() {
        ArrayList<Producto> prodConDescuento =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_PRODUCTOS_CON_DESCUENTO_ACTIVO"
                    +"()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Producto prod = new Producto();
                prod.setIdProducto(rs.getInt("id_producto"));
                prod.setNombre(rs.getString("nombre"));
                prod.setDescripcion(rs.getString("descripcion"));
                ProductoPrecio prodPre = new ProductoPrecio();
                prodPre.setPrecio(rs.getDouble("precio"));
               
                Descuento desc = new Descuento();
                desc.setDescuentoAplicado(rs.getDouble("descuentoAplicado"));
                desc.setIdDescuento(rs.getInt("id_descuento"));
                Date fechaIni = rs.getDate("fechaInicial");
                Date fechaFin = rs.getDate("fechaFinal");
                desc.setFechaInicial(fechaIni);
                desc.setFechaFinal(fechaFin);
                
                prodPre.setDescuento(desc);
                prod.setProdPrecio(prodPre);
                prodConDescuento.add(prod);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return prodConDescuento;
    }

    @Override
    public ArrayList<Producto> listarDescuentoDeUnProducto(int idProducto) {
        ArrayList<Producto> prodConDescuento =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_DESCUENTOS_DE_UN_PRODUCTO"
                    +"(?)}");
            cs.setInt("_id_producto", idProducto);
            rs = cs.executeQuery();
            while(rs.next()){
                Producto prod = new Producto();
                prod.setIdProducto(rs.getInt("id_producto"));
                prod.setNombre(rs.getString("nombre"));
                prod.setDescripcion(rs.getString("descripcion"));
                ProductoPrecio prodPre = new ProductoPrecio();
                prodPre.setPrecio(rs.getDouble("precio"));
               
                Descuento desc = new Descuento();
                desc.setDescuentoAplicado(rs.getDouble("descuentoAplicado"));
                desc.setIdDescuento(rs.getInt("id_descuento"));
                Date fechaIni = rs.getDate("fechaInicial");
                Date fechaFin = rs.getDate("fechaFinal");
                desc.setFechaInicial(fechaIni);
                desc.setFechaFinal(fechaFin);
                
                prodPre.setDescuento(desc);
                prod.setProdPrecio(prodPre);
                prodConDescuento.add(prod);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return prodConDescuento;
    }

    @Override
    public ArrayList<Producto> listarProductosMasConsumidos() {
        ArrayList<Producto> prodMasConsumidos =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call RF_PRODUCTOS_MAS_CONSUMIDOS"
                    +"( )}");
            rs = cs.executeQuery();
            while(rs.next()){
                Producto prod = new Producto();
                prod.setIdProducto(rs.getInt("id_producto"));
                prod.setNombre(rs.getString("nombre"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setCantidadComprada(rs.getInt("cantidadComprada"));
                
                prodMasConsumidos.add(prod);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return prodMasConsumidos;
    }

    @Override
    public ArrayList<Producto> listarProductos() {
        
        ArrayList<Producto> prodMasConsumidos =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_PRODUCTOS"
                    +"( )}");
            rs = cs.executeQuery();
            while(rs.next()){
                Producto prod = new Producto();
                prod.setIdProducto(rs.getInt("id_producto"));
                prod.setNombre(rs.getString("nombre"));
                prod.setDescripcion(rs.getString("descripcion"));
                
                
                prodMasConsumidos.add(prod);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return prodMasConsumidos;
    }

    @Override
    public ArrayList<Producto> listarProductosPorNombre(String nombre) {
        ArrayList<Producto> prodMasConsumidos =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_PRODUCTOS_NOMBRE"
                    +"(?)}");
            cs.setString("_nombre", nombre);
            rs = cs.executeQuery();
            while(rs.next()){
                Producto prod = new Producto();
                prod.setIdProducto(rs.getInt("id_producto"));
                prod.setNombre(rs.getString("nombre"));
                prod.setDescripcion(rs.getString("descripcion"));
                
                
                prodMasConsumidos.add(prod);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return prodMasConsumidos;
    
    }
    
    
}