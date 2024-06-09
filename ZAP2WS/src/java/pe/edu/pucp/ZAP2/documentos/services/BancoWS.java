/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import pe.edu.pucp.ZAP2.documentos.dao.BancoDao;
import pe.edu.pucp.ZAP2.documentos.model.Banco;
import pe.edu.pucp.ZAP2.documentos.mySql.BancoMySql;
/**
 *
 * @author Alejandro
 */
@WebService(serviceName = "BancoWS", targetNamespace = "ZAP2WS")
public class BancoWS {

     private BancoDao daoBanco;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "insertarBanco")
    public int insertarBanco(@WebParam(name = "banco") Banco banco) {
        int resultado = 0;
        try{
            daoBanco = new BancoMySql();
            resultado = daoBanco.insertar(banco);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
}
