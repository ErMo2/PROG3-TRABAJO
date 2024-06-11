/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.dao.ProductoPrecioDao;
import pe.edu.pucp.ZAP2.infraestructura.model.ProductoPrecio;
import pe.edu.pucp.ZAP2.infraestructura.mysql.ProductoPrecioMySql;

/**
 *
 * @author Coco
 */
@WebService(serviceName = "ProductoPrecioWS", targetNamespace = "ZAP2WS")
public class ProductoPrecioWS {

    private ProductoPrecioDao daoProductoPrecio;
    @WebMethod(operationName = "insertarProductoPrecio")
    public int insertarProductoPrecio(@WebParam(name = "productoPrecio") ProductoPrecio productoPrecio) {
        int resultado = 0;
        try{
            daoProductoPrecio = new ProductoPrecioMySql();
            resultado = daoProductoPrecio.insertar(productoPrecio);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "modificarProductoPrecio")
    public int modificarProductoPrecio(@WebParam(name = "productoPrecio") ProductoPrecio productoPrecio) {
        int resultado = 0;
        try{
            daoProductoPrecio = new ProductoPrecioMySql();
            resultado = daoProductoPrecio.modificar(productoPrecio);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarProductoPrecio")
    public int eliminarProductoPrecio(@WebParam(name = "idProductoPrecio") int idProductoPrecio) {
        int resultado = 0;
        try{
            daoProductoPrecio = new ProductoPrecioMySql();
            resultado = daoProductoPrecio.eliminar(idProductoPrecio);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarProductoPrecio")
    public ArrayList<ProductoPrecio> listarProductoPrecio() {
        ArrayList<ProductoPrecio> prodPere = null;
        try{
            daoProductoPrecio = new ProductoPrecioMySql();
            prodPere = daoProductoPrecio.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return prodPere;
    }
}
