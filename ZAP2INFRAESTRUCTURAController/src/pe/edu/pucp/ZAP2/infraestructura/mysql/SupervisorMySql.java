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
import pe.edu.pucp.ZAP2.infraestructura.dao.SupervisorDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Supervisor;
import java.sql.SQLException;
/**
 *
 * @author Alejandro
 */
public class SupervisorMySql implements SupervisorDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    
    @Override
    public int insertar(Supervisor supervisor) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_SUPERVISOR"
                    +"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_supervisor", java.sql.Types.INTEGER);
                
            cs.setString("_nombre", supervisor.getNombre());
            cs.setString("_apellido_paterno", supervisor.getApellido_paterno());
            cs.setString("_apellido_materno", supervisor.getApellido_materno());
            cs.setInt("_telefono", supervisor.getTelefono());
            cs.setString("_email", supervisor.getEmail());
            cs.setString("_tipoDocumento", supervisor.getTipo_documento().toString());
            cs.setInt("_numDocumento", supervisor.getNro_documento());
            
            cs.setString("_sexo", String.valueOf(supervisor.getSexo()));
            cs.setString("_direccion",supervisor.getDireccion());
            
            cs.setInt("_fid_area",supervisor.getArea().getIdArea());
            cs.setDouble("_salario",supervisor.getSalario());
            java.sql.Date sqlDate = new java.sql.Date(supervisor.getFechaContratacion().getTime());
            cs.setDate("_fechaContratacion",sqlDate);
            cs.setString("_tipoContrato",supervisor.getTipoContrato().toString());
            cs.setString("_horario",supervisor.getHorario().toString());
            
            cs.setInt("_num_empleados", supervisor.getNumempleados());
            
            resultado = cs.executeUpdate();
            
            supervisor.setIdEmpleado(cs.getInt("_id_supervisor"));
            supervisor.setId_Persona(cs.getInt("_id_supervisor"));
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Supervisor supervisor) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_SUPERVISOR (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("_id_persona",supervisor.getId_Persona());
            cs.setString("_nombre", supervisor.getNombre());
            cs.setString("_apellido_paterno", supervisor.getApellido_paterno());
            cs.setString("_apellido_materno", supervisor.getApellido_materno());
            cs.setInt("_telefono", supervisor.getTelefono());
            cs.setString("_email", supervisor.getEmail());
            cs.setString("_tipoDocumento", supervisor.getTipo_documento().toString());
            cs.setInt("_numDocumento", supervisor.getNro_documento());
            
            cs.setString("_sexo", String.valueOf(supervisor.getSexo()));
            cs.setString("_direccion",supervisor.getDireccion());
            
            cs.setInt("_fid_area",supervisor.getArea().getIdArea());
            cs.setDouble("_salario",supervisor.getSalario());
            java.sql.Date sqlDate = new java.sql.Date(supervisor.getFechaContratacion().getTime());
            cs.setDate("_fechaContratacion",sqlDate);
            cs.setString("_tipoContrato",supervisor.getTipoContrato().toString());
            cs.setString("_horario",supervisor.getHorario().toString());
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idSupervisor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Supervisor> listarTodas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
