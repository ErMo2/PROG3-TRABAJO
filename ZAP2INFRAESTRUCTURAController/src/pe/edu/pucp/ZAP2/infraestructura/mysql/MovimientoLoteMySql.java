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
import pe.edu.pucp.ZAP2.infraestructura.dao.MovimientoLoteDao;
import pe.edu.pucp.ZAP2.infraestructura.model.MovimientoLote;

/**
 *
 * @author User
 */
public class MovimientoLoteMySql implements MovimientoLoteDao{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public int insertar(MovimientoLote movLote) {
//        int resultado = 0;
//        try{
//            con = DBManager.getInstance().getConnection();
//            cs = con.prepareCall("{call INSERTAR_MOVIMIENTO_LOTE"
//                    +"(?,?,?,?,?,?,?,?)}");
//            cs.registerOutParameter("_idMovimientoLote", java.sql.Types.INTEGER);
//            cs.setInt("_idAlmacenEntrada",movLote.get);
//            cs.setInt("_idAlmacenSalida",lote.getAlmacen().getId_almacen());
//            cs.setInt("_fechaMovimiento", lote.getProducto().getIdProducto());
//            cs.setInt("_motivo", lote.getProducto().getIdProducto());
//            cs.setInt("_movimientoEntrada", lote.getProducto().getIdProducto());
//            cs.setInt("_cantidadProductosMovidos", lote.getProducto().getIdProducto());
//            cs.setInt("_fid_lote", lote.getProducto().getIdProducto());
//            resultado = cs.executeUpdate();
//            movLote.setIdMovimientoLote(cs.getInt("_idMovimientoLote"));
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }finally{
//            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
//        }
//        return resultado;
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int modificar(MovimientoLote movLote) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idMovimientoLote) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<MovimientoLote> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
