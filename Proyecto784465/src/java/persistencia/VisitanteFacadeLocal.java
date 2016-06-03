/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Visitante;

/**
 *
 * @author ADMIN
 */
@Local
public interface VisitanteFacadeLocal {

    void create(Visitante visitante);

    void edit(Visitante visitante);

    void remove(Visitante visitante);

    Visitante find(Object id);

    List<Visitante> findAll();

    List<Visitante> findRange(int[] range);

    int count();
    
}
