/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Persona;
import persistencia.PersonaFacadeLocal;

/**
 *
 * @author ADMIN
 */
@Stateless
public class PersonaLogica implements PersonaLogicaLocal {
    @EJB
    private PersonaFacadeLocal personaDAO;

    @Override
    public Persona consultarxDocumento(Long documento) throws Exception {
        if(documento==null){
            throw new Exception("El documento es Obligatorio");
        }
        return personaDAO.find(documento);
    }
}
