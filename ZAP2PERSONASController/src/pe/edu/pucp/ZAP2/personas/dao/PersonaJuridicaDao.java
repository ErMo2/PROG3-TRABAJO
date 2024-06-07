/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.personas.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.personas.model.PersonaJuridica;
/**
 *
 * @author Alejandro
 */
public interface PersonaJuridicaDao {
    int insertar(PersonaJuridica personaJuridica);
    int modificar(PersonaJuridica personaJuridica);
    int eliminar(int idPersonaJuridica);
    ArrayList<PersonaJuridica> listarTodas();
}
