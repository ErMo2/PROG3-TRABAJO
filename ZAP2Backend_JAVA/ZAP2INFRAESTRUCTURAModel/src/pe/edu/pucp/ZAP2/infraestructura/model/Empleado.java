/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.model;

import jakarta.xml.bind.annotation.XmlSeeAlso;
import java.util.Date;
import pe.edu.pucp.ZAP2.personas.model.TipoDocumento;

/**
 *
 * @author Alejandro
 */
@XmlSeeAlso({Cajero.class,Supervisor.class,EmpleadoDeArea.class})
public abstract class Empleado extends PersonaNatural{
    private int idEmpleado;
    private double salario;
    private Date fechaContratacion;
    private TipoContrato tipoContrato;
    private TurnosHorario horario;
    private Area area;

    public Empleado() {
    }

    public Empleado(int idEmpleado, double salario, Date fechaContratacion, TipoContrato tipoContrato, TurnosHorario horario, Area area) {
        this.idEmpleado = idEmpleado;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
        this.tipoContrato = tipoContrato;
        this.horario = horario;
        this.area = area;
    }

    public Empleado(int idEmpleado, double salario, Date fechaContratacion, TipoContrato tipoContrato, TurnosHorario horario, Area area, char sexo, String direccion, CuentaUsuario cuenta_usuario) {
        super(sexo, direccion, cuenta_usuario);
        this.idEmpleado = idEmpleado;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
        this.tipoContrato = tipoContrato;
        this.horario = horario;
        this.area = area;
    }

    public Empleado(int idEmpleado, double salario, Date fechaContratacion, TipoContrato tipoContrato, TurnosHorario horario, Area area, char sexo, String direccion, CuentaUsuario cuenta_usuario, int id_Persona, String nombre, String apellido_paterno, String apellido_materno, int telefono, String email, TipoDocumento tipo_documento, int nro_documento) {
        super(sexo, direccion, cuenta_usuario, id_Persona, nombre, apellido_paterno, apellido_materno, telefono, email, tipo_documento, nro_documento);
        this.idEmpleado = idEmpleado;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
        this.tipoContrato = tipoContrato;
        this.horario = horario;
        this.area = area;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public TurnosHorario getHorario() {
        return horario;
    }

    public void setHorario(TurnosHorario horario) {
        this.horario = horario;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Empleado{" + "idEmpleado=" + idEmpleado + ", salario=" 
                + salario + ", fechaContratacion=" + fechaContratacion +
                ", tipoContrato=" + tipoContrato + ", horario=" + horario + 
                ", area=" + area.getIdArea() + '}');
    }
    
}
