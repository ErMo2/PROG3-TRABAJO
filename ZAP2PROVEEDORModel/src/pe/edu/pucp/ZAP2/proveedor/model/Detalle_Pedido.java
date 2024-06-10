/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.proveedor.model;

import pe.edu.pucp.ZAP2.infraestructura.model.Producto;

/**
 *
 * @author Alejandro
 */
public class Detalle_Pedido {
    private int id_DetallePedido;
    private double precioTotal;
    private double precioUnitario;
    private double subtotal;
    private Producto producto;
    private Pedido pedido;
    public Detalle_Pedido() {
    }

    public Detalle_Pedido(int id_DetallePedido, double precioTotal, double precioUnitario, double subtotal, Producto producto, Pedido pedido) {
        this.id_DetallePedido = id_DetallePedido;
        this.precioTotal = precioTotal;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.producto = producto;
        this.pedido = pedido;
    }

    

    public int getId_DetallePedido() {
        return id_DetallePedido;
    }

    public void setId_DetallePedido(int id_DetallePedido) {
        this.id_DetallePedido = id_DetallePedido;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void imprimir() {
        System.out.println("Detalle_Pedido{" + "id_DetallePedido=" + id_DetallePedido 
                + ", precioTotal=" + precioTotal + ", precioUnitario=" + 
                precioUnitario + ", subtotal=" + subtotal + ", producto=" + 
                producto.getIdProducto() + '}');
    }

   
    
}
