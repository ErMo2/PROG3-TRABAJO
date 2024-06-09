/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pe.edu.pucp.ZAP2.program.main;

import pe.edu.pucp.ZAP2.infraestructura.dao.AlmacenDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.AreaDao;
import pe.edu.pucp.ZAP2.infraestructura.dao.SucursalDao;
import pe.edu.pucp.ZAP2.infraestructura.model.Almacen;
import pe.edu.pucp.ZAP2.infraestructura.model.Area;
import pe.edu.pucp.ZAP2.infraestructura.model.Lote;
import pe.edu.pucp.ZAP2.infraestructura.model.Sucursal;
import pe.edu.pucp.ZAP2.infraestructura.model.TipoAlmacen;
import pe.edu.pucp.ZAP2.infraestructura.mysql.AlmacenMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.AreaMySql;
import pe.edu.pucp.ZAP2.infraestructura.mysql.SucursalMySql;

/**
 *
 * @author Alejandro
 */
public class Principal {
    //AREA
    public static void main(String[] args) {
<<<<<<< Updated upstream
        SucursalDao daoSucursal = new SucursalMySql();
        Sucursal sucursal = new Sucursal(1, "Av. Pepito Valle",
                1300.4, "Pepe's shop",
                null, null, null);
        daoSucursal.insertar(sucursal);
        
        AreaDao daoArea = new AreaMySql();
        Area area = new Area(1, "Zona de alimentos",sucursal, null);
        daoArea.insertar(area);
        
        Lote lote = new Lote();
        
        AlmacenDao daoAlmacen = new AlmacenMySql();
        Almacen almacen = new Almacen(0,TipoAlmacen.ALMACENCOMUN,500.0,0.0,null,true,sucursal,lote);
        daoAlmacen.insertar(almacen);
        
        
=======
//        SucursalDao daoSucursal = new SucursalMySql();
//        Sucursal sucursal = new Sucursal(1, "Av. Pepito Valle",
//                1300.4, "Pepe's shop",
//                null, null, null);
//        daoSucursal.insertar(sucursal);
//        
//        AreaDao daoArea = new AreaMySql();
//        Area area = new Area(1, "Zona de alimentos",sucursal, null);
//        daoArea.insertar(area);
>>>>>>> Stashed changes
    }
    
}
