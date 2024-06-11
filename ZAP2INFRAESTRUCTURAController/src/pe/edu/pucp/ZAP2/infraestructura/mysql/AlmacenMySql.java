/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.mysql;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.infraestructura.dao.AlmacenDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Almacen;

/**
 *
 * @author User
 */
public class AlmacenMySql implements AlmacenDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    
    @Override
    public int insertar(Almacen almacen) {
    
        int resultado=0;
        try{
            con=DBManager.getInstance().getConnection();
            cs=con.prepareCall("{call INSERTAR_ALMACEN(?,?,?,?)}");
            cs.registerOutParameter("_id_almacen", java.sql.Types.INTEGER);
            cs.setInt("_fid_sucursal",almacen.getSucursal().getId_sucursal());
            cs.setString("_tipoAlmacen",almacen.getTipoAlmacen().toString());
            cs.setDouble("_capacidadMaximaProductos",almacen.getCapacidadMaximaProductos());
            
            resultado = cs.executeUpdate();
            
            almacen.setId_almacen(cs.getInt("_id_almacen"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
             try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}  
        }
        return resultado;
    }

    @Override
    public int modificar(Almacen almacen) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_ALMACEN (?,?,?,?,?)}");
            cs.setInt("_id_almacen",almacen.getId_almacen());
            cs.setInt("_fid_surcursal",almacen.getSucursal().getId_sucursal());
            cs.setString("_tipoAlmacen",almacen.getTipoAlmacen().toString());
            cs.setDouble("_capacidadMaximaProductos",almacen.getCapacidadMaximaProductos());
            cs.setDouble("_capacidadActualProductos",almacen.getCapacidadActualProductos());
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idAlmacen) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_ALMACEN(?)}");
            cs.setInt("_id_almacen",idAlmacen);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<Almacen> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
