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
import pe.edu.pucp.ZAP2.infraestructura.model.ProductoPrecio;

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
            cs = con.prepareCall("{call  (?)}");
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
