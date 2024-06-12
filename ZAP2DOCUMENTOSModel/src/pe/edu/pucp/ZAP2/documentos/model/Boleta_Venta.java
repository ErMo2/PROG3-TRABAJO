/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.model;
/**
 *
 * @author Alejandro
 */
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.ZAP2.infraestructura.model.Cliente;
import pe.edu.pucp.ZAP2.infraestructura.model.Empleado;
import pe.edu.pucp.ZAP2.personas.model.Persona;
public class Boleta_Venta extends Documento_de_Venta{
    private int numSerie;
    private String detalles;
    private double impuestos;
    private Cliente cliente;

    public Boleta_Venta() {
    }

    public Boleta_Venta(int numSerie, String detalles, double impuestos, Cliente cliente, int id_doc_venta, double montoTotal, 
            Tarjeta tarjeta, Empleado empleado, int id_documento, Date fecha_emision, double total, Moneda moneda, ArrayList<LineaDoc> lineasDocVenta) {
        super(id_doc_venta, montoTotal, tarjeta, empleado, id_documento, fecha_emision, total, moneda, lineasDocVenta);
        this.numSerie = numSerie;
        this.detalles = detalles;
        this.impuestos = impuestos;
        this.cliente = cliente;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Boleta_Venta{" + "numSerie=" + numSerie + ", detalles=" 
                + detalles + ", impuestos=" + impuestos + ", persona=" + 
                cliente.getId_Persona() + '}');
    }
    
}
