/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.dao.ClienteDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Cliente;
import pe.edu.pucp.ZAP2.infraestructura.mysql.ClienteMySql;

/**
 *
 * @author Coco
 */
@WebService(serviceName = "ClienteWS", targetNamespace = "ZAP2WS")
public class ClienteWS {

    private ClienteDao daoCliente;
    @WebMethod(operationName = "insertarCliente")
    public int insertarCliente(@WebParam(name = "cliente") Cliente cliente) {
        int resultado = 0;
        try{
            daoCliente = new ClienteMySql();
            resultado = daoCliente.insertar(cliente);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "modificarCliente")
    public int modificarCliente(@WebParam(name = "cliente") Cliente cliente) {
        int resultado = 0;
        try{
            daoCliente = new ClienteMySql();
            resultado = daoCliente.modificar(cliente);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarCliente")
    public int eliminarCliente(@WebParam(name = "idCliente") int idCliente) {
        int resultado = 0;
        try{
            daoCliente = new ClienteMySql();
            resultado = daoCliente.eliminar(idCliente);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    } 
    @WebMethod(operationName = "listarClientes")
    public ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> clientes = null;
        try{
            daoCliente = new ClienteMySql();
            clientes = daoCliente.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return clientes;
    }
    
    @WebMethod(operationName = "buscarCliente")
    public Cliente buscarCliente(@WebParam(name = "idCliente") int id) {
        Cliente dato = null;
        try{
            daoCliente = new ClienteMySql();
            dato = daoCliente.buscar(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return dato;
    }
    
    @WebMethod(operationName = "listarClientesPorNombre")
    public ArrayList<Cliente> listarClientesPorNombre(String nombre) {
        ArrayList<Cliente> clientes = null;
        try{
            daoCliente = new ClienteMySql();
            clientes = daoCliente.listarPorNombre(nombre);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return clientes;
    }
}
