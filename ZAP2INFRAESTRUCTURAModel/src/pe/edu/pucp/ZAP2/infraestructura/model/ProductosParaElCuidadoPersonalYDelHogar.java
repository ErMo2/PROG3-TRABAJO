/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.model;

/**
 *
 * @author User
 */
public class ProductosParaElCuidadoPersonalYDelHogar extends Producto{
    private UnidadDeMedida unidadMedida;
    private String tipo;

    public ProductosParaElCuidadoPersonalYDelHogar() {
    }

    public ProductosParaElCuidadoPersonalYDelHogar(UnidadDeMedida unidadMedida, String tipo) {
        this.unidadMedida = unidadMedida;
        this.tipo = tipo;
    }

    public ProductosParaElCuidadoPersonalYDelHogar(UnidadDeMedida unidadMedida, String tipo, int idProducto, String nombre, String descripcion, byte[] imagen, int activo, ProductoPrecio prodPrecio) {
        super(idProducto, nombre, descripcion, imagen, activo, prodPrecio);
        this.unidadMedida = unidadMedida;
        this.tipo = tipo;
    }

    public UnidadDeMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadDeMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("ProductorParaElCuidadoPersonalYDelHogar{" + "unidadMedida=" + 
                unidadMedida + ", tipo=" + tipo);
    }

}
