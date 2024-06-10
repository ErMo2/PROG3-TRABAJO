/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.personas.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.personas.dao.PersonaJuridicaDao;
import pe.edu.pucp.ZAP2.personas.model.PersonaJuridica;

/**
 *
 * @author Alejandro
 */
public class PersonaJuridicaMySql implements PersonaJuridicaDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    
    @Override
    public int insertar(PersonaJuridica personaJuridica) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_PERSONA_JURIDICA"
                    +"(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_persona_juridica", java.sql.Types.INTEGER);
            cs.setString("_nombre", personaJuridica.getNombre());
            cs.setString("_apellido_paterno", personaJuridica.getApellido_paterno());
            cs.setString("_apellido_materno", personaJuridica.getApellido_materno());
            cs.setString("_telefono", String.valueOf(personaJuridica.getTelefono()));
            cs.setString("_email", personaJuridica.getEmail());
            cs.setString("_tipoDocumento", personaJuridica.getTipo_documento().toString());    
            cs.setString("_numDocumento", String.valueOf(personaJuridica.getNro_documento()));
            
            
            cs.setString("_tipoEntidad", personaJuridica.getTipoEntidad().toString());
            cs.setInt("_numIdentificadorFiscal", personaJuridica.getNumIdentificadorFiscal());
            cs.setString("_direccionLegal", personaJuridica.getDireccionLegal());
            cs.setString("_RUC", personaJuridica.getRUC());
            resultado = cs.executeUpdate();
            personaJuridica.setId_Persona(cs.getInt("_id_persona_juridica"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
            
            
        }
        //buscar en mysql driver -> conectors
        return resultado;
    }

    @Override
    public int modificar(PersonaJuridica personaJuridica) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idPersonaJuridica) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PersonaJuridica> listarTodas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
