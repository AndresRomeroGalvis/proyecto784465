/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Aprendiz;
import persistencia.AprendizFacadeLocal;

/**
 *
 * @author USER
 */
@Stateless
public class AprendizLogica implements AprendizLogicaLocal {
@EJB
     private AprendizFacadeLocal aprendizDAO;
    
      public Aprendiz consultarxDocumento(Long documentoC) throws Exception {
        if(documentoC==null){
            throw new Exception("El documento es Obligatorio");
        }
        return aprendizDAO.find(documentoC);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void modificar(Aprendiz aprendiz) throws Exception {
        Aprendiz objAprendiz = aprendizDAO.find(aprendiz.getDocumentoA());
        if(objAprendiz==null){
            throw new Exception("Usuario no existe");
        }else if(objAprendiz.equals("seleccione")){
            throw new Exception("Seleccione una ficha existente");
        }
        objAprendiz.setPersona(aprendiz.getPersona());
        objAprendiz.setNumFicha(aprendiz.getNumFicha());
        aprendizDAO.edit(objAprendiz);
    }
}
