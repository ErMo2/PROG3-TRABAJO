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
import pe.edu.pucp.ZAP2.infraestructura.dao.SucursalDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.SupervisorDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Almacen;
import pe.edu.pucp.ZAP2.infraestructura.model.Area;
import pe.edu.pucp.ZAP2.infraestructura.model.Cajero;
import pe.edu.pucp.ZAP2.infraestructura.model.Cliente;
import pe.edu.pucp.ZAP2.infraestructura.model.Lote;
import pe.edu.pucp.ZAP2.infraestructura.model.Sucursal;
import pe.edu.pucp.ZAP2.infraestructura.model.Supervisor;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoAlmacen;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoContrato;
import pe.edu.pucp.ZAP2.infraestructura.model.TurnosHorario;
import pe.edu.pucp.ZAP2.infraestructura.mysql.AlmacenMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.AreaMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.CajeroMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.ClienteMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.SucursalMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.SupervisorMySql;
import pe.edu.pucp.ZAP2.personas.model.TipoDocumento;

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
        Area area = new Area();
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
//        
        /*=================*/
        /*==== Almacen ====*/
        /*=================*/
//        Lote lote = new Lote();
//        
//        AlmacenDao daoAlmacen = new AlmacenMySql();
//        Almacen almacen = new Almacen(0,TipoAlmacen.ALMACENCOMUN,500.0,0.0,null,true,sucursal,lote);
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

        /*=============*/
        /*=== Cajero ==*/
        /*=============*/
//        Supervisor supervisor = new Supervisor();
//        supervisor.setIdEmpleado(2);
//        
//        
//        CajeroDao daoCajero = new CajeroMySql();
//        Cajero cajero = new Cajero(1, 2, supervisor, 0, 456.5, fecha_Contratacion, TipoContrato.TiempoCompleto, TurnosHorario.MAÑANA, 
//                area, 'M', "Mz C Lt9 Señor de los Milagros", null, 0, "Juan", "Vega", "Suares", 456485489, "juan.perez@example.com", TipoDocumento.DNI, 75607208);
//        daoCajero.insertar(cajero);
        
        /*=================*/
        /*=== Supervisor ==*/
        /*=================*/
//        SupervisorDao daoSupervisor = new SupervisorMySql();
//        Supervisor supervisor = new Supervisor(5,null,null, 0, 456.5, fecha_Contratacion, TipoContrato.TiempoCompleto, TurnosHorario.MAÑANA, 
//                area, 'M', "Mz C Lt9 Señor de los Milagros", null, 0, "Juan", "Vega", "Suares", 456485489, "juan.perez@example.com", 
//                TipoDocumento.DNI, 75607208);
//        daoSupervisor.insertar(supervisor);
        
    
                
                
 }
    
}
