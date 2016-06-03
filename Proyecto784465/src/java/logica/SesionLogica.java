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
public class SesionLogica implements SesionLogicaLocal {
    @EJB
    private PersonaFacadeLocal personaDAO;
    
    @Override
    public Persona iniciarSesion(Long documento, String clave) throws Exception {
        Persona objPersona = personaDAO.find(documento);
        if(documento==null){
            throw new Exception("El documento es Obligatorio");
        }
        if(clave==null || clave.equals("")){
            throw new Exception("La clave es Obligatoria");
        }
        if(objPersona==null){
            throw new Exception("Usuario No existe");
        }
        if(!objPersona.getContrasenaPersona().equals(clave)){
            throw new Exception("Contraseña Incorrecta");
        }
        return objPersona;
    }
}
