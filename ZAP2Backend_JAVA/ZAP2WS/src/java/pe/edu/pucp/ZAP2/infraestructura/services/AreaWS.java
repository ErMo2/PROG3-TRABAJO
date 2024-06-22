/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.dao.AreaDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Area;
import pe.edu.pucp.ZAP2.infraestructura.mysql.AreaMySql;

/**
 *
 * @author Alejandro
 */
@WebService(serviceName = "AreaWS", targetNamespace = "ZAP2WS")
public class AreaWS {

    /**
     * This is a sample web service operation
     */
    private AreaDao daoArea;
    @WebMethod(operationName = "insertarArea")
    public int insertarArea(@WebParam(name = "area") Area area) {
        int resultado = 0;
        try{
            daoArea = new AreaMySql();
            resultado = daoArea.insertar(area);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "modificarArea")
    public int modificarArea(@WebParam(name = "area") Area area) {
        int resultado = 0;
        try{
            daoArea = new AreaMySql();
            resultado = daoArea.modificar(area);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarArea")
    public int eliminarArea(@WebParam(name = "idArea") int idArea) {
        int resultado = 0;
        try{
            daoArea = new AreaMySql();
            resultado = daoArea.eliminar(idArea);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarArea")
    public ArrayList<Area> listarArea() {
        ArrayList<Area> areas = null;
        try{
            daoArea = new AreaMySql();
            areas = daoArea.listarTodas();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return areas;
    }
    
    @WebMethod(operationName = "buscarArea")
    public Area buscarArea(@WebParam(name = "idArea") int id) {
        Area dato = null;
        try{
            daoArea = new AreaMySql();
            dato = daoArea.buscar(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return dato;
    }
    
    @WebMethod(operationName = "listarAreaConSucursales")
    public ArrayList<Area> listarAreaConSucursales() {
        ArrayList<Area> areas = null;
        try{
            daoArea = new AreaMySql();
            areas = daoArea.listarTodaDeConSucursal();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return areas;
    }
    
    @WebMethod(operationName = "ListarProductosDelArea")
    public Area ListarProductosDelArea(@WebParam(name = "idArea") int id) {
        Area dato = null;
        try{
            daoArea = new AreaMySql();
            dato = daoArea.ListarProductosDelArea(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return dato;
    }
    
    @WebMethod(operationName = "insertarAreaProducto")
    public int insertarAreaProducto(@WebParam(name = "Idarea") int Idarea,@WebParam(name = "IdProducto") int IdProducto) {
        int resultado = 0;
        try{
            daoArea = new AreaMySql();
            resultado = daoArea.insertProductoArea(Idarea,IdProducto);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarAreaProducto")
    public int eliminarAreaProducto(@WebParam(name = "idAreaProducto") int idArea) {
        int resultado = 0;
        try{
            daoArea = new AreaMySql();
            resultado = daoArea.eliminarAreaProducto(idArea);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
        
    }
    
    
}
