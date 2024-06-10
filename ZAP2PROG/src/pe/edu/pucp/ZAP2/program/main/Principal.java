/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pe.edu.pucp.ZAP2.program.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import pe.edu.pucp.ZAP2.documentos.dao.Boleta_VentaDao;
import pe.edu.pucp.ZAP2.documentos.dao.Documento_de_CompraDao;
import pe.edu.pucp.ZAP2.documentos.dao.Factura_VentaDao;
import pe.edu.pucp.ZAP2.documentos.dao.MonedaDao;
import pe.edu.pucp.ZAP2.documentos.dao.TarjetaDao;
import pe.edu.pucp.ZAP2.documentos.model.Banco;
import pe.edu.pucp.ZAP2.documentos.model.Boleta_Venta;
import pe.edu.pucp.ZAP2.documentos.model.Documento_de_Compra;
import pe.edu.pucp.ZAP2.documentos.model.Factura_Venta;
import pe.edu.pucp.ZAP2.documentos.model.Moneda;
import pe.edu.pucp.ZAP2.documentos.model.Tarjeta;
import pe.edu.pucp.ZAP2.documentos.model.Tipo_Tarjeta;
import pe.edu.pucp.ZAP2.documentos.mySql.Boleta_VentaMySql;
import pe.edu.pucp.ZAP2.documentos.mySql.Documento_de_CompraMySql;
import pe.edu.pucp.ZAP2.documentos.mySql.Factura_VentaMySql;
import pe.edu.pucp.ZAP2.documentos.mySql.MonedaMySql;
import pe.edu.pucp.ZAP2.documentos.mySql.TarjetaMySql;
import pe.edu.pucp.ZAP2.infraestructura.dao.AlmacenDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.AreaDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.CajeroDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.ClienteDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.CuentaUsuarioDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.ElectrodomesticosDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.EmpleadoDeAreaDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.LoteDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.MovimientoLoteDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.ProductoPerecibleDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.ProductoPrecioDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.ProductosParaElCuidadoPersonalYDelHogarDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.RopaDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.SucursalDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.SupervisorDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Almacen;
import pe.edu.pucp.ZAP2.infraestructura.model.Area;
import pe.edu.pucp.ZAP2.infraestructura.model.Cajero;
import pe.edu.pucp.ZAP2.infraestructura.model.Cliente;
import pe.edu.pucp.ZAP2.infraestructura.model.CuentaUsuario;
import pe.edu.pucp.ZAP2.infraestructura.model.Descuento;
import pe.edu.pucp.ZAP2.infraestructura.model.Electrodomesticos;
import pe.edu.pucp.ZAP2.infraestructura.model.EmpleadoDeArea;
import pe.edu.pucp.ZAP2.infraestructura.model.Lote;
import pe.edu.pucp.ZAP2.infraestructura.model.MovimientoLote;
import pe.edu.pucp.ZAP2.infraestructura.model.Producto;
import pe.edu.pucp.ZAP2.infraestructura.model.ProductoPerecible;
import pe.edu.pucp.ZAP2.infraestructura.model.ProductoPrecio;
import pe.edu.pucp.ZAP2.infraestructura.model.ProductosParaElCuidadoPersonalYDelHogar;
import pe.edu.pucp.ZAP2.infraestructura.model.Ropa;
import pe.edu.pucp.ZAP2.infraestructura.model.Sucursal;
import pe.edu.pucp.ZAP2.infraestructura.model.Supervisor;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoAlmacen;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoContrato;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoDeMotivoMovimientoAlmacen;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoProductoPerecible;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoPuesto;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoRopa;
import pe.edu.pucp.ZAP2.infraestructura.model.TurnosHorario;
import pe.edu.pucp.ZAP2.infraestructura.model.UnidadDeMedida;
import pe.edu.pucp.ZAP2.infraestructura.mysql.AlmacenMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.AreaMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.CajeroMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.ClienteMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.CuentaUsuarioMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.ElectrodomesticosMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.EmpleadoDeAreaMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.LoteMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.MovimientoLoteMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.ProductoPerecibleMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.ProductoPrecioMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.ProductosParaElCuidadoPersonalYDelHogarMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.RopaMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.SucursalMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.SupervisorMySql;
import pe.edu.pucp.ZAP2.personas.dao.PersonaJuridicaDao;
import pe.edu.pucp.ZAP2.personas.model.PersonaJuridica;
import pe.edu.pucp.ZAP2.personas.model.TipoDocumento;
import pe.edu.pucp.ZAP2.personas.model.TipoEntidad;
import pe.edu.pucp.ZAP2.personas.mysql.PersonaJuridicaMySql;
import pe.edu.pucp.ZAP2.proveedor.dao.PedidoDao;
import pe.edu.pucp.ZAP2.proveedor.model.Estado_Pedido;
import pe.edu.pucp.ZAP2.proveedor.model.Pedido;
import pe.edu.pucp.ZAP2.proveedor.mysql.PedidoMySql;

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
        Producto producto = new ProductoPerecible();
        producto.setIdProducto(1);
        
        String fechaStr = "2022-05-10"; // Formato de fecha: "yyyy-MM-dd"
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = formato.parse(fechaStr);
        
        Sucursal sucursal = new Sucursal(1, "Av. Pepito Valle",
                1300.4, "Pepe's shop",
                null, null, null);
        
        Area area = new Area(1, "Zona de alimentos",sucursal, null);
        
        Supervisor supervisor = new Supervisor(5,null,null, 6, 456.5, fecha, TipoContrato.TiempoCompleto, TurnosHorario.MAÑANA, 
                area, 'M', "Mz C Lt9 Señor de los Milagros", null, 6, "Juan", "Vega", "Suares", 456485489, "juan.perez@example.com", 
                TipoDocumento.DNI, 75607208);
        
        Pedido pedido = new Pedido(1, 500.6, Estado_Pedido.COMPLETADO, fecha, 468.8, null);
        
        /*======================================================================*/
        /*============================== Sucursal ==============================*/
        /*======================================================================*/
        
        
//        SucursalDao daoSucursal = new SucursalMySql();
//        daoSucursal.insertar(sucursal);
        
        /*======================================================================*/
        /*================================ Area ================================*/
        /*======================================================================*/  
//        AreaDao daoArea = new AreaMySql();
//        daoArea.insertar(area);
        
        /*======================================================================*/
        /*============================== Almacen ===============================*/
        /*======================================================================*/  
//        Lote lote = new Lote();

//        Almacen almacen = new Almacen(1,TipoAlmacen.ALMACENCOMUN,500.0,0.0,null,true,sucursal,lote);
//        AlmacenDao daoAlmacen = new AlmacenMySql();

//        Sucursal sucursal = new Sucursal(1,"San Borja",20,"Tottus_San_Borja",null,null,null);
//        SucursalDao daoSucursal = new SucursalMySql();
//        daoSucursal.insertar(sucursal);
//        sucursal.setNombre("AQUI");
//        daoSucursal.modificar(sucursal);

//        daoAlmacen.insertar(almacen);
//        sucursal.setId_sucursal(1);
//        Almacen almacen = new Almacen(0,TipoAlmacen.ALMACENCOMUN,500.0,0.0,null,true,sucursal,null);
//        daoAlmacen.insertar(almacen); 
//        almacen.setId_almacen(1); 
//        almacen.setCapacidadMaximaProductos(777);
//        daoAlmacen.modificar(almacen); 
//        
        /*======================================================================*/
        /*============================== Cliente ===============================*/
        /*======================================================================*/ 

//        ClienteDao daoCliente = new ClienteMySql();
//        Cliente cliente = new Cliente(1,"12345678", 0, 'M', "su jato", null, 1, 
//                "SoyUnCliente", "Apellido1", "Apellido2", 965456534, "email@gmail.com",
//                TipoDocumento.DNI, 12432544);
//        daoCliente.insertar(cliente);

        /*======================================================================*/
        /*============================= Supervisor =============================*/
        /*======================================================================*/
//        SupervisorDao daoSupervisor = new SupervisorMySql();
//        daoSupervisor.insertar(supervisor);
//        supervisor.setId_Persona(6);
//        supervisor.setNombre("AQUI");
//        daoSupervisor.modificar(supervisor);

        /*======================================================================*/
        /*=============================== Cajero ===============================*/
        /*======================================================================*/
//        CajeroDao daoCajero = new CajeroMySql();
//        Cajero cajero = new Cajero(1, 2, supervisor, 0, 456.5, fecha, TipoContrato.TiempoCompleto, TurnosHorario.MAÑANA, 
//                area, 'M', "Mz C Lt9 Señor de los Milagros", null, 0, "Juan", "Vega", "Suares", 456485489, "juan.perez@example.com", TipoDocumento.DNI, 75607208);
//        daoCajero.insertar(cajero);
        
        /*======================================================================*/
        /*=========================== EmpleadoDeArea ===========================*/
        /*======================================================================*/
//        EmpleadoDeAreaDao daoEmpleadoDeArea = new EmpleadoDeAreaMySql();
//        EmpleadoDeArea empDeArea = new EmpleadoDeArea(supervisor, TipoPuesto.Consultor, 0, 456.5, fecha, TipoContrato.TiempoCompleto, TurnosHorario.MAÑANA, 
//                area, 'M', "Mz C Lt9 Señor de los Milagros", null, 0, "Juan", "Vega", "Suares", 456485489, "juan.perez@example.com", 
//                TipoDocumento.DNI, 75607208);
//        daoEmpleadoDeArea.insertar(empDeArea);

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

        /*======================================================================*/
        /*=========================== CuentaUsuario ============================*/
        /*======================================================================*/
//        CuentaUsuarioDao daoCuentaUsu = new CuentaUsuarioMySql();
//        CuentaUsuario cuentaUsu = new CuentaUsuario(0, "jorge123", "paraalo456*4", true, supervisor);
//        daoCuentaUsu.insertar(cuentaUsu);
    
        /*======================================================================*/
        /*============================== Pedido ================================*/
        /*======================================================================*/
//        PedidoDao daoPedido = new PedidoMySql();
//        daoPedido.insertar(pedido);

        /*======================================================================*/
        /*============================= Descuento ==============================*/
        /*======================================================================*/
//        DescuentoDao daoDescuento = new DescuentoMySql();
//        Descuento descuento = new Descuento(0, 0, 0, fecha, fecha, 0, prodPrecio);
//        daoDescuento.insertar(descuento);
        /*============================*/
        /*OJO: Falta probar!!!!!!!!!!!*/
        /*Alejandro le faltó implementar*/
        /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
        /*============================*/
        
        /*======================================================================*/
        /*=========================== ProductoPrecio ===========================*/
        /*======================================================================*/ 
//        ProductoPrecioDao daoProdPrecio = new ProductoPrecioMySql();
//        ProductoPrecio prodPrecio = new ProductoPrecio(1, 15.5, 1, sucursal, null, producto);
//        daoProdPrecio.insertar(prodPrecio);
        
        /*======================================================================*/
        /*========================= ProductoPerecible ==========================*/
        /*======================================================================*/ 
//        ProductoPerecibleDao daoProdPerec = new ProductoPerecibleMySql();
//        ProductoPerecible prodPerecible = new ProductoPerecible(fecha, TipoProductoPerecible.CEREALES, UnidadDeMedida.UNIDAD, 
//                0, fechaStr, fechaStr, null, 0, null);
//        daoProdPerec.insertar(prodPerecible);
        
        /*======================================================================*/
        /*============== ProductosParaElCuidadoPersonalYDelHogar ===============*/
        /*======================================================================*/      
//        ProductosParaElCuidadoPersonalYDelHogarDao daoProdParaCuidado = new ProductosParaElCuidadoPersonalYDelHogarMySql();
//        ProductosParaElCuidadoPersonalYDelHogar prodCuidado = new ProductosParaElCuidadoPersonalYDelHogar(UnidadDeMedida.UNIDAD, "higiene dental", 1,
//                "Colinos", "deja los dientes bien blancos", null, 1, null);
//        daoProdParaCuidado.insertar(prodCuidado);
        
        /*======================================================================*/
        /*================================ Ropa ================================*/
        /*======================================================================*/
//        RopaDao daoRopa = new RopaMySql();
//        Ropa ropa = new Ropa("invierno", "algodon", TipoRopa.CALZADO, 0, "Jeans", "skinny jeans", null, 1, null);
//        daoRopa.insertar(ropa);
        
        
        /*======================================================================*/
        /*========================= Electrodomésticos ==========================*/
        /*======================================================================*/ 
//        ElectrodomesticosDao daoElectrodomesticos = new ElectrodomesticosMySql();
//        Electrodomesticos electrodo = new Electrodomesticos("XYZ123", fecha, true, 1, "Lavadora Super Eficiente", 
//                "Lavadora con alta eficiencia energética y múltiples programas de lavado.", null, 1, null);
//        daoElectrodomesticos.insertar(electrodo);
        

        /*======================================================================*/
        /*================================ Lote ================================*/
        /*======================================================================*/
//        Almacen almacen = new Almacen();
//        almacen.setId_almacen(1);
//        
//        LoteDao daoLote = new LoteMySql();
//        Lote lote = new Lote(1,50 , 20, almacen, producto, null, 1);
//        daoLote.insertar(lote);

        /*======================================================================*/
        /*=========================== MovimientoLote ===========================*/
        /*======================================================================*/
//        Almacen almacenN = new Almacen();
//        almacenN.setId_almacen(1);
//        
//        Lote lote = new Lote();
//        lote.setIdLote(1);
//        
//        MovimientoLoteDao daoMovLote = new MovimientoLoteMySql();
//        MovimientoLote movLote = new MovimientoLote(1, fecha, 1, TipoDeMotivoMovimientoAlmacen.COMPRA,
//                1, 50, almacenN, null, lote);
//        daoMovLote.insertar(movLote);
        /*============================*/
        /*OJO: Falta probar!!!!!!!!!!!*/
        //Ojo: Cómo hariamos para insertar un movimiento que tenga relación con solo 1 almacen y que no salga ERROR
        /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
        /*============================*/
        
        
        /*======================================================================*/
        /*============================ Boleta_Venta ============================*/
        /*======================================================================*/ 
//        Supervisor supervisor = new Supervisor(5,null,null, 0, 456.5, fecha, TipoContrato.TiempoCompleto, TurnosHorario.MAÑANA, 
//                area, 'M', "Mz C Lt9 Señor de los Milagros", null, 0, "Juan", "Vega", "Suares", 456485489, "juan.perez@example.com", 
//                TipoDocumento.DNI, 75607208);
//        supervisor.setIdEmpleado(6);
//        supervisor.setId_Persona(6);
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
//        bol_venta.setFecha_emision(fecha);
//        Boleta_VentaDao daoBol_Venta = new Boleta_VentaMySql();
//        daoBol_Venta.insertar(bol_venta);
//        bol_venta.setDetalles("AQUI");
//        daoBol_Venta.eliminar(21);
//        daoBol_Venta.modificar(bol_venta); // FALTA PROBAR, ERROR EN EL PROCEDURE

        /*======================================================================*/
        /*============================ CuentaUsuario ============================*/
        /*======================================================================*/   
//        CuentaUsuario cuenta = new CuentaUsuario(1,"PRUEBA_USUARIO","PRUEBA_CONTRA",true,cliente);
//        CuentaUsuarioDao daoCuenta = new CuentaUsuarioMySql();
//        cuenta.setIdCuenta(5);
//        cuenta.setPersonaNatural(cliente);
//        daoCuenta.insertar(cuenta);
//        cuenta.setUsuario("AQUI");
//        daoCuenta.modificar(cuenta);

        /*======================================================================*/
        /*================================ Banco ===============================*/
        /*======================================================================*/   
//        Banco banco = new Banco(1,"BBVA");
//        BancoDao daoBanco = new BancoMySql();
//        daoBanco.insertar(banco);
//        banco.setNombre("MIFARMA");
//        banco.setIdBanco(2);
//        daoBanco.modificar(banco);

        /*======================================================================*/
        /*========================= Documento_de_Compra ========================*/
        /*======================================================================*/ 
        
//        Moneda moneda = new Moneda();
//        moneda.setIdMoneda(1);
//        moneda.setAbreviacion("PEN");
//        moneda.setNombre("Soles");
//
//        Documento_de_Compra doc_Compra = new Documento_de_Compra(1,pedido,1,fecha,200,moneda,null);
//        Documento_de_CompraDao daoDoc_Comra = new Documento_de_CompraMySql();
//        
////        daoDoc_Comra.insertar(doc_Compra); 
////        daoDoc_Comra.modificar(doc_Compra); // ERRPR EN EL PROCEDURE, FALTA PROBAR
//        daoDoc_Comra.eliminar(20);

        /*======================================================================*/
        /*============================ Factura_Venta ===========================*/
        /*======================================================================*/
//        Moneda moneda = new Moneda();
//        moneda.setIdMoneda(1);
//        moneda.setAbreviacion("PEN");
//        moneda.setNombre("Soles");
//        
//        
//        PersonaJuridica persona_juridica = new PersonaJuridica();
//        persona_juridica.setRUC("123");
//        
//        Banco banco = new Banco(1,"BBVA");
//        
//        Tarjeta tarjeta = new Tarjeta();
//        tarjeta.setCodTarjeta(777);
//        tarjeta.setIdTarjeta(1);
//        tarjeta.setBanco(banco);
//        tarjeta.setTipoTarjeta(Tipo_Tarjeta.DEBITO);
//        
//        Factura_Venta fact_venta = new Factura_Venta(1,"CAMBIAR",fecha,persona_juridica);
//        fact_venta.setTarjeta(tarjeta);
//        fact_venta.setEmpleado(supervisor);
//        fact_venta.setMoneda(moneda);
//        fact_venta.setFecha_emision(fecha);
//        Factura_VentaDao daoFac_Venta = new Factura_VentaMySql();
//        
//        daoFac_Venta.insertar(fact_venta); // ERROR EN EL PROCEDURE FALTA PROBAR 
//        daoFac_Venta.modificar(fact_venta); // ERROR EN EL PROCEDURE FALTA PROBAR 

        /*======================================================================*/
        /*=============================== Moneda ===============================*/
        /*======================================================================*/
//        Moneda moneda = new Moneda();
//        moneda.setIdMoneda(1);
//        moneda.setAbreviacion("PEN");
//        moneda.setNombre("Soles");
//        MonedaDao daoMoneda = new MonedaMySql();
//        
//        daoMoneda.insertar(moneda);
//        moneda.setNombre("AQUI");
//        daoMoneda.modificar(moneda);
                
        /*======================================================================*/
        /*=============================== Tarjeta ==============================*/
        /*======================================================================*/
//        Banco banco = new Banco(1,"BBVA");
//        
//        Tarjeta tarjeta = new Tarjeta();
//        tarjeta.setCodTarjeta(777);
//        tarjeta.setIdTarjeta(1);
//        tarjeta.setBanco(banco);
//        tarjeta.setTipoTarjeta(Tipo_Tarjeta.DEBITO);
//        
//        TarjetaDao daoTarjeta = new TarjetaMySql();
//        daoTarjeta.insertar(tarjeta);
//        tarjeta.setCodTarjeta(666);
//        daoTarjeta.modificar(tarjeta);
        
        /*======================================================================*/
        /*=========================== PersonaJuridica ==========================*/
        /*======================================================================*/
//        PersonaJuridica persona_juridica = new PersonaJuridica("CAMBIAR",TipoEntidad.Asociacion,12223,"DIRECCION","123",1,"NOMBRE","APP","APM",12345,"EMAIL",
//                                                                TipoDocumento.CARNET_EXTRANJERIA,1234);
//        PersonaJuridicaDao daopersona_juridica = new PersonaJuridicaMySql();
        
//        daopersona_juridica.insertar(persona_juridica);
//        persona_juridica.setDireccionLegal("AQUI");
//        persona_juridica.setId_Persona(12);
//        daopersona_juridica.modificar(persona_juridica);

        /*======================================================================*/
        /*=============================== LineaDoc =============================*/
        /*======================================================================*/
        
        
        
        
        
 }
    
}
