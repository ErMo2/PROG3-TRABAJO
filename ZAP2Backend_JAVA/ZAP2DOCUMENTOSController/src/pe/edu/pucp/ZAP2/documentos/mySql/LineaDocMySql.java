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
import pe.edu.pucp.ZAP2.documentos.dao.LineaDocDao;
import pe.edu.pucp.ZAP2.documentos.model.Documento;
import pe.edu.pucp.ZAP2.documentos.model.LineaDoc;
import pe.edu.pucp.ZAP2.infraestructura.model.ProductoPrecio;

/**
 *
 * @author Alejandro
 */
public class LineaDocMySql implements LineaDocDao{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public synchronized int insertar(LineaDoc lineaDoc) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_LINEADOC_Mejorado(?,?,?,?)}");
            cs.registerOutParameter("_id_lineaDoc",java.sql.Types.INTEGER);
            cs.setInt("_fid_producto_precio", lineaDoc.getProducto().getIdProductoPrecio());
            cs.setInt("_fid_id_doc", lineaDoc.getDocumento().getId_documento());
            cs.setDouble("_cantidad", lineaDoc.getCantidad());
            cs.executeUpdate();
            lineaDoc.setIdLineDoc(cs.getInt("_id_lineaDoc"));
            resultado = lineaDoc.getIdLineDoc();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(LineaDoc lineaDoc) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_LINEA_DOC (?,?,?,?)}");
            cs.setInt("_id_lineaDoc",lineaDoc.getIdLineDoc());
            cs.setInt("_fid_producto_precio",lineaDoc.getProducto().getIdProductoPrecio());
            cs.setInt("_fid_id_doc",lineaDoc.getDocumento().getId_documento());
            cs.setDouble("_cantidad",lineaDoc.getCantidad());
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idLineaDoc) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_LINEA_DOC(?)}");
            cs.setInt("_id_lineaDoc",idLineaDoc);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<LineaDoc> listarTodos() {
        ArrayList<LineaDoc> lineas =  new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_LINEADOC()}");
            rs = cs.executeQuery();
            while(rs.next()){
                LineaDoc linea = new LineaDoc();
                
                linea.setIdLineDoc(rs.getInt("id_lineaDoc"));
                ProductoPrecio prodPrecio = new ProductoPrecio();
                prodPrecio.setIdProductoPrecio(rs.getInt("fid_producto_precio"));
                linea.setProducto(prodPrecio);
                Documento doc = new Documento();
                doc.setId_documento(rs.getInt("fid_id_doc"));
                linea.setDocumento(doc);
                
                linea.setPrecioUnitario(rs.getDouble("precioUnitario"));
                linea.setPrecioTotal(rs.getDouble("precioTotal"));
                linea.setCantidad(rs.getDouble("cantidad"));
                linea.setSubTotal(rs.getDouble("subtotal"));
                lineas.add(linea);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return lineas;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
