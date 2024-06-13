/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.dao.ProductoPerecibleDao;
import pe.edu.pucp.ZAP2.infraestructura.model.ProductoPerecible;
import pe.edu.pucp.ZAP2.infraestructura.mysql.ProductoPerecibleMySql;

/**
 *
 * @author Coco
 */
@WebService(serviceName = "ProductoPerecibleWS", targetNamespace = "ZAP2WS")
public class ProductoPerecibleWS {

    private ProductoPerecibleDao daoProductoPerecible;
    @WebMethod(operationName = "insertarProductoPerecible")
    public int insertarProductoPerecible(@WebParam(name = "productoPerecible") ProductoPerecible productoPerecible) {
        int resultado = 0;
        try{
            daoProductoPerecible = new ProductoPerecibleMySql();
            resultado = daoProductoPerecible.insertar(productoPerecible);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "modificarProductoPerecible")
    public int modificarProductoPerecible(@WebParam(name = "productoPerecible") ProductoPerecible productoPerecible) {
        int resultado = 0;
        try{
            daoProductoPerecible = new ProductoPerecibleMySql();
            resultado = daoProductoPerecible.modificar(productoPerecible);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarProductoPerecible")
    public int eliminarProductoPerecible(@WebParam(name = "idProductoPerecible") int idProductoPerecible) {
        int resultado = 0;
        try{
            daoProductoPerecible = new ProductoPerecibleMySql();
            resultado = daoProductoPerecible.eliminar(idProductoPerecible);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarProductoPerecible")
    public ArrayList<ProductoPerecible> listarProductoPerecible() {
        ArrayList<ProductoPerecible> prodPere = null;
        try{
            daoProductoPerecible = new ProductoPerecibleMySql();
            prodPere = daoProductoPerecible.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return prodPere;
    }
    
    @WebMethod(operationName = "buscarProductoPerecible")
    public ProductoPerecible buscarProductoPerecible(@WebParam(name = "idProductoPerecible") int idProductoPerecible) {
        ProductoPerecible prodPere = null;
        try{
            daoProductoPerecible = new ProductoPerecibleMySql();
            prodPere = daoProductoPerecible.buscarProducto(idProductoPerecible);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return prodPere;
    }
}
