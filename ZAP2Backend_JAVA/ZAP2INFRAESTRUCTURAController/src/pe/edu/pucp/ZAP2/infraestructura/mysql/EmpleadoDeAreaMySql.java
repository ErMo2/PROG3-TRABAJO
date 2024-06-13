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
import pe.edu.pucp.ZAP2.infraestructura.model.Area;
import pe.edu.pucp.ZAP2.infraestructura.model.Supervisor;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoContrato;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoPuesto;
import pe.edu.pucp.ZAP2.infraestructura.model.TurnosHorario;
import pe.edu.pucp.ZAP2.personas.model.TipoDocumento;

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
        }catch(SQLException ex){
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
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_PERSONA(?)}");
            cs.setInt("_id_persona",idEmpleadoDeArea);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<EmpleadoDeArea> listarTodas() {
        ArrayList<EmpleadoDeArea> empleados =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_EMPLEADODEAREA"
                    +"( )}");
            rs = cs.executeQuery();
            while(rs.next()){
                EmpleadoDeArea empleado = new EmpleadoDeArea();
                
                empleado.setId_Persona(rs.getInt("id_persona"));
                empleado.setIdEmpleado(rs.getInt("id_persona"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido_paterno(rs.getString("apellido_paterno"));
                empleado.setApellido_materno(rs.getString("apellido_materno"));
                empleado.setTelefono(rs.getInt("telefono"));
                empleado.setEmail(rs.getString("email"));
                
                empleado.setSexo(rs.getString("sexo").charAt(0));
                empleado.setSalario(rs.getDouble("salario"));
//                empleado.setEmail(rs.getString("email"));
//                empleado.setTelefono(rs.getInt("telefono"));
                String puesto = rs.getString("puesto");
                TipoPuesto tipopuesto = TipoPuesto.valueOf(puesto);
                empleado.setPuesto(tipopuesto);
                Supervisor supervisor = new Supervisor();
                supervisor.setIdEmpleado(rs.getInt("fid_supervisor"));
                supervisor.setId_Persona(rs.getInt("fid_supervisor"));
                
                empleados.add(empleado);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return empleados;
        
    }

    @Override
    public EmpleadoDeArea buscar(int id) {
        EmpleadoDeArea empleado = null;
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call BUSCAR_EMPLEADODEAREA_X_ID"
                    +"(?)}");
            cs.setInt("_id", id);
            rs = cs.executeQuery();
            empleado = new EmpleadoDeArea();
            while(rs.next()){
                
                
                empleado.setId_Persona(rs.getInt("id_persona"));
                empleado.setIdEmpleado(rs.getInt("id_persona"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido_paterno(rs.getString("apellido_paterno"));
                empleado.setApellido_materno(rs.getString("apellido_materno"));
                empleado.setSexo(rs.getString("sexo").charAt(0));
                empleado.setSalario(rs.getDouble("salario"));
                String puesto = rs.getString("puesto");
                TipoPuesto tipopuesto = TipoPuesto.valueOf(puesto);
                empleado.setPuesto(tipopuesto);
                Supervisor supervisor = new Supervisor();
                supervisor.setIdEmpleado(rs.getInt("fid_supervisor"));
                supervisor.setId_Persona(rs.getInt("fid_supervisor"));
                
                
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return empleado;
    }
    
}
