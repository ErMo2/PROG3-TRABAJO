/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.model;

/**
 *
 * @author User
 */
public class Ropa extends Producto{
    private String temporada;
    private String material;
    private TipoRopa tipo;

    public Ropa() {
    }

    public Ropa(String temporada, String material, TipoRopa tipo) {
        this.temporada = temporada;
        this.material = material;
        this.tipo = tipo;
    }

    public Ropa(String temporada, String material, TipoRopa tipo, int idProducto, String nombre, String descripcion, byte[] imagen, int activo, ProductoPrecio prodPrecio) {
        super(idProducto, nombre, descripcion, imagen, activo, prodPrecio);
        this.temporada = temporada;
        this.material = material;
        this.tipo = tipo;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public TipoRopa getTipo() {
        return tipo;
    }

    public void setTipo(TipoRopa tipo) {
        this.tipo = tipo;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Ropa{" + "temporada=" + temporada + ", material=" +
                material + ", tipo=" + tipo);
    }   
    
}
