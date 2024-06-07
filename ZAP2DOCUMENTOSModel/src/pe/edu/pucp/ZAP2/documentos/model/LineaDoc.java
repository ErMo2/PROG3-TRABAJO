/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.model;

/**
 *
 * @author Alejandro
 */
public class LineaDoc {
    private double precioUnitario;
    private double precioTotal;
    private double cantidad;
    private double subTotal;
    private ProductoPrecio producto;

    public LineaDoc() {
    }

    public LineaDoc(double precioUnitario, double precioTotal, double cantidad, double subTotal, ProductoPrecio producto) {
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.producto = producto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public ProductoPrecio getProducto() {
        return producto;
    }

    public void setProducto(ProductoPrecio producto) {
        this.producto = producto;
    }

    public void imprimir() {
        System.out.println("LineaDocVenta{" + "precioUnitario=" + precioUnitario 
                + ", precioTotal=" + precioTotal + ", cantidad=" + cantidad + 
                ", subTotal=" + subTotal + ", producto=" + producto + '}');
    }
    
}
