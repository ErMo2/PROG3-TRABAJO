/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.model.MovimientoLote;

/**
 *
 * @author User
 */
public interface MovimientoLoteDao {
    int insertar(MovimientoLote movLote);
    int modificar(MovimientoLote movLote);
    int eliminar(int idMovimientoLote);
    ArrayList<MovimientoLote> listarTodos();
    ArrayList<MovimientoLote> listarTodosDeUnLote(int id);
}
