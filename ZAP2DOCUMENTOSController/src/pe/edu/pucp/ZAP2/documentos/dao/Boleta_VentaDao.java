/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.documentos.model.Boleta_Venta;

/**
 *
 * @author Alejandro
 */
public interface Boleta_VentaDao {
    int insertar(Boleta_Venta boletaVenta);
    int modificar(Boleta_Venta boletaVenta);
    int eliminar(int idBoleta_Venta);
    ArrayList<Boleta_Venta> listarTodas();
}
