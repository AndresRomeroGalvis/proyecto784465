/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Coordinador;
import persistencia.CoordinadorFacadeLocal;

/**
 *
 * @author USER
 */
@Stateless
public class CoordinadorLogica implements CoordinadorLogicaLocal {

    @EJB
     private CoordinadorFacadeLocal coordinadorDAO;
    
      public Coordinador consultarxDocumento(Long documentoC) throws Exception {
        if(documentoC==null){
            throw new Exception("El documento es Obligatorio");
        }
        return coordinadorDAO.find(documentoC);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
