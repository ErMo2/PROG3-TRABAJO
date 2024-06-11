/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.dao.CajeroDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Cajero;
import pe.edu.pucp.ZAP2.infraestructura.mysql.CajeroMySql;

/**
 *
 * @author User
 */
@WebService(serviceName = "CajeroWS", targetNamespace = "ZAP2WS")
public class CajeroWS {
    
    private CajeroDao daoCajero;
    @WebMethod(operationName = "insertaCajero")
    public int insertaCajero(@WebParam(name = "cajero") Cajero cajero) {
        int resultado = 0;
        try{
            daoCajero = new CajeroMySql();
            resultado = daoCajero.insertar(cajero);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "modificarCajero")
    public int modificarCajero(@WebParam(name = "cajero") Cajero cajero) {
        int resultado = 0;
        try{
            daoCajero = new CajeroMySql();
            resultado = daoCajero.modificar(cajero);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarCajero")
    public int eliminarCajero(@WebParam(name = "idCajero") int idCajero) {
        int resultado = 0;
        try{
            daoCajero = new CajeroMySql();
            resultado = daoCajero.eliminar(idCajero);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarCajeros")
    public ArrayList<Cajero> listarCajeros() {
        ArrayList<Cajero> cajeros = null;
        try{
            daoCajero = new CajeroMySql();
            cajeros = daoCajero.listarTodas();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return cajeros;
    }
}
