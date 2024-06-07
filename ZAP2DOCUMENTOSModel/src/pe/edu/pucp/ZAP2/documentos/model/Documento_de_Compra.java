/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Alejandro
 */
public class Documento_de_Compra extends Documento{
    private int id_doc_compra;
    private Pedido pedido;

    public Documento_de_Compra() {
    }

    public Documento_de_Compra(int id_doc_compra, Pedido pedido) {
        this.id_doc_compra = id_doc_compra;
        this.pedido = pedido;
    }

    public Documento_de_Compra(int id_doc_compra, Pedido pedido, int id_documento, Date fecha_emision, double total, Moneda moneda, ArrayList<LineaDocVenta> lineasDocVenta) {
        super(id_documento, fecha_emision, total, moneda, lineasDocVenta);
        this.id_doc_compra = id_doc_compra;
        this.pedido = pedido;
    }

    public int getId_doc_compra() {
        return id_doc_compra;
    }

    public void setId_doc_compra(int id_doc_compra) {
        this.id_doc_compra = id_doc_compra;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void imprimir() {
        System.out.println("Documento_de_Compra{" + "id_doc_compra=" + 
                id_doc_compra + ", pedido=" + pedido + '}');
    }
    
}
