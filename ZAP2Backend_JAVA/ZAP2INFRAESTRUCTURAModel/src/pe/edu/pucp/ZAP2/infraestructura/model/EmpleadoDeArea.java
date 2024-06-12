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
public class EmpleadoDeArea extends Empleado{
    private Supervisor supervisor;
    TipoPuesto puesto;

    public EmpleadoDeArea() {
    }

    public EmpleadoDeArea(Supervisor supervisor, TipoPuesto puesto) {
        this.supervisor = supervisor;
        this.puesto = puesto;
    }

    public EmpleadoDeArea(Supervisor supervisor, TipoPuesto puesto, int idEmpleado, double salario, Date fechaContratacion, TipoContrato tipoContrato, TurnosHorario horario, Area area) {
        super(idEmpleado, salario, fechaContratacion, tipoContrato, horario, area);
        this.supervisor = supervisor;
        this.puesto = puesto;
    }

    public EmpleadoDeArea(Supervisor supervisor, TipoPuesto puesto, int idEmpleado, double salario, Date fechaContratacion, TipoContrato tipoContrato, TurnosHorario horario, Area area, char sexo, String direccion, CuentaUsuario cuenta_usuario) {
        super(idEmpleado, salario, fechaContratacion, tipoContrato, horario, area, sexo, direccion, cuenta_usuario);
        this.supervisor = supervisor;
        this.puesto = puesto;
    }

    public EmpleadoDeArea(Supervisor supervisor, TipoPuesto puesto, int idEmpleado, double salario, Date fechaContratacion, TipoContrato tipoContrato, TurnosHorario horario, Area area, char sexo, String direccion, CuentaUsuario cuenta_usuario, int id_Persona, String nombre, String apellido_paterno, String apellido_materno, int telefono, String email, TipoDocumento tipo_documento, int nro_documento) {
        super(idEmpleado, salario, fechaContratacion, tipoContrato, horario, area, sexo, direccion, cuenta_usuario, id_Persona, nombre, apellido_paterno, apellido_materno, telefono, email, tipo_documento, nro_documento);
        this.supervisor = supervisor;
        this.puesto = puesto;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public TipoPuesto getPuesto() {
        return puesto;
    }

    public void setPuesto(TipoPuesto puesto) {
        this.puesto = puesto;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("EmpleadoDeArea{" + "supervisor=" + supervisor.getId_Persona() + 
                ", puesto=" + puesto + '}');
    }
    
}
