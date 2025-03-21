/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.model.ProductoPrecio;

/**
 *
 * @author User
 */
public interface ProductoPrecioDao {
    int insertar(ProductoPrecio productoPrecio);
    int modificar(ProductoPrecio productoPrecio);
    int eliminar(int idProductoPrecio);
    ArrayList<ProductoPrecio> listarTodos();
    ArrayList<ProductoPrecio> listarPreciosProducto(int idProd);
    ArrayList<ProductoPrecio> listarPreciosProductoDeUnaSucursal(int idsucursal);
}
