/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.model.Lote;

/**
 *
 * @author User
 */
public interface LoteDao {
    int insertar(Lote lote);
    int modificar(Lote lote);
    int eliminar(int idLote);
    ArrayList<Lote> listarTodos();
}
