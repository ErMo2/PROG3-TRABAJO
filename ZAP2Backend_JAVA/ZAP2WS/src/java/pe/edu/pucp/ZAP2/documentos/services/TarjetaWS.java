/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.documentos.dao.TarjetaDao;
import pe.edu.pucp.ZAP2.documentos.model.Tarjeta;
import pe.edu.pucp.ZAP2.documentos.mySql.TarjetaMySql;

/**
 *
 * @author Coco
 */
@WebService(serviceName = "TarjetaWS", targetNamespace = "ZAP2WS")
public class TarjetaWS {

    private TarjetaDao daoTarjeta;
    @WebMethod(operationName = "insertarTarjeta")
    public int insertarTarjeta(@WebParam(name = "tarjeta") Tarjeta tarjeta) {
        int resultado = 0;
        try{
            daoTarjeta = new TarjetaMySql();
            resultado = daoTarjeta.insertar(tarjeta);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarTarjeta")
    public int modificarTarjeta(@WebParam(name = "tarjeta") Tarjeta tarjeta) {
        int resultado = 0;
        try{
            daoTarjeta = new TarjetaMySql();
            resultado = daoTarjeta.modificar(tarjeta);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarTarjeta")
    public int eliminarTarjeta(@WebParam(name = "idTarjeta") int idTarjeta) {
        int resultado = 0;
        try{
            daoTarjeta = new TarjetaMySql();
            resultado = daoTarjeta.eliminar(idTarjeta);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarTarjeta")
    public ArrayList<Tarjeta> listarTarjeta() {
        ArrayList<Tarjeta> tarjetas = null;
        try{
            daoTarjeta = new TarjetaMySql();
            tarjetas = daoTarjeta.listarTodas();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return tarjetas;
    }
}
