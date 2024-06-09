/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import pe.edu.pucp.ZAP2.infraestructura.dao.AlmacenDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Almacen;
import pe.edu.pucp.ZAP2.infraestructura.mysql.AlmacenMySql;

/**
 *
 * @author User
 */
@WebService(serviceName = "AlmacenWS")
public class AlmacenWS {
    private AlmacenDao daoAlmacen;
    @WebMethod(operationName = "insertarAlmacen")
    public int insertarAlmacen(@WebParam(name = "almacen") Almacen almacen) {
        int resultado = 0;
        try{
            daoAlmacen = new AlmacenMySql();
            resultado = daoAlmacen.insertar(almacen);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
}
