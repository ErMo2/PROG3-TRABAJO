/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author User
 */
public class MovimientoLote {
    private int idMovimientoLote;
    private Date fechaMovimiento;
    private int activo;
    private TipoDeMotivoMovimientoAlmacen motivo;
    private int movimientoEntrada;
    private double cantidadProductosMovidos;
    private Almacen almacenEntrada;
    private Almacen almacenSalida;
    private Lote lote;

    public MovimientoLote() {
    }

    public MovimientoLote(int idMovimientoLote, Date fechaMovimiento, int activo, TipoDeMotivoMovimientoAlmacen motivo, int movimientoEntrada,
            double cantidadProductosMovidos, Almacen almacenEntrada, Almacen almacenSalida, Lote lote) {
        this.idMovimientoLote = idMovimientoLote;
        this.fechaMovimiento = fechaMovimiento;
        this.activo = activo;
        this.motivo = motivo;
        this.movimientoEntrada = movimientoEntrada;
        this.cantidadProductosMovidos = cantidadProductosMovidos;
        this.almacenEntrada = almacenEntrada;
        this.almacenSalida = almacenSalida;
        this.lote = lote;
    }

    public int getIdMovimientoLote() {
        return idMovimientoLote;
    }

    public void setIdMovimientoLote(int idMovimientoLote) {
        this.idMovimientoLote = idMovimientoLote;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public TipoDeMotivoMovimientoAlmacen getMotivo() {
        return motivo;
    }

    public void setMotivo(TipoDeMotivoMovimientoAlmacen motivo) {
        this.motivo = motivo;
    }

    public int getMovimientoEntrada() {
        return movimientoEntrada;
    }

    public void setMovimientoEntrada(int movimientoEntrada) {
        this.movimientoEntrada = movimientoEntrada;
    }

    public double getCantidadProductosMovidos() {
        return cantidadProductosMovidos;
    }

    public void setCantidadProductosMovidos(double cantidadProductosMovidos) {
        this.cantidadProductosMovidos = cantidadProductosMovidos;
    }

    public Almacen getAlmacenEntrada() {
        return almacenEntrada;
    }

    public void setAlmacenEntrada(Almacen almacenEntrada) {
        this.almacenEntrada = almacenEntrada;
    }

    public Almacen getAlmacenSalida() {
        return almacenSalida;
    }

    public void setAlmacenSalida(Almacen almacenSalida) {
        this.almacenSalida = almacenSalida;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public void imprimir() {
        System.out.println("MovimientoLote{" + "idMovimientoLote=" +
                idMovimientoLote + ", fechaMovimiento=" + 
                fechaMovimiento + ", activo=" + activo + ", motivo=" + motivo +
                ", movimientoEntrada=" + movimientoEntrada +
                ", cantidadProductosMovidos=" + cantidadProductosMovidos +
                ", almacenEntrada=" + almacenEntrada.getId_almacen() + ", almacenSalida=" + 
                almacenSalida.getId_almacen() + ", lote=" + lote.getIdLote() + '}');
    }

    
}
