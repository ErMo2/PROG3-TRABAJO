/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.proveedor.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.proveedor.model.Detalle_Pedido;

/**
 *
 * @author Alejandro
 */
public interface Detalle_PedidoDao {
    int insertar(Detalle_Pedido detallePedido);
    int modificar(Detalle_Pedido detallePedido);
    int eliminar(int idDetallePedido);
    ArrayList<Detalle_Pedido> listarTodas();
}
