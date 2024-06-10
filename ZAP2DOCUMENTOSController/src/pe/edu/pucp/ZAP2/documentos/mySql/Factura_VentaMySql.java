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
import pe.edu.pucp.ZAP2.documentos.dao.Factura_VentaDao;
import pe.edu.pucp.ZAP2.documentos.model.Factura_Venta;

/**
 *
 * @author Alejandro
 */
public class Factura_VentaMySql implements Factura_VentaDao{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;

    @Override
    public int insertar(Factura_Venta facturaVenta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_FACTURA_VENTA(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_factura_venta",java.sql.Types.INTEGER);
            cs.setInt("_fid_persona_juridica", facturaVenta.getPersonaJuridica().getId_Persona());
            cs.setString("_detalles", facturaVenta.getDetalles());
            
            java.sql.Date sqlDate = new java.sql.Date(facturaVenta.getFechaVenc().getTime());
            cs.setDate("_fechaVenc", sqlDate);
            
            cs.setInt("_ruc", Integer.parseInt(facturaVenta.getPersonaJuridica().getRUC()));
            
            cs.setInt("_fid_id_tarjeta", facturaVenta.getTarjeta().getIdTarjeta());
            cs.setInt("_fid_empleado", facturaVenta.getEmpleado().getIdEmpleado());
            cs.setDouble("_montoTotal", facturaVenta.getMontoTotal());
            
            cs.setInt("_fid_moneda", facturaVenta.getMoneda().getIdMoneda());
            java.sql.Date sqlDate2 = new java.sql.Date(facturaVenta.getFecha_emision().getTime());
            cs.setDate("_fecha_emision",sqlDate2);
            cs.setDouble("_total", facturaVenta.getTotal());
            
            cs.executeUpdate();
            facturaVenta.setId_doc_venta(cs.getInt("_id_boleta_venta"));
            facturaVenta.setId_documento(cs.getInt("_id_boleta_venta"));
            resultado = facturaVenta.getId_doc_venta();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Factura_Venta facturaVenta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_FACTURA_VENTA (?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("_id_documento",facturaVenta.getId_documento());
            cs.setInt("_fid_persona_juridica", facturaVenta.getPersonaJuridica().getId_Persona());
            cs.setString("_detalles", facturaVenta.getDetalles());
            
            java.sql.Date sqlDate = new java.sql.Date(facturaVenta.getFechaVenc().getTime());
            cs.setDate("_fechaVenc", sqlDate);
            
            cs.setInt("_ruc", Integer.parseInt(facturaVenta.getPersonaJuridica().getRUC()));
            
            cs.setInt("_fid_id_tarjeta", facturaVenta.getTarjeta().getCodTarjeta());
            cs.setInt("_fid_empleado", facturaVenta.getEmpleado().getIdEmpleado());
            cs.setDouble("_montoTotal", facturaVenta.getMontoTotal());
            
            cs.setInt("_fid_moneda", facturaVenta.getMoneda().getIdMoneda());
            java.sql.Date sqlDate2 = new java.sql.Date(facturaVenta.getFecha_emision().getTime());
            cs.setDate("_fecha_emision",sqlDate2);
            cs.setDouble("_total", facturaVenta.getTotal());
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idFacturaVenta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_DOCUMENTO(?)}");
            cs.setInt("_id_documento",idFacturaVenta);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<Factura_Venta> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
