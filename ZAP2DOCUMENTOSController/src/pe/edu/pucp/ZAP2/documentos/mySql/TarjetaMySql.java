/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.mySql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.documentos.dao.TarjetaDao;
import pe.edu.pucp.ZAP2.documentos.model.Tarjeta;

/**
 *
 * @author Alejandro
 */
public class TarjetaMySql implements TarjetaDao{

    private Connection con;
    private PreparedStatement pst;
    private CallableStatement cs;
    private ResultSet rs;
	
    @Override
    public int insertar(Tarjeta tarjeta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_TARJETA(?,?,?,?)}");
            cs.registerOutParameter("_id_tarjeta",java.sql.Types.INTEGER);
            cs.setInt("_fid_banco", tarjeta.getBanco().getIdBanco());
            cs.setInt("_codTarjeta", tarjeta.getCodTarjeta());
            
            cs.setString("_tipoTarjeta", tarjeta.getTipoTarjeta().toString());
            cs.executeUpdate();
            tarjeta.setIdTarjeta(cs.getInt("_id_Tarjeta"));
            resultado = tarjeta.getIdTarjeta();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }

    @Override
    public int modificar(Tarjeta tarjeta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_TARJETA (?,?,?,?)}");
            cs.setInt("_id_tarjeta",tarjeta.getIdTarjeta());
            cs.setInt("_fid_banco", tarjeta.getBanco().getIdBanco());
            cs.setInt("_codTarjeta", tarjeta.getCodTarjeta());
            
            cs.setString("_tipoTarjeta", tarjeta.getTipoTarjeta().toString());
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idTarjeta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_CLIENTE (?)}");
            cs.setInt("_id_tarjeta",idTarjeta);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<Tarjeta> listarTodas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
