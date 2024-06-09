/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import pe.edu.pucp.ZAP2.documentos.dao.Boleta_VentaDao;
import pe.edu.pucp.ZAP2.documentos.model.Boleta_Venta;
import pe.edu.pucp.ZAP2.documentos.mySql.Boleta_VentaMySql;
/**
 *
 * @author Alejandro
 */
@WebService(serviceName = "Boleta_VentaWS", targetNamespace = "ZAP2WS")
public class Boleta_VentaWS {

     private Boleta_VentaDao daoBoletaVenta;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "insertarBoletaVenta")
    public int insertarBoletaVenta(@WebParam(name = "boletaVenta") Boleta_Venta boletaVenta) {
        int resultado = 0;
        try{
            daoBoletaVenta = new Boleta_VentaMySql();
            resultado = daoBoletaVenta.insertar(boletaVenta);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
}
