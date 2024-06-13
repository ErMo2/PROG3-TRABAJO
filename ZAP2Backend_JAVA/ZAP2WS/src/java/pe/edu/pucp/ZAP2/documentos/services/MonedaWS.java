/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.documentos.dao.MonedaDao;
import pe.edu.pucp.ZAP2.documentos.model.Moneda;
import pe.edu.pucp.ZAP2.documentos.mySql.MonedaMySql;

/**
 *
 * @author Coco
 */
@WebService(serviceName = "MonedaWS", targetNamespace = "ZAP2WS")
public class MonedaWS {

    /**
     * This is a sample web service operation
     */
    private MonedaDao daoMoneda;
    @WebMethod(operationName = "insertarMoneda")
    public int insertarMoneda(@WebParam(name = "moneda") Moneda moneda) {
        int resultado = 0;
        try{
            daoMoneda = new MonedaMySql();
            resultado = daoMoneda.insertar(moneda);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarMoneda")
    public int modificarMoneda(@WebParam(name = "moneda") Moneda moneda) {
        int resultado = 0;
        try{
            daoMoneda = new MonedaMySql();
            resultado = daoMoneda.modificar(moneda);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarMoneda")
    public int eliminarMoneda(@WebParam(name = "idMoneda") int idMoneda) {
        int resultado = 0;
        try{
            daoMoneda = new MonedaMySql();
            resultado = daoMoneda.eliminar(idMoneda);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarMoneda")
    public ArrayList<Moneda> listarMoneda() {
        ArrayList<Moneda> monedas = null;
        try{
            daoMoneda = new MonedaMySql();
            monedas = daoMoneda.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return monedas;
    }
    
    @WebMethod(operationName = "buscarMoneda")
    public Moneda buscarMoneda(@WebParam(name = "idMoneda") int id) {
        Moneda dato = null;
        try{
            daoMoneda = new MonedaMySql();
            dato = daoMoneda.buscar(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return dato;
    }
}
