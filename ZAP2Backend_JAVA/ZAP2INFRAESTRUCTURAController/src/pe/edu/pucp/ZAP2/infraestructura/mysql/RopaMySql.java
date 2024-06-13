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
import java.sql.SQLException;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.infraestructura.dao.RopaDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Ropa;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoRopa;

/**
 *
 * @author User
 */
public class RopaMySql implements RopaDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public int insertar(Ropa ropa) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_ROPA"
                    +"(?,?,?,?,?)}");
            cs.registerOutParameter("_id_ropa", java.sql.Types.INTEGER);
            cs.setString("_nombre", ropa.getNombre());
            cs.setString("_descripcion", ropa.getDescripcion());
            cs.setString("_material", ropa.getMaterial());
            cs.setString("_tipo", ropa.getTipo().toString());
            resultado = cs.executeUpdate();
            ropa.setIdProducto(cs.getInt("_id_ropa"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Ropa ropa) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_ROPA"
                    +"(?,?,?,?,?)}");
            cs.setInt("_id_ropa", ropa.getIdProducto());
            cs.setString("_nombre", ropa.getNombre());
            cs.setString("_descripcion", ropa.getDescripcion());
            cs.setString("_material", ropa.getMaterial());
            cs.setString("_tipo", ropa.getTipo().toString());
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idRopa) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_PRODUCTO(?)}");
            cs.setInt("_id_ropa",idRopa);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<Ropa> listarTodas() {
        ArrayList<Ropa> ropas =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_ROPA"
                    +"( )}");
            
            rs = cs.executeQuery();
            while(rs.next()){
                Ropa ropa = new Ropa();
                ropa.setIdProducto(rs.getInt("id_producto"));
                ropa.setNombre(rs.getString("nombre"));
                ropa.setDescripcion(rs.getString("descripcion"));
                ropa.setMaterial(rs.getString("material"));
                String tipoRopa = rs.getString("tipo");
                TipoRopa tipo = TipoRopa.valueOf(tipoRopa);
                ropa.setTipo(tipo);
                ropas.add(ropa);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return ropas;
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Ropa buscarProducto(int idProd) {
        Ropa ropa = null;
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call BUSCAR_ROPA_X_ID"
                    +"(?)}");
            cs.setInt("_id_producto", idProd);
            rs = cs.executeQuery();
            ropa = new Ropa();
            while(rs.next()){
                
                ropa.setIdProducto(rs.getInt("id_producto"));
                ropa.setNombre(rs.getString("nombre"));
                ropa.setDescripcion(rs.getString("descripcion"));
                ropa.setMaterial(rs.getString("material"));
                String tipoRopa = rs.getString("tipo");
                TipoRopa tipo = TipoRopa.valueOf(tipoRopa);
                ropa.setTipo(tipo);
                
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return ropa;
    }
    
}
