/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.model;
/**
 *
 * @author Alejandro
 */
import pe.edu.pucp.ZAP2.infraestructura.model.Empleado;
import pe.edu.pucp.ZAP2.personas.model.Persona;
public class Boleta_Venta extends Documento_de_Venta{
    private int numSerie;
    private String detalles;
    private double impuestos;
    private Persona persona;

    public Boleta_Venta() {
    }

    public Boleta_Venta(int numSerie, String detalles, double impuestos, 
            Persona persona, int id_doc_venta, double montoTotal, Tarjeta tarjeta, 
            Empleado empleado) {
        super(id_doc_venta, montoTotal, tarjeta, empleado);
        this.numSerie = numSerie;
        this.detalles = detalles;
        this.impuestos = impuestos;
        this.persona = persona;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Boleta_Venta{" + "numSerie=" + numSerie + ", detalles=" 
                + detalles + ", impuestos=" + impuestos + ", persona=" + 
                persona.getId_Persona() + '}');
    }
    
}
