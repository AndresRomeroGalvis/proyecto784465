/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Instructor;

/**
 *
 * @author ADMIN
 */
@Local
public interface InstructorFacadeLocal {

    void create(Instructor instructor);

    void edit(Instructor instructor);

    void remove(Instructor instructor);

    Instructor find(Object id);

    List<Instructor> findAll();

    List<Instructor> findRange(int[] range);

    int count();
    
}
