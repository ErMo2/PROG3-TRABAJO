/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.infraestructura.dao.LoteDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Lote;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class LoteMySql implements LoteDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public int insertar(Lote lote) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_LOTE"
                    +"(?,?,?,?,?)}");
            cs.registerOutParameter("_id_lote", java.sql.Types.INTEGER);
            cs.setInt("_fid_pedido",lote.getIdPedido());
            cs.setInt("_fid_almacen",lote.getAlmacen().getId_almacen());
            cs.setInt("_fid_producto", lote.getProducto().getIdProducto());
            cs.setDouble("_stockInicial", lote.getStockInicial());
            resultado = cs.executeUpdate();
            lote.setIdLote(cs.getInt("_id_lote"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Lote lote) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_LOTE"
                    +"(?,?,?,?,?,?)}");
            cs.setInt("_id_lote", lote.getIdLote());
            cs.setInt("_fid_pedido",lote.getIdPedido());
            cs.setInt("_fid_almacen",lote.getAlmacen().getId_almacen());
            cs.setInt("_fid_producto", lote.getProducto().getIdProducto());
            cs.setDouble("_stockInicial", lote.getStockInicial());
            cs.setDouble("_stockActual", lote.getStockActual());
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idLote) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  (?)}");
            cs.setInt("_id_lote",idLote);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<Lote> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
