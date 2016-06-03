/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Observaciones;

/**
 *
 * @author ADMIN
 */
@Local
public interface ObservacionesFacadeLocal {

    void create(Observaciones observaciones);

    void edit(Observaciones observaciones);

    void remove(Observaciones observaciones);

    Observaciones find(Object id);

    List<Observaciones> findAll();

    List<Observaciones> findRange(int[] range);

    int count();
    
}
