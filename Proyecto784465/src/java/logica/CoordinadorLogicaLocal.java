/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.Local;
import modelo.Coordinador;

/**
 *
 * @author USER
 */
@Local
public interface CoordinadorLogicaLocal {
     public Coordinador consultarxDocumento(Long documento) throws Exception;
}
