/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.model;

/**
 *
 * @author Alejandro
 */
public class Banco {
    private int idBanco;
    private String nombre;

    public Banco() {
    }

    public Banco(int idBanco, String nombre) {
        this.idBanco = idBanco;
        this.nombre = nombre;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void imprimir() {
        System.out.println("Banco{" + "idBanco=" + idBanco + ", nombre=" + nombre + '}');
    }
    
}
