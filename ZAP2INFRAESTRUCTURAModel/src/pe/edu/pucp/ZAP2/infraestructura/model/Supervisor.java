/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.model;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.ZAP2.personas.model.TipoDocumento;

/**
 *
 * @author Alejandro
 */
public class Supervisor extends Empleado{
    private int numempleados;
    private ArrayList<Cajero> cajeros;
    private ArrayList<EmpleadoDeArea> empleadosArea;

    public Supervisor() {
    }

    public Supervisor(int numempleados, ArrayList<Cajero> cajeros, 
            ArrayList<EmpleadoDeArea> empleadosArea) {
        this.numempleados = numempleados;
        this.cajeros = cajeros;
        this.empleadosArea = empleadosArea;
    }

    public Supervisor(int numempleados, ArrayList<Cajero> cajeros, 
            ArrayList<EmpleadoDeArea> empleadosArea, int idEmpleado, 
            double salario, Date fechaContratacion, TipoContrato tipoContrato, 
            TurnosHorario horario, Area area) {
        super(idEmpleado, salario, fechaContratacion, tipoContrato, horario, area);
        this.numempleados = numempleados;
        this.cajeros = cajeros;
        this.empleadosArea = empleadosArea;
    }

    public Supervisor(int numempleados, ArrayList<Cajero> cajeros, 
            ArrayList<EmpleadoDeArea> empleadosArea, int idEmpleado, 
            double salario, Date fechaContratacion, TipoContrato tipoContrato, 
            TurnosHorario horario, Area area, char sexo, String direccion, 
            CuentaUsuario cuenta_usuario) {
        super(idEmpleado, salario, fechaContratacion, tipoContrato, horario, 
                area, sexo, direccion, cuenta_usuario);
        this.numempleados = numempleados;
        this.cajeros = cajeros;
        this.empleadosArea = empleadosArea;
    }

    public Supervisor(int numempleados, ArrayList<Cajero> cajeros, ArrayList<EmpleadoDeArea> empleadosArea, int idEmpleado, double salario, Date fechaContratacion, TipoContrato tipoContrato, TurnosHorario horario, Area area, char sexo, String direccion, CuentaUsuario cuenta_usuario, int id_Persona, String nombre, String apellido_paterno, String apellido_materno, int telefono, String email, TipoDocumento tipo_documento, int nro_documento) {
        super(idEmpleado, salario, fechaContratacion, tipoContrato, horario, area, sexo, direccion, cuenta_usuario, id_Persona, nombre, apellido_paterno, apellido_materno, telefono, email, tipo_documento, nro_documento);
        this.numempleados = numempleados;
        this.cajeros = cajeros;
        this.empleadosArea = empleadosArea;
    }

    public int getNumempleados() {
        return numempleados;
    }

    public void setNumempleados(int numempleados) {
        this.numempleados = numempleados;
    }

    public ArrayList<Cajero> getCajeros() {
        return cajeros;
    }

    public void setCajeros(ArrayList<Cajero> cajeros) {
        this.cajeros = cajeros;
    }

    public ArrayList<EmpleadoDeArea> getEmpleadosArea() {
        return empleadosArea;
    }

    public void setEmpleadosArea(ArrayList<EmpleadoDeArea> empleadosArea) {
        this.empleadosArea = empleadosArea;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Supervisor{" + "numempleados=" + numempleados + '}');
    }
    
}
