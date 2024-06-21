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
import pe.edu.pucp.ZAP2.documentos.dao.Documento_de_CompraDao;
import pe.edu.pucp.ZAP2.documentos.dao.Documento_de_VentaDao;
import pe.edu.pucp.ZAP2.documentos.dao.Factura_VentaDao;
import pe.edu.pucp.ZAP2.documentos.dao.LineaDocDao;
import pe.edu.pucp.ZAP2.documentos.dao.MonedaDao;
import pe.edu.pucp.ZAP2.documentos.dao.TarjetaDao;
import pe.edu.pucp.ZAP2.documentos.model.Banco;
import pe.edu.pucp.ZAP2.documentos.model.Boleta_Venta;
import pe.edu.pucp.ZAP2.documentos.model.Documento;
import pe.edu.pucp.ZAP2.documentos.model.Documento_de_Compra;
import pe.edu.pucp.ZAP2.documentos.model.Documento_de_Venta;
import pe.edu.pucp.ZAP2.documentos.model.Factura_Venta;
import pe.edu.pucp.ZAP2.documentos.model.LineaDoc;
import pe.edu.pucp.ZAP2.documentos.model.Moneda;
import pe.edu.pucp.ZAP2.documentos.model.Tarjeta;
import pe.edu.pucp.ZAP2.documentos.model.Tipo_Tarjeta;
import pe.edu.pucp.ZAP2.documentos.mySql.BancoMySql;
import pe.edu.pucp.ZAP2.documentos.mySql.Boleta_VentaMySql;
import pe.edu.pucp.ZAP2.documentos.mySql.Documento_de_CompraMySql;
import pe.edu.pucp.ZAP2.documentos.mySql.Documento_de_VentaMySql;
import pe.edu.pucp.ZAP2.documentos.mySql.Factura_VentaMySql;
import pe.edu.pucp.ZAP2.documentos.mySql.LineaDocMySql;
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
import pe.edu.pucp.ZAP2.proveedor.dao.Detalle_PedidoDao;
import pe.edu.pucp.ZAP2.proveedor.dao.PedidoDao;
import pe.edu.pucp.ZAP2.proveedor.model.Detalle_Pedido;
import pe.edu.pucp.ZAP2.proveedor.model.Estado_Pedido;
import pe.edu.pucp.ZAP2.proveedor.model.Pedido;
import pe.edu.pucp.ZAP2.proveedor.mysql.Detalle_PedidoMySql;
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
        
        String fechaStr = "2022-05-10"; // Formato de fecha: "yyyy-MM-dd"
        String fechaStr2 = "2022-08-10"; // Formato de fecha: "yyyy-MM-dd"
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha1 = formato.parse(fechaStr);
        Date fecha2 = formato.parse(fechaStr2);
        
        /*======================================================================*/
        /*============================== Sucursal ==============================*/
        /*======================================================================*/
//        SucursalDao daoSucursal = new SucursalMySql();
        
        /*######### Insertar ########*/
//        Sucursal sucursalB = new Sucursal(1,"San Borja",20,"Tottus_San_Borja",null,null,null);
//        daoSucursal.insertar(sucursalB);

        /*######## Modificar ########*/
//        Sucursal sucursalB = new Sucursal(2,"San Borja",20,"Tottus_San_Borja",null,null,null);
//        sucursalB.setNombre("AQUISITO");
//        daoSucursal.modificar(sucursalB);
        
        /*######## Eliminar #########*/
//        daoSucursal.eliminar(1);
        
        /*########## Listar #########*/
//        ArrayList<Sucursal> sucursales;
//        sucursales = daoSucursal.listarTodas();
//        for(Sucursal sucursalLB : sucursales){
//            System.out.println("id: " + sucursalLB.getId_sucursal() + " Direccion: " + sucursalLB.getDireccion() + " Nombre: " + sucursalLB.getNombre() + "\n");
//        }
        
        /*======================================================================*/
        /*================================ Area ================================*/
        /*======================================================================*/
        AreaDao daoArea = new AreaMySql();
        Area area = new Area();
        area.setIdArea(1);
        Producto producto = new  Producto();
        producto.setIdProducto(89);
        daoArea.insertProductoArea(area, producto);
        /*######### Insertar ########*/
//        Area areaB = new Area(1, "Zona de Electrodomesticos",sucursal, null);
//        daoArea.insertar(areaB);
        
        /*######## Modificar ########*/
//        Area areaB = new Area(2, "CAMBIO",sucursal, null);
//        daoArea.modificar(areaB);
        
        /*######## Eliminar #########*/
//        daoArea.eliminar(1);
        
        /*########## Listar #########*/
//        ArrayList<Area> areas = new ArrayList();
//        areas = daoArea.listarTodas();
//        for(Area area : areas){
//            System.out.println("ID: " + area.getIdArea() + " Nombre: " + area.getNombre() + "\n");
//        }
        

        /*======================================================================*/
        /*============================== Almacen ===============================*/
        /*======================================================================*/
//        AlmacenDao daoAlmacen = new AlmacenMySql();
        
        /*######### Insertar ########*/
//        Almacen almacen = new Almacen(1,TipoAlmacen.ALMACENSECO,500.0,0.0,null,true,sucursal,null);
//        daoAlmacen.insertar(almacen);
        
        /*######## Modificar ########*/
//        Almacen almacen = new Almacen(2,TipoAlmacen.REFRIGERADORA,856.0,0.0,null,true,sucursal,null);
//        almacen.setCapacidadMaximaProductos(560);
//        daoAlmacen.modificar(almacen); 
        
        /*######## Eliminar #########*/
//        daoAlmacen.eliminar(1);

        /*########## Listar #########*/
//        ArrayList<Almacen> almcaenes = new ArrayList<Almacen>();
//        almcaenes = daoAlmacen.listarTodos();
//        for(Almacen almacen: almcaenes){
//            System.out.println("ID: " + almacen.getId_almacen() + " Cpacidad Maxima: " + almacen.getCapacidadMaximaProductos()
//            + " Tipo Almacen: " + almacen.getTipoAlmacen());
//        }
        
        /*======================================================================*/
        /*============================== Cliente ===============================*/
        /*======================================================================*/
//        ClienteDao daoCliente = new ClienteMySql();

        /*######### Insertar ########*/
//        Cliente cliente = new Cliente(1,"12345678", 0, 'M', "su jato", null, 1, 
//                "SoyUnCliente", "Apellido1", "Apellido2", 965456534, "email@gmail.com",
//                TipoDocumento.DNI, 12432544);
//        daoCliente.insertar(cliente);
        
        /*######## Modificar ########*/
//        Cliente cliente = new Cliente(17,"9991", 0, 'M', "su jato", null, 1, 
//                "SoyUnAdministrador", "Apellido1", "Apellido2", 965456534, "email@gmail.com",
//                TipoDocumento.DNI, 12432544);
//        cliente.setId_Persona(17);
//        cliente.setDni("987345");
//        daoCliente.modificar(cliente);

        /*######## Eliminar #########*/
//        daoCliente.eliminar(17);

        /*########## Listar #########*/   

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
//        daoSupervisor.eliminar(20);
        
        /*########## Listar #########*/
//        ArrayList<Supervisor> supervisores = new ArrayList<Supervisor>();
//        supervisores = daoSupervisor.listarTodas();
//        for(Supervisor supervisor : supervisores){
//            System.out.println("ID: " + supervisor.getId_Persona() + " Nombre: " + supervisor.getNombre() + "\n");
//        }

        /*======================================================================*/
        /*=============================== Cajero ===============================*/
        /*======================================================================*/
//        Supervisor supervisor = new Supervisor();
//        supervisor.setIdEmpleado(6);
//        supervisor.setId_Persona(6);
//        
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
//        empDeArea.setPuesto(TipoPuesto.Consultor);
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
//        
//        Producto producto = new ProductoPerecible();
//        producto.setIdProducto(2);
//        
//        Detalle_PedidoDao daoDetPed = new Detalle_PedidoMySql();
//        Detalle_Pedido detPed = new Detalle_Pedido();
//        detPed.setPrecioTotal(50);
//        detPed.setPrecioUnitario(10);
//        detPed.setProducto(producto);
//        detPed.setSubtotal(59);
//        
//        /*######### Insertar ########*/
////        Pedido pedido = new Pedido(5, 999, Estado_Pedido.EN_PROCESO, fecha2, 468.8, null);
//        //daoPedido.insertar(pedido);
//        
//        detPed.setPedido(pedido);
//        daoDetPed.insertar(detPed);
//        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
//        daoPedido.eliminar(1);
        
        /*########## Listar #########*/
//        ArrayList<Pedido> pedidos = daoPedido.listarTodas();
//        for(Pedido ped:pedidos){
//            ped.imprimir();
//        }
        
        /*======================================================================*/
        /*=========================== Detalle_Pedido ==========================*/
        /*======================================================================*/
        /*######### Insertar ########*/
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/  
        
        /*########## ListarXId #########*/  
//        Detalle_PedidoDao daoDetPed=new Detalle_PedidoMySql();
//        ArrayList<Detalle_Pedido> extra = daoDetPed.listarXIDPedido(1);
//        for(Detalle_Pedido ped:extra){
//            ped.imprimir();
//        }

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
//        /*======================================================================*/
//        Sucursal sucursal = new Sucursal();
//        sucursal.setId_sucursal(1);
//        Producto producto = new Producto();
//        producto.setIdProducto(89);
//        ProductoPrecioDao daoProdPrecio = new ProductoPrecioMySql();
//        
//        /*######### Insertar ########*/
//        ProductoPrecio prodPrecio = new ProductoPrecio(1, 40.50, 1, sucursal, null, producto);
//        daoProdPrecio.insertar(prodPrecio);
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
        
        /*########## Listar #########*/    
        
        /*======================================================================*/
        /*========================= ProductoPerecible ==========================*/
        /*======================================================================*/
//        ProductoPerecibleDao daoProdPerec = new ProductoPerecibleMySql();
//        /*######### Insertar ########*/
//        ProductoPerecible prodPerecible = new ProductoPerecible(fecha1, TipoProductoPerecible.Despensa, UnidadDeMedida.paquete, 
//                0, "Keke Sabores", "Marmoleado", null, 1, null);
//        daoProdPerec.insertar(prodPerecible);
        
        /*######## Modificar ########*/
        
        /*######## Eliminar #########*/
//        daoProdPerec.eliminar(1);
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
//        Ropa ropa = new Ropa("invierno", "algodon", TipoRopa.ROPAHOMBRE, 0, "Jeans", "skinny jeans", null, 1, null);
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
//        ArrayList<Boleta_Venta> boletasVenta = daoBol_Venta.listarTodas();
//        for(Boleta_Venta bolVent:boletasVenta){
//            bolVent.imprimir();
//        }
        //############################################################################
        //############################################################################
        //############################################################################
        //########## Sebas tiene que corregir el LISTAR_BOLETA_VENTA() #########
        //################# Una vez arreglado eso, corrigue el listarTodas de Boleta_VentaMySql ###########################
        //############################################################################
        //############################################################################
        
        /*======================================================================*/
        /*================================ Banco ===============================*/
        /*======================================================================*/
//        BancoDao daoBanco = new BancoMySql();
        
        /*######### Insertar ########*/
//        Banco banco = new Banco(0,"BANBIF");
//        daoBanco.insertar(banco);
        
        /*######## Modificar ########*/
//        Banco banco = new Banco(8,"BBVA");
//        banco.setNombre("Pichincha");
//        daoBanco.modificar(banco);
        
        /*######## Eliminar #########*/
//        daoBanco.eliminar(3);
        
        /*########## Listar #########*/
//        ArrayList<Banco> bancos = daoBanco.listarTodos();
//        for(Banco banco:bancos){
//            banco.imprimir();
//        }

        /*======================================================================*/
        /*========================= Documento_de_Compra ========================*/
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
//        Pedido pedido = new Pedido();
//        pedido.setId_pedido(1);
//        
//        Documento_de_CompraDao daoDoc_Comra = new Documento_de_CompraMySql();
        
        /*######### Insertar ########*/
//        Documento_de_Compra doc_Compra = new Documento_de_Compra(1,pedido,1,fecha1,200,moneda,null);
//        daoDoc_Comra.insertar(doc_Compra); 
        
        /*######## Modificar ########*/
//        pedido.setId_pedido(2);
//        Documento_de_Compra doc_Compra = new Documento_de_Compra(20,pedido,1,fecha1,200,moneda,null);
//        daoDoc_Comra.modificar(doc_Compra);
        
        
        /*######## Eliminar #########*/
//        daoDoc_Comra.eliminar(25);
        
        /*########## Listar #########*/
//        ArrayList<Documento_de_Compra> documentosCompra = daoDoc_Comra.listarTodos();
//        for(Documento_de_Compra docCompra:documentosCompra){
//            docCompra.imprimir();
//        }
        
        /*########## Listar Egresos #########*/
//        String fechaStr = "2022-05-05"; // Formato de fecha: "yyyy-MM-dd"
//        String fechaStr2 = "2022-08-20"; // Formato de fecha: "yyyy-MM-dd"
//        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//        Date fecha1 = formato.parse(fechaStr);
//        Date fecha2 = formato.parse(fechaStr2);
//        ArrayList<Documento_de_Compra> extra;
//        extra = daoDoc_Comra.listarEgresos(fecha1, fecha2);
//        for(Documento_de_Compra doc : extra){
//            doc.imprimir();
//        }
        /*======================================================================*/
        /*============================ Documento_de_Venta ===========================*/
        /*======================================================================*/
 
        /*########## Listar Ingresos #########*/
//        String fechaStr = "2022-05-05"; // Formato de fecha: "yyyy-MM-dd"
//        String fechaStr2 = "2022-08-20"; // Formato de fecha: "yyyy-MM-dd"
//        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//        Date fecha1 = formato.parse(fechaStr);
//        Date fecha2 = formato.parse(fechaStr2);
//        Documento_de_VentaDao daoDocVenta = new Documento_de_VentaMySql();
//        ArrayList<Documento_de_Venta> extra;
//        extra = daoDocVenta.listarIngresos( fecha1, fecha2);
//        for(Documento_de_Venta doc:extra){
//            doc.imprimir();
//        }        
        
        /*======================================================================*/
        /*============================ Factura_Venta ===========================*/
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
//        Pedido pedido = new Pedido();
//        pedido.setId_pedido(1);
//        
//        PersonaJuridica perJur = new PersonaJuridica();
//        perJur.setRUC("123");
//        perJur.setId_Persona(12);
//        
//        Factura_Venta facVenta = new Factura_Venta(0, "detallitos bonitos", fecha1, perJur, 
//                0, 568.8, tarjeta, supervisor, 0, fecha1, 568.8, moneda, null);
//        
//        Factura_VentaDao daofacVenta = new Factura_VentaMySql();
//        
        /*######### Insertar ########*/  
//        daofacVenta.insertar(facVenta);
        
        /*######## Modificar ########*/
//        facVenta.setDetalles("CAMBIO AQUI");
//        facVenta.setId_documento(34);
//        daofacVenta.modificar(facVenta);
        
        /*######## Eliminar #########*/
//        daofacVenta.eliminar(33);

        /*########## Listar #########*/
//        ArrayList<Factura_Venta> fac_ventas = new ArrayList<Factura_Venta>();
//        fac_ventas = daofacVenta.listarTodos();
//        for(Factura_Venta fac : fac_ventas){
//            System.out.println("ID: " + fac.getIdFactura() + " Detalles: " + fac.getDetalles() + "\n");
//        }
        
        /*======================================================================*/
        /*=============================== Moneda ===============================*/
        /*======================================================================*/
//        MonedaDao daoMoneda = new MonedaMySql();    
        
        /*######### Insertar ########*/
//        Moneda moneda = new Moneda("NUEVO SOL", "S/", 0);
//        daoMoneda.insertar(moneda);
        
        /*######## Modificar ########*/
//        Moneda moneda = new Moneda("NUEVO SOL", "S/", 0);
//        moneda.setIdMoneda(19);
//        moneda.setNombre("DOLAR");
//        moneda.setAbreviacion("$");
//        daoMoneda.modificar(moneda);
        
        /*######## Eliminar #########*/
//        daoMoneda.eliminar(12);
        
        /*########## Listar #########*/
//        ArrayList<Moneda> monedas = new ArrayList<Moneda>();
//        monedas = daoMoneda.listarTodos();
//        for(Moneda moneda : monedas){
//            System.out.println("ID: " + moneda.getIdMoneda() + " Abreviacion: " + moneda.getAbreviacion());
//        }
        
        /*======================================================================*/
        /*=============================== Tarjeta ==============================*/
        /*======================================================================*/
//        Banco banco = new Banco(1,"BBVA");
//        
//        Tarjeta tarjeta = new Tarjeta();
//        tarjeta.setCodTarjeta(777);
//        tarjeta.setIdTarjeta(2);
//        tarjeta.setBanco(banco);
//        tarjeta.setTipoTarjeta(Tipo_Tarjeta.DEBITO);
//        
//        TarjetaDao daoTarjeta = new TarjetaMySql();
        /*######### Insertar ########*/
//        daoTarjeta.insertar(tarjeta);
        
        /*######## Modificar ########*/
//        tarjeta.setCodTarjeta(666);
//        daoTarjeta.modificar(tarjeta);
        
        /*######## Eliminar #########*/
//        daoTarjeta.eliminar(1);

        /*########## Listar #########*/
//        ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
//        tarjetas = daoTarjeta.listarTodas();
//        for(Tarjeta tarjetaL : tarjetas){
//            System.out.println("ID: " + tarjetaL.getIdTarjeta() + " Cod Tarjeta: " + tarjetaL.getCodTarjeta());
//        }

        /*======================================================================*/
        /*=========================== PersonaJuridica ==========================*/
        /*======================================================================*/
//        PersonaJuridica persona_juridica = new PersonaJuridica("CAMBIAR",TipoEntidad.Asociación,12223,"DIRECCION","123",1,"NOMBRE","APP","APM",12345,"EMAIL",
//                                                                TipoDocumento.CARNET_EXTRANJERIA,1234);
//        PersonaJuridicaDao daopersona_juridica = new PersonaJuridicaMySql();

        /*######### Insertar ########*/
//        daopersona_juridica.insertar(persona_juridica);

        /*######## Modificar ########*/
//        persona_juridica.setDireccionLegal("CAMBIO");
//        daopersona_juridica.modificar(persona_juridica);

        /*######## Eliminar #########*/
//        daopersona_juridica.eliminar(23);

        /*########## Listar #########*/
//        ArrayList<PersonaJuridica> personas_juridicas = new ArrayList<PersonaJuridica>();
//        personas_juridicas = daopersona_juridica.listarTodas();
//        for(PersonaJuridica persona : personas_juridicas){
//            System.out.println("ID: " + persona.getId_Persona() + " Direccion: " + persona.getDireccionLegal() + "\n");
//        }

        /*======================================================================*/
        /*=============================== LineaDoc =============================*/
        /*======================================================================*/
//        ProductoPrecio producPrecio = new ProductoPrecio();
//        producPrecio.setIdProductoPrecio(71);
//        
//        Documento doc = new Documento();
//        doc.setId_documento(43);
//        
//        LineaDoc linea_doc = new LineaDoc(1,200,500,51,2,producPrecio,doc);
//        
//        LineaDocDao daoLineaDoc = new LineaDocMySql();
//
//        /*######### Insertar ########*/
//        daoLineaDoc.insertar(linea_doc);

        /*######## Modificar ########*/
//        linea_doc.setCantidad(1);
//        linea_doc.setIdLineDoc(2);
//        daoLineaDoc.modificar(linea_doc);
        
        /*######## Eliminar #########*/
//        daoLineaDoc.eliminar(2);
        
        /*########## Listar #########*/
//        ArrayList<LineaDoc> lineas = new ArrayList<LineaDoc>();
//        lineas = daoLineaDoc.listarTodos();
//        for(LineaDoc linea : lineas){
//            System.out.println("ID: " + linea.getIdLineDoc() + " Cantidad: " + linea.getCantidad());
//        }
 }
    
}
