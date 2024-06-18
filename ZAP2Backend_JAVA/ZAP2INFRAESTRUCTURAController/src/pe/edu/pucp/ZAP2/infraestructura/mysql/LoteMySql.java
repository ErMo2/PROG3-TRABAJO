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
import pe.edu.pucp.ZAP2.infraestructura.model.Almacen;
import pe.edu.pucp.ZAP2.infraestructura.model.Producto;
import pe.edu.pucp.ZAP2.infraestructura.model.Sucursal;

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
            cs = con.prepareCall("{call  ELIMINAR_LOTE(?)}");
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
        ArrayList<Lote> lotes =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();

            cs = con.prepareCall("{call LISTAR_LOTE"
                    +"( )}");

            rs = cs.executeQuery();
            while(rs.next()){
                Lote lote = new Lote();
                lote.setIdLote(rs.getInt("id_lote"));
                //Pedido
                lote.setIdPedido(rs.getInt("fid_pedido"));
                Almacen almacen = new Almacen();
                almacen.setId_almacen(rs.getInt("fid_almacen"));
                
                Sucursal sur = new  Sucursal();
                sur.setNombre(rs.getString("nombre"));
                almacen.setSucursal(sur);
                lote.setAlmacen(almacen);
                Producto producto = new Producto() ;
                producto.setIdProducto(rs.getInt("fid_producto"));
                lote.setProducto(producto);

                lote.setStockInicial(rs.getInt("stockInicial"));
                lote.setStockActual(rs.getInt("stockActual"));
                lotes.add(lote);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return lotes;
<<<<<<< HEAD
        
=======
>>>>>>> origin/BACK2
    }
    
}
