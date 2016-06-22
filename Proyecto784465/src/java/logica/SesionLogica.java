/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import static com.sun.faces.facelets.util.Path.context;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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
            //throw new Exception("Usuario No existe");
            FacesContext context =FacesContext.getCurrentInstance();
            ExternalContext extContext = context.getExternalContext();
            String url = "";
            url = extContext.encodeActionURL(context.getApplication().
            getViewHandler().getActionURL(context, "/vista/registrarPersona.xhtml"));
            
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
