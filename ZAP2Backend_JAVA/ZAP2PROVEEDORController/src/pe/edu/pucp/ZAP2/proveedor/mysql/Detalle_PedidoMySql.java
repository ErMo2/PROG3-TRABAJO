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
import pe.edu.pucp.ZAP2.infraestructura.model.Producto;
import pe.edu.pucp.ZAP2.proveedor.dao.Detalle_PedidoDao;
import pe.edu.pucp.ZAP2.proveedor.model.Detalle_Pedido;
import pe.edu.pucp.ZAP2.proveedor.model.Pedido;

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
    public synchronized int insertar(Detalle_Pedido detallePedido) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_DETALLE_PEDIDO"
                    +"(?,?,?,?,?)}");
            cs.registerOutParameter("_id_DetallePedido", java.sql.Types.INTEGER);
            cs.setInt("_fid_pedido", detallePedido.getPedido().getId_pedido());
            cs.setDouble("_precioUnitario", detallePedido.getPrecioUnitario());
            cs.setDouble("_precioTotal", detallePedido.getPrecioTotal());
            cs.setInt("_fidProducto", detallePedido.getProducto().getIdProducto());
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
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_DETALLE_PEDIDO"
                    +"(?,?,?,?)}");
            cs.setInt("_id_DetallePedido", detallePedido.getId_DetallePedido());
            cs.setInt("_fid_pedido", detallePedido.getPedido().getId_pedido());
            cs.setDouble("_precioUnitario", detallePedido.getPrecioUnitario());
            cs.setDouble("_precioTotal", detallePedido.getPrecioTotal());
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
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
        ArrayList<Detalle_Pedido> detallesArray =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_DETALLE_PEDIDO"
                    +"( )}");
            rs = cs.executeQuery();
            while(rs.next()){
                Detalle_Pedido detalles = new Detalle_Pedido();
                detalles.setId_DetallePedido(rs.getInt("id_DetallePedido"));
                Pedido ped = new Pedido();
                ped.setId_pedido(rs.getInt("fid_pedido"));
                detalles.setPedido(ped);
                detalles.setPrecioTotal(rs.getDouble("precioTotal"));
                detalles.setPrecioUnitario(rs.getDouble("precioUnitario"));
                detalles.setSubtotal(rs.getDouble("subtotal"));
                
                detallesArray.add(detalles);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return detallesArray;

        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Detalle_Pedido> listarXIDPedido(int idPedido) {
        ArrayList<Detalle_Pedido> detallesArray =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_DETALLE_DE_UN_PEDIDO_X_ID"
                    +"(?)}");
            cs.setInt("_id_pedido", idPedido);
            rs = cs.executeQuery();
            while(rs.next()){
                Detalle_Pedido detalles = new Detalle_Pedido();
                detalles.setId_DetallePedido(rs.getInt("id_DetallePedido"));
                detalles.setPrecioTotal(rs.getDouble("precioTotal"));
                detalles.setPrecioUnitario(rs.getDouble("precioUnitario"));
                detalles.setSubtotal(rs.getDouble("subtotal"));
                
                Producto prod = new Producto();
                prod.setIdProducto(rs.getInt("fid_producto"));
                prod.setNombre(rs.getString("nombre"));
                detalles.setProducto(prod);
                detallesArray.add(detalles);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return detallesArray;
    }
    
}
