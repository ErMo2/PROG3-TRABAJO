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
    private boolean estado;
    private TipoDeMotivoMovimientoAlmacen motivo;
    private boolean movimientoEntrada;
    private double cantidadProductosMovidos;
    private ArrayList<Almacen> almacenes;//Como máximo solo habrá dos almacenes
    private Lote lote;

    public MovimientoLote() {
    }

    public MovimientoLote(int idMovimientoLote, Date fechaMovimiento, boolean estado, TipoDeMotivoMovimientoAlmacen motivo, boolean movimientoEntrada, double cantidadProductosMovidos, ArrayList<Almacen> almacenes, Lote lote) {
        this.idMovimientoLote = idMovimientoLote;
        this.fechaMovimiento = fechaMovimiento;
        this.estado = estado;
        this.motivo = motivo;
        this.movimientoEntrada = movimientoEntrada;
        this.cantidadProductosMovidos = cantidadProductosMovidos;
        this.almacenes = almacenes;
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

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoDeMotivoMovimientoAlmacen getMotivo() {
        return motivo;
    }

    public void setMotivo(TipoDeMotivoMovimientoAlmacen motivo) {
        this.motivo = motivo;
    }

    public boolean isMovimientoEntrada() {
        return movimientoEntrada;
    }

    public void setMovimientoEntrada(boolean movimientoEntrada) {
        this.movimientoEntrada = movimientoEntrada;
    }

    public double getCantidadProductosMovidos() {
        return cantidadProductosMovidos;
    }

    public void setCantidadProductosMovidos(double cantidadProductosMovidos) {
        this.cantidadProductosMovidos = cantidadProductosMovidos;
    }

    public ArrayList<Almacen> getAlmacenes() {
        return almacenes;
    }

    public void setAlmacenes(ArrayList<Almacen> almacenes) {
        this.almacenes = almacenes;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public void imprimir() {
        System.out.println("MovimientoLote{" + "idMovimientoLote=" + idMovimientoLote + ", fechaMovimiento=" + 
                fechaMovimiento + ", estado=" + estado + ", motivo=" + motivo + ", movimientoEntrada="
                + movimientoEntrada + ", cantidadProductosMovidos=" + cantidadProductosMovidos + ", lote=" + lote.getIdLote() );
    }
}
