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
import java.util.Date;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.documentos.dao.Factura_VentaDao;
import pe.edu.pucp.ZAP2.documentos.model.Banco;
import pe.edu.pucp.ZAP2.documentos.model.Factura_Venta;
import pe.edu.pucp.ZAP2.documentos.model.Moneda;
import pe.edu.pucp.ZAP2.documentos.model.Tarjeta;
import pe.edu.pucp.ZAP2.documentos.model.Tipo_Tarjeta;
import pe.edu.pucp.ZAP2.infraestructura.model.Area;
import pe.edu.pucp.ZAP2.infraestructura.model.Cajero;
import pe.edu.pucp.ZAP2.infraestructura.model.CuentaUsuario;
import pe.edu.pucp.ZAP2.infraestructura.model.Sucursal;
import pe.edu.pucp.ZAP2.infraestructura.model.Supervisor;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoContrato;
import pe.edu.pucp.ZAP2.infraestructura.model.TurnosHorario;
import pe.edu.pucp.ZAP2.personas.model.PersonaJuridica;
import pe.edu.pucp.ZAP2.personas.model.TipoDocumento;
import pe.edu.pucp.ZAP2.personas.model.TipoEntidad;

/**
 *
 * @author Alejandro
 */
public class Factura_VentaMySql implements Factura_VentaDao{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;

    @Override
    public int insertar(Factura_Venta facturaVenta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_FACTURA_VENTA(?,?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_factura_venta",java.sql.Types.INTEGER);
            cs.setInt("_fid_persona_juridica", facturaVenta.getPersonaJuridica().getId_Persona());
            cs.setString("_detalles", facturaVenta.getDetalles());
            
            java.sql.Date sqlDate = new java.sql.Date(facturaVenta.getFechaVenc().getTime());
            cs.setDate("_fechaVenc", sqlDate);
            
            //cs.setInt("_ruc", Integer.parseInt(facturaVenta.getPersonaJuridica().getRUC()));
            
            cs.setInt("_fid_id_tarjeta", facturaVenta.getTarjeta().getIdTarjeta());
            cs.setInt("_fid_empleado", facturaVenta.getEmpleado().getIdEmpleado());
            cs.setDouble("_montoTotal", facturaVenta.getMontoTotal());
            
            cs.setInt("_fid_moneda", facturaVenta.getMoneda().getIdMoneda());
            java.sql.Date sqlDate2 = new java.sql.Date(facturaVenta.getFecha_emision().getTime());
            cs.setDate("_fecha_emision",sqlDate2);
            cs.setDouble("_total", facturaVenta.getTotal());
            
            cs.executeUpdate();
            //facturaVenta.setId_doc_venta(cs.getInt("_id_boleta_venta"));
            //facturaVenta.setId_documento(cs.getInt("_id_boleta_venta"));
            //resultado = facturaVenta.getId_doc_venta();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Factura_Venta facturaVenta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_FACTURA_VENTA (?,?,?,?,?,?,?,?)}");
            cs.setInt("_id_documento",facturaVenta.getId_documento());
            cs.setInt("_fid_persona_juridica", facturaVenta.getPersonaJuridica().getId_Persona());
            cs.setString("_detalles", facturaVenta.getDetalles());
            
            java.sql.Date sqlDate = new java.sql.Date(facturaVenta.getFechaVenc().getTime());
            cs.setDate("_fechaVenc", sqlDate);
            
//            cs.setInt("_ruc", Integer.parseInt(facturaVenta.getPersonaJuridica().getRUC()));
            
            cs.setInt("_fid_id_tarjeta", facturaVenta.getTarjeta().getIdTarjeta());
            cs.setInt("_fid_empleado", facturaVenta.getEmpleado().getIdEmpleado());
//            cs.setDouble("_montoTotal", facturaVenta.getMontoTotal());
            
            cs.setInt("_fid_moneda", facturaVenta.getMoneda().getIdMoneda());
            java.sql.Date sqlDate2 = new java.sql.Date(facturaVenta.getFecha_emision().getTime());
            cs.setDate("_fecha_emision",sqlDate2);
//            cs.setDouble("_total", facturaVenta.getTotal());
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idFacturaVenta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call  ELIMINAR_DOCUMENTO(?)}");
            cs.setInt("_id_documento",idFacturaVenta);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<Factura_Venta> listarTodos() {
         ArrayList<Factura_Venta> facturasVentas =  new ArrayList<>();
        try{
            con=DBManager.getInstance().getConnection();           
            cs = con.prepareCall("{call LISTAR_FACTURA_VENTA_TOTAL"
                    +"( )}");
            
            rs = cs.executeQuery();
            while(rs.next()){
                
                Factura_Venta factVent = new Factura_Venta();
                factVent.setId_doc_venta(rs.getInt("id_documento"));
                factVent.setId_documento(rs.getInt("id_documento"));
                factVent.setIdFactura(rs.getInt("id_documento"));
                Date fecha = rs.getDate("fecha_emision");
                factVent.setFecha_emision(fecha);
                factVent.setTotal(rs.getDouble("total"));
                
                factVent.setMontoTotal(rs.getDouble("montoTotal"));
                
                
                factVent.setDetalles(rs.getString("detalles"));
                Date fechaVenc = rs.getDate("fechaVenc");
                factVent.setFechaVenc(fechaVenc);
                
                PersonaJuridica pj = new PersonaJuridica(){};
                
                pj.setId_Persona(rs.getInt("id_p_cliente"));
                pj.setNombre(rs.getString("nombre_cliente"));
                pj.setApellido_paterno(rs.getString("apellido_paterno_cliente"));
                pj.setApellido_materno(rs.getString("apellido_materno_cliente"));
                pj.setTelefono(rs.getInt("telefono_cliente"));               
                pj.setEmail(rs.getString("email_cliente"));
                pj.setTipo_documento(TipoDocumento.valueOf(rs.getString("tipoDocumento_cliente")));
                pj.setNro_documento(rs.getInt("numDocumento_cliente"));
                
                pj.setTipoEntidad(TipoEntidad.valueOf(rs.getString("tipoEntidad")));
                pj.setNumIdentificadorFiscal(rs.getInt("numIdentificadorFiscal"));
                pj.setDireccionLegal(rs.getString("direccionLegal"));
                pj.setRUC(rs.getString("RUC"));
                factVent.setPersonaJuridica(pj);
                
                Cajero cajero = new Cajero(){};
                cajero.setIdEmpleado(rs.getInt("id_p_empleado"));
                cajero.setId_Persona(rs.getInt("id_p_empleado"));
                cajero.setNombre(rs.getString("nombre_empleado"));
                cajero.setApellido_paterno(rs.getString("apellido_paterno_empleado"));
                cajero.setApellido_materno(rs.getString("apellido_materno_empleado"));
                cajero.setTelefono(rs.getInt("telefono_empleado"));               
                cajero.setEmail(rs.getString("email_empleado"));
                cajero.setTipo_documento(TipoDocumento.valueOf(rs.getString("tipoDocumento_empleado")));
                cajero.setNro_documento(rs.getInt("numDocumento_empleado"));
                cajero.setSexo(rs.getString("sexo_empleado").charAt(0));
                cajero.setDireccion(rs.getString("direccion_empleado"));
                
                CuentaUsuario cuentaEmpleado = new CuentaUsuario(){};
                cajero.setCuenta_usuario(cuentaEmpleado);
                Area area  = new  Area (){};
                Sucursal sucursal = new Sucursal(){};
                sucursal.setId_sucursal(rs.getInt("id_sucursal"));
                sucursal.setDireccion(rs.getString("sc_direccion"));
                sucursal.setNombre(rs.getString("sc_nombre"));
                sucursal.setTam_metros(rs.getDouble("tam_metros"));
                area.setSucursal(sucursal);
                
                cajero.setSalario(rs.getDouble("salario_empleado"));
                Date fechaContrato = rs.getDate("fechaContratacion_empleado");
                cajero.setFechaContratacion(fechaContrato);
                cajero.setTipoContrato(TipoContrato.valueOf(rs.getString("tipoContrato_empleado")));
                cajero.setHorario(TurnosHorario.valueOf(rs.getString("horario_empleado")));
                
                cajero.setArea(area);
                Supervisor supervisor = new  Supervisor(){};
                supervisor.setIdEmpleado(rs.getInt("fid_supervisor"));
                supervisor.setId_Persona(rs.getInt("fid_supervisor"));
                cajero.setSupervisor(supervisor);
                cajero.setNumeroCaja(rs.getInt("numeroCaja"));
                cajero.setCantidadCaja(rs.getDouble("cantidadCaja"));
                
                factVent.setEmpleado(cajero);
                
                Moneda moneda = new Moneda(){};
                moneda.setIdMoneda(rs.getInt("m_id_moneda"));
                moneda.setNombre(rs.getString("m_nombre"));
                moneda.setAbreviacion(rs.getString("abreviacion"));
                factVent.setMoneda(moneda);
                
                Tarjeta tarjeta = new Tarjeta(){};
                tarjeta.setIdTarjeta(rs.getInt("t_id_tarjeta"));
                
                Banco banco = new Banco(){};
                banco.setIdBanco(rs.getInt("fid_banco"));
                banco.setNombre(rs.getString("b_nombre"));
                tarjeta.setBanco(banco);
                
                tarjeta.setCodTarjeta(rs.getInt("codTarjeta"));
                tarjeta.setTipoTarjeta(Tipo_Tarjeta.valueOf(rs.getString("tipoTarjeta")));
                factVent.setTarjeta(tarjeta);
                
                facturasVentas.add(factVent);
                            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return facturasVentas;
    
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
