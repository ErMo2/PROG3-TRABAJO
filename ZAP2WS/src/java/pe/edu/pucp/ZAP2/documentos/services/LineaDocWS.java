/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.documentos.dao.LineaDocDao;
import pe.edu.pucp.ZAP2.documentos.model.LineaDoc;
import pe.edu.pucp.ZAP2.documentos.mySql.LineaDocMySql;

/**
 *
 * @author Coco
 */
@WebService(serviceName = "LineaDocWS", targetNamespace = "ZAP2WS")
public class LineaDocWS {

    /**
     * This is a sample web service operation
     */
    private LineaDocDao daoLineaDoc;
    @WebMethod(operationName = "insertarLineaDoc")
    public int insertarLineaDoc(@WebParam(name = "lineaDoc") LineaDoc lineaDoc) {
        int resultado = 0;
        try{
            daoLineaDoc = new LineaDocMySql();
            resultado = daoLineaDoc.insertar(lineaDoc);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarLineaDoc")
    public int modificarLineaDoc(@WebParam(name = "lineaDoc") LineaDoc lineaDoc) {
        int resultado = 0;
        try{
            daoLineaDoc = new LineaDocMySql();
            resultado = daoLineaDoc.modificar(lineaDoc);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarLineaDoc")
    public int eliminarLineaDoc(@WebParam(name = "idLineaDoc") int idLineaDoc) {
        int resultado = 0;
        try{
            daoLineaDoc = new LineaDocMySql();
            resultado = daoLineaDoc.eliminar(idLineaDoc);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarLineaDoc")
    public ArrayList<LineaDoc> listarLineaDoc() {
        ArrayList<LineaDoc> lineasDoc = null;
        try{
            daoLineaDoc = new LineaDocMySql();
            lineasDoc = daoLineaDoc.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return lineasDoc;
    }
}
