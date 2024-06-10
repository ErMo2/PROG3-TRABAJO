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
            cs.setInt("_unidad_de_medida", productoParaElCuidadoPersonalYDelHogar.getUnidadMedida().ordinal()+1);
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
    public int modificar(ProductosParaElCuidadoPersonalYDelHogar prodParaElCuidado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idProducto) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_PRODUCTO(?)}");
            cs.setInt("_id_PCH",idProducto);
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
