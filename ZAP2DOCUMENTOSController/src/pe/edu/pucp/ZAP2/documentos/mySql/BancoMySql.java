/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.mySql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Banco> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
