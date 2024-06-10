/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.model.Descuento;

/**
 *
 * @author Alejandro
 */
public interface DescuentoDao {
    int insertar(Descuento descuento);
    int modificar(Descuento descuento);
    int eliminar(int idDescuento);
    ArrayList<Descuento> listarTodas();
}
