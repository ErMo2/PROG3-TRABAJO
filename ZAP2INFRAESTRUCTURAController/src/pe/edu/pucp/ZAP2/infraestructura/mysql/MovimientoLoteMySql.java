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
import java.util.Date;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.infraestructura.dao.MovimientoLoteDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Almacen;
import pe.edu.pucp.ZAP2.infraestructura.model.Lote;
import pe.edu.pucp.ZAP2.infraestructura.model.MovimientoLote;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoDeMotivoMovimientoAlmacen;

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
            if(movLote.getMotivo()==TipoDeMotivoMovimientoAlmacen.traslado || movLote.getMotivo()==TipoDeMotivoMovimientoAlmacen.reposicionAnaqueles)
                cs.setInt("_idAlmacenSalida",movLote.getAlmacenSalida().getId_almacen());
            else
                cs.setNull("_idAlmacenSalida",1);
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
    //FALTA PROCEDURE MOVIMIENTO LOTE 
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
        ArrayList<MovimientoLote> lotes =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();

            cs = con.prepareCall("{call LISTAR_MOVIMIENTO_LOTE"
                    +"( )}");

            rs = cs.executeQuery();
            while(rs.next()){
                MovimientoLote MovLote = new MovimientoLote();
                MovLote.setIdMovimientoLote(rs.getInt("idMovimientoLote"));
                Almacen entrada = new Almacen();
                Almacen salida = new Almacen();
                entrada.setId_almacen(rs.getInt("idAlmacenEntrada"));
                salida.setId_almacen(rs.getInt("idAlmacenSalida"));
                MovLote.setAlmacenEntrada(entrada);
                MovLote.setAlmacenSalida(salida);
                Date fecha = rs.getDate("fechaMovimiento");
                MovLote.setFechaMovimiento(fecha);
                TipoDeMotivoMovimientoAlmacen tip = TipoDeMotivoMovimientoAlmacen.valueOf(rs.getString("motivo"));
                MovLote.setMotivo(tip);
                MovLote.setMovimientoEntrada(rs.getInt("movimientoEntrada"));
                MovLote.setCantidadProductosMovidos(rs.getDouble("cantidadProductosMovidos"));
                Lote lote = new Lote();
                lote.setIdLote(rs.getInt("fid_lote"));
                MovLote.setLote(lote);
                lotes.add(MovLote);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return lotes;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
