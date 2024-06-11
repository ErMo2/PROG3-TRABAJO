/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.proveedor.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.proveedor.dao.Detalle_PedidoDao;
import pe.edu.pucp.ZAP2.proveedor.model.Detalle_Pedido;
import pe.edu.pucp.ZAP2.proveedor.mysql.Detalle_PedidoMySql;

/**
 *
 * @author Coco
 */
@WebService(serviceName = "Detalle_PedidoWS", targetNamespace = "ZAP2WS")
public class Detalle_PedidoWS {

    Detalle_PedidoDao daoDetallePedido;
    @WebMethod(operationName = "insertarDetallePedido")
    public int insertarDetallePedido(@WebParam(name="detalle_Pedido") Detalle_Pedido detalle_Pedido) {
        int resultado = 0;
        try{
            daoDetallePedido = new Detalle_PedidoMySql();
            resultado = daoDetallePedido.insertar(detalle_Pedido);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "modificarDetallePedido")
    public int modificarDetallePedido(@WebParam(name="detalle_Pedido") Detalle_Pedido detalle_Pedido) {
        int resultado = 0;
        try{
            daoDetallePedido = new Detalle_PedidoMySql();
            resultado = daoDetallePedido.modificar(detalle_Pedido);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarDetallePedido")
    public int eliminarDetallePedido(@WebParam(name="idDetalle_Pedido") int idDetalle_Pedido) {
        int resultado = 0;
        try{
            daoDetallePedido = new Detalle_PedidoMySql();
            resultado = daoDetallePedido.eliminar(idDetalle_Pedido);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarDetallePedidos")
    public ArrayList<Detalle_Pedido> listarDetallePedidos() {
        ArrayList<Detalle_Pedido> detallesPedidos = null;
        try{
            daoDetallePedido = new Detalle_PedidoMySql();
            detallesPedidos = daoDetallePedido.listarTodas();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return detallesPedidos;
    }
}
