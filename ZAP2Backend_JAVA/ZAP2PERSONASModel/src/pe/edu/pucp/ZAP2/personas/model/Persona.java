/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.personas.model;

/**
 *
 * @author Alejandro
 */
public abstract class Persona {
    private int id_Persona;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private int telefono;
    private String email;
    private TipoDocumento tipo_documento;
    private int nro_documento;
    private int activo;
    
    public Persona() {
    }

    public Persona(int id_Persona, String nombre, String apellido_paterno, String apellido_materno, int telefono, String email, TipoDocumento tipo_documento, int nro_documento) {
        this.id_Persona = id_Persona;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.telefono = telefono;
        this.email = email;
        this.tipo_documento = tipo_documento;
        this.nro_documento = nro_documento;
        this.activo = 1;
    }

    public int getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(int id_Persona) {
        this.id_Persona = id_Persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoDocumento getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(TipoDocumento tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public int getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(int nro_documento) {
        this.nro_documento = nro_documento;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    
    public void imprimir() {
        System.out.println("Persona{" + "id_Persona=" + id_Persona + ", nombre=" 
                + nombre + ", apellido_paterno=" + apellido_paterno 
                + ", apellido_materno=" + apellido_materno + ", telefono=" + 
                telefono + ", email=" + email + ", tipo_documento=" + 
                tipo_documento + ", nro_documento=" + nro_documento + '}');
    }
    
}
