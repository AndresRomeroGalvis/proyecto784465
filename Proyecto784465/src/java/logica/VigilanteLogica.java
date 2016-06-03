/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Vigilante;
import persistencia.VigilanteFacadeLocal;

/**
 *
 * @author ADMIN
 */
@Stateless
public class VigilanteLogica implements VigilanteLogicaLocal {
    @EJB
    private VigilanteFacadeLocal vigilanteDAO;
    

    @Override
    public Vigilante consultarxDocumento(Long documentoV) throws Exception {
        if(documentoV==null){
            throw new Exception("Documento Obligatorio");
        }
        return vigilanteDAO.find(documentoV);
    }
}
