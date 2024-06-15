/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.model.Sucursal;

/**
 *
 * @author Alejandro
 */
public interface SucursalDao {
    int insertar(Sucursal sucursal);
    int modificar(Sucursal sucursal);
    int eliminar(int idSucursal);
    ArrayList<Sucursal> listarTodas();
    Sucursal buscar(int id);
    ArrayList<Sucursal> listarTodaSinProductoConPrecioActivo(int idProducto);
}
