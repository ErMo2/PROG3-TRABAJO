/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.dao.RopaDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Ropa;
import pe.edu.pucp.ZAP2.infraestructura.mysql.RopaMySql;

/**
 *
 * @author Coco
 */
@WebService(serviceName = "RopaWS", targetNamespace = "ZAP2WS")
public class RopaWS {

    private RopaDao daoRopa;
    @WebMethod(operationName = "insertarRopa")
    public int insertarRopa(@WebParam(name = "ropa") Ropa ropa) {
        int resultado = 0;
        try{
            daoRopa = new RopaMySql();
            resultado = daoRopa.insertar(ropa);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "modificarRopa")
    public int modificarRopa(@WebParam(name = "ropa") Ropa ropa) {
        int resultado = 0;
        try{
            daoRopa = new RopaMySql();
            resultado = daoRopa.modificar(ropa);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarRopa")
    public int eliminarRopa(@WebParam(name = "idRopa") int idRopa) {
        int resultado = 0;
        try{
            daoRopa = new RopaMySql();
            resultado = daoRopa.eliminar(idRopa);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarRopa")
    public ArrayList<Ropa> listarRopa() {
        ArrayList<Ropa> ropas = null;
        try{
            daoRopa = new RopaMySql();
            ropas = daoRopa.listarTodas();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return ropas;
    }
    
    @WebMethod(operationName = "buscarRopa")
    public Ropa buscarRopa(@WebParam(name = "idRopa") int idProd) {
        Ropa prod = null;
        try{
            daoRopa = new RopaMySql();
            prod = daoRopa.buscarProducto(idProd);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return prod;
    }
    
    @WebMethod(operationName = "listarRopaXnombre")
    public ArrayList<Ropa> listarRopaXnombre(@WebParam(name = "nombre") String dato) {
        ArrayList<Ropa> ropas = null;
        try{
            daoRopa = new RopaMySql();
            ropas = daoRopa.listarTodosPorNombre(dato);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return ropas;
    }
}
