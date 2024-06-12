/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.ZAP2.infraestructura.dao;

import java.util.ArrayList;
import pe.edu.pucp.ZAP2.infraestructura.model.CuentaUsuario;

/**
 *
 * @author Alejandro
 */
public interface CuentaUsuarioDao {
    int insertar(CuentaUsuario Cuenta);
    int modificar(CuentaUsuario Cuenta);
    int eliminar(int Cuenta);
    ArrayList<CuentaUsuario> listarTodas();
}
