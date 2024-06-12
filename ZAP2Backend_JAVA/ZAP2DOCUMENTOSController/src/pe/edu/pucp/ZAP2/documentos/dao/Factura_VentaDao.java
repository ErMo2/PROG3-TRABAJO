/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.documentos.model.Factura_Venta;

/**
 *
 * @author Alejandro
 */
public interface Factura_VentaDao {
    int insertar(Factura_Venta facturaVenta);
    int modificar(Factura_Venta facturaVenta);
    int eliminar(int idFacturaVenta);
    ArrayList<Factura_Venta> listarTodos();
}
