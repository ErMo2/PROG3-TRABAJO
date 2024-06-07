/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Alejandro
 */
public class Documento {
    private int id_documento;
    private Date fecha_emision;
    private double total;
    private Moneda moneda;
    private ArrayList<LineaDocVenta> lineasDocVenta;

    public Documento() {
    }

    public Documento(int id_documento, Date fecha_emision, double total, Moneda moneda, ArrayList<LineaDocVenta> lineasDocVenta) {
        this.id_documento = id_documento;
        this.fecha_emision = fecha_emision;
        this.total = total;
        this.moneda = moneda;
        this.lineasDocVenta = lineasDocVenta;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public ArrayList<LineaDocVenta> getLineasDocVenta() {
        return lineasDocVenta;
    }

    public void setLineasDocVenta(ArrayList<LineaDocVenta> lineasDocVenta) {
        this.lineasDocVenta = lineasDocVenta;
    }

    public void imprimir() {
        System.out.println("Documento{" + "id_documento=" + id_documento + 
                ", fecha_emision=" + fecha_emision + ", total=" + total + 
                ", moneda=" + moneda.getNombre() +'}');
        
    }
    
}
