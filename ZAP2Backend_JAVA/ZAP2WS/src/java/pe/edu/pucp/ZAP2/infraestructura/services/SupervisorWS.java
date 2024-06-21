/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.dao.SupervisorDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Supervisor;
import pe.edu.pucp.ZAP2.infraestructura.mysql.SupervisorMySql;

/**
 *
 * @author Coco
 */
@WebService(serviceName = "SupervisorWS", targetNamespace = "ZAP2WS")
public class SupervisorWS {

    SupervisorDao daoSupervisor;
    @WebMethod(operationName = "insertarSupervisor")
    public int insertarSupervisor(@WebParam(name="supervisor") Supervisor supervisor) {
        int resultado = 0;
        try{
            daoSupervisor = new SupervisorMySql();
            resultado = daoSupervisor.insertar(supervisor);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "modificarSupervisor")
    public int modificarSupervisor(@WebParam(name="supervisor") Supervisor supervisor) {
        int resultado = 0;
        try{
            daoSupervisor = new SupervisorMySql();
            resultado = daoSupervisor.modificar(supervisor);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarSupervisor")
    public int eliminarSupervisor(@WebParam(name="idSupervisor") int idSupervisor) {
        int resultado = 0;
        try{
            daoSupervisor = new SupervisorMySql();
            resultado = daoSupervisor.eliminar(idSupervisor);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarSupervisores")
    public ArrayList<Supervisor> listarSupervisores() {
        ArrayList<Supervisor> supervisores = null;
        try{
            daoSupervisor = new SupervisorMySql();
            supervisores = daoSupervisor.listarTodas();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return supervisores;
    }
    
    @WebMethod(operationName = "buscarSupervisor")
    public Supervisor buscarSupervisor(@WebParam(name = "idSupervisor") int id) {
        Supervisor dato = null;
        try{
            daoSupervisor = new SupervisorMySql();
            dato = daoSupervisor.buscar(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return dato;
    }
    
    @WebMethod(operationName = "listarSupervisoresDeUnaSucursal")
    public ArrayList<Supervisor> listarSupervisoresDeUnaSucursal(@WebParam(name = "idSucursal") int id) {
        ArrayList<Supervisor> supervisores = null;
        try{
            daoSupervisor = new SupervisorMySql();
            supervisores = daoSupervisor.listarTodasDeUnaSucursal(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return supervisores;
    }
}
