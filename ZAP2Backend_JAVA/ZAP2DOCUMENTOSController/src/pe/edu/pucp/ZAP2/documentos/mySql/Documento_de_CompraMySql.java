/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.mySql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.documentos.dao.Documento_de_CompraDao;
import pe.edu.pucp.ZAP2.documentos.model.Documento_de_Compra;
import pe.edu.pucp.ZAP2.documentos.model.Moneda;
import pe.edu.pucp.ZAP2.proveedor.model.Pedido; 
/**
 *
 * @author Alejandro
 */
public class Documento_de_CompraMySql implements Documento_de_CompraDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public int insertar(Documento_de_Compra DocCompra) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_DOCUMENTO_DE_COMPRA"
                    +"(?,?,?,?,?)}");
            cs.registerOutParameter("_id_doc_compra",java.sql.Types.INTEGER);
            cs.setInt("_fid_moneda", DocCompra.getMoneda().getIdMoneda());
            cs.setInt("_fid_pedido", DocCompra.getPedido().getId_pedido());
            Date fechaEmisionSQL = new Date(DocCompra.getFecha_emision().getTime());
            cs.setDate("_fecha_emision", fechaEmisionSQL);
            cs.setDouble("_total", DocCompra.getTotal());
            cs.executeUpdate();
            DocCompra.setId_doc_compra(cs.getInt("_id_doc_compra"));
            resultado = DocCompra.getId_doc_compra();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
       
        return resultado;
    }

    @Override
    public int modificar(Documento_de_Compra DocCompra) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_DOCUMENTO_COMPRA (?,?,?,?)}");
            cs.setInt("_id_documento",DocCompra.getId_doc_compra());
            cs.setInt("_fid_moneda", DocCompra.getMoneda().getIdMoneda());
            cs.setInt("_fid_pedido", DocCompra.getPedido().getId_pedido());
            Date fechaEmisionSQL = new Date(DocCompra.getFecha_emision().getTime());
            cs.setDate("_fecha_emision", fechaEmisionSQL);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idDocCompra) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_DOCUMENTO(?)}");
            cs.setInt("_id_documento",idDocCompra);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<Documento_de_Compra> listarTodos() {
        ArrayList<Documento_de_Compra> documentosCompra =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();           
            cs = con.prepareCall("{call LISTAR_DOCUMENTO_COMPRA"
                    +"( )}");
            
            rs = cs.executeQuery();
            while(rs.next()){
                Documento_de_Compra docCompra = new Documento_de_Compra();
                docCompra.setId_doc_compra(rs.getInt("id_doc_compra"));
                docCompra.setId_documento(rs.getInt("id_doc_compra"));
                Moneda moneda = new Moneda();
                Pedido pedido = new Pedido();
                moneda.setIdMoneda(rs.getInt("fid_moneda"));
                pedido.setId_pedido(rs.getInt("fid_pedido"));
                
                Date fecha = rs.getDate("fecha_emision");
                docCompra.setFecha_emision(fecha);
                docCompra.setTotal(rs.getDouble("total"));
                
                docCompra.setMoneda(moneda);
                docCompra.setPedido(pedido);
                
                documentosCompra.add(docCompra);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return documentosCompra;
    }

    @Override
    public ArrayList<Documento_de_Compra> listarEgresos(java.util.Date fechaInicial, java.util.Date fechaFinal) {
        
        ArrayList<Documento_de_Compra> egresos = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call RF_OBTENER_EGRESOS(?,?)}");
            Date fechaIni = new Date(fechaInicial.getTime());
            Date fechaFin = new Date(fechaFinal.getTime());
            cs.setDate("_fecha_inicio", fechaIni);
            cs.setDate( "_fecha_fin", fechaFin);
            cs.executeUpdate();
            rs = cs.executeQuery();
            while(rs.next()){
                Documento_de_Compra egreso= new Documento_de_Compra();
                egreso.setId_doc_compra(rs.getInt("id_doc_compra"));
                egreso.setId_documento(rs.getInt("id_documento"));
                Date fecha = rs.getDate("fecha_emision");
                egreso.setFecha_emision(fecha);
                Moneda mod = new Moneda();
                mod.setNombre(rs.getString("nombre_moneda"));
                mod.setAbreviacion(rs.getString("abreviacion"));
                egreso.setMoneda(mod);
                egreso.setTotal(rs.getDouble("total"));
                egresos.add(egreso);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return egresos;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
