/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.infraestructura.dao.AreaDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Area;
import pe.edu.pucp.ZAP2.infraestructura.model.Sucursal;

/**
 *
 * @author Alejandro
 */
public class AreaMySql implements AreaDao{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public int insertar(Area area) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_AREA"
                    +"(?,?,?)}");
            cs.registerOutParameter("_id_area", java.sql.Types.INTEGER);
            cs.setString("_nombre", area.getNombre());
            cs.setInt("_fid_sucursal",area.getSucursal().getId_sucursal());   
            resultado = cs.executeUpdate();
            area.setIdArea(cs.getInt("_id_area"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }
    
    @Override
    public int modificar(Area area) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_AREA (?,?,?)}");
            cs.setInt("_id_area",area.getIdArea());
            cs.setInt("_fid_sucursal",area.getSucursal().getId_sucursal());
            cs.setString("_nombre",area.getNombre());
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idArea) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_AREA(?)}");
            cs.setInt("_id_area",idArea);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<Area> listarTodas() {
        ArrayList<Area> areas =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_AREA"
                    +"( )}");
            
            rs = cs.executeQuery();
            while(rs.next()){
                Area area = new Area();
                Sucursal sucursal = new Sucursal();
                area.setIdArea(rs.getInt("id_area"));
                sucursal.setId_sucursal(rs.getInt("fid_sucursal"));
                area.setSucursal(sucursal);
                area.setNombre(rs.getString("nombre"));
                
                areas.add(area);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return areas;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Area buscar(int id) {
        Area area = null;
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call BUSCAR_AREA_X_ID"
                    +"(?)}");
            cs.setInt("_id", id);
            rs = cs.executeQuery();
            area = new Area();
            while(rs.next()){
                
                Sucursal sucursal = new Sucursal();
                area.setIdArea(rs.getInt("id_area"));
                sucursal.setId_sucursal(rs.getInt("fid_sucursal"));
                area.setSucursal(sucursal);
                area.setNombre(rs.getString("nombre"));
                
                
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }    
        return area;
    }
    
}
