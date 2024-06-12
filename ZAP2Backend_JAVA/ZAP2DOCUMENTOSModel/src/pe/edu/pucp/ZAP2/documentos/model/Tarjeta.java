/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.model;

/**
 *
 * @author Alejandro
 */
public class Tarjeta {
    private int idTarjeta;
    private int codTarjeta;
    private Tipo_Tarjeta tipoTarjeta;
    private Banco banco;

    public Tarjeta() {
    }

    public Tarjeta(int codTarjeta, Tipo_Tarjeta tipoTarjeta, Banco banco) {
        this.codTarjeta = codTarjeta;
        this.tipoTarjeta = tipoTarjeta;
        this.banco = banco;
    }

    public int getCodTarjeta() {
        return codTarjeta;
    }

    public void setCodTarjeta(int codTarjeta) {
        this.codTarjeta = codTarjeta;
    }

    public Tipo_Tarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(Tipo_Tarjeta tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public void imprimir() {
        System.out.println("Tarjeta{"+"idTarjeta=" + idTarjeta + "codTarjeta=" + 
                codTarjeta +", tipoTarjeta=" + tipoTarjeta + ", banco=" + 
                banco + '}');
    }
    
}
