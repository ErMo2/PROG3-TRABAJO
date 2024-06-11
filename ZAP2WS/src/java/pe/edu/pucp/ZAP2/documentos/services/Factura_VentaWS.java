/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.documentos.dao.Factura_VentaDao;
import pe.edu.pucp.ZAP2.documentos.model.Factura_Venta;
import pe.edu.pucp.ZAP2.documentos.mySql.Factura_VentaMySql;

/**
 *
 * @author Coco
 */
@WebService(serviceName = "Factura_VentaWS", targetNamespace = "ZAP2WS")
public class Factura_VentaWS {

    /**
     * This is a sample web service operation
     */
    private Factura_VentaDao daoFacturaVentas;
    @WebMethod(operationName = "insertarFacturaVenta")
    public int insertarFacturaVenta(@WebParam(name = "facturaVenta") Factura_Venta facturaVenta) {
        int resultado = 0;
        try{
            daoFacturaVentas = new Factura_VentaMySql();
            resultado = daoFacturaVentas.insertar(facturaVenta);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarFacturaVenta")
    public int modificarFacturaVenta(@WebParam(name = "facturaVenta") Factura_Venta facturaVenta) {
        int resultado = 0;
        try{
            daoFacturaVentas = new Factura_VentaMySql();
            resultado = daoFacturaVentas.modificar(facturaVenta);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarFacturaVenta")
    public int eliminarFacturaVenta(@WebParam(name = "idFacturaVenta") int idFacturaVenta) {
        int resultado = 0;
        try{
            daoFacturaVentas = new Factura_VentaMySql();
            resultado = daoFacturaVentas.eliminar(idFacturaVenta);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarFacturaVenta")
    public ArrayList<Factura_Venta> listarFacturaVenta() {
        ArrayList<Factura_Venta> facturasVentas = null;
        try{
            daoFacturaVentas = new Factura_VentaMySql();
            facturasVentas = daoFacturaVentas.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return facturasVentas;
    }
}
