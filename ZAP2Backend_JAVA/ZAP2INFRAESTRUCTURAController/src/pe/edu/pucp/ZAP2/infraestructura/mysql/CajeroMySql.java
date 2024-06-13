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
import pe.edu.pucp.ZAP2.infraestructura.model.Area;
import pe.edu.pucp.ZAP2.infraestructura.model.Supervisor;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoContrato;
import pe.edu.pucp.ZAP2.infraestructura.model.TurnosHorario;
import pe.edu.pucp.ZAP2.personas.model.TipoDocumento;
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
            cs = con.prepareCall("{call  ELIMINAR_PERSONA(?)}");
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
        ArrayList<Cajero> cajeros =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_CAJERO"
                    +"( )}");
            rs = cs.executeQuery();
            while(rs.next()){
                Cajero cajero = new Cajero();
                
                cajero.setId_Persona(rs.getInt("id_persona"));
                cajero.setNombre(rs.getString("nombre"));
                cajero.setIdEmpleado(rs.getInt("id_persona"));
                
                cajero.setApellido_paterno(rs.getString("apellido_paterno"));
                cajero.setApellido_materno(rs.getString("apellido_materno"));
                cajero.setSexo(rs.getString("sexo").charAt(0));
                cajero.setSalario(rs.getDouble("salario"));
                
                Supervisor supervisor = new Supervisor();
                supervisor.setIdEmpleado(rs.getInt("fid_supervisor"));
                supervisor.setId_Persona(rs.getInt("fid_supervisor"));
                cajero.setNumeroCaja(rs.getInt("numeroCaja"));
                
                cajeros.add(cajero);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return cajeros;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cajero buscar(int id) {
        Cajero cajero = null;
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call BUSCAR_CAJERO_X_ID"
                    +"(?)}");
            cs.setInt("_id", id);
            rs = cs.executeQuery();
            cajero = new Cajero();
                
            while(rs.next()){
                 
                cajero.setId_Persona(rs.getInt("id_persona"));
                cajero.setNombre(rs.getString("nombre"));
                cajero.setIdEmpleado(rs.getInt("id_persona"));
                
                cajero.setApellido_paterno(rs.getString("apellido_paterno"));
                cajero.setApellido_materno(rs.getString("apellido_materno"));
                cajero.setSexo(rs.getString("sexo").charAt(0));
                cajero.setSalario(rs.getDouble("salario"));
                
                Supervisor supervisor = new Supervisor();
                supervisor.setIdEmpleado(rs.getInt("fid_supervisor"));
                supervisor.setId_Persona(rs.getInt("fid_supervisor"));
                cajero.setNumeroCaja(rs.getInt("numeroCaja"));
                
                
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return cajero;
    }
    
}
