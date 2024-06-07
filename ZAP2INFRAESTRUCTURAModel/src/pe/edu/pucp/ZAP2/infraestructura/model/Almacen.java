/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.model;

/**
 *
 * @author User
 */
public class Almacen {
    private int id_almacen;
    private TipoAlmacen tipoAlmacen;
    private int capacidadMaximaProductos;
    private int capacidadActualProductos;
    private boolean activo;
    private Sucursal sucursal;
    private Lote lote;

    public Almacen() {
    }

    public Almacen(int id_almacen, TipoAlmacen tipoAlmacen, int capacidadMaximaProductos, int capacidadActualProductos, boolean activo, Sucursal sucursal, Lote lote) {
        this.id_almacen = id_almacen;
        this.tipoAlmacen = tipoAlmacen;
        this.capacidadMaximaProductos = capacidadMaximaProductos;
        this.capacidadActualProductos = capacidadActualProductos;
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
    
    public void impimrir() {
        System.out.println("Almacen{" + "id_almacen=" + id_almacen + ", tipoAlmacen=" + tipoAlmacen + 
                ", capacidadMaximaProductos=" + capacidadMaximaProductos + ", capacidadActualProductos=" + 
                capacidadActualProductos + ", activo=" + activo + ", sucursal=" + sucursal.getIdSucursal + ", lote=" + lote.getIdLote() );
    }
    
    
    
}
