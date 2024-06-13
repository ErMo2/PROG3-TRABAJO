/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.proveedor.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.proveedor.dao.PedidoDao;
import pe.edu.pucp.ZAP2.proveedor.model.Pedido;
import pe.edu.pucp.ZAP2.proveedor.mysql.PedidoMySql;

/**
 *
 * @author Coco
 */
@WebService(serviceName = "PedidoWS", targetNamespace = "ZAP2WS")
public class PedidoWS {

    PedidoDao daoPedido;
    @WebMethod(operationName = "insertarPedido")
    public int insertarPedido(@WebParam(name="pedido") Pedido pedido) {
        int resultado = 0;
        try{
            daoPedido = new PedidoMySql();
            resultado = daoPedido.insertar(pedido);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "modificarPedido")
    public int modificarPedido(@WebParam(name="pedido") Pedido pedido) {
        int resultado = 0;
        try{
            daoPedido = new PedidoMySql();
            resultado = daoPedido.modificar(pedido);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarPedido")
    public int eliminarPedido(@WebParam(name="idPedido") int idPedido) {
        int resultado = 0;
        try{
            daoPedido = new PedidoMySql();
            resultado = daoPedido.eliminar(idPedido);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarPedidos")
    public ArrayList<Pedido> listarPedidos() {
        ArrayList<Pedido> pedidos = null;
        try{
            daoPedido = new PedidoMySql();
            pedidos = daoPedido.listarTodas();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return pedidos;
    }
    
    @WebMethod(operationName = "buscarPedido")
    public Pedido buscarPedido(@WebParam(name = "idPedido") int id) {
        Pedido dato = null;
        try{
            daoPedido = new PedidoMySql();
            dato = daoPedido.buscar(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return dato;
    }
}
