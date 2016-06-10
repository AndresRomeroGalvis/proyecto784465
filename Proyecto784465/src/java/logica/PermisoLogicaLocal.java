/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Permiso;

/**
 *
 * @author USER
 */
@Local
public interface PermisoLogicaLocal {
    void create(Permiso permiso);

    void edit(Permiso permiso);

    void remove (Permiso permiso);

    Permiso find(Object numFicha);

    List<Permiso> findAll();

    //List<Empleado> findRange(int[] range);

}
