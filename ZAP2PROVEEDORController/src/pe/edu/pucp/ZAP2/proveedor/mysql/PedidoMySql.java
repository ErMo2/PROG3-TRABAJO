/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.proveedor.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.proveedor.dao.PedidoDao;
import pe.edu.pucp.ZAP2.proveedor.model.Pedido;

/**
 *
 * @author Alejandro
 */
public class PedidoMySql implements PedidoDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public int insertar(Pedido pedido) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_PEDIDO"
                    +"(?,?,?,?,?)}");
            cs.registerOutParameter("_id_pedido", java.sql.Types.INTEGER);
            cs.setDouble("_saldo", pedido.getSaldo());
            cs.setString("_estado", pedido.getEstado().toString());
            java.sql.Date fechaPedido = new java.sql.Date(pedido.getFecha_Pedido().getTime()); 
            cs.setDate("_fecha_pedido", fechaPedido);
            cs.setDouble("_total", pedido.getTotal());
            resultado = cs.executeUpdate();
            pedido.setId_pedido(cs.getInt("_id_pedido"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Pedido pedido) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_PEDIDO"
                    +"(?,?,?,?)}");
            cs.setInt("_id_pedido", pedido.getId_pedido());
            cs.setDouble("_saldo", pedido.getSaldo());
            cs.setString("_estado", pedido.getEstado().toString());
            java.sql.Date fechaPedido = new java.sql.Date(pedido.getFecha_Pedido().getTime()); 
            cs.setDate("_fecha_pedido", fechaPedido);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idpedido) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_PEDIDO(?)}");
            cs.setInt("_id_pedido",idpedido);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<Pedido> listarTodas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
