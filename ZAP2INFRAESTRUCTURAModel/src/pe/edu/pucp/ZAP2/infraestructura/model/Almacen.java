/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.model;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Almacen {
    private int id_almacen;
    private TipoAlmacen tipoAlmacen;
    private int capacidadMaximaProductos;
    private int capacidadActualProductos;
    ArrayList<MovimientoLote> movimientosLote;
    private boolean activo;
    private Sucursal sucursal;
    private Lote lote;

    public Almacen() {
    }

    public Almacen(int id_almacen, TipoAlmacen tipoAlmacen, int capacidadMaximaProductos, int capacidadActualProductos, ArrayList<MovimientoLote> movimientosLote, boolean activo, Sucursal sucursal, Lote lote) {
        this.id_almacen = id_almacen;
        this.tipoAlmacen = tipoAlmacen;
        this.capacidadMaximaProductos = capacidadMaximaProductos;
        this.capacidadActualProductos = capacidadActualProductos;
        this.movimientosLote = movimientosLote;
        this.activo = activo;
        this.sucursal = sucursal;
        this.lote = lote;
    }

    public int getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }

    public TipoAlmacen getTipoAlmacen() {
        return tipoAlmacen;
    }

    public void setTipoAlmacen(TipoAlmacen tipoAlmacen) {
        this.tipoAlmacen = tipoAlmacen;
    }

    public int getCapacidadMaximaProductos() {
        return capacidadMaximaProductos;
    }

    public void setCapacidadMaximaProductos(int capacidadMaximaProductos) {
        this.capacidadMaximaProductos = capacidadMaximaProductos;
    }

    public int getCapacidadActualProductos() {
        return capacidadActualProductos;
    }

    public void setCapacidadActualProductos(int capacidadActualProductos) {
        this.capacidadActualProductos = capacidadActualProductos;
    }

    public ArrayList<MovimientoLote> getMovimientosLote() {
        return movimientosLote;
    }

    public void setMovimientosLote(ArrayList<MovimientoLote> movimientosLote) {
        this.movimientosLote = movimientosLote;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public void imprimir() {
        System.out.println("Almacen{" + "id_almacen=" + id_almacen + ", tipoAlmacen=" + tipoAlmacen + ", "
                + "capacidadMaximaProductos=" + capacidadMaximaProductos + ", capacidadActualProductos=" + 
                capacidadActualProductos + ", activo=" + activo + ", sucursal=" + sucursal.getId_sucursal() + ", lote=" + lote.getIdLote());
    }
    
    
    
}
