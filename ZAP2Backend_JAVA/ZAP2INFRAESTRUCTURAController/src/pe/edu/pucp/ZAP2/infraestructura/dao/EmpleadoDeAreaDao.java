/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.model.EmpleadoDeArea;

/**
 *
 * @author Alejandro
 */
public interface EmpleadoDeAreaDao {
    int insertar(EmpleadoDeArea empleadoDeArea);
    int modificar(EmpleadoDeArea empleadoDeArea);
    int eliminar(int idEmpleadoDeArea);
    ArrayList<EmpleadoDeArea> listarTodas();
    EmpleadoDeArea buscar(int id);
}
