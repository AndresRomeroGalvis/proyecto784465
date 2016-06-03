/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Entregaambiente;

/**
 *
 * @author USUARIO
 */
@Local
public interface EntregaambienteFacadeLocal {

    void create(Entregaambiente entregaambiente);

    void edit(Entregaambiente entregaambiente);

    void remove(Entregaambiente entregaambiente);

    Entregaambiente find(Object id);

    List<Entregaambiente> findAll();

    List<Entregaambiente> findRange(int[] range);

    int count();
    
}
