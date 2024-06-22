/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.model.ProductosParaElCuidadoPersonalYDelHogar;

/**
 *
 * @author User
 */
public interface ProductosParaElCuidadoPersonalYDelHogarDao {
    int insertar(ProductosParaElCuidadoPersonalYDelHogar prodParaElCuidado);
    int modificar(ProductosParaElCuidadoPersonalYDelHogar prodParaElCuidado);
    int eliminar(int idProducto);
    ArrayList<ProductosParaElCuidadoPersonalYDelHogar> listarTodos();
    ArrayList<ProductosParaElCuidadoPersonalYDelHogar> listarTodosPorNombre(String nombre);
    ProductosParaElCuidadoPersonalYDelHogar buscarProducto(int idProd);
}
