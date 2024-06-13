/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.dao.ProductosParaElCuidadoPersonalYDelHogarDao;
import pe.edu.pucp.ZAP2.infraestructura.model.ProductosParaElCuidadoPersonalYDelHogar;
import pe.edu.pucp.ZAP2.infraestructura.mysql.ProductosParaElCuidadoPersonalYDelHogarMySql;

/**
 *
 * @author Coco
 */
@WebService(serviceName = "ProductosParaElCuidadoPersonalYDelHogarWS", targetNamespace = "ZAP2WS")
public class ProductosParaElCuidadoPersonalYDelHogarWS {

    private ProductosParaElCuidadoPersonalYDelHogarDao daoPCH;
    @WebMethod(operationName = "insertarPCH")
    public int insertarPCH(@WebParam(name = "PCH") ProductosParaElCuidadoPersonalYDelHogar PCH) {
        int resultado = 0;
        try{
            daoPCH = new ProductosParaElCuidadoPersonalYDelHogarMySql();
            resultado = daoPCH.insertar(PCH);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "modificarPCH")
    public int modificarPCH(@WebParam(name = "PCH") ProductosParaElCuidadoPersonalYDelHogar PCH) {
        int resultado = 0;
        try{
            daoPCH = new ProductosParaElCuidadoPersonalYDelHogarMySql();
            resultado = daoPCH.modificar(PCH);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "eliminarPCH")
    public int eliminarPCH(@WebParam(name = "idPCH") int idPCH) {
        int resultado = 0;
        try{
            daoPCH = new ProductosParaElCuidadoPersonalYDelHogarMySql();
            resultado = daoPCH.eliminar(idPCH);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarPCH")
    public ArrayList<ProductosParaElCuidadoPersonalYDelHogar> listarPCH() {
        ArrayList<ProductosParaElCuidadoPersonalYDelHogar> PCHs = null;
        try{
            daoPCH = new ProductosParaElCuidadoPersonalYDelHogarMySql();
            PCHs = daoPCH.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return PCHs;
    }
    
    @WebMethod(operationName = "buscarProductoPCH")
    public ProductosParaElCuidadoPersonalYDelHogar buscarProductoPCH(@WebParam(name = "idProductoPCH") int idProd) {
        ProductosParaElCuidadoPersonalYDelHogar prod = null;
        try{
            daoPCH = new ProductosParaElCuidadoPersonalYDelHogarMySql();
            prod = daoPCH.buscarProducto(idProd);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return prod;
    }
}
