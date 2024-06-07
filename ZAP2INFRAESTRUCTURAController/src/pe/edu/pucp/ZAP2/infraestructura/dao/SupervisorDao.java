/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.model.Supervisor;

/**
 *
 * @author Alejandro
 */
public interface SupervisorDao {
    int insertar(Supervisor supervisor);
    int modificar(Supervisor supervisor);
    int eliminar(int idSupervisor);
    ArrayList<Supervisor> listarTodas();
}
