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
import pe.edu.pucp.ZAP2.infraestructura.dao.CajeroDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Cajero;
import java.sql.Date;
import java.sql.SQLException;
/**
 *
 * @author Alejandro
 */
public class CajeroMySql implements CajeroDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    
    @Override
    public int insertar(Cajero cajero) {
        
        int resultado=0;
        try{
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call INSERTAR_CAJERO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_cajero", java.sql.Types.INTEGER);
            
            cs.setString("_nombre",cajero.getNombre());
            cs.setString("_apellido_paterno",cajero.getApellido_paterno());
            cs.setString("_apellido_materno",cajero.getApellido_materno());
            cs.setInt("_telefono",cajero.getTelefono());
            cs.setString("_email",cajero.getEmail());
            cs.setString("_tipoDocumento",cajero.getTipo_documento().toString());
            cs.setInt("_numDocumento",cajero.getNro_documento());
            
            cs.setString("_sexo", String.valueOf(cajero.getSexo()));
            cs.setString("_direccion",cajero.getDireccion());
            
            cs.setInt("_fid_area",cajero.getArea().getIdArea());
            cs.setDouble("_salario",cajero.getSalario());
            java.sql.Date sqlDate = new java.sql.Date(cajero.getFechaContratacion().getTime());
            cs.setDate("_fechaContratacion",sqlDate);
            cs.setString("_tipoContrato",cajero.getTipoContrato().toString());
            cs.setString("_horario",cajero.getHorario().toString());
            
            cs.setInt("_fid_supervisor",cajero.getSupervisor().getIdEmpleado());
            cs.setInt("_numeroCaja",cajero.getNumeroCaja());
            cs.setDouble("_cantidadCaja",cajero.getCantidadCaja());
            
            resultado = cs.executeUpdate();
            
            cajero.setIdEmpleado(cs.getInt("_id_cajero"));
            cajero.setId_Persona(cs.getInt("_id_cajero"));
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
             try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}  
        }
        return resultado;
        
    }

    @Override
    public int modificar(Cajero cajero) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_CAJERO (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("_id_persona",cajero.getId_Persona());
            cs.setString("_nombre",cajero.getNombre());
            cs.setString("_apellido_paterno",cajero.getApellido_paterno());
            cs.setString("_apellido_materno",cajero.getApellido_materno());
            cs.setString("_telefono",Integer.toString(cajero.getTelefono()));
            cs.setString("_email",cajero.getEmail());
            cs.setString("_tipoDocumento",cajero.getTipo_documento().toString());
            cs.setString("_numDocumento",Integer.toString(cajero.getNro_documento()));
            cs.setString("_sexo",String.valueOf(cajero.getSexo()));
            cs.setString("_direccion",cajero.getDireccion());
            cs.setInt("_fid_area",cajero.getArea().getIdArea());
            cs.setDouble("_salario",cajero.getSalario());
            cs.setDate("_fechaContratacion",new java.sql.Date(cajero.getFechaContratacion().getTime()));
            cs.setString("_tipoContrato",cajero.getTipoContrato().toString());
            cs.setString("_horario",cajero.getHorario().toString());
            cs.setInt("_fid_supervisor",cajero.getSupervisor().getIdEmpleado());
            cs.setInt("_numeroCaja",cajero.getNumeroCaja());
            cs.setDouble("_cantidadCaja",cajero.getCantidadCaja());
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idCajero) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  (?)}");
            cs.setInt("_id_persona",idCajero);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<Cajero> listarTodas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
