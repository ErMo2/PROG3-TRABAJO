/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.dao.ProductoDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Producto;
import pe.edu.pucp.ZAP2.infraestructura.mysql.ProductoMySql;

/**
 *
 * @author Alejandro
 */
@WebService(serviceName = "ProductoWS")
public class ProductoWS {

    private ProductoDao daoProducto;
    @WebMethod(operationName = "listarProductosConDescuento")
    public ArrayList<Producto> listarProductosConDescuento() {
        ArrayList<Producto> productos = null;
        try{
            daoProducto = new ProductoMySql();
            productos = daoProducto.listarProductosConDescuento();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return productos;
    }
    @WebMethod(operationName = "listarProductosConDescuentoEnFecha")
    public ArrayList<Producto> listarProductosConDescuentoEnFecha() {
        ArrayList<Producto> productos = null;
        try{
            daoProducto = new ProductoMySql();
            productos = daoProducto.listarProductosConDescuentoEnFecha();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return productos;
    }
    @WebMethod(operationName = "listarDescuentoDeUnProducto")
    public ArrayList<Producto> listarDescuentoDeUnProducto(@WebParam(name = "idProducto") int idProducto) {
        ArrayList<Producto> productos = null;
        try{
            daoProducto = new ProductoMySql();
            productos = daoProducto.listarDescuentoDeUnProducto(idProducto);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return productos;
    }
}
