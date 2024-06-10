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
import pe.edu.pucp.ZAP2.infraestructura.dao.EmpleadoDeAreaDao;
import pe.edu.pucp.ZAP2.infraestructura.model.EmpleadoDeArea;
import java.sql.SQLException;
/**
 *
 * @author Alejandro
 */
public class EmpleadoDeAreaMySql implements EmpleadoDeAreaDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public int insertar(EmpleadoDeArea empleadoDeArea) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_EMPLEADODEAREA"
                    +"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_empleadoDeArea", java.sql.Types.INTEGER);
            cs.setString("_nombre", empleadoDeArea.getNombre());
            cs.setString("_apellido_paterno", empleadoDeArea.getApellido_paterno());
            cs.setString("_apellido_materno", empleadoDeArea.getApellido_materno());
            cs.setInt("_telefono", empleadoDeArea.getTelefono());
            cs.setString("_email", empleadoDeArea.getEmail());
            cs.setString("_tipoDocumento", empleadoDeArea.getTipo_documento().toString());
            cs.setInt("_numDocumento", empleadoDeArea.getNro_documento());
            cs.setString("_sexo", String.valueOf(empleadoDeArea.getSexo()));
            cs.setString("_direccion", empleadoDeArea.getDireccion());
            cs.setDouble("_salario", empleadoDeArea.getSalario());
            java.sql.Date sqlDate = new java.sql.Date(empleadoDeArea.getFechaContratacion().getTime());
            cs.setDate("_fechaContratacion", sqlDate);
            cs.setString("_tipoContrato", empleadoDeArea.getTipoContrato().toString());
            cs.setString("_horario", empleadoDeArea.getHorario().toString());
            cs.setInt("_fid_supervisor",empleadoDeArea.getSupervisor().getIdEmpleado());
            cs.setInt("_fid_area",empleadoDeArea.getArea().getIdArea());
            cs.setString("_puesto",empleadoDeArea.getPuesto().toString());
            cs.executeUpdate();
            empleadoDeArea.setIdEmpleado(cs.getInt("_id_empleadoDeArea"));
            empleadoDeArea.setId_Persona(cs.getInt("_id_empleadoDeArea"));
            resultado = cs.getInt("_id_empleadoDeArea");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(EmpleadoDeArea empleadoDeArea) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_EMPLEADO_DE_AREA (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("_id_persona",empleadoDeArea.getId_Persona());
            cs.setString("_nombre", empleadoDeArea.getNombre());
            cs.setString("_apellido_paterno", empleadoDeArea.getApellido_paterno());
            cs.setString("_apellido_materno", empleadoDeArea.getApellido_materno());
            cs.setInt("_telefono", empleadoDeArea.getTelefono());
            cs.setString("_email", empleadoDeArea.getEmail());
            cs.setString("_tipoDocumento", empleadoDeArea.getTipo_documento().toString());
            cs.setInt("_numDocumento", empleadoDeArea.getNro_documento());
            cs.setString("_sexo", String.valueOf(empleadoDeArea.getSexo()));
            cs.setString("_direccion", empleadoDeArea.getDireccion());
            cs.setDouble("_salario", empleadoDeArea.getSalario());
            java.sql.Date sqlDate = new java.sql.Date(empleadoDeArea.getFechaContratacion().getTime());
            cs.setDate("_fechaContratacion", sqlDate);
            cs.setString("_tipoContrato", empleadoDeArea.getTipoContrato().toString());
            cs.setString("_horario", empleadoDeArea.getHorario().toString());
            cs.setInt("_fid_supervisor",empleadoDeArea.getSupervisor().getId_Persona());
            cs.setInt("_fid_area",empleadoDeArea.getArea().getIdArea());
            cs.setString("_puesto",empleadoDeArea.getPuesto().toString());
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idEmpleadoDeArea) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<EmpleadoDeArea> listarTodas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
