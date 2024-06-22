/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.model;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Producto {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private byte[] imagen;
    private int activo;
    private ProductoPrecio prodPrecio;
    private int cantidadComprada;
    private ArrayList<ProductoPrecio> productosPrecio;
    public Producto() {
    }

    public Producto(int idProducto, String nombre, String descripcion, byte[] imagen, int activo, ProductoPrecio prodPrecio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.activo = activo;
        this.prodPrecio = prodPrecio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public ProductoPrecio getProdPrecio() {
        return prodPrecio;
    }

    public void setProdPrecio(ProductoPrecio prodPrecio) {
        this.prodPrecio = prodPrecio;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public void imprimir() {
        System.out.println("Producto{" + "idProducto=" + idProducto + ", nombre=" 
                + nombre + ", descripcion=" + descripcion + ", activo=" + activo + ", prodPrecio=" + prodPrecio );
    }

    public ArrayList<ProductoPrecio> getProductosPrecio() {
        return productosPrecio;
    }

    public void setProductosPrecio(ArrayList<ProductoPrecio> productosPrecio) {
        this.productosPrecio = productosPrecio;
    }
    
}
