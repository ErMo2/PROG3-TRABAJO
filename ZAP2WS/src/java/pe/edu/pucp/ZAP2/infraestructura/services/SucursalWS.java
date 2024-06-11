/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.dao.SucursalDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Sucursal;
import pe.edu.pucp.ZAP2.infraestructura.mysql.SucursalMySql;

/**
 *
 * @author Alejandro
 */
@WebService(serviceName = "SucursalWS", targetNamespace = "ZAP2WS")
public class SucursalWS {

    /**
     * This is a sample web service operation
     */
    SucursalDao daoSucursal;
    @WebMethod(operationName = "insertarSucursal")
    public int insertarSucursal(@WebParam(name="sucursal") Sucursal sucursal) {
        int resultado = 0;
        try{
            daoSucursal = new SucursalMySql();
            resultado = daoSucursal.insertar(sucursal);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "modificarSucursal")
    public int modificarSucursal(@WebParam(name="sucursal") Sucursal sucursal) {
        int resultado = 0;
        try{
            daoSucursal = new SucursalMySql();
            resultado = daoSucursal.modificar(sucursal);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarSucursal")
    public int eliminarSucursal(@WebParam(name="idSucursal") int idSucursal) {
        int resultado = 0;
        try{
            daoSucursal = new SucursalMySql();
            resultado = daoSucursal.eliminar(idSucursal);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarSucursal")
    public ArrayList<Sucursal> listarSucursal() {
        ArrayList<Sucursal> sucursales = null;
        try{
            daoSucursal = new SucursalMySql();
            sucursales = daoSucursal.listarTodas();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return sucursales;
    }
}
