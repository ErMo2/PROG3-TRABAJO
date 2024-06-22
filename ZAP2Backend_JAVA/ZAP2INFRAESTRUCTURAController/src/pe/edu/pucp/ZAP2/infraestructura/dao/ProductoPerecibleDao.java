/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.model.ProductoPerecible;

/**
 *
 * @author User
 */
public interface ProductoPerecibleDao {
    int insertar(ProductoPerecible prodPerecible);
    int modificar(ProductoPerecible prodPerecible);
    int eliminar(int idProdPere);
    ArrayList<ProductoPerecible> listarTodos();
    ArrayList<ProductoPerecible> listarTodosPorNombre(String nombre);
    ProductoPerecible buscarProducto(int idProdPere);
    
}
