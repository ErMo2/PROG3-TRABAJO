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
import pe.edu.pucp.ZAP2.documentos.dao.Boleta_VentaDao;
import pe.edu.pucp.ZAP2.documentos.model.Banco;
import pe.edu.pucp.ZAP2.documentos.model.Boleta_Venta;
import pe.edu.pucp.ZAP2.documentos.model.Moneda;
import pe.edu.pucp.ZAP2.documentos.model.Tarjeta;
import pe.edu.pucp.ZAP2.documentos.model.Tipo_Tarjeta;
import pe.edu.pucp.ZAP2.infraestructura.model.Area;
import pe.edu.pucp.ZAP2.infraestructura.model.Cajero;
import pe.edu.pucp.ZAP2.infraestructura.model.Cliente;
import pe.edu.pucp.ZAP2.infraestructura.model.CuentaUsuario;
import pe.edu.pucp.ZAP2.infraestructura.model.Empleado;
import pe.edu.pucp.ZAP2.infraestructura.model.Sucursal;
import pe.edu.pucp.ZAP2.infraestructura.model.Supervisor;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoContrato;
import pe.edu.pucp.ZAP2.infraestructura.model.TurnosHorario;
import pe.edu.pucp.ZAP2.personas.model.Persona;
import pe.edu.pucp.ZAP2.personas.model.TipoDocumento;
/**
 *
 * @author Alejandro
 */
public class Boleta_VentaMySql implements Boleta_VentaDao{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;

    @Override
    public int insertar(Boleta_Venta boletaVenta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_BOLETA_VENTA(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_boleta_venta",java.sql.Types.INTEGER);
            cs.setInt("_fid_id_persona", boletaVenta.getCliente().getId_Persona());
            cs.setInt("_numSerie", boletaVenta.getNumSerie());
            cs.setString("_detalles", boletaVenta.getDetalles());
            cs.setDouble("_impuestos", boletaVenta.getImpuestos());
            
            cs.setInt("_fid_id_tarjeta", boletaVenta.getTarjeta().getIdTarjeta());
            cs.setInt("_fid_empleado", boletaVenta.getEmpleado().getIdEmpleado());
            cs.setDouble("_montoTotal", boletaVenta.getMontoTotal());
            
            cs.setInt("_fid_moneda", boletaVenta.getMoneda().getIdMoneda());
            java.sql.Date sqlDate = new java.sql.Date(boletaVenta.getFecha_emision().getTime());
            cs.setDate("_fecha_emision",sqlDate);
            cs.setDouble("_total", boletaVenta.getTotal());
            
            cs.executeUpdate();
            boletaVenta.setId_doc_venta(cs.getInt("_id_boleta_venta"));
            boletaVenta.setId_documento(cs.getInt("_id_boleta_venta"));
            resultado = boletaVenta.getId_doc_venta();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){ System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Boleta_Venta boletaVenta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_BOLETA_VENTA (?,?,?,?,?,?,?,?)}");
            cs.setInt("_id_documento",boletaVenta.getId_documento());
            cs.setInt("_fid_id_persona", boletaVenta.getCliente().getId_Persona());
            cs.setInt("_numSerie", boletaVenta.getNumSerie());
            cs.setString("_detalles", boletaVenta.getDetalles());
            
            cs.setInt("_fid_id_tarjeta", boletaVenta.getTarjeta().getIdTarjeta());
            cs.setInt("_fid_empleado", boletaVenta.getEmpleado().getIdEmpleado());
            
            cs.setInt("_fid_moneda", boletaVenta.getMoneda().getIdMoneda());
            java.sql.Date sqlDate = new java.sql.Date(boletaVenta.getFecha_emision().getTime());
            cs.setDate("_fecha_emision",sqlDate);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idBoleta_Venta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_DOCUMENTO(?)}");
            cs.setInt("_id_documento",idBoleta_Venta);
            resultado = cs.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;

    }

    @Override
    public ArrayList<Boleta_Venta> listarTodas() {
        ArrayList<Boleta_Venta> boletasVenta =  new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_BOLETA_VENTA_COMPLETO( )}");
            rs = cs.executeQuery();
            while(rs.next()){
                Boleta_Venta bolVenta = new Boleta_Venta();
                bolVenta.setId_doc_venta(rs.getInt("id_documento"));
                bolVenta.setId_documento(rs.getInt("id_documento"));
                Date fecha = rs.getDate("fecha_emision");
                bolVenta.setFecha_emision(fecha);
                bolVenta.setTotal(rs.getDouble("total"));
                
                bolVenta.setMontoTotal(rs.getDouble("montoTotal"));
                
                bolVenta.setNumSerie(rs.getInt("numSerie"));
                bolVenta.setDetalles(rs.getString("detalles"));
                bolVenta.setImpuestos(rs.getDouble("impuestos"));
                
                Cliente cliente = new Cliente(){};
                cliente.setId_cliente(rs.getInt("id_p_cliente"));
                cliente.setId_Persona(rs.getInt("id_p_cliente"));
                cliente.setNombre(rs.getString("nombre_cliente"));
                cliente.setApellido_paterno(rs.getString("apellido_paterno_cliente"));
                cliente.setApellido_materno(rs.getString("apellido_materno_cliente"));
                cliente.setTelefono(rs.getInt("telefono_cliente"));               
                cliente.setEmail(rs.getString("email_cliente"));
                cliente.setTipo_documento(TipoDocumento.valueOf(rs.getString("tipoDocumento_cliente")));
                cliente.setNro_documento(rs.getInt("numDocumento_cliente"));
                cliente.setSexo(rs.getString("sexo_cliente").charAt(0));
                cliente.setDireccion(rs.getString("direccion_cliente"));
                cliente.setDni(rs.getString("dni_cliente"));
                cliente.setPuntosBonus(rs.getInt("puntosBonus_cliente"));
                CuentaUsuario cuentaCliente = new CuentaUsuario(){};
                cliente.setCuenta_usuario(cuentaCliente);
                bolVenta.setCliente(cliente);
                
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
                
                bolVenta.setEmpleado(cajero);
                
                Moneda moneda = new Moneda(){};
                moneda.setIdMoneda(rs.getInt("m_id_moneda"));
                moneda.setNombre(rs.getString("m_nombre"));
                moneda.setAbreviacion(rs.getString("abreviacion"));
                bolVenta.setMoneda(moneda);
                
                Tarjeta tarjeta = new Tarjeta(){};
                tarjeta.setIdTarjeta(rs.getInt("t_id_tarjeta"));
                
                Banco banco = new Banco(){};
                banco.setIdBanco(rs.getInt("fid_banco"));
                banco.setNombre(rs.getString("b_nombre"));
                tarjeta.setBanco(banco);
                
                tarjeta.setCodTarjeta(rs.getInt("codTarjeta"));
                tarjeta.setTipoTarjeta(Tipo_Tarjeta.valueOf(rs.getString("tipoTarjeta")));
                bolVenta.setTarjeta(tarjeta);
                
                boletasVenta.add(bolVenta);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return boletasVenta;
    }
    
}
