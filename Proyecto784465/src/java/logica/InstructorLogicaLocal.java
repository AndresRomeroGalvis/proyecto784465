/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.Local;
import modelo.Instructor;

/**
 *
 * @author USER
 */
@Local
public interface InstructorLogicaLocal {
     public Instructor consultarxDocumento(Long documento) throws Exception;
}
