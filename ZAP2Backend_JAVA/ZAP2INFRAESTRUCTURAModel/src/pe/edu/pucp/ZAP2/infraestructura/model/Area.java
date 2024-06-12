/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.model;

import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class Area {
    private int idArea;
    private String nombre;
    private Sucursal sucursal;
    private ArrayList<Producto> productos;

    public Area() {
    }

    public Area(int idArea, String nombre, Sucursal sucursal, ArrayList<Producto> productos) {
        this.idArea = idArea;
        this.nombre = nombre;
        this.sucursal = sucursal;
        this.productos = productos;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public void imprimir() {
        System.out.println("Area{" + "idArea=" + idArea + ", nombre=" + nombre 
                + ", sucursal=" + sucursal + ", productos=" + productos + '}');
    }
    
}
