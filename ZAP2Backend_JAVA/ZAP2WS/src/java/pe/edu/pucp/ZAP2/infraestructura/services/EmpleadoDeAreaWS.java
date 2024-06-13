/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.dao.EmpleadoDeAreaDao;
import pe.edu.pucp.ZAP2.infraestructura.model.EmpleadoDeArea;
import pe.edu.pucp.ZAP2.infraestructura.mysql.EmpleadoDeAreaMySql;

/**
 *
 * @author Coco
 */
@WebService(serviceName = "EmpleadoDeAreaWS", targetNamespace = "ZAP2WS")
public class EmpleadoDeAreaWS {

    private EmpleadoDeAreaDao daoEmpleadoDeArea;
    @WebMethod(operationName = "insertarEmpleadoDeArea")
    public int insertarEmpleadoDeArea(@WebParam(name = "empleadoDeArea") EmpleadoDeArea empleadoDeArea) {
        int resultado = 0;
        try{
            daoEmpleadoDeArea = new EmpleadoDeAreaMySql();
            resultado = daoEmpleadoDeArea.insertar(empleadoDeArea);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarEmpleadoDeArea")
    public int modificarEmpleadoDeArea(@WebParam(name = "empleadoDeArea") EmpleadoDeArea empleadoDeArea) {
        int resultado = 0;
        try{
            daoEmpleadoDeArea = new EmpleadoDeAreaMySql();
            resultado = daoEmpleadoDeArea.modificar(empleadoDeArea);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarEmpleadoDeArea")
    public int eliminarEmpleadoDeArea(@WebParam(name = "idEmpleadoDeArea") int idEmpleadoDeArea) {
        int resultado = 0;
        try{
            daoEmpleadoDeArea = new EmpleadoDeAreaMySql();
            resultado = daoEmpleadoDeArea.eliminar(idEmpleadoDeArea);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarEmpleadoArea")
    public ArrayList<EmpleadoDeArea> listarEmpleadoArea() {
        ArrayList<EmpleadoDeArea> empleadosArea = null;
        try{
            daoEmpleadoDeArea = new EmpleadoDeAreaMySql();
            empleadosArea = daoEmpleadoDeArea.listarTodas();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return empleadosArea;
    }
    
    @WebMethod(operationName = "buscarEmpleadoArea")
    public EmpleadoDeArea buscarEmpleadoArea(@WebParam(name = "idEmpleadoArea") int id) {
        EmpleadoDeArea dato = null;
        try{
            daoEmpleadoDeArea = new EmpleadoDeAreaMySql();
            dato = daoEmpleadoDeArea.buscar(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return dato;
    }
}
