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
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.documentos.dao.Boleta_VentaDao;
import pe.edu.pucp.ZAP2.documentos.model.Boleta_Venta;
/**
 *
 * @author Alejandro
 */
public class Boleta_VentaMySql implements Boleta_VentaDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;

    @Override
    public int insertar(Boleta_Venta boletaVenta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_BOLETA_VENTA(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_boleta_venta",java.sql.Types.INTEGER);
            cs.setInt("_fid_id_persona", boletaVenta.getPersona().getId_Persona());
            cs.setInt("_numSerie", boletaVenta.getNumSerie());
            cs.setString("_detalles", boletaVenta.getDetalles());
            cs.setDouble("_impuestos", boletaVenta.getImpuestos());
            
            cs.setInt("_fid_id_tarjeta", boletaVenta.getTarjeta().getCodTarjeta());
            cs.setInt("_fid_empleado", boletaVenta.getEmpleado().getIdEmpleado());
            cs.setDouble("_montoTotal", boletaVenta.getMontoTotal());
            
            cs.setInt("_fid_moneda", boletaVenta.getMoneda().getIdMoneda());
            java.sql.Date sqlDate = new java.sql.Date(boletaVenta.getFecha_emision().getTime());
            cs.setDate("_fecha_emision",sqlDate);
            cs.setDouble("_total", boletaVenta.getTotal());
            
            cs.executeUpdate();
            boletaVenta.setId_doc_venta(cs.getInt("_id_boleta_venta"));
            boletaVenta.setId_documento(cs.getInt("_id_boleta_venta"));
            resultado = boletaVenta.getId_doc_venta();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Boleta_Venta boletaVenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idBoleta_Venta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Boleta_Venta> listarTodas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
