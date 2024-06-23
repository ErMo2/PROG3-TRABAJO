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
import java.util.Date;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.proveedor.dao.PedidoDao;
import pe.edu.pucp.ZAP2.proveedor.model.Estado_Pedido;
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
            cs.setString("_nombre",pedido.getNombre());
            
            resultado = cs.executeUpdate();
            pedido.setId_pedido(cs.getInt("_id_pedido"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return pedido.getId_pedido();
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
            cs.setString("_nombre",pedido.getNombre());
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
        ArrayList<Pedido> pedidos =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_PEDIDO"
                    +"( )}");
            rs = cs.executeQuery();
            while(rs.next()){
                Pedido ped = new Pedido();
                ped.setId_pedido(rs.getInt("id_pedido"));
                ped.setSaldo(rs.getDouble("saldo"));
                
                String estadoPedStr = rs.getString("estado");
                Estado_Pedido est_pedido = Estado_Pedido.valueOf(estadoPedStr);
                ped.setEstado(est_pedido);
                
                Date fecha = rs.getDate("fecha_pedido");
                ped.setFecha_Pedido(fecha);
                ped.setTotal(rs.getDouble("total"));
                ped.setNombre(rs.getString("nombre"));
                pedidos.add(ped);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return pedidos;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pedido buscar(int id) {
    Pedido ped = null;
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call BUSCAR_PEDIDO_X_ID"
                    +"(?)}");
            cs.setInt("_id", id);
            rs = cs.executeQuery();
            ped = new Pedido();
            while(rs.next()){
                
                 
                ped.setId_pedido(rs.getInt("id_pedido"));
                ped.setSaldo(rs.getDouble("saldo"));
                
                ped.setEstado(Estado_Pedido.valueOf(rs.getString("estado")));
                Date fecha = rs.getDate("fecha_pedido");
                ped.setFecha_Pedido(fecha);
                ped.setTotal(rs.getDouble("total"));
                
                
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return ped;
    }

    @Override
    public ArrayList<Pedido> listarTodasXnombre(String id) {
        
        ArrayList<Pedido> pedidos =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_PEDIDO_X_NOMBRE"
                    +"(?)}");
            cs.setString("_nombre", id);
            rs = cs.executeQuery();
            while(rs.next()){
                Pedido ped = new Pedido();
                ped.setId_pedido(rs.getInt("id_pedido"));
                ped.setSaldo(rs.getDouble("saldo"));
                
                String estadoPedStr = rs.getString("estado");
                Estado_Pedido est_pedido = Estado_Pedido.valueOf(estadoPedStr);
                ped.setEstado(est_pedido);
                
                Date fecha = rs.getDate("fecha_pedido");
                ped.setFecha_Pedido(fecha);
                ped.setTotal(rs.getDouble("total"));
                ped.setNombre(rs.getString("nombre"));
                pedidos.add(ped);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return pedidos;
    }
    
}
