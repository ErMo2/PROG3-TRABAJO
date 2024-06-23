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
import pe.edu.pucp.ZAP2.documentos.dao.Documento_de_CompraDao;
import pe.edu.pucp.ZAP2.documentos.model.Documento_de_Compra;
import pe.edu.pucp.ZAP2.documentos.mySql.Documento_de_CompraMySql;

/**
 *
 * @author Coco
 */
@WebService(serviceName = "Documento_de_CompraWS", targetNamespace = "ZAP2WS")
public class Documento_de_CompraWS {

    /**
     * This is a sample web service operation
     */
    private Documento_de_CompraDao daoDocumentoCompras;
    @WebMethod(operationName = "insertarDocumentoCompra")
    public int insertarDocumentoCompra(@WebParam(name = "documentoCompra") Documento_de_Compra documentoCompra) {
        int resultado = 0;
        try{
            daoDocumentoCompras = new Documento_de_CompraMySql();
            resultado = daoDocumentoCompras.insertar(documentoCompra);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarDocumentoCompra")
    public int modificarDocumentoCompra(@WebParam(name = "documentoCompra") Documento_de_Compra documentoCompra) {
        int resultado = 0;
        try{
            daoDocumentoCompras = new Documento_de_CompraMySql();
            resultado = daoDocumentoCompras.modificar(documentoCompra);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarDocumentoCompra")
    public int eliminarDocumentoCompra(@WebParam(name = "idDocumentoCompra") int idDocumentoCompra) {
        int resultado = 0;
        try{
            daoDocumentoCompras = new Documento_de_CompraMySql();
            resultado = daoDocumentoCompras.eliminar(idDocumentoCompra);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarDocumentosCompras")
    public ArrayList<Documento_de_Compra> listarDocumentosCompras() {
        ArrayList<Documento_de_Compra> boletasVentas = null;
        try{
            daoDocumentoCompras = new Documento_de_CompraMySql();
            boletasVentas = daoDocumentoCompras.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return boletasVentas;
    }
    @WebMethod(operationName = "listarEgresos")
    public ArrayList<Documento_de_Compra> 
        listarEgresos(@WebParam(name = "fechaIni") Date fechaIni, 
                @WebParam(name = "fechaFin") Date fechaFin) {
        ArrayList<Documento_de_Compra> docCompras = null;
        try{
            System.out.println("Fecha inicio: " + fechaIni);
            System.out.println("Fecha Fin: " + fechaFin);
            daoDocumentoCompras = new Documento_de_CompraMySql();
            docCompras = daoDocumentoCompras.listarEgresos(fechaIni, fechaFin);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return docCompras;
    }
}
