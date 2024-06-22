/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.infraestructura.dao.ElectrodomesticosDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Electrodomesticos;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ElectrodomesticosMySql implements ElectrodomesticosDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public int insertar(Electrodomesticos electrodomesticos) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_ELECTRODOMESTICO"
                    +"(?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_electrodomesticos", java.sql.Types.INTEGER);
            cs.setString("_nombre", electrodomesticos.getNombre());
            cs.setString("_descripcion", electrodomesticos.getDescripcion());
            Date fecha1 = new Date(electrodomesticos.getTiempoGarantia().getTime());
            cs.setString("_modelo", electrodomesticos.getModelo());
            cs.setDate("_tiempoGarantia", fecha1);
            cs.setBoolean("_tieneGarantia", electrodomesticos.getTieneGarantia());
            resultado = cs.executeUpdate();
            electrodomesticos.setIdProducto(cs.getInt("_id_electrodomesticos"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
       
        return resultado;
    }

    @Override
    public int modificar(Electrodomesticos electrodomesticos) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_ELECTRODOMESTICO"
                    +"(?,?,?,?,?,?)}");
            cs.setInt("_id_producto", electrodomesticos.getIdProducto());
            cs.setString("_nombre", electrodomesticos.getNombre());
            cs.setString("_descripcion", electrodomesticos.getDescripcion());
            Date fecha1 = new Date(electrodomesticos.getTiempoGarantia().getTime());
            cs.setString("_modelo", electrodomesticos.getModelo());
            cs.setDate("_tiempoGarantia", fecha1);
            cs.setBoolean("_tieneGarantia", electrodomesticos.getTieneGarantia());
            resultado = cs.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idElectrodomestico) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_PRODUCTO(?)}");
            cs.setInt("_id_producto",idElectrodomestico);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<Electrodomesticos> listarTodos() {
        ArrayList<Electrodomesticos> electrodomesticos =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_ELECTRODOMESTICOS"
                    +"( )}");
            
            rs = cs.executeQuery();
            while(rs.next()){
                Electrodomesticos electrodomestico = new Electrodomesticos();
                electrodomestico.setIdProducto(rs.getInt("id_producto"));
                electrodomestico.setNombre(rs.getString("nombre"));
                electrodomestico.setDescripcion(rs.getString("descripcion"));
                electrodomestico.setModelo(rs.getString("modelo"));
                
                Date fechaGarantia = rs.getDate("tiempoGarantia");
                electrodomestico.setTiempoGarantia(fechaGarantia);
                
                electrodomestico.setTieneGarantia(rs.getBoolean("tieneGarantia"));
                electrodomesticos.add(electrodomestico);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return electrodomesticos;
       
    }

    @Override
    public Electrodomesticos buscarProducto(int idProd) {
        Electrodomesticos electrodomestico = null;
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call BUSCAR_ELECTRODOMESTICO_X_ID"
                    +"(?)}");
            cs.setInt("_id_producto", idProd);
            rs = cs.executeQuery();
            electrodomestico = new Electrodomesticos();
            while(rs.next()){
                
                electrodomestico.setIdProducto(rs.getInt("id_producto"));
                electrodomestico.setNombre(rs.getString("nombre"));
                electrodomestico.setDescripcion(rs.getString("descripcion"));
                electrodomestico.setModelo(rs.getString("modelo"));
                
                Date fechaGarantia = rs.getDate("tiempoGarantia");
                electrodomestico.setTiempoGarantia(fechaGarantia);
                
                electrodomestico.setTieneGarantia(rs.getBoolean("tieneGarantia"));
                
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return electrodomestico;
    
    }
    
}
