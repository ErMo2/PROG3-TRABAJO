/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.dao.MovimientoLoteDao;
import pe.edu.pucp.ZAP2.infraestructura.model.MovimientoLote;
import pe.edu.pucp.ZAP2.infraestructura.mysql.MovimientoLoteMySql;

/**
 *
 * @author Coco
 */
@WebService(serviceName = "MovimientoLoteWS", targetNamespace = "ZAP2WS")
public class MovimientoLoteWS {

    private MovimientoLoteDao daoMovimientoLote;
    @WebMethod(operationName = "insertarMovimientoLote")
    public int insertarMovimientoLote(@WebParam(name = "movimientoLote") MovimientoLote movimientoLote) {
        int resultado = 0;
        try{
            daoMovimientoLote = new MovimientoLoteMySql();
            resultado = daoMovimientoLote.insertar(movimientoLote);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "modificarMovimientoLote")
    public int modificarMovimientoLote(@WebParam(name = "movimientoLote") MovimientoLote movimientoLote) {
        int resultado = 0;
        try{
            daoMovimientoLote = new MovimientoLoteMySql();
            resultado = daoMovimientoLote.modificar(movimientoLote);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarMovimientoLote")
    public int eliminarMovimientoLote(@WebParam(name = "idMovimientoLote") int idMovimientoLote) {
        int resultado = 0;
        try{
            daoMovimientoLote = new MovimientoLoteMySql();
            resultado = daoMovimientoLote.eliminar(idMovimientoLote);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarMovimientoLote")
    public ArrayList<MovimientoLote> listarMovimientoLote() {
        ArrayList<MovimientoLote> movLotes = null;
        try{
            daoMovimientoLote = new MovimientoLoteMySql();
            movLotes = daoMovimientoLote.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return movLotes;
    }
}
