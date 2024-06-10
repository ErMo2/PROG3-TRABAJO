/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pe.edu.pucp.ZAP2.program.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import pe.edu.pucp.ZAP2.documentos.dao.BancoDao;
import pe.edu.pucp.ZAP2.documentos.dao.Boleta_VentaDao;
import pe.edu.pucp.ZAP2.documentos.dao.MonedaDao;
import pe.edu.pucp.ZAP2.documentos.dao.TarjetaDao;
import pe.edu.pucp.ZAP2.documentos.model.Banco;
import pe.edu.pucp.ZAP2.documentos.model.Boleta_Venta;
import pe.edu.pucp.ZAP2.documentos.model.Moneda;
import pe.edu.pucp.ZAP2.documentos.model.Tarjeta;
import pe.edu.pucp.ZAP2.documentos.model.Tipo_Tarjeta;
import pe.edu.pucp.ZAP2.documentos.mySql.BancoMySql;
import pe.edu.pucp.ZAP2.documentos.mySql.Boleta_VentaMySql;
import pe.edu.pucp.ZAP2.infraestructura.dao.AlmacenDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.AreaDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.CajeroDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.ClienteDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.CuentaUsuarioDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.EmpleadoDeAreaDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.LoteDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.MovimientoLoteDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.SucursalDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.SupervisorDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Almacen;
import pe.edu.pucp.ZAP2.infraestructura.model.Area;
import pe.edu.pucp.ZAP2.infraestructura.model.Cajero;
import pe.edu.pucp.ZAP2.infraestructura.model.Cliente;
import pe.edu.pucp.ZAP2.infraestructura.model.CuentaUsuario;
import pe.edu.pucp.ZAP2.infraestructura.model.EmpleadoDeArea;
import pe.edu.pucp.ZAP2.infraestructura.model.Lote;
import pe.edu.pucp.ZAP2.infraestructura.model.MovimientoLote;
import pe.edu.pucp.ZAP2.infraestructura.model.PersonaNatural;
import pe.edu.pucp.ZAP2.infraestructura.model.Sucursal;
import pe.edu.pucp.ZAP2.infraestructura.model.Supervisor;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoAlmacen;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoContrato;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoPuesto;
import pe.edu.pucp.ZAP2.infraestructura.model.TurnosHorario;
import pe.edu.pucp.ZAP2.infraestructura.mysql.AlmacenMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.AreaMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.CajeroMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.ClienteMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.CuentaUsuarioMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.EmpleadoDeAreaMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.LoteMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.MovimientoLoteMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.SucursalMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.SupervisorMySql;
import pe.edu.pucp.ZAP2.personas.model.TipoDocumento;
import pe.edu.pucp.ZAP2.documentos.mySql.MonedaMySql;
import pe.edu.pucp.ZAP2.documentos.mySql.TarjetaMySql;

/**
 *
 * @author Alejandro
 */
public class Principal {
    //AREA
    public static void main(String[] args) throws ParseException {
        
        /*=============================*/
        /*==== Objetos compartidos ====*/
        /*=============================*/
        Area area = new Area(1, "Zona de alimentos",null, null);
        area.setIdArea(1);
        
        String fechaStr = "2022-05-10"; // Formato de fecha: "yyyy-MM-dd"
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_Contratacion = formato.parse(fechaStr);
        
        /*===============*/
        /*==== Area ====*/
        /*==============*/
//        SucursalDao daoSucursal = new SucursalMySql();
//        Sucursal sucursal = new Sucursal(1, "Av. Pepito Valle",
//                1300.4, "Pepe's shop",
//                null, null, null);
//        daoSucursal.insertar(sucursal);
//        
//        AreaDao daoArea = new AreaMySql();
//        Area area = new Area(1, "Zona de alimentos",sucursal, null);
//        daoArea.insertar(area);
//        area.setNombre("Av. Juan");
//        daoArea.modificar(area);
//        

        /*===============*/
        /*==== Sucursal ====*/
        /*==============*/   
//        Sucursal sucursal = new Sucursal(1,"San Borja",20,"Tottus_San_Borja",null,null,null);
//        SucursalDao daoSucursal = new SucursalMySql();
//        daoSucursal.insertar(sucursal);
//        sucursal.setNombre("AQUI");
//        daoSucursal.modificar(sucursal);

        /*=================*/
        /*==== Almacen ====*/
        /*=================*/
//        Lote lote = new Lote();
//        
//        AlmacenDao daoAlmacen = new AlmacenMySql();
//        sucursal.setId_sucursal(1);
//        Almacen almacen = new Almacen(0,TipoAlmacen.ALMACENCOMUN,500.0,0.0,null,true,sucursal,null);
//        daoAlmacen.insertar(almacen); 
//        almacen.setId_almacen(1); 
//        almacen.setCapacidadMaximaProductos(777);
//        daoAlmacen.modificar(almacen); 
//        
        /*==============*/
        /*=== Cliente ==*/
        /*==============*/

//        ClienteDao daoCliente = new ClienteMySql();
//        Cliente cliente = new Cliente(1,"12345678", 0, 'M', "su jato", null, 1, 
//                "SoyUnCliente", "Apellido1", "Apellido2", 965456534, "email@gmail.com",
//                TipoDocumento.DNI, 12432544);
//        daoCliente.insertar(cliente);
//        cliente.setId_Persona(5);
//        cliente.setDni("777");
//        daoCliente.modificar(cliente);

        /*=============*/
        /*=== Cajero ==*/
        /*=============*/
//        Supervisor supervisor = new Supervisor();
//        supervisor.setIdEmpleado(3);
//        
//        
//        CajeroDao daoCajero = new CajeroMySql();
//        Cajero cajero = new Cajero(1, 2, supervisor, 0, 456.5, fecha_Contratacion, TipoContrato.TiempoCompleto, TurnosHorario.MAÑANA, 
//                area, 'M', "Mz C Lt9 Señor de los Milagros", null, 0, "Juan", "Vega", "Suares", 456485489, "juan.perez@example.com", TipoDocumento.DNI, 75607208);
////        daoCajero.insertar(cajero);
//        cajero.setId_Persona(6);
//        cajero.setCantidadCaja(777);
//        daoCajero.modificar(cajero);
        
        /*=================*/
        /*=== Supervisor ==*/
        /*=================*/
//        SupervisorDao daoSupervisor = new SupervisorMySql();
//        Supervisor supervisor = new Supervisor(5,null,null, 0, 456.5, fecha_Contratacion, TipoContrato.TiempoCompleto, TurnosHorario.MAÑANA, 
//                area, 'M', "Mz C Lt9 Señor de los Milagros", null, 0, "Juan", "Vega", "Suares", 456485489, "juan.perez@example.com", 
//                TipoDocumento.DNI, 75607208);
//        daoSupervisor.insertar(supervisor);
//        supervisor.setId_Persona(6);
//        supervisor.setNombre("AQUI");
//        daoSupervisor.modificar(supervisor);
          
//        
         /*===============*/
        /*==== Banco ====*/
        /*==============*/   
//        Banco banco = new Banco(1,"BBVA");
//        BancoDao daoBanco = new BancoMySql();
//        daoBanco.insertar(banco);
//        banco.setNombre("MIFARMA");
//        banco.setIdBanco(2);
//        daoBanco.modificar(banco);
        
        /*===============*/
        /*==== Lote ====*/
        /*==============*/  
//        Lote lote = new Lote();
//        LoteDao daoLote = new LoteMySql();

        /*===============*/
        /*==== Movimiento Lote ====*/
        /*==============*/   
//        MovimientoLote movLote = new MovimientoLote();
//        ArrayList<MovimientoLote> movsLote = new ArrayList<MovimientoLote>();
//        MovimientoLoteDao daoMovLote = new MovimientoLoteMySql();

        /*===============*/
        /*==== Cuenta Usuario ====*/
        /*==============*/   
//        CuentaUsuario cuenta = new CuentaUsuario(1,"PRUEBA_USUARIO","PRUEBA_CONTRA",true,cliente);
//        CuentaUsuarioDao daoCuenta = new CuentaUsuarioMySql();
//        cuenta.setIdCuenta(5);
//        cuenta.setPersonaNatural(cliente);
//        daoCuenta.insertar(cuenta);
//        cuenta.setUsuario("AQUI");
//        daoCuenta.modificar(cuenta);


        /*===============*/
        /*==== Empleado de Area ====*/
        /*==============*/ 
//        Supervisor supervisor = new Supervisor(5,null,null, 0, 456.5, fecha_Contratacion, TipoContrato.TiempoCompleto, TurnosHorario.MAÑANA, 
//                area, 'M', "Mz C Lt9 Señor de los Milagros", null, 0, "Juan", "Vega", "Suares", 456485489, "juan.perez@example.com", 
//                TipoDocumento.DNI, 75607208);
//        supervisor.setId_Persona(6);
//        EmpleadoDeArea emplArea = new EmpleadoDeArea(supervisor,TipoPuesto.Consultor,1,2000,fecha_Contratacion,TipoContrato.ContratoEspecial,TurnosHorario.NOCHE,area);
//        EmpleadoDeAreaDao daoEmpArae = new EmpleadoDeAreaMySql();
//        emplArea.setId_Persona(11);
//        emplArea.setTipo_documento(TipoDocumento.DNI);
//        emplArea.setPuesto(TipoPuesto.Empacador);
//        daoEmpArae.modificar(emplArea);

        /*===============*/
        /*==== Boleta de Venta ====*/
        /*==============*/ 
//        Supervisor supervisor = new Supervisor(5,null,null, 0, 456.5, fecha_Contratacion, TipoContrato.TiempoCompleto, TurnosHorario.MAÑANA, 
//                area, 'M', "Mz C Lt9 Señor de los Milagros", null, 0, "Juan", "Vega", "Suares", 456485489, "juan.perez@example.com", 
//                TipoDocumento.DNI, 75607208);
//        supervisor.setIdEmpleado(6);
//        supervisor.setId_Persona(1);
//        
//        Banco banco = new Banco(1,"BBVA");
//        
//        Tarjeta tarjeta = new Tarjeta();
//        tarjeta.setCodTarjeta(777);
//        tarjeta.setIdTarjeta(1);
//        tarjeta.setBanco(banco);
//        tarjeta.setTipoTarjeta(Tipo_Tarjeta.DEBITO);
//        TarjetaDao daoTarjeta = new TarjetaMySql();
//        daoTarjeta.insertar(tarjeta);
//        
//        Moneda moneda = new Moneda();
//        moneda.setIdMoneda(1);
//        moneda.setAbreviacion("PEN");
//        moneda.setNombre("Soles");
//        MonedaDao daoMoneda = new MonedaMySql();
//        daoMoneda.insertar(moneda);
//        
//        Boleta_Venta bol_venta = new Boleta_Venta(1,"CAMBIAR",18,supervisor,1,200,tarjeta,supervisor);
//        bol_venta.setMoneda(moneda);
//        bol_venta.setFecha_emision(fecha_Contratacion);
//        Boleta_VentaDao daoBol_Venta = new Boleta_VentaMySql();
//        daoBol_Venta.insertar(bol_venta);
//        bol_venta.setDetalles("AQUI");
//        daoBol_Venta.modificar(bol_venta); // FALTA PROBAR, ERROR EN EL PROCEDURE
 }
   
}
