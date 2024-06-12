/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.documentos.model.Moneda;

/**
 *
 * @author Alejandro
 */
public interface MonedaDao {
    int insertar(Moneda moneda);
    int modificar(Moneda moneda);
    int eliminar(int idmoneda);
    ArrayList<Moneda> listarTodos();
}
