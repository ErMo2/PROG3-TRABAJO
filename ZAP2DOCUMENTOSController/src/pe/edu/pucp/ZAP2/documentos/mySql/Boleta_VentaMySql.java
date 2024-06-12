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
import java.sql.SQLException;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.documentos.dao.Boleta_VentaDao;
import pe.edu.pucp.ZAP2.documentos.model.Boleta_Venta;
import pe.edu.pucp.ZAP2.documentos.model.Moneda;
import pe.edu.pucp.ZAP2.documentos.model.Tarjeta;
import pe.edu.pucp.ZAP2.infraestructura.model.Empleado;
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
            
            cs.setInt("_fid_id_tarjeta", boletaVenta.getTarjeta().getIdTarjeta());
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
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_BOLETA_VENTA (?,?,?,?,?,?,?,?)}");
            cs.setInt("_id_documento",boletaVenta.getId_documento());
            cs.setInt("_fid_id_persona", boletaVenta.getPersona().getId_Persona());
            cs.setInt("_numSerie", boletaVenta.getNumSerie());
            cs.setString("_detalles", boletaVenta.getDetalles());
            
            cs.setInt("_fid_id_tarjeta", boletaVenta.getTarjeta().getIdTarjeta());
            cs.setInt("_fid_empleado", boletaVenta.getEmpleado().getIdEmpleado());
            
            cs.setInt("_fid_moneda", boletaVenta.getMoneda().getIdMoneda());
            java.sql.Date sqlDate = new java.sql.Date(boletaVenta.getFecha_emision().getTime());
            cs.setDate("_fecha_emision",sqlDate);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idBoleta_Venta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_DOCUMENTO(?)}");
            cs.setInt("_id_documento",idBoleta_Venta);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<Boleta_Venta> listarTodas() {
        ArrayList<Boleta_Venta> boletasVenta =  new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_BOLETA_VENTA( )}");
            rs = cs.executeQuery();
            while(rs.next()){
                Boleta_Venta bolVenta = new Boleta_Venta();
                bolVenta.setId_doc_venta(rs.getInt("id_boleta_venta"));
                
                Empleado empleado = new Empleado(){};
                empleado.setId_Persona(rs.getInt("fid_id_persona"));
                empleado.setIdEmpleado(rs.getInt("fid_id_persona"));
                bolVenta.setEmpleado(empleado);
                
                bolVenta.setNumSerie(rs.getInt("numSerie"));
                bolVenta.setDetalles(rs.getString("detalles"));
                bolVenta.setImpuestos(rs.getDouble("impuestos"));
                
                Tarjeta tarjeta = new Tarjeta();
                tarjeta.setIdTarjeta(rs.getInt("fid_id_tarjeta"));
                bolVenta.setTarjeta(tarjeta);
                bolVenta.setMontoTotal(rs.getDouble("montoTotal"));
                
                Moneda moneda = new Moneda();
                moneda.setIdMoneda(rs.getInt("fid_moneda"));
                bolVenta.setMoneda(moneda);
                bolVenta.setFecha_emision(rs.getDate("fecha_emision"));
                bolVenta.setTotal(rs.getDouble("total"));
                
                boletasVenta.add(bolVenta);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return boletasVenta;
    }
    
}
