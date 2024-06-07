/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.model;

import java.util.Date;

/**
 *
 * @author User
 */
public class MovimientoLote {
    private Date fechaMovimiento;
    private boolean estado;
    private TipoDeMotivoMovimientoAlmacen motivo;
    private boolean movimientoEntrada;
    private double cantidadProductosMovidos;
    private Lote lote;

    public MovimientoLote() {
    }

    public MovimientoLote(Date fechaMovimiento, boolean estado, TipoDeMotivoMovimientoAlmacen motivo, boolean movimientoEntrada, double cantidadProductosMovidos, Lote lote) {
        this.fechaMovimiento = fechaMovimiento;
        this.estado = estado;
        this.motivo = motivo;
        this.movimientoEntrada = movimientoEntrada;
        this.cantidadProductosMovidos = cantidadProductosMovidos;
        this.lote = lote;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public boolean isEstado() {
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

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public void imprimir() {
        System.out.println("MovimientoLote{" + "fechaMovimiento=" + fechaMovimiento + ", estado=" + estado + ", motivo=" + 
                motivo + ", movimientoEntrada=" + movimientoEntrada + ", cantidadProductosMovidos=" + 
                cantidadProductosMovidos + ", lote=" + lote.getIdLote());
    }

}
