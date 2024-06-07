/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.model;

/**
 *
 * @author User
 */
public class ProductoPrecio {
    private int idProductoPrecio;
    private double precio;
    private int activo;
    private Sucursal sucursal;
    private Descuento descuento;
    private Producto producto;

    public ProductoPrecio() {
    }

    public ProductoPrecio(int idProductoPrecio, double precio, int activo, Sucursal sucursal, Descuento descuento, Producto producto) {
        this.idProductoPrecio = idProductoPrecio;
        this.precio = precio;
        this.activo = activo;
        this.sucursal = sucursal;
        this.descuento = descuento;
        this.producto = producto;
    }

    public int getIdProductoPrecio() {
        return idProductoPrecio;
    }

    public void setIdProductoPrecio(int idProductoPrecio) {
        this.idProductoPrecio = idProductoPrecio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void imprimir() {
        System.out.println("ProductoPrecio{" + "idProductoPrecio=" + idProductoPrecio + ", precio=" + precio + ", "
                + "activo=" + activo + ", sucursal=" + sucursal.getNombre + ", descuento=" + descuento.getIdDescuento + ", producto=" + producto.getNombre());
    }
    
}
