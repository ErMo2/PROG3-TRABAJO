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
import pe.edu.pucp.ZAP2.infraestructura.dao.SucursalDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Sucursal;
import java.sql.SQLException;

/**
 *
 * @author Alejandro
 */
public class SucursalMySql implements SucursalDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public int insertar(Sucursal sucursal) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_SUCURSAL"
                    +"(?,?,?,?)}");
            cs.registerOutParameter("_id_sucursal", java.sql.Types.INTEGER);
            cs.setString("_nombre", sucursal.getNombre());
            cs.setString("_direccion", sucursal.getDireccion());
            cs.setDouble("_tam_metros", sucursal.getTam_metros());
            resultado = cs.executeUpdate();
            sucursal.setId_sucursal(cs.getInt("_id_sucursal"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Sucursal sucursal) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_SUCURSAL (?,?,?,?)}");
            cs.setInt("_id_sucursal",sucursal.getId_sucursal());
            cs.setString("_nombre", sucursal.getNombre());
            cs.setString("_direccion", sucursal.getDireccion());
            cs.setDouble("_tam_metros", sucursal.getTam_metros());
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idSucursal) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_CLIENTE (?)}");
            cs.setInt("_id_sucursal",idSucursal);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<Sucursal> listarTodas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
