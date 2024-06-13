/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.model.Cajero;

/**
 *
 * @author Alejandro
 */
public interface CajeroDao {
    int insertar(Cajero cajero);
    int modificar(Cajero cajero);
    int eliminar(int idCajero);
    ArrayList<Cajero> listarTodas();
    Cajero buscar(int id);
}
