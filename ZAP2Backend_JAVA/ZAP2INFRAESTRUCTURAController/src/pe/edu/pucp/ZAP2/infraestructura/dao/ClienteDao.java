/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.model.Cliente;

/**
 *
 * @author Alejandro
 */
public interface ClienteDao {
    int insertar(Cliente cliente);
    int modificar(Cliente cliente);
    int eliminar(int idPersona);
    ArrayList<Cliente> listarTodos();
}
