/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.personas.model;

/**
 *
 * @author Alejandro
 */
public class PersonaJuridica extends Persona{
    private String nombreLegal;
    private TipoEntidad tipoEntidad;
    private int numIdentificadorFiscal;
    private String direccionLegal;
    private String RUC;

    public PersonaJuridica() {
    }

    public PersonaJuridica(String nombreLegal, TipoEntidad tipoEntidad, 
            int numIdentificadorFiscal, String direccionLegal, String RUC, 
            int id_Persona, String nombre, String apellido_paterno, 
            String apellido_materno, int telefono, String email, 
            TipoDocumento tipo_documento, int nro_documento) {
        super(id_Persona, nombre, apellido_paterno, apellido_materno, 
                telefono, email, tipo_documento, nro_documento);
        this.nombreLegal = nombreLegal;
        this.tipoEntidad = tipoEntidad;
        this.numIdentificadorFiscal = numIdentificadorFiscal;
        this.direccionLegal = direccionLegal;
        this.RUC = RUC;
    }

    public String getNombreLegal() {
        return nombreLegal;
    }

    public void setNombreLegal(String nombreLegal) {
        this.nombreLegal = nombreLegal;
    }

    public TipoEntidad getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(TipoEntidad tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public int getNumIdentificadorFiscal() {
        return numIdentificadorFiscal;
    }

    public void setNumIdentificadorFiscal(int numIdentificadorFiscal) {
        this.numIdentificadorFiscal = numIdentificadorFiscal;
    }

    public String getDireccionLegal() {
        return direccionLegal;
    }

    public void setDireccionLegal(String direccionLegal) {
        this.direccionLegal = direccionLegal;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("PersonaJuridica{" + "nombreLegal=" + nombreLegal + 
                ", tipoEntidad=" + tipoEntidad + ", numIdentificadorFiscal=" 
                + numIdentificadorFiscal + ", direccionLegal=" + direccionLegal 
                + ", RUC=" + RUC + '}');
    }
    
}
