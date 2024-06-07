/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.proveedor.model;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.ZAP2.infraestructura.model.Lote;

/**
 *
 * @author Alejandro
 */
public class Pedido {
    private int id_pedido;
    private double saldo;
    private Estado_Pedido estado;
    private Date fecha_Pedido;
    private double total;
    ArrayList<Detalle_Pedido> detallesPedido;
    ArrayList<Lote> lotes;
    public Pedido() {
    }

    public Pedido(int id_pedido, double saldo, Estado_Pedido estado, 
            Date fecha_Pedido, double total, 
            ArrayList<Detalle_Pedido> detallesPedido) {
        this.id_pedido = id_pedido;
        this.saldo = saldo;
        this.estado = estado;
        this.fecha_Pedido = fecha_Pedido;
        this.total = total;
        this.detallesPedido = detallesPedido;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Estado_Pedido getEstado() {
        return estado;
    }

    public void setEstado(Estado_Pedido estado) {
        this.estado = estado;
    }

    public Date getFecha_Pedido() {
        return fecha_Pedido;
    }

    public void setFecha_Pedido(Date fecha_Pedido) {
        this.fecha_Pedido = fecha_Pedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Detalle_Pedido> getDetallesPedido() {
        return detallesPedido;
    }

    public void setDetallesPedido(ArrayList<Detalle_Pedido> detallesPedido) {
        this.detallesPedido = detallesPedido;
    }

    public void imprimir() {
        System.out.println("Pedido{" + "id_pedido=" + id_pedido + ", saldo=" + 
                saldo + ", estado=" + estado + ", fecha_Pedido=" + fecha_Pedido 
                + ", total=" + total +  '}');
    }
    
}
