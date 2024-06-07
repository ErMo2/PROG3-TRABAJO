/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.model;

/**
 *
 * @author User
 */
public class Lote {
    private int idLote;
    private int stockInicial;
    private int stockActual;
    private Pedido pedido;
    private Almacen almacen;
    private Producto producto;
    private MovimientoLote movLote;

    public Lote() {
    }

    public Lote(int idLote, int stockInicial, int stockActual, Pedido pedido, Almacen almacen, Producto producto, MovimientoLote movLote) {
        this.idLote = idLote;
        this.stockInicial = stockInicial;
        this.stockActual = stockActual;
        this.pedido = pedido;
        this.almacen = almacen;
        this.producto = producto;
        this.movLote = movLote;
    }

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public int getStockInicial() {
        return stockInicial;
    }

    public void setStockInicial(int stockInicial) {
        this.stockInicial = stockInicial;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public MovimientoLote getMovLote() {
        return movLote;
    }

    public void setMovLote(MovimientoLote movLote) {
        this.movLote = movLote;
    }

    public void imprimir() {
        System.out.println("Lote{" + "idLote=" + idLote + ", stockInicial=" + stockInicial + ", stockActual=" + 
                stockActual + ", pedido=" + pedido.getIdPedido + ", almacen=" + almacen.getIdAlmacen + ", producto=" + producto.getNombre());
    }
    
    
}
