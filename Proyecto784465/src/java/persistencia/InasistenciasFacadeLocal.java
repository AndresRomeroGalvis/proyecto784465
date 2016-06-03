/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Inasistencias;

/**
 *
 * @author ADMIN
 */
@Local
public interface InasistenciasFacadeLocal {

    void create(Inasistencias inasistencias);

    void edit(Inasistencias inasistencias);

    void remove(Inasistencias inasistencias);

    Inasistencias find(Object id);

    List<Inasistencias> findAll();

    List<Inasistencias> findRange(int[] range);

    int count();
    
}
