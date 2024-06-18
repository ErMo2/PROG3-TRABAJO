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
import pe.edu.pucp.ZAP2.infraestructura.model.PersonaNatural;

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
        }catch(SQLException ex){
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
    public int eliminar(int idCuenta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_CUENTAUSUARIO(?)}");
            cs.setInt("_id_cuentaUsuario",idCuenta);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<CuentaUsuario> listarTodas() {
        ArrayList<CuentaUsuario> cuentas =  new ArrayList<>();
        try{
            
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_CUENTAUSUARIO( )}");
            rs = cs.executeQuery();
            while(rs.next()){
                CuentaUsuario cuentaUsu = new CuentaUsuario();
                cuentaUsu.setIdCuenta(rs.getInt("id_cuentaUsuario"));
                cuentaUsu.setUsuario(rs.getString("usuario"));
                cuentaUsu.setContrasena(rs.getString("contraseña"));
                PersonaNatural persNat = new PersonaNatural();
                persNat.setId_Persona(rs.getInt("id_personaNatural"));
                persNat.setNombre(rs.getString("nombre"));
                persNat.setApellido_paterno(rs.getString("apellido_paterno"));
                cuentaUsu.setPersonaNatural(persNat);
                cuentas.add(cuentaUsu);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return cuentas;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int verificar(String usuario, String pass) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call VERIFICAR_USUARIO"
                    +"(?,?,?)}");
            cs.registerOutParameter("_fid_personaNatural", java.sql.Types.INTEGER);
            
            cs.setString("_usuario", usuario);
            cs.setString("_contrasena", pass);
            cs.executeUpdate();
            resultado= cs.getInt("_fid_personaNatural");
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}            
        }
       
        return resultado; 
    
    }
    
}
