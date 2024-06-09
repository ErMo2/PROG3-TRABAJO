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
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idPersona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cliente> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
