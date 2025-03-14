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
import pe.edu.pucp.ZAP2.documentos.dao.BancoDao;
import pe.edu.pucp.ZAP2.documentos.model.Banco;

/**
 *
 * @author Alejandro
 */
public class BancoMySql implements BancoDao{
    private Connection con;
    private PreparedStatement pst;
    private CallableStatement cs;//Clase que nos ayuda a trabajar con procedimientos almacenados
    private ResultSet rs;
    @Override
    public int insertar(Banco banco) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_BANCO(?,?)}");
            cs.registerOutParameter("_id_banco",java.sql.Types.INTEGER);
            cs.setString("_nombre", banco.getNombre());
            cs.executeUpdate();
            banco.setIdBanco(cs.getInt("_id_banco"));
            resultado = banco.getIdBanco();
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
    public int modificar(Banco banco) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_BANCO(?,?)}");
            cs.setString("_nombre",banco.getNombre());
            cs.setInt("_id_banco",banco.getIdBanco());
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idBanco) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_BANCO(?)}");
            cs.setInt("_id_banco",idBanco);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<Banco> listarTodos() {
        ArrayList<Banco> bancos =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();           
            cs = con.prepareCall("{call LISTAR_BANCO"
                    +"( )}");
            
            rs = cs.executeQuery();
            while(rs.next()){
                Banco banco = new Banco();
                banco.setIdBanco(rs.getInt("id_banco"));
                banco.setNombre(rs.getString("nombre"));
                bancos.add(banco);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return bancos;
    }

    @Override
    public Banco buscar(int id) {
        Banco banco = null;
        try{
            con=DBManager.getInstance().getConnection();           
            cs = con.prepareCall("{call BUSCAR_BANCO_X_ID"
                    +"(?)}");
            cs.setInt("_id", id);
            rs = cs.executeQuery();
            banco = new Banco();
            while(rs.next()){
                 
                banco.setIdBanco(rs.getInt("id_banco"));
                banco.setNombre(rs.getString("nombre"));
                
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }    
        return banco;
    }
    
}
