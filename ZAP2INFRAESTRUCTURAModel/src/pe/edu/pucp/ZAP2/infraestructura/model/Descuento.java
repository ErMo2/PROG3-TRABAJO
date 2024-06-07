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
public class Descuento {
    private int idDescuento;
    double descuentoAplicado;
    private double pp;
    private Date fechaInicial;
    private Date fechaFinal;
    private int activo;
    private ProductoPrecio prodPrecio;

    public Descuento() {
    }

    public Descuento(int idDescuento, double descuentoAplicado, double pp, Date fechaInicial, Date fechaFinal, int activo, ProductoPrecio prodPrecio) {
        this.idDescuento = idDescuento;
        this.descuentoAplicado = descuentoAplicado;
        this.pp = pp;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.activo = activo;
        this.prodPrecio = prodPrecio;
    }

    public int getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(int idDescuento) {
        this.idDescuento = idDescuento;
    }

    public double getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(double descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public double getPp() {
        return pp;
    }

    public void setPp(double pp) {
        this.pp = pp;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public ProductoPrecio getProdPrecio() {
        return prodPrecio;
    }

    public void setProdPrecio(ProductoPrecio prodPrecio) {
        this.prodPrecio = prodPrecio;
    }
    
    public void imprimir() {
        System.out.println("Descuento{" + "idDescuento=" + idDescuento + ", descuentoAplicado=" + descuentoAplicado 
                + ", pp=" + pp + ", fechaInicial=" + fechaInicial + ", fechaFinal=" + fechaFinal + ", activo=" + 
                activo + ", prodPrecio=" + prodPrecio.getIdProductoPrecio());
    }

}
