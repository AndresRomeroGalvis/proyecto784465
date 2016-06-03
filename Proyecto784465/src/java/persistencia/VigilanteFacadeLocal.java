/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Vigilante;

/**
 *
 * @author ADMIN
 */
@Local
public interface VigilanteFacadeLocal {

    void create(Vigilante vigilante);

    void edit(Vigilante vigilante);

    void remove(Vigilante vigilante);

    Vigilante find(Object id);

    List<Vigilante> findAll();

    List<Vigilante> findRange(int[] range);

    int count();
    
}
