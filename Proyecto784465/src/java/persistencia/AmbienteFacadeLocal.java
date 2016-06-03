/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Ambiente;

/**
 *
 * @author ADMIN
 */
@Local
public interface AmbienteFacadeLocal {

    void create(Ambiente ambiente);

    void edit(Ambiente ambiente);

    void remove(Ambiente ambiente);

    Ambiente find(Object id);

    List<Ambiente> findAll();

    List<Ambiente> findRange(int[] range);

    int count();
    
}
