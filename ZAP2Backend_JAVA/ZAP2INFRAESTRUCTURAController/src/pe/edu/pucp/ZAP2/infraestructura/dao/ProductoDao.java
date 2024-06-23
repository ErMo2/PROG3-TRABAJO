/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.model.Producto;

/**
 *
 * @author Alejandro
 */
public interface ProductoDao {
    ArrayList<Producto> listarProductosConDescuento();
    ArrayList<Producto> listarProductosConDescuentoEnFecha();
    ArrayList<Producto> listarDescuentoDeUnProducto(int idProducto);
    ArrayList<Producto> listarProductosMasConsumidos();
    ArrayList<Producto> listarProductos();
    ArrayList<Producto> listarProductosPorNombre(String nombre); 
    String listarProductosConStockaAgotarse(int umbral);  
}