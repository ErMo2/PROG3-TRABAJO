/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.mySql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.documentos.dao.MonedaDao;
import pe.edu.pucp.ZAP2.documentos.model.Moneda;

/**
 *
 * @author Alejandro
 */
public class MonedaMySql implements MonedaDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public int insertar(Moneda moneda) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_MONEDA"
                    +"(?,?,?)}");
            cs.setString("_nombre", moneda.getNombre());
            cs.setString("_abreviacion", moneda.getAbreviacion());
            resultado = cs.executeUpdate();
            moneda.setIdMoneda(cs.getInt("_id_moneda"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
            
            
        }
       
        return resultado;
    }

    @Override
    public int modificar(Moneda moneda) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_MONEDA (?,?,?)}");
            cs.setInt("_id_moneda", moneda.getIdMoneda());
            cs.setString("_nombre", moneda.getNombre());
            cs.setString("_abreviacion", moneda.getAbreviacion());
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idmoneda) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_MONEDA(?)}");
            cs.setInt("_id_moneda",idmoneda);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<Moneda> listarTodos() {
        ArrayList<Moneda> monedas =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();           
            cs = con.prepareCall("{call LISTAR_MONEDA"
                    +"( )}");
            
            rs = cs.executeQuery();
            while(rs.next()){
                Moneda moneda = new Moneda();
                moneda.setIdMoneda(rs.getInt("id_moneda"));
                moneda.setNombre(rs.getString("nombre"));
                moneda.setAbreviacion(rs.getString("abreviacion"));           
                monedas.add(moneda);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return monedas;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Moneda buscar(int id) {
        Moneda moneda = null;
        try{
            con=DBManager.getInstance().getConnection();           
            cs = con.prepareCall("{call BUSCAR_MONEDA_X_ID"
                    +"(?)}");
            cs.setInt("_id", id);
            rs = cs.executeQuery();
            moneda =  new Moneda();
            while(rs.next()){
                 
                moneda.setIdMoneda(rs.getInt("id_moneda"));
                moneda.setNombre(rs.getString("nombre"));
                moneda.setAbreviacion(rs.getString("abreviacion"));           
                
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return moneda;
    }
    
}
