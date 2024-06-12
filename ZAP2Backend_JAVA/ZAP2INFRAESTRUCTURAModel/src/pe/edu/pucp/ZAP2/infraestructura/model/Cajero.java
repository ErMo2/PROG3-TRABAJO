/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.model;

import java.util.Date;
import pe.edu.pucp.ZAP2.personas.model.TipoDocumento;

/**
 *
 * @author Alejandro
 */
public class Cajero extends Empleado{
    private int numeroCaja;
    private double cantidadCaja;
    private Supervisor supervisor;

    public Cajero() {
    }

    public Cajero(int numeroCaja, double cantidadCaja, Supervisor supervisor) {
        this.numeroCaja = numeroCaja;
        this.cantidadCaja = cantidadCaja;
        this.supervisor = supervisor;
    }

    public Cajero(int numeroCaja, double cantidadCaja, Supervisor supervisor, int idEmpleado, double salario, Date fechaContratacion, TipoContrato tipoContrato, TurnosHorario horario, Area area) {
        super(idEmpleado, salario, fechaContratacion, tipoContrato, horario, area);
        this.numeroCaja = numeroCaja;
        this.cantidadCaja = cantidadCaja;
        this.supervisor = supervisor;
    }

    public Cajero(int numeroCaja, double cantidadCaja, Supervisor supervisor, int idEmpleado, double salario, Date fechaContratacion, TipoContrato tipoContrato, TurnosHorario horario, Area area, char sexo, String direccion, CuentaUsuario cuenta_usuario) {
        super(idEmpleado, salario, fechaContratacion, tipoContrato, horario, area, sexo, direccion, cuenta_usuario);
        this.numeroCaja = numeroCaja;
        this.cantidadCaja = cantidadCaja;
        this.supervisor = supervisor;
    }

    public Cajero(int numeroCaja, double cantidadCaja, Supervisor supervisor, int idEmpleado, double salario, Date fechaContratacion, TipoContrato tipoContrato, TurnosHorario horario, Area area, char sexo, String direccion, CuentaUsuario cuenta_usuario, int id_Persona, String nombre, String apellido_paterno, String apellido_materno, int telefono, String email, TipoDocumento tipo_documento, int nro_documento) {
        super(idEmpleado, salario, fechaContratacion, tipoContrato, horario, area, sexo, direccion, cuenta_usuario, id_Persona, nombre, apellido_paterno, apellido_materno, telefono, email, tipo_documento, nro_documento);
        this.numeroCaja = numeroCaja;
        this.cantidadCaja = cantidadCaja;
        this.supervisor = supervisor;
    }

    
    public int getNumeroCaja() {
        return numeroCaja;
    }

    public void setNumeroCaja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    public double getCantidadCaja() {
        return cantidadCaja;
    }

    public void setCantidadCaja(double cantidadCaja) {
        this.cantidadCaja = cantidadCaja;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Cajero{" + "numeroCaja=" + numeroCaja + 
                ", cantidadCaja=" + cantidadCaja + ", supervisor=" + 
                supervisor.getId_Persona() + '}');
    }
    
}
