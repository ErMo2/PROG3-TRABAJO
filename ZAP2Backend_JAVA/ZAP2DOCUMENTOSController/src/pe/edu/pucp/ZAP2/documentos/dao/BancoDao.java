/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.documentos.model.Banco;

/**
 *
 * @author Alejandro
 */
public interface BancoDao {
    int insertar(Banco banco);
    int modificar(Banco banco);
    int eliminar(int idBanco);
    ArrayList<Banco> listarTodos();
    Banco buscar(int id);
}
