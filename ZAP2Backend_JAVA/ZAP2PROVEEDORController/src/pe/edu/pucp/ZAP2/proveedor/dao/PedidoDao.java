/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.proveedor.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.proveedor.model.Pedido;

/**
 *
 * @author Alejandro
 */
public interface PedidoDao {
    int insertar(Pedido pedido);
    int modificar(Pedido pedido);
    int eliminar(int idpedido);
    ArrayList<Pedido> listarTodas();
    ArrayList<Pedido> listarTodasXnombre(String id);
    Pedido buscar(int id);
}
