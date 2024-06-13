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
import java.sql.SQLException;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.personas.dao.PersonaJuridicaDao;
import pe.edu.pucp.ZAP2.personas.model.PersonaJuridica;
import pe.edu.pucp.ZAP2.personas.model.TipoDocumento;
import pe.edu.pucp.ZAP2.personas.model.TipoEntidad;

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
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
            
            
        }
        //buscar en mysql driver -> conectors
        return resultado;
    }

    @Override
    public int modificar(PersonaJuridica personaJuridica) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_PERSONA_JURIDICA (?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("_id_persona", personaJuridica.getId_Persona());
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
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idPersonaJuridica) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_PERSONA(?)}");
            cs.setInt("_id_persona",idPersonaJuridica);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<PersonaJuridica> listarTodas() {
        ArrayList<PersonaJuridica> PJs =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_PERSONA_JURIDICA"
                    +"( )}");
            rs = cs.executeQuery();
            while(rs.next()){
                PersonaJuridica PJ = new PersonaJuridica();
                PJ.setId_Persona(rs.getInt("id_persona"));
                PJ.setNombre(rs.getString("nombre"));
                PJ.setApellido_paterno(rs.getString("apellido_paterno"));
                PJ.setApellido_materno(rs.getString("apellido_materno"));
                PJ.setEmail(rs.getString("email"));
                PJ.setTipo_documento(TipoDocumento.valueOf(rs.getString("tipoDocumento")));
                PJ.setNro_documento(rs.getInt("numDocumento"));
                PJ.setTelefono(rs.getInt("telefono"));
                
                TipoEntidad tip = TipoEntidad.valueOf(rs.getString("tipoEntidad"));
                PJ.setTipoEntidad(tip);
                PJ.setDireccionLegal(rs.getString("direccionLegal"));
                PJ.setNumIdentificadorFiscal(rs.getInt("numIdentificadorFiscal"));
                PJ.setRUC(rs.getString("RUC"));
                
                PJs.add(PJ);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return PJs;
        
    }
    
}
