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
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.infraestructura.dao.ProductoPerecibleDao;
import pe.edu.pucp.ZAP2.infraestructura.model.ProductoPerecible;

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
            
            cs.setString("_nombre",productoPerecible.getNombre());
            cs.setString("_descripcion", productoPerecible.getDescripcion());
            Date fecha1 = new Date(productoPerecible.getFechVencimiento().getTime());
            cs.setDate("_fechaVencimiento", fecha1);
            cs.setString("_tipo_producto_perecible", productoPerecible.getTipo_producto_perecible().toString());
            cs.setString("_unidad_de_medida", productoPerecible.getUnidad_de_medida().toString());
            resultado = cs.executeUpdate();
            productoPerecible.setIdProducto(cs.getInt("_id_productoPerecible"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(ProductoPerecible prodPerecible) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idProdPere) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ProductoPerecible> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
