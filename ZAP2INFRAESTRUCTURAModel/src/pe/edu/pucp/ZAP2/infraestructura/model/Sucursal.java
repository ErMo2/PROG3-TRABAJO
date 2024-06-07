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
public class Sucursal {
    private int id_sucursal;
    private String direccion;
    private double tam_metros;
    private String nombre;
    private ArrayList<Area> areas;
    private ArrayList<Almacen> almacenes;
    private ArrayList<ProductoPrecio> producto;

    public Sucursal() {
    }

    public Sucursal(int id_sucursal, String direccion, double tam_metros, String nombre, ArrayList<Area> areas, ArrayList<Almacen> almacenes, ArrayList<ProductoPrecio> producto) {
        this.id_sucursal = id_sucursal;
        this.direccion = direccion;
        this.tam_metros = tam_metros;
        this.nombre = nombre;
        this.areas = areas;
        this.almacenes = almacenes;
        this.producto = producto;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getTam_metros() {
        return tam_metros;
    }

    public void setTam_metros(double tam_metros) {
        this.tam_metros = tam_metros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }

    public void setAreas(ArrayList<Area> areas) {
        this.areas = areas;
    }

    public ArrayList<Almacen> getAlmacenes() {
        return almacenes;
    }

    public void setAlmacenes(ArrayList<Almacen> almacenes) {
        this.almacenes = almacenes;
    }

    public ArrayList<ProductoPrecio> getProducto() {
        return producto;
    }

    public void setProducto(ArrayList<ProductoPrecio> producto) {
        this.producto = producto;
    }

    public void imprimir() {
        System.out.println("Sucursal{" + "id_sucursal=" + id_sucursal + 
                ", direccion=" + direccion + ", tam_metros=" + tam_metros +
                ", nombre=" + nombre + ", areas="+ '}');
    }
    
}
