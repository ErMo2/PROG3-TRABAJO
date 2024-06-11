/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.mySql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.documentos.dao.Documento_de_VentaDao;
import pe.edu.pucp.ZAP2.documentos.model.Documento_de_Venta;
import pe.edu.pucp.ZAP2.documentos.model.Moneda;

/**
 *
 * @author Alejandro
 */
public class Documento_de_VentaMySql implements Documento_de_VentaDao{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public ArrayList<Documento_de_Venta> listarIngresos(Date fechaInicial, Date fechaFinal) {
        ArrayList<Documento_de_Venta> ingresos = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call RF_OBTENER_INGRESOS(?,?)}");
            java.sql.Date fechaIni = new java.sql.Date(fechaInicial.getTime());
            java.sql.Date fechaFin = new java.sql.Date(fechaFinal.getTime());
            cs.setDate("_fecha_inicio", fechaIni);
            cs.setDate("_fecha_fin", fechaFin);
            cs.executeUpdate();
            rs = cs.executeQuery();
            while(rs.next()){
                Documento_de_Venta ingreso= new Documento_de_Venta();
                ingreso.setId_doc_venta(rs.getInt("id_documento"));
                ingreso.setId_documento(rs.getInt("id_documento"));
                Date fecha = rs.getDate("fecha_emision");
                ingreso.setFecha_emision(fecha);
                Moneda mon = new Moneda();
                mon.setNombre(rs.getString("nombre_moneda"));
                mon.setAbreviacion(rs.getString("abreviacion"));
                ingreso.setMoneda(mon);
                ingreso.setTotal(rs.getDouble("total"));
                ingreso.setMontoTotal(rs.getDouble("montoTotal"));
                ingresos.add(ingreso);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return ingresos;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
