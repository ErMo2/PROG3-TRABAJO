/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.personas.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.personas.dao.PersonaJuridicaDao;
import pe.edu.pucp.ZAP2.personas.model.PersonaJuridica;
import pe.edu.pucp.ZAP2.personas.mysql.PersonaJuridicaMySql;

/**
 *
 * @author Coco
 */
@WebService(serviceName = "PersonaJuridicaWS", targetNamespace = "ZAP2WS")
public class PersonaJuridicaWS {

    PersonaJuridicaDao daoPersonaJuridica;
    @WebMethod(operationName = "insertarPersonaJuridica")
    public int insertarPersonaJuridica(@WebParam(name="personaJuridica") PersonaJuridica personaJuridica) {
        int resultado = 0;
        try{
            daoPersonaJuridica = new PersonaJuridicaMySql();
            resultado = daoPersonaJuridica.insertar(personaJuridica);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "modificarPersonaJuridica")
    public int modificarPersonaJuridica(@WebParam(name="personaJuridica") PersonaJuridica personaJuridica) {
        int resultado = 0;
        try{
            daoPersonaJuridica = new PersonaJuridicaMySql();
            resultado = daoPersonaJuridica.modificar(personaJuridica);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarPersonaJuridica")
    public int eliminarPersonaJuridica(@WebParam(name="idPersonaJuridica") int idPersonaJuridica) {
        int resultado = 0;
        try{
            daoPersonaJuridica = new PersonaJuridicaMySql();
            resultado = daoPersonaJuridica.eliminar(idPersonaJuridica);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarPersonasJuridicas")
    public ArrayList<PersonaJuridica> listarPersonasJuridicas() {
        ArrayList<PersonaJuridica> personasJuridicas = null;
        try{
            daoPersonaJuridica = new PersonaJuridicaMySql();
            personasJuridicas = daoPersonaJuridica.listarTodas();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return personasJuridicas;
    }
}
