/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.model.Ropa;

/**
 *
 * @author User
 */
public interface RopaDao {
    int insertar(Ropa ropa);
    int modificar(Ropa ropa);
    int eliminar(int idRopa);
    ArrayList<Ropa> listarTodas();
    ArrayList<Ropa> listarTodosPorNombre(String nombre);
    Ropa buscarProducto(int idProd);
}
