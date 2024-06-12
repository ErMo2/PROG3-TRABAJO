/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.documentos.model.LineaDoc;

/**
 *
 * @author Alejandro
 */
public interface LineaDocDao {
    int insertar(LineaDoc lineaDoc);
    int modificar(LineaDoc lineaDoc);
    int eliminar(int idLineaDoc);
    ArrayList<LineaDoc> listarTodos();
}
