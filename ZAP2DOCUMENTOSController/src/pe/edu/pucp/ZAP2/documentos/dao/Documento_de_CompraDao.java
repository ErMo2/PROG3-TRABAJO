/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.dao;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.ZAP2.documentos.model.Documento_de_Compra;

/**
 *
 * @author Alejandro
 */
public interface Documento_de_CompraDao {
    int insertar(Documento_de_Compra DocCompra);
    int modificar(Documento_de_Compra DocCompra);
    int eliminar(int idDocCompra);
    ArrayList<Documento_de_Compra> listarTodos();
    ArrayList<Documento_de_Compra> listarEgresos(Date fechaInicial,Date fechaFinal);
}
