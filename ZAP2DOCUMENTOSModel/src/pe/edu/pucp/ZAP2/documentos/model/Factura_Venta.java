/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.model;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.ZAP2.infraestructura.model.Empleado;
import pe.edu.pucp.ZAP2.personas.model.PersonaJuridica;

/**
 *
 * @author Alejandro
 */
public class Factura_Venta extends Documento_de_Venta{
    private int idFactura;
    private String detalles;
    private Date fechaVenc;
    private PersonaJuridica personaJuridica;

    public Factura_Venta() {
    }

    public Factura_Venta(int idFactura, String detalles, Date fechaVenc, PersonaJuridica personaJuridica) {
        this.idFactura = idFactura;
        this.detalles = detalles;
        this.fechaVenc = fechaVenc;
        this.personaJuridica = personaJuridica;
    }

    public Factura_Venta(int idFactura, String detalles, Date fechaVenc, 
            PersonaJuridica personaJuridica, int id_doc_venta, double montoTotal, 
            Tarjeta tarjeta, Empleado empleado) {
        super(id_doc_venta, montoTotal, tarjeta, empleado);
        this.idFactura = idFactura;
        this.detalles = detalles;
        this.fechaVenc = fechaVenc;
        this.personaJuridica = personaJuridica;
    }

    public Factura_Venta(int idFactura, String detalles, Date fechaVenc, 
            PersonaJuridica personaJuridica, int id_doc_venta, double montoTotal, 
            Tarjeta tarjeta, Empleado empleado, int id_documento, Date fecha_emision, 
            double total, Moneda moneda, ArrayList<LineaDoc> lineasDocVenta) {
        super(id_doc_venta, montoTotal, tarjeta, empleado, id_documento, fecha_emision, total, moneda, lineasDocVenta);
        this.idFactura = idFactura;
        this.detalles = detalles;
        this.fechaVenc = fechaVenc;
        this.personaJuridica = personaJuridica;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Date getFechaVenc() {
        return fechaVenc;
    }

    public void setFechaVenc(Date fechaVenc) {
        this.fechaVenc = fechaVenc;
    }

    public PersonaJuridica getPersonaJuridica() {
        return personaJuridica;
    }

    public void setPersonaJuridica(PersonaJuridica personaJuridica) {
        this.personaJuridica = personaJuridica;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Factura_Venta{" + "idFactura=" + idFactura + 
                ", detalles=" + detalles + ", fechaVenc=" + fechaVenc + 
                ", personaJuridica=" + personaJuridica + '}');
    }
    

    
}
