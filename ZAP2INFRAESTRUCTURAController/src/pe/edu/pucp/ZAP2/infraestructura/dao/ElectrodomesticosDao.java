/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.model.Electrodomesticos;

/**
 *
 * @author User
 */
public interface ElectrodomesticosDao {
    int insertar(Electrodomesticos electrodomestico);
    int modificar(Electrodomesticos electrodomestico);
    int eliminar(int idElectrodomestico);
    ArrayList<Electrodomesticos> listarTodos();
}
