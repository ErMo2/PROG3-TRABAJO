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
import pe.edu.pucp.ZAP2.infraestructura.dao.DescuentoDao;
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
import pe.edu.pucp.ZAP2.infraestructura.mysql.DescuentoMySql;
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
import pe.edu.pucp.ZAP2.personas.model.Persona;
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
        String fechaStr2 = "2022-08-10"; // Formato de fecha: "yyyy-MM-dd"
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha1 = formato.parse(fechaStr);
        Date fecha2 = formato.parse(fechaStr2);
        
        Sucursal sucursal = new Sucursal(1, "Av. Pepito Valle",
                1300.4, "Pepe's shop",
                null, null, null);
        
        Area area = new Area(1, "Zona de alimentos",sucursal, null);
        
        /*======================================================================*/
        /*============================== Sucursal ==============================*/
        /*======================================================================*/
//        SucursalDao daoSucursal = new SucursalMySql();
        
        /*######### Insertar ########*/
//        Sucursal sucursal = new Sucursal(1,"San Borja",20,"Tottus_San_Borja",null,null,null);
//        daoSucursal.insertar(sucursal);

        /*######## Modificar ########*/
//        Sucursal sucursal = new Sucursal(1,"San Borja",20,"Tottus_San_Borja",null,null,null);
//        sucursal.setNombre("AQUI");
//        daoSucursal.modificar(sucursal);
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/
        

        
        /*======================================================================*/
        /*================================ Area ================================*/
        /*======================================================================*/
//        AreaDao daoArea = new AreaMySql();
        
        /*######### Insertar ########*/
//        daoArea.insertar(area);
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/
        
        /*======================================================================*/
        /*============================== Almacen ===============================*/
        /*======================================================================*/
//        AlmacenDao daoAlmacen = new AlmacenMySql();
        
        /*######### Insertar ########*/
//        Almacen almacen = new Almacen(1,TipoAlmacen.ALMACENCOMUN,500.0,0.0,null,true,sucursal,null);
//        daoAlmacen.insertar(almacen);
        
        /*######## Modificar ########*/
//        Almacen almacen = new Almacen(1,TipoAlmacen.ALMACENCOMUN,856.0,0.0,null,true,sucursal,null);
//        almacen.setCapacidadMaximaProductos(800);
//        daoAlmacen.modificar(almacen); 
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/
 
        /*======================================================================*/
        /*============================== Cliente ===============================*/
        /*======================================================================*/
//        ClienteDao daoCliente = new ClienteMySql();
        /*######### Insertar ########*/
//        Cliente cliente = new Cliente(1,"12345678", 0, 'M', "su jato", null, 1, 
//                "SoyUnCliente", "Apellido1", "Apellido2", 965456534, "email@gmail.com",
//                TipoDocumento.DNI, 12432544);
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/


//        daoCliente.insertar(cliente);

        /*======================================================================*/
        /*============================= Supervisor =============================*/
        /*======================================================================*/
//        SupervisorDao daoSupervisor = new SupervisorMySql();

        /*######### Insertar ########*/
//        Supervisor supervisor = new Supervisor(0,null,null, 6, 456.5, fecha1, TipoContrato.TiempoCompleto, TurnosHorario.MAÑANA, 
//                area, 'M', "Mz C Lt9 Señor de los Milagros", null, 6, "Juan", "Vega", "Suares", 456485489, "juan.perez@example.com", 
//                TipoDocumento.DNI, 75607208);
//        daoSupervisor.insertar(supervisor);
        
        /*######## Modificar ########*/
//        Supervisor supervisor = new Supervisor(6,null,null, 6, 456.5, fecha1, TipoContrato.TiempoCompleto, TurnosHorario.MAÑANA, 
//                area, 'M', "Mz C Lt9 Señor de los Milagros", null, 6, "Juan", "Vega", "Suares", 456485489, "juan.perez@example.com", 
//                TipoDocumento.DNI, 75607208);
//        supervisor.setNombre("AQUI");
//        daoSupervisor.modificar(supervisor);
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/

        /*======================================================================*/
        /*=============================== Cajero ===============================*/
        /*======================================================================*/
//        CajeroDao daoCajero = new CajeroMySql();
        
        /*######### Insertar ########*/
//        Cajero cajero = new Cajero(1, 2, supervisor, 0, 456.5, fecha1, TipoContrato.TiempoCompleto, TurnosHorario.MAÑANA, 
//                area, 'M', "Mz C Lt9 Señor de los Milagros", null, 0, "Juan", "Vega", "Suares", 456485489, "juan.perez@example.com", TipoDocumento.DNI, 75607208);
//        daoCajero.insertar(cajero);
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/        
        
        
        /*======================================================================*/
        /*=========================== EmpleadoDeArea ===========================*/
        /*======================================================================*/
//        Supervisor supervisor = new Supervisor();
//        supervisor.setIdEmpleado(6);
//        supervisor.setId_Persona(6);
//        
//        EmpleadoDeAreaDao daoEmpleadoDeArea = new EmpleadoDeAreaMySql();
        
        /*######### Insertar ########*/
//        EmpleadoDeArea empDeArea = new EmpleadoDeArea(supervisor, TipoPuesto.Consultor, 0, 456.5, fecha1, TipoContrato.TiempoCompleto, TurnosHorario.MAÑANA, 
//                area, 'M', "Mz C Lt9 Señor de los Milagros", null, 0, "Juan", "Vega", "Suares", 456485489, "juan.perez@example.com", 
//                TipoDocumento.DNI, 75607208);
//        daoEmpleadoDeArea.insertar(empDeArea);
        
        /*######## Modificar ########*/
//        EmpleadoDeArea empDeArea = new EmpleadoDeArea(supervisor, TipoPuesto.Consultor, 0, 456.5, fecha1, TipoContrato.TiempoCompleto, TurnosHorario.MAÑANA, 
//                area, 'M', "Mz C Lt9 Señor de los Milagros", null, 0, "Juan", "Vega", "Suares", 456485489, "juan.perez@example.com", 
//                TipoDocumento.DNI, 75607208);
//        empDeArea.setId_Persona(11);
//        empDeArea.setIdEmpleado(11);
//        empDeArea.setTipo_documento(TipoDocumento.DNI);
//        empDeArea.setPuesto(TipoPuesto.Empacador);
//        daoEmpleadoDeArea.modificar(empDeArea);
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/

        /*======================================================================*/
        /*=========================== CuentaUsuario ============================*/
        /*======================================================================*/
//        Supervisor supervisor = new Supervisor();
//        supervisor.setIdEmpleado(6);
//        supervisor.setId_Persona(6);
        
        /*######### Insertar ########*/
//        CuentaUsuarioDao daoCuentaUsu = new CuentaUsuarioMySql();
//        CuentaUsuario cuentaUsu = new CuentaUsuario(0, "jorge123", "paraalo456*4", true, supervisor);
//        daoCuentaUsu.insertar(cuentaUsu);
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/
        
    
        /*======================================================================*/
        /*============================== Pedido ================================*/
        /*======================================================================*/
//        PedidoDao daoPedido = new PedidoMySql();
        
        /*######### Insertar ########*/
//        Pedido pedido = new Pedido(1, 500.6, Estado_Pedido.COMPLETADO, fecha1, 468.8, null);
//        daoPedido.insertar(pedido);
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/    

        /*======================================================================*/
        /*============================= Descuento ==============================*/
        /*======================================================================*/
//        DescuentoDao daoDescuento = new DescuentoMySql();
//        
//        ProductoPrecio prodPrecio = new ProductoPrecio();
//        prodPrecio.setIdProductoPrecio(1);
        
        /*######### Insertar ########*/
//        Descuento descuento = new Descuento(0,0.2, 0, fecha1, fecha2, 1, prodPrecio);//0.2 <> 20% 
//        daoDescuento.insertar(descuento);
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/        
        
        /*======================================================================*/
        /*=========================== ProductoPrecio ===========================*/
        /*======================================================================*/
//        ProductoPrecioDao daoProdPrecio = new ProductoPrecioMySql();
        
        /*######### Insertar ########*/
//        ProductoPrecio prodPrecio = new ProductoPrecio(1, 15.5, 1, sucursal, null, producto);
//        daoProdPrecio.insertar(prodPrecio);
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/    
        
        /*======================================================================*/
        /*========================= ProductoPerecible ==========================*/
        /*======================================================================*/
//        ProductoPerecibleDao daoProdPerec = new ProductoPerecibleMySql();
//        /*######### Insertar ########*/
//        ProductoPerecible prodPerecible = new ProductoPerecible(fecha, TipoProductoPerecible.DESPENSA, UnidadDeMedida.UNIDAD, 
//                0, "Lata atún", "Lata Atún Florida En Trozos", null, 1, null);
//        daoProdPerec.insertar(prodPerecible);
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/   
        
        
        /*======================================================================*/
        /*============== ProductosParaElCuidadoPersonalYDelHogar ===============*/
        /*======================================================================*/
//        ProductosParaElCuidadoPersonalYDelHogarDao daoProdParaCuidado = new ProductosParaElCuidadoPersonalYDelHogarMySql();
        
        /*######### Insertar ########*/
//        ProductosParaElCuidadoPersonalYDelHogar prodCuidado = new ProductosParaElCuidadoPersonalYDelHogar(UnidadDeMedida.UNIDAD, "higiene dental", 1,
//        "Colinos", "deja los dientes bien blancos", null, 1, null);
//        daoProdParaCuidado.insertar(prodCuidado);
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/

        /*======================================================================*/
        /*================================ Ropa ================================*/
        /*======================================================================*/
//        RopaDao daoRopa = new RopaMySql();
        
        /*######### Insertar ########*/
//        Ropa ropa = new Ropa("invierno", "algodon", TipoRopa.CALZADO, 0, "Jeans", "skinny jeans", null, 1, null);
//        daoRopa.insertar(ropa);
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/
        
        /*======================================================================*/
        /*========================= Electrodomésticos ==========================*/
        /*======================================================================*/
//        ElectrodomesticosDao daoElectrodomesticos = new ElectrodomesticosMySql();
        
        /*######### Insertar ########*/
//        Electrodomesticos electrodo = new Electrodomesticos("XYZ123", fecha1, true, 1, "Lavadora Super Eficiente", 
//                "Lavadora con alta eficiencia energética y múltiples programas de lavado.", null, 1, null);
//        daoElectrodomesticos.insertar(electrodo);
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/   

        /*======================================================================*/
        /*================================ Lote ================================*/
        /*======================================================================*/
//        Almacen almacen = new Almacen();
//        almacen.setId_almacen(1);
//        
//        LoteDao daoLote = new LoteMySql();
        
        /*######### Insertar ########*/
//        Lote lote = new Lote(1,50 , 20, almacen, producto, null, 1);
//        daoLote.insertar(lote);
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/

        /*======================================================================*/
        /*=========================== MovimientoLote ===========================*/
        /*======================================================================*/
//        Almacen almacenN = new Almacen();
//        almacenN.setId_almacen(1);
//        
//        Lote lote = new Lote();
//        lote.setIdLote(3);
//        
//        MovimientoLoteDao daoMovLote = new MovimientoLoteMySql();
        
        /*######### Insertar ########*/
////        MovimientoLote movLote = new MovimientoLote(1, fecha1, 1, TipoDeMotivoMovimientoAlmacen.COMPRA,
////                1, 50, almacenN, null, lote);
////        daoMovLote.insertar(movLote);
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/
        
        /*======================================================================*/
        /*============================ Boleta_Venta ============================*/
        /*======================================================================*/
//        Supervisor supervisor = new Supervisor();
//        supervisor.setIdEmpleado(6);
//        supervisor.setId_Persona(6);
//        
//        Tarjeta tarjeta = new Tarjeta();
//        tarjeta.setIdTarjeta(1);
//        
//        Moneda moneda = new Moneda();
//        moneda.setIdMoneda(1);
//        
//        Persona cli = new Cliente();
//        cli.setId_Persona(5);
//        
//        Boleta_VentaDao daoBol_Venta = new Boleta_VentaMySql();
        
        /*######### Insertar ########*/
//        Boleta_Venta bol_venta = new Boleta_Venta(6485, "Pago a tiempo", 145.6, cli, 0, 684.8, tarjeta, supervisor
//                                , 0, fecha1, 684.8, moneda, null);
//        daoBol_Venta.insertar(bol_venta);
        
        /*######## Modificar ########*/
//        Boleta_Venta bol_venta = new Boleta_Venta(6485, "Pago a tiempo", 145.6, cli, 0, 684.8, tarjeta, supervisor
//                                , 0, fecha1, 684.8, moneda, null);
//        bol_venta.setId_doc_venta(23);
//        bol_venta.setId_documento(23);
//        bol_venta.setDetalles("AQUI");
//        daoBol_Venta.modificar(bol_venta);
        
        /*######## Eliminar #########*/
//        daoBol_Venta.eliminar(23);
        
        /*########## Listar #########*/
        
        /*
        
        LOS PUSE ENTENDIBLE HASTA ACÁ (SOY LEONARDO)
        
        */

        /*======================================================================*/
        /*============================ CuentaUsuario ===========================*/
        /*======================================================================*/
        /*######### Insertar ########*/
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/
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
        /*######### Insertar ########*/
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/
//        Banco banco = new Banco(1,"BBVA");
//        BancoDao daoBanco = new BancoMySql();
//        daoBanco.insertar(banco);
//        banco.setNombre("MIFARMA");
//        banco.setIdBanco(2);
//        daoBanco.modificar(banco);

        /*======================================================================*/
        /*========================= Documento_de_Compra ========================*/
        /*======================================================================*/
        /*######### Insertar ########*/
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/
        
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
        /*######### Insertar ########*/
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/
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
        /*######### Insertar ########*/
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/
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
        /*######### Insertar ########*/
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/
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
        /*######### Insertar ########*/
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/
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
        /*######### Insertar ########*/
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/
        
        
        
        
        
 }
    
}
