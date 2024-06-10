/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pe.edu.pucp.ZAP2.program.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
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
import pe.edu.pucp.ZAP2.personas.model.TipoDocumento;
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
        
        /*==================*/
        /*==== Sucursal ====*/
        /*=================*/
//        SucursalDao daoSucursal = new SucursalMySql();
//        daoSucursal.insertar(sucursal);
        
        /*===============*/
        /*==== Area ====*/
        /*==============*/   
//        AreaDao daoArea = new AreaMySql();
//        daoArea.insertar(area);
        
        /*=================*/
        /*==== Almacen ====*/
        /*=================*/
//        Lote lote = new Lote();
//        Almacen almacen = new Almacen(1,TipoAlmacen.ALMACENCOMUN,500.0,0.0,null,true,sucursal,lote);
//        AlmacenDao daoAlmacen = new AlmacenMySql();
//        daoAlmacen.insertar(almacen);
//        
        /*==============*/
        /*=== Cliente ==*/
        /*==============*/

//        ClienteDao daoCliente = new ClienteMySql();
//        Cliente cliente = new Cliente(1,"12345678", 0, 'M', "su jato", null, 1, 
//                "SoyUnCliente", "Apellido1", "Apellido2", 965456534, "email@gmail.com",
//                TipoDocumento.DNI, 12432544);
//        daoCliente.insertar(cliente);

        /*=================*/
        /*=== Supervisor ==*/
        /*=================*/
//        SupervisorDao daoSupervisor = new SupervisorMySql();
//        daoSupervisor.insertar(supervisor);

        /*=============*/
        /*=== Cajero ==*/
        /*=============*/
//        CajeroDao daoCajero = new CajeroMySql();
//        Cajero cajero = new Cajero(1, 2, supervisor, 0, 456.5, fecha, TipoContrato.TiempoCompleto, TurnosHorario.MAÑANA, 
//                area, 'M', "Mz C Lt9 Señor de los Milagros", null, 0, "Juan", "Vega", "Suares", 456485489, "juan.perez@example.com", TipoDocumento.DNI, 75607208);
//        daoCajero.insertar(cajero);
        
        /*========================*/
        /*=== EmpleadoDeArea ===*/
        /*========================*/
//        EmpleadoDeAreaDao daoEmpleadoDeArea = new EmpleadoDeAreaMySql();
//        EmpleadoDeArea empDeArea = new EmpleadoDeArea(supervisor, TipoPuesto.Consultor, 0, 456.5, fecha, TipoContrato.TiempoCompleto, TurnosHorario.MAÑANA, 
//                area, 'M', "Mz C Lt9 Señor de los Milagros", null, 0, "Juan", "Vega", "Suares", 456485489, "juan.perez@example.com", 
//                TipoDocumento.DNI, 75607208);
//        daoEmpleadoDeArea.insertar(empDeArea);

        /*========================*/
        /*==== CuentaUsuario =====*/
        /*========================*/
//        CuentaUsuarioDao daoCuentaUsu = new CuentaUsuarioMySql();
//        CuentaUsuario cuentaUsu = new CuentaUsuario(0, "jorge123", "paraalo456*4", true, supervisor);
//        daoCuentaUsu.insertar(cuentaUsu);
    
        /*========================*/
        /*========= Pedido =========*/
        /*========================*/
//        PedidoDao daoPedido = new PedidoMySql();
//        daoPedido.insertar(pedido);

        /*=============================*/
        /*========= Descuento =========*/
        /*============================*/
//        DescuentoDao daoDescuento = new DescuentoMySql();
//        Descuento descuento = new Descuento(0, 0, 0, fecha, fecha, 0, prodPrecio);
//        daoDescuento.insertar(descuento);
        /*============================*/
        /*OJO: Falta probar!!!!!!!!!!!*/
        /*Alejandro le faltó implementar*/
        /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
        /*============================*/
        
        /*===================================*/
        /*========= ProductoPrecio =========*/
        /*=================================*/ 
//        ProductoPrecioDao daoProdPrecio = new ProductoPrecioMySql();
//        ProductoPrecio prodPrecio = new ProductoPrecio(1, 15.5, 1, sucursal, null, producto);
//        daoProdPrecio.insertar(prodPrecio);
        
        /*====================================*/
        /*========= ProductoPerecible =========*/
        /*====================================*/
//        ProductoPerecibleDao daoProdPerec = new ProductoPerecibleMySql();
//        ProductoPerecible prodPerecible = new ProductoPerecible(fecha, TipoProductoPerecible.CEREALES, UnidadDeMedida.UNIDAD, 
//                0, fechaStr, fechaStr, null, 0, null);
//        daoProdPerec.insertar(prodPerecible);
        
        /*===========================================================*/
        /*========= ProductosParaElCuidadoPersonalYDelHogar =========*/
        /*===========================================================*/       
//        ProductosParaElCuidadoPersonalYDelHogarDao daoProdParaCuidado = new ProductosParaElCuidadoPersonalYDelHogarMySql();
//        ProductosParaElCuidadoPersonalYDelHogar prodCuidado = new ProductosParaElCuidadoPersonalYDelHogar(UnidadDeMedida.UNIDAD, "higiene dental", 1,
//                "Colinos", "deja los dientes bien blancos", null, 1, null);
//        daoProdParaCuidado.insertar(prodCuidado);
        
        /*========================*/
        /*========= Ropa =========*/
        /*========================*/
//        RopaDao daoRopa = new RopaMySql();
//        Ropa ropa = new Ropa("invierno", "algodon", TipoRopa.CALZADO, 0, "Jeans", "skinny jeans", null, 1, null);
//        daoRopa.insertar(ropa);
        
        
        /*======================================*/
        /*========= Electrodomesticos =========*/
        /*====================================*/ 
//        ElectrodomesticosDao daoElectrodomesticos = new ElectrodomesticosMySql();
//        Electrodomesticos electrodo = new Electrodomesticos("XYZ123", fecha, true, 1, "Lavadora Super Eficiente", 
//                "Lavadora con alta eficiencia energética y múltiples programas de lavado.", null, 1, null);
//        daoElectrodomesticos.insertar(electrodo);
        

        /*========================*/
        /*========= Lote =========*/
        /*========================*/
//        Almacen almacen = new Almacen();
//        almacen.setId_almacen(1);
//        
//        LoteDao daoLote = new LoteMySql();
//        Lote lote = new Lote(1,50 , 20, almacen, producto, null, 1);
//        daoLote.insertar(lote);

        /*===================================*/
        /*========= MovimientoLote =========*/
        /*==================================*/
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
 }
    
}
