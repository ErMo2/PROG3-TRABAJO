/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.ZAP2.documentos.dao.Documento_de_VentaDao;
import pe.edu.pucp.ZAP2.documentos.model.Documento_de_Venta;
import pe.edu.pucp.ZAP2.documentos.mySql.Documento_de_VentaMySql;

/**
 *
 * @author Alejandro
 */
@WebService(serviceName = "Documento_de_VentaWS", targetNamespace = "ZAP2WS")
public class Documento_de_VentaWS {

    /**
     * This is a sample web service operation
     */
    private Documento_de_VentaDao daoDocVent;
    @WebMethod(operationName = "listarIngresos")
    public ArrayList<Documento_de_Venta> 
        listarIngresos(@WebParam(name = "fechaIni") Date fechaIni, 
                @WebParam(name = "fechaFin") Date fechaFin) {
        ArrayList<Documento_de_Venta> docVentas = null;
        try{
            daoDocVent = new Documento_de_VentaMySql();
            docVentas = daoDocVent.listarIngresos(fechaIni, fechaFin);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return docVentas;
    }
}
