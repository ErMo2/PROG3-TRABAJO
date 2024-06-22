/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.dao.ElectrodomesticosDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Electrodomesticos;
import pe.edu.pucp.ZAP2.infraestructura.mysql.ElectrodomesticosMySql;

/**
 *
 * @author Coco
 */
@WebService(serviceName = "ElectrodomesticosWS", targetNamespace = "ZAP2WS")
public class ElectrodomesticosWS {

    /**
     * This is a sample web service operation
     */
     private ElectrodomesticosDao daoElectrodomesticos;
    @WebMethod(operationName = "insertarElectrodomestico")
    public int insertarElectrodomestico(@WebParam(name = "electrodomestico") Electrodomesticos electrodomestico) {
        int resultado = 0;
        try{
            daoElectrodomesticos = new ElectrodomesticosMySql();
            resultado = daoElectrodomesticos.insertar(electrodomestico);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "modificarElectrodomestico")
    public int modificarElectrodomestico(@WebParam(name = "electrodomestico") Electrodomesticos electrodomestico) {
        int resultado = 0;
        try{
            daoElectrodomesticos = new ElectrodomesticosMySql();
            resultado = daoElectrodomesticos.modificar(electrodomestico);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarElectrodomestico")
    public int eliminarElectrodomestico(@WebParam(name = "idElectrodomestico") int idElectrodomestico) {
        int resultado = 0;
        try{
            daoElectrodomesticos = new ElectrodomesticosMySql();
            resultado = daoElectrodomesticos.eliminar(idElectrodomestico);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarElectrodomesticos")
    public ArrayList<Electrodomesticos> listarElectrodomesticos() {
        ArrayList<Electrodomesticos> electrodomesticos = null;
        try{
            daoElectrodomesticos = new ElectrodomesticosMySql();
            electrodomesticos = daoElectrodomesticos.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return electrodomesticos;
    }
    
    @WebMethod(operationName = "buscarElectrodomestico")
    public Electrodomesticos buscarElectrodomestico(@WebParam(name = "idElectrodomestico") int idProd) {
        Electrodomesticos prod = null;
        try{
            daoElectrodomesticos = new ElectrodomesticosMySql();
            prod = daoElectrodomesticos.buscarProducto(idProd);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return prod;
    }
    
    @WebMethod(operationName = "listarElectrodomesticosXnombre")
    public ArrayList<Electrodomesticos> listarElectrodomesticosXnombre(@WebParam(name = "nombre") String dato) {
        ArrayList<Electrodomesticos> electrodomesticos = null;
        try{
            daoElectrodomesticos = new ElectrodomesticosMySql();
            electrodomesticos = daoElectrodomesticos.listarTodosPorNombre(dato);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return electrodomesticos;
    }
}
