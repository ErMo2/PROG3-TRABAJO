/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.model;

import pe.edu.pucp.ZAP2.infraestructura.model.ProductoPrecio;

/**
 *
 * @author Alejandro
 */
public class LineaDoc {
    private int idLineDoc;
    private double precioUnitario;
    private double precioTotal;
    private double cantidad;
    private double subTotal;
    private ProductoPrecio producto;
    private Documento documento;
    public LineaDoc() {
    }

    public LineaDoc(int idLineDoc, double precioUnitario, double precioTotal, 
            double cantidad, double subTotal, ProductoPrecio producto, 
            Documento documento) {
        this.idLineDoc = idLineDoc;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.producto = producto;
        this.documento = documento;
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

    public int getIdLineDoc() {
        return idLineDoc;
    }

    public void setIdLineDoc(int idLineDoc) {
        this.idLineDoc = idLineDoc;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public void imprimir() {
        System.out.println("LineaDocVenta{" + "precioUnitario=" + precioUnitario 
                + ", precioTotal=" + precioTotal + ", cantidad=" + cantidad + 
                ", subTotal=" + subTotal + ", producto=" + producto + '}');
    }
    
}
