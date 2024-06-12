/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.model;

import pe.edu.pucp.ZAP2.personas.model.Persona;
import pe.edu.pucp.ZAP2.personas.model.TipoDocumento;

/**
 *
 * @author Alejandro
 */
public class PersonaNatural extends Persona{
    private char sexo;
    private String direccion;
    private CuentaUsuario cuenta_usuario;

    public PersonaNatural() {
    }

    public PersonaNatural(char sexo, String direccion, CuentaUsuario cuenta_usuario) {
        this.sexo = sexo;
        this.direccion = direccion;
        this.cuenta_usuario = cuenta_usuario;
    }

    public PersonaNatural(char sexo, String direccion, CuentaUsuario cuenta_usuario, int id_Persona, String nombre, String apellido_paterno, String apellido_materno, int telefono, String email, TipoDocumento tipo_documento, int nro_documento) {
        super(id_Persona, nombre, apellido_paterno, apellido_materno, telefono, email, tipo_documento, nro_documento);
        this.sexo = sexo;
        this.direccion = direccion;
        this.cuenta_usuario = cuenta_usuario;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public CuentaUsuario getCuenta_usuario() {
        return cuenta_usuario;
    }

    public void setCuenta_usuario(CuentaUsuario cuenta_usuario) {
        this.cuenta_usuario = cuenta_usuario;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("PersonaNatural{" + "sexo=" + sexo + ", direccion=" 
                + direccion + ", cuenta_usuario=" + cuenta_usuario + '}');
    }
    
}
