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
import pe.edu.pucp.ZAP2.infraestructura.model.Area;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoContrato;
import pe.edu.pucp.ZAP2.infraestructura.model.TurnosHorario;
import pe.edu.pucp.ZAP2.personas.model.TipoDocumento;
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
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_PERSONA(?)}");
            cs.setInt("_id_persona",idSupervisor);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<Supervisor> listarTodas() {
        ArrayList<Supervisor> supervisores =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_SUPERVISOR"
                    +"( )}");
            rs = cs.executeQuery();
            while(rs.next()){
                Supervisor supervisor = new Supervisor();
                supervisor.setId_Persona(rs.getInt("id_persona"));
                supervisor.setIdEmpleado(rs.getInt("id_persona"));
                supervisor.setNombre(rs.getString("nombre"));
                supervisor.setApellido_paterno(rs.getString("apellido_paterno"));
                supervisor.setApellido_materno(rs.getString("apellido_materno"));
                supervisor.setTelefono(rs.getInt("telefono"));
                supervisor.setEmail(rs.getString("email"));
                String aux = rs.getString("tipoDocumento");
                TipoDocumento doc = TipoDocumento.valueOf(aux);
                supervisor.setTipo_documento(doc);
                supervisor.setNro_documento(rs.getInt("numDocumento"));
                supervisor.setSexo(rs.getString("sexo").charAt(0));
                supervisor.setDireccion(rs.getString("direccion"));
                supervisor.setSalario(rs.getDouble("salario"));
                supervisor.setFechaContratacion(rs.getDate("fechaContratacion"));
                String aux2 = rs.getString("tipoContrato");
                TipoContrato tipCont = TipoContrato.valueOf(aux2);
                supervisor.setTipoContrato(tipCont);
                String aux3 = rs.getString("horario");
                TurnosHorario horario = TurnosHorario.valueOf(aux3);
                supervisor.setHorario(horario);
                supervisor.setNumempleados(rs.getInt("num_empleados"));
                Area area = new Area();
                //area.setIdArea(rs.getInt("fid_area"));
                supervisor.setArea(area);
                
                supervisores.add(supervisor);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return supervisores;

        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
