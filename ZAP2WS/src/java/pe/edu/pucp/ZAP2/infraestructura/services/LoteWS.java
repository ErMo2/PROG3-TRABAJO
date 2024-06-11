/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.dao.LoteDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Lote;
import pe.edu.pucp.ZAP2.infraestructura.mysql.LoteMySql;

/**
 *
 * @author Coco
 */
@WebService(serviceName = "LoteWS", targetNamespace = "ZAP2WS")
public class LoteWS {

    private LoteDao daoLote;
    @WebMethod(operationName = "insertarLote")
    public int insertarLote(@WebParam(name = "lote") Lote lote) {
        int resultado = 0;
        try{
            daoLote = new LoteMySql();
            resultado = daoLote.insertar(lote);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarLote")
    public int modificarLote(@WebParam(name = "lote") Lote lote) {
        int resultado = 0;
        try{
            daoLote = new LoteMySql();
            resultado = daoLote.modificar(lote);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarLote")
    public int eliminarLote(@WebParam(name = "idLote") int idLote) {
        int resultado = 0;
        try{
            daoLote = new LoteMySql();
            resultado = daoLote.eliminar(idLote);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarLote")
    public ArrayList<Lote> listarLote() {
        ArrayList<Lote> lotes = null;
        try{
            daoLote = new LoteMySql();
            lotes = daoLote.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return lotes;
    }
}
