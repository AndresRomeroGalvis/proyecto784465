/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Aprendiz;

/**
 *
 * @author ADMIN
 */
@Local
public interface AprendizFacadeLocal {

    void create(Aprendiz aprendiz);

    void edit(Aprendiz aprendiz);

    void remove(Aprendiz aprendiz);

    Aprendiz find(Object id);

    List<Aprendiz> findAll();

    List<Aprendiz> findRange(int[] range);

    int count();
     List<Aprendiz> consultarDocumento(String nombre);//enviar nombre de departamento
}
