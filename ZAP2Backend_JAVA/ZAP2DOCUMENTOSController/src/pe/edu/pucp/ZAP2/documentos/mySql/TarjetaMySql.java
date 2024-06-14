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
import pe.edu.pucp.ZAP2.documentos.model.Banco;
import pe.edu.pucp.ZAP2.documentos.model.Tarjeta;
import pe.edu.pucp.ZAP2.documentos.model.Tipo_Tarjeta;

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
            cs = con.prepareCall("{call ELIMINAR_TARJETA(?)}");
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
        ArrayList<Tarjeta> tarjetas =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_TARJETA"+"( )}");
            
            rs = cs.executeQuery();
            while(rs.next()){
                
                Tarjeta tarjeta = new Tarjeta();
                tarjeta.setIdTarjeta(rs.getInt("id_tarjeta"));
                tarjeta.setCodTarjeta(rs.getInt("codTarjeta"));
                Banco banco = new Banco();
                banco.setIdBanco(rs.getInt("fid_banco"));
                tarjeta.setBanco(banco);
                tarjeta.setTipoTarjeta(Tipo_Tarjeta.valueOf(rs.getString("tipoTarjeta")));
                
                tarjetas.add(tarjeta);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return tarjetas;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Tarjeta buscar(int id) {
        Tarjeta tarjeta = null;
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call BUSCAR_TARJETA_X_ID"+"(?)}");
            cs.setInt("_id", id);
            rs = cs.executeQuery();
            tarjeta = new Tarjeta();
            while(rs.next()){
                
                
                tarjeta.setIdTarjeta(rs.getInt("id_tarjeta"));
                tarjeta.setCodTarjeta(rs.getInt("codTarjeta"));
                Banco banco = new Banco();
                int numero;
                
                banco.setIdBanco(rs.getInt("fid_banco"));
                
                tarjeta.setBanco(banco);
                tarjeta.setTipoTarjeta(Tipo_Tarjeta.valueOf(rs.getString("tipoTarjeta")));
                
                
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return tarjeta;
    }
    
}
