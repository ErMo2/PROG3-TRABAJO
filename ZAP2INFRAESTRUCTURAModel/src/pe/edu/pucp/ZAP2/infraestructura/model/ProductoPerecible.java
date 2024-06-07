/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.model;

import java.util.Date;

/**
 *
 * @author User
 */
public class ProductoPerecible extends Producto{
    private Date fechVencimiento;
    private TipoProductoPerecible tipo_producto_perecible;
    private UnidadDeMedida unidad_de_medida;

    public ProductoPerecible() {
    }

    public ProductoPerecible(Date fechVencimiento, TipoProductoPerecible tipo_producto_perecible, UnidadDeMedida unidad_de_medida) {
        this.fechVencimiento = fechVencimiento;
        this.tipo_producto_perecible = tipo_producto_perecible;
        this.unidad_de_medida = unidad_de_medida;
    }

    public ProductoPerecible(Date fechVencimiento, TipoProductoPerecible tipo_producto_perecible, UnidadDeMedida unidad_de_medida, int idProducto, String nombre, String descripcion, byte[] imagen, int activo, ProductoPrecio prodPrecio) {
        super(idProducto, nombre, descripcion, imagen, activo, prodPrecio);
        this.fechVencimiento = fechVencimiento;
        this.tipo_producto_perecible = tipo_producto_perecible;
        this.unidad_de_medida = unidad_de_medida;
    }

    public Date getFechVencimiento() {
        return fechVencimiento;
    }

    public void setFechVencimiento(Date fechVencimiento) {
        this.fechVencimiento = fechVencimiento;
    }

    public TipoProductoPerecible getTipo_producto_perecible() {
        return tipo_producto_perecible;
    }

    public void setTipo_producto_perecible(TipoProductoPerecible tipo_producto_perecible) {
        this.tipo_producto_perecible = tipo_producto_perecible;
    }

    public UnidadDeMedida getUnidad_de_medida() {
        return unidad_de_medida;
    }

    public void setUnidad_de_medida(UnidadDeMedida unidad_de_medida) {
        this.unidad_de_medida = unidad_de_medida;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("fechVencimiento=" + fechVencimiento + ", tipo_producto_perecible=" + 
                tipo_producto_perecible + ", unidad_de_medida=" + unidad_de_medida);
    }
    
}
