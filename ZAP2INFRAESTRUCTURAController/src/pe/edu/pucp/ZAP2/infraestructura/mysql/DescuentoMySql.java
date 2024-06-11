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
import pe.edu.pucp.ZAP2.infraestructura.dao.DescuentoDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Descuento;
import pe.edu.pucp.ZAP2.infraestructura.model.ProductoPrecio;

/**
 *
 * @author Alejandro
 */
public class DescuentoMySql implements DescuentoDao{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public int insertar(Descuento descuento) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_DESCUENTO"
                    +"(?,?,?,?,?)}");
            cs.registerOutParameter("_id_descuento", java.sql.Types.INTEGER);
            cs.setDouble("_descuentoAplicado", descuento.getDescuentoAplicado());
            cs.setInt("_fid_productoPrecio", descuento.getProdPrecio().getIdProductoPrecio());
            Date fecha1 = new Date(descuento.getFechaInicial().getTime());
            Date fecha2 = new Date(descuento.getFechaFinal().getTime());
            cs.setDate("_fechaInicial", fecha1);
            cs.setDate("_fechaFinal", fecha2);
            resultado = cs.executeUpdate();
            
            descuento.setIdDescuento(cs.getInt("_id_descuento"));
            resultado = descuento.getIdDescuento();

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
            
            
        }
       
        return resultado;
    }

    @Override
    public int modificar(Descuento descuento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int eliminar(int idDescuento) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_DESCUENTO"
                    +"(?)}");
            
            cs.setInt("_id_descuento", idDescuento);
            
            resultado=cs.executeUpdate();       
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}       
        }
        return resultado;
    }

    @Override
    public ArrayList<Descuento> listarTodas() {
        ArrayList<Descuento> ld =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();
            
            cs = con.prepareCall("{call LISTAR_DESCUENTO"
                    +"( )}");
            rs = cs.executeQuery();
            while(rs.next()){
                Descuento d = new Descuento();
                d.setIdDescuento(rs.getInt("id_descuento"));
                ProductoPrecio prodPre = new ProductoPrecio();
                prodPre.setIdProductoPrecio(rs.getInt("fid_productoPrecio"));
                d.setDescuentoAplicado(rs.getDouble("descuentoAplicado"));
                d.setFechaInicial(rs.getDate("fechaInicial"));
                d.setFechaFinal(rs.getDate("fechaFinal"));
                
                ld.add(d);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return ld;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
