/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import pe.edu.pucp.ZAP2.infraestructura.dao.AreaDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Area;
import pe.edu.pucp.ZAP2.infraestructura.mysql.AreaMySql;

/**
 *
 * @author Alejandro
 */
@WebService(serviceName = "AreaWS", targetNamespace = "ZAP2WS")
public class AreaWS {

    /**
     * This is a sample web service operation
     */
    private AreaDao daoArea;
    @WebMethod(operationName = "insertarArea")
    public int insertarArea(@WebParam(name = "area") Area area) {
        int resultado = 0;
        try{
            daoArea = new AreaMySql();
            resultado = daoArea.insertar(area);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
}
