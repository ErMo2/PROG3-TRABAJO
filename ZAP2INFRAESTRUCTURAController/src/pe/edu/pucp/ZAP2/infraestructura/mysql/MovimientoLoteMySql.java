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
import java.sql.SQLException;
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
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_MOVIMIENTO_LOTE"
                    +"(?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_idMovimientoLote", java.sql.Types.INTEGER);
            cs.setInt("_idAlmacenEntrada",movLote.getAlmacenEntrada().getId_almacen());
            cs.setInt("_idAlmacenSalida",movLote.getAlmacenSalida().getId_almacen());
            java.sql.Date sqlDate = new java.sql.Date(movLote.getFechaMovimiento().getTime());
            cs.setDate("_fechaMovimiento",sqlDate);
            
            cs.setString("_motivo", movLote.getMotivo().toString());
            cs.setInt("_movimientoEntrada", movLote.getMovimientoEntrada());
            cs.setDouble("_cantidadProductosMovidos", movLote.getCantidadProductosMovidos());
            cs.setInt("_fid_lote", movLote.getLote().getIdLote());
            resultado = cs.executeUpdate();
            movLote.setIdMovimientoLote(cs.getInt("_idMovimientoLote"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(MovimientoLote movLote) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idMovimientoLote) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_MOVIMIENTO_LOTE(?)}");
            cs.setInt("_idMovimientoLote",idMovimientoLote);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<MovimientoLote> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
