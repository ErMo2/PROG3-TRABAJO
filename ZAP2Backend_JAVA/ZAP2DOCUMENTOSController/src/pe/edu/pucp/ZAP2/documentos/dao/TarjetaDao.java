/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.documentos.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.documentos.model.Tarjeta;

/**
 *
 * @author Alejandro
 */
public interface TarjetaDao {
    int insertar(Tarjeta tarjeta);
    int modificar(Tarjeta tarjeta);
    int eliminar(int codTarjeta);
    ArrayList<Tarjeta> listarTodas();
    Tarjeta buscar(int id);
}
