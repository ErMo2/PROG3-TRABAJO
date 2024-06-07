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
public class Electrodomesticos extends Producto{
    private String modelo;
    private Date tiempoGarantia;
    private boolean tieneGarantia;

    public Electrodomesticos() {
    }

    public Electrodomesticos(String modelo, Date tiempoGarantia, boolean tieneGarantia) {
        this.modelo = modelo;
        this.tiempoGarantia = tiempoGarantia;
        this.tieneGarantia = tieneGarantia;
    }

    public Electrodomesticos(String modelo, Date tiempoGarantia, boolean tieneGarantia, int idProducto, String nombre, String descripcion, byte[] imagen, int activo, ProductoPrecio prodPrecio) {
        super(idProducto, nombre, descripcion, imagen, activo, prodPrecio);
        this.modelo = modelo;
        this.tiempoGarantia = tiempoGarantia;
        this.tieneGarantia = tieneGarantia;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getTiempoGarantia() {
        return tiempoGarantia;
    }

    public void setTiempoGarantia(Date tiempoGarantia) {
        this.tiempoGarantia = tiempoGarantia;
    }

    public boolean getTieneGarantia() {
        return tieneGarantia;
    }

    public void setTieneGarantia(boolean tieneGarantia) {
        this.tieneGarantia = tieneGarantia;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Electrodomesticos{" + "modelo=" + modelo + ", tiempoGarantia=" + 
                tiempoGarantia + ", tieneGarantia=" + tieneGarantia);
    }
    
    
}
