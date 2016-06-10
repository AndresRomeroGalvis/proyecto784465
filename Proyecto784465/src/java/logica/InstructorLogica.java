/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Instructor;
import persistencia.InstructorFacadeLocal;

/**
 *
 * @author USER
 */
@Stateless
public class InstructorLogica implements InstructorLogicaLocal {
@EJB
    private InstructorFacadeLocal instructorDAO;
    

    public Instructor consultarxDocumento(Long documentoI) throws Exception {
        if(documentoI==null){
            throw new Exception("Documento Obligatorio");
        }
        return instructorDAO.find(documentoI);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    
}
