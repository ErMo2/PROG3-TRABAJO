/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.model;

/**
 *
 * @author Alejandro
 */
public class Moneda {
    private String nombre;
    private String abreviacion;
    private int idMoneda;

    public Moneda() {
    }

    public Moneda(String nombre, String abreviacion, int idMoneda) {
        this.nombre = nombre;
        this.abreviacion = abreviacion;
        this.idMoneda = idMoneda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }

    public int getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(int idMoneda) {
        this.idMoneda = idMoneda;
    }

    public void imprimir() {
        System.out.println("Moneda{" + "nombre=" + nombre + ", abreviacion=" + 
                abreviacion + ", idMoneda=" + idMoneda + '}');
    }
    
}
