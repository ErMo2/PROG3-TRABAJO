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
import pe.edu.pucp.ZAP2.infraestructura.dao.ClienteDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Cliente;
import java.sql.SQLException;
import pe.edu.pucp.ZAP2.personas.model.TipoDocumento;

/**
 *
 * @author Alejandro
 */
public class ClienteMySql implements ClienteDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public int insertar(Cliente cliente) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_CLIENTE"
                    +"(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_cliente", java.sql.Types.INTEGER);
            cs.setInt("_dni", Integer.parseInt(cliente.getDni()));   
            
            cs.setString("_sexo", String.valueOf(cliente.getSexo()));
            cs.setString("_direccion", cliente.getDireccion());
            
            cs.setString("_nombre", cliente.getNombre());
            cs.setString("_apellido_paterno", cliente.getApellido_paterno());
            cs.setString("_apellido_materno", cliente.getApellido_materno());
            cs.setString("_telefono", String.valueOf(cliente.getTelefono()));
            cs.setString("_email", cliente.getEmail());
            cs.setString("_tipoDocumento", cliente.getTipo_documento().toString());    
            cs.setString("_numDocumento", String.valueOf(cliente.getNro_documento()));
            resultado = cs.executeUpdate();
            cliente.setId_cliente(cs.getInt("_id_cliente"));
            cliente.setId_Persona(cs.getInt("_id_cliente"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Cliente cliente) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_CLIENTE (?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("_id_persona",cliente.getId_Persona());
            cs.setInt("_dni", Integer.parseInt(cliente.getDni()));   
            
            cs.setString("_sexo", String.valueOf(cliente.getSexo()));
            cs.setString("_direccion", cliente.getDireccion());
            
            cs.setString("_nombre", cliente.getNombre());
            cs.setString("_apellido_paterno", cliente.getApellido_paterno());
            cs.setString("_apellido_materno", cliente.getApellido_materno());
            cs.setString("_telefono", String.valueOf(cliente.getTelefono()));
            cs.setString("_email", cliente.getEmail());
            cs.setString("_tipoDocumento", cliente.getTipo_documento().toString());    
            cs.setString("_numDocumento", String.valueOf(cliente.getNro_documento()));
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idPersona) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_PERSONA(?)}");
            cs.setInt("_id_persona",idPersona);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<Cliente> listarTodos() {
        ArrayList<Cliente> clientes =  new ArrayList<>();
        try{
            
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_CLIENTE( )}");
            rs = cs.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_persona"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido_paterno(rs.getString("apellido_paterno"));
                cliente.setApellido_materno(rs.getString("apellido_materno"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTipo_documento(TipoDocumento.valueOf(rs.getString("tipoDocumento")));
                cliente.setNro_documento(rs.getInt("numDocumento"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setSexo(rs.getString("sexo").charAt(0));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setDni(String.valueOf(rs.getInt("dni")));
                cliente.setPuntosBonus(rs.getInt("puntosBonus"));
                clientes.add(cliente);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return clientes;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente buscar(int id) {
        Cliente cliente = null;
        try{
            
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call BUSCAR_CLIENTE_X_ID(?)}");
            cs.setInt("_id", id);
            rs = cs.executeQuery();
            cliente = new Cliente();
            while(rs.next()){
                 
                cliente.setId_cliente(rs.getInt("id_persona"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido_paterno(rs.getString("apellido_paterno"));
                cliente.setApellido_materno(rs.getString("apellido_materno"));
                
                cliente.setSexo(rs.getString("sexo").charAt(0));
                cliente.setDni(String.valueOf(rs.getInt("dni")));
                cliente.setPuntosBonus(rs.getInt("puntosBonus"));
                
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return cliente;
    }

    @Override
    public ArrayList<Cliente> listarPorNombre(String nombre) {
        
        ArrayList<Cliente> clientes =  new ArrayList<>();
        try{
            
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call RF_BUSCAR_CLIENTE_X_NOMBRE(?)}");
            cs.setString("_nombre", nombre);
            rs = cs.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_persona"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido_paterno(rs.getString("apellido_paterno"));
                cliente.setApellido_materno(rs.getString("apellido_materno"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTipo_documento(TipoDocumento.valueOf(rs.getString("tipoDocumento")));
                cliente.setNro_documento(rs.getInt("numDocumento"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setSexo(rs.getString("sexo").charAt(0));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setDni(String.valueOf(rs.getInt("dni")));
                cliente.setPuntosBonus(rs.getInt("puntosBonus"));
                clientes.add(cliente);
                
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return clientes;   
    
    }

    @Override
    public Cliente buscarPNatural(int id) {
        
        Cliente cliente = null;
        try{
            
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call RF_BUSCAR_PERSONA_NATURAL_X_ID(?)}");
            cs.setInt("_id_persona", id);
            rs = cs.executeQuery();
            cliente = new Cliente();
            while(rs.next()){
                 
                cliente.setId_cliente(rs.getInt("id_persona"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido_paterno(rs.getString("apellido_paterno"));
                cliente.setApellido_materno(rs.getString("apellido_materno"));
                
                cliente.setEmail(rs.getString("email"));
                cliente.setNro_documento(rs.getInt("numDocumento"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setTipo_documento(TipoDocumento.valueOf(rs.getString("tipoDocumento")));
                
                cliente.setSexo(rs.getString("sexo").charAt(0));
                cliente.setDireccion(rs.getString("direccion"));     
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return cliente;
    }
    
}
