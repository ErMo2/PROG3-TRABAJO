/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.model.Almacen;

/**
 *
 * @author User
 */
public interface AlmacenDao {
    int insertar(Almacen almacen);
    int modificar(Almacen almacen);
    int eliminar(int idAlmacen);
    ArrayList<Almacen> listarTodos();
    Almacen buscar(int id);
    Almacen buscarAlmacenDisponible(int idSucursal, int cantidadAcolocar);
}
