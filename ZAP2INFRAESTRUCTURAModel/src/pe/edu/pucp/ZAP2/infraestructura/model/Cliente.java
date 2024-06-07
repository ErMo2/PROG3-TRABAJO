/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.model;

import pe.edu.pucp.ZAP2.personas.model.TipoDocumento;

/**
 *
 * @author Alejandro
 */
public class Cliente extends PersonaNatural{
    private int id_cliente;
    private String dni;
    private int puntosBonus;

    public Cliente(int id_cliente, String dni, int puntosBonus) {
        this.id_cliente = id_cliente;
        this.dni = dni;
        this.puntosBonus = puntosBonus;
    }

    public Cliente(int id_cliente, String dni, int puntosBonus, char sexo, String direccion, CuentaUsuario cuenta_usuario) {
        super(sexo, direccion, cuenta_usuario);
        this.id_cliente = id_cliente;
        this.dni = dni;
        this.puntosBonus = puntosBonus;
    }

    public Cliente(int id_cliente, String dni, int puntosBonus, char sexo, String direccion, CuentaUsuario cuenta_usuario, int id_Persona, String nombre, String apellido_paterno, String apellido_materno, int telefono, String email, TipoDocumento tipo_documento, int nro_documento) {
        super(sexo, direccion, cuenta_usuario, id_Persona, nombre, apellido_paterno, apellido_materno, telefono, email, tipo_documento, nro_documento);
        this.id_cliente = id_cliente;
        this.dni = dni;
        this.puntosBonus = puntosBonus;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getPuntosBonus() {
        return puntosBonus;
    }

    public void setPuntosBonus(int puntosBonus) {
        this.puntosBonus = puntosBonus;
    }

    @Override
    public void imprimir() {
        System.out.println("Cliente{" + "id_cliente=" + id_cliente + ", dni=" + 
                dni + ", puntosBonus=" + puntosBonus + '}');
    }

    
    
}
