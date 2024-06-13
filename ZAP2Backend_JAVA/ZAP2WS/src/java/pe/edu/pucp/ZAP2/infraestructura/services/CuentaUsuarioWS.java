/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.dao.CuentaUsuarioDao;
import pe.edu.pucp.ZAP2.infraestructura.model.CuentaUsuario;
import pe.edu.pucp.ZAP2.infraestructura.mysql.CuentaUsuarioMySql;

/**
 *
 * @author Coco
 */
@WebService(serviceName = "CuentaUsuarioWS", targetNamespace = "ZAP2WS")
public class CuentaUsuarioWS {

    private CuentaUsuarioDao daoCuentaUsuario;
    @WebMethod(operationName = "insertarCuentaUsuario")
    public int insertarCuentaUsuario(@WebParam(name = "cuentaUsuario") CuentaUsuario cuentaUsuario) {
        int resultado = 0;
        try{
            daoCuentaUsuario = new CuentaUsuarioMySql();
            resultado = daoCuentaUsuario.insertar(cuentaUsuario);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "modificarCuentaUsuario")
    public int modificarCuentaUsuario(@WebParam(name = "cuentaUsuario") CuentaUsuario cuentaUsuario) {
        int resultado = 0;
        try{
            daoCuentaUsuario = new CuentaUsuarioMySql();
            resultado = daoCuentaUsuario.modificar(cuentaUsuario);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarCuentaUsuario")
    public int eliminarCuentaUsuario(@WebParam(name = "idCuentaUsuario") int idCuentaUsuario) {
        int resultado = 0;
        try{
            daoCuentaUsuario = new CuentaUsuarioMySql();
            resultado = daoCuentaUsuario.eliminar(idCuentaUsuario);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarCuentaUsuarios")
    public ArrayList<CuentaUsuario> listarCuentaUsuarios() {
        ArrayList<CuentaUsuario> cuentas = null;
        try{
            daoCuentaUsuario = new CuentaUsuarioMySql();
            cuentas = daoCuentaUsuario.listarTodas();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return cuentas;
    }
    
    
    @WebMethod(operationName = "VerificarCuenta")
    public int VerificarCuenta(@WebParam(name = "Usuario") String usuario,@WebParam(name = "Contra")String contra) {
        int resultado = 0;
        try{
            daoCuentaUsuario = new CuentaUsuarioMySql();
            resultado = daoCuentaUsuario.verificar(usuario,contra);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
}
