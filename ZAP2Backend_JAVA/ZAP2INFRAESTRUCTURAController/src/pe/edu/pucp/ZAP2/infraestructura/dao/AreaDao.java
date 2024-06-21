/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.model.Area;
import pe.edu.pucp.ZAP2.infraestructura.model.Producto;

/**
 *
 * @author Alejandro
 */
public interface AreaDao {
    int insertar(Area area);
    int modificar(Area area);
    int eliminar(int idArea);
    ArrayList<Area> listarTodas();
    Area buscar(int id);
    ArrayList<Area> listarTodaDeConSucursal();
    int insertProductoArea(Area area, Producto producto);
    int eliminarAreaProducto(int idAreaProducto);
    Area ListarProductosDelArea(int idArea);
}
