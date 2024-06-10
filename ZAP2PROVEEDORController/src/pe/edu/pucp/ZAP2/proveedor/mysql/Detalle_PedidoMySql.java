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
import pe.edu.pucp.ZAP2.proveedor.dao.Detalle_PedidoDao;
import pe.edu.pucp.ZAP2.proveedor.model.Detalle_Pedido;

/**
 *
 * @author Alejandro
 */
public class Detalle_PedidoMySql implements Detalle_PedidoDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public int insertar(Detalle_Pedido detallePedido) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_DETALLE_PEDIDO"
                    +"(?,?,?,?)}");
            cs.registerOutParameter("_id_DetallePedido", java.sql.Types.INTEGER);
            cs.setInt("_fid_pedido", detallePedido.getPedido().getId_pedido());
            cs.setDouble("_precioUnitario", detallePedido.getPrecioUnitario());
            cs.setDouble("_precioTotal", detallePedido.getPrecioTotal());
            resultado = cs.executeUpdate();
            detallePedido.setId_DetallePedido(cs.getInt("_id_DetallePedido"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Detalle_Pedido detallePedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idDetallePedido) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  (?)}");
            cs.setInt("_id_DetallePedido",idDetallePedido);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<Detalle_Pedido> listarTodas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
