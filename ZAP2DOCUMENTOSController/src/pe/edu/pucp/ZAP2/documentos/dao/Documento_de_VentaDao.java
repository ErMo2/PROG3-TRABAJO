/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.dao;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.ZAP2.documentos.model.Documento_de_Venta;

/**
 *
 * @author Alejandro
 */
public interface Documento_de_VentaDao {
    ArrayList<Documento_de_Venta> listarIngresos(Date fechaInicial,Date fechaFinal);
}
