/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.model;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.ZAP2.infraestructura.model.Empleado;

/**
 *
 * @author Alejandro
 */
public class Documento_de_Venta extends Documento{
    private int id_doc_venta;
    private double montoTotal;
    private Tarjeta tarjeta;
    private Empleado empleado;

    public Documento_de_Venta() {
    }

    public Documento_de_Venta(int id_doc_venta, double montoTotal, Tarjeta tarjeta, 
            Empleado empleado) {
        this.id_doc_venta = id_doc_venta;
        this.montoTotal = montoTotal;
        this.tarjeta = tarjeta;
        this.empleado = empleado;
    }

    public Documento_de_Venta(int id_doc_venta, double montoTotal, Tarjeta tarjeta, 
            Empleado empleado, int id_documento, Date fecha_emision, double total, 
            Moneda moneda, ArrayList<LineaDoc> lineasDocVenta) {
        super(id_documento, fecha_emision, total, moneda, lineasDocVenta);
        this.id_doc_venta = id_doc_venta;
        this.montoTotal = montoTotal;
        this.tarjeta = tarjeta;
        this.empleado = empleado;
    }

    public int getId_doc_venta() {
        return id_doc_venta;
    }

    public void setId_doc_venta(int id_doc_venta) {
        this.id_doc_venta = id_doc_venta;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Documento_de_Venta{" + "id_doc_venta=" + id_doc_venta
                + ", montoTotal=" + montoTotal + ", tarjeta=" + tarjeta +
                ", empleado=" + empleado + '}');
    }
    
    
}
