/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import modelo.Aprendiz;
import modelo.Persona;
import persistencia.AprendizFacadeLocal;
import persistencia.PersonaFacadeLocal;

/**
 *
 * @author USER
 */
@Stateless
public class AprendizLogica implements AprendizLogicaLocal {
@EJB
     private AprendizFacadeLocal aprendizDAO;

@EJB
private PersonaFacadeLocal personaDAO;
    
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

    @Override
    public void modificarContraseña(String claveVieja, String claveNueva) throws Exception {
        Aprendiz aprendizSesion = (Aprendiz) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        if(!aprendizSesion.getPersona().getContrasenaPersona().equals(claveVieja)){
            throw new Exception("La clave anterior no es correcta");
        }
        Persona objPersona = personaDAO.find(aprendizSesion.getDocumentoA());
        objPersona.setContrasenaPersona(claveNueva);
        personaDAO.edit(objPersona);
    }
}
