/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.Local;
import modelo.Persona;

/**
 *
 * @author ADMIN
 */
@Local
public interface PersonaLogicaLocal {
    public Persona consultarxDocumento(Long documento) throws Exception;
    public void registrar(Persona persona) throws Exception;
    public void modificar(Persona persona) throws Exception;
}
