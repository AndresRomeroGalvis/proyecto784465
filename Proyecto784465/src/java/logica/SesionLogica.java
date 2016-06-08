/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Persona;
import org.apache.commons.codec.digest.DigestUtils;
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
       
        
       /* String claveEncriptada = encriptarContraseña(clave);
        if(!objPersona.getContrasenaPersona().equals(claveEncriptada)){
            throw new Exception("Contraseña Incorrecta");
        }*/
        return objPersona;
    }
    
    /*public String encriptarContraseña(String password) {
        String encriptMD5 = DigestUtils.md5Hex(password);
        System.out.println("md5:" + encriptMD5);        
        return encriptMD5;
    }
*/
}
