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
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.infraestructura.dao.CuentaUsuarioDao;
import pe.edu.pucp.ZAP2.infraestructura.model.CuentaUsuario;
import java.sql.SQLException;

/**
 *
 * @author Alejandro
 */
public class CuentaUsuarioMySql implements CuentaUsuarioDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public int insertar(CuentaUsuario cuenta) {
         int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_CUENTAUSUARIO"
                    +"(?,?,?,?)}");
            cs.registerOutParameter("_id_cuentaUsuario", java.sql.Types.INTEGER);
            cs.setInt("_fid_personaNatural", cuenta.getPersonaNatural().getId_Persona());
            cs.setString("_usuario", cuenta.getUsuario());
            cs.setString("_contraseña", cuenta.getContrasena());
            resultado = cs.executeUpdate();
            cuenta.setIdCuenta(cs.getInt("_id_cuentaUsuario"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}            
        }
       
        return resultado; 
    }

    @Override
    public int modificar(CuentaUsuario cuenta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_CUENTAUSUARIO (?,?,?,?)}");
            cs.setInt("_id_cuentaUsuario", cuenta.getIdCuenta());
            cs.setInt("_fid_personaNatural", cuenta.getPersonaNatural().getId_Persona());
            cs.setString("_usuario", cuenta.getUsuario());
            cs.setString("_contraseña", cuenta.getContrasena());
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int Cuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<CuentaUsuario> listarTodas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
