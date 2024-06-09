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
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.documentos.dao.Documento_de_CompraDao;
import pe.edu.pucp.ZAP2.documentos.model.Documento_de_Compra;

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idDocCompra) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Documento_de_Compra> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
