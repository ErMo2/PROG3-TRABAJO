/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.model;

/**
 *
 * @author Alejandro
 */
public class CuentaUsuario {
    private int idCuenta;
    private String usuario;
    private String contrasena;
    private boolean activo;
    private PersonaNatural personaNatural;

    public CuentaUsuario() {
    }

    public CuentaUsuario(int idCuenta, String usuario, String contrasena, boolean activo, PersonaNatural personaNatural) {
        this.idCuenta = idCuenta;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.activo = activo;
        this.personaNatural = personaNatural;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contraseña) {
        this.contrasena = contraseña;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public PersonaNatural getPersonaNatural() {
        return personaNatural;
    }

    public void setPersonaNatural(PersonaNatural personaNatural) {
        this.personaNatural = personaNatural;
    }

    public void imprimir() {
        System.out.println("CuentaUsuario{" + "idCuenta=" + idCuenta + 
                ", usuario=" + usuario + ", contrasena=" + contrasena + 
                ", activo=" + activo + ", personaNatural=" + personaNatural + '}');
    }
    
}
