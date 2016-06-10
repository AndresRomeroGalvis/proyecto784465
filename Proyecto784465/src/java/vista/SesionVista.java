/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import logica.AprendizLogicaLocal;
import logica.CoordinadorLogicaLocal;
import logica.InstructorLogica;
import logica.InstructorLogicaLocal;
import logica.SesionLogicaLocal;
import logica.VigilanteLogicaLocal;
import modelo.Aprendiz;
import modelo.Coordinador;
import modelo.Instructor;

import modelo.Persona;
import modelo.Vigilante;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

/**
 *
 * @author ADMIN
 */
@Named(value = "sesionVista")
@RequestScoped
public class SesionVista {
    private InputText txtDocumento;
    private Password txtClave;
    private CommandButton btnIngresar;
    @EJB
    private SesionLogicaLocal sesionLogica;
    
     @EJB
    private AprendizLogicaLocal aprendizLogica;
    
    @EJB
    private VigilanteLogicaLocal vigilanteLogica;
    
     @EJB
     private InstructorLogicaLocal instructorLogica;
    @EJB 
    private CoordinadorLogicaLocal coordinadorLogica;
     
    public SesionVista() {
    }

    public InputText getTxtDocumento() {
        return txtDocumento;
    }

    public void setTxtDocumento(InputText txtDocumento) {
        this.txtDocumento = txtDocumento;
    }

    public Password getTxtClave() {
        return txtClave;
    }

    public void setTxtClave(Password txtClave) {
        this.txtClave = txtClave;
    }

    public CommandButton getBtnIngresar() {
        return btnIngresar;
    }

    public void setBtnIngresar(CommandButton btnIngresar) {
        this.btnIngresar = btnIngresar;
    }
    
    public void actionIngresar(){
        try{
            Long documento = Long.parseLong(txtDocumento.getValue().toString());
            String clave = txtClave.getValue().toString();
            Persona objPersona = sesionLogica.iniciarSesion(documento, clave);
            char tipoUsuario = objPersona.getLetraTU().getLetraTU().charAt(0);
            FacesContext context =FacesContext.getCurrentInstance();
            ExternalContext extContext = context.getExternalContext();
            String url = "";
            switch(tipoUsuario){
                case 'V':
                    url = extContext.encodeActionURL(context.getApplication().
                    getViewHandler().getActionURL(context, "/vigilante/indexVigilante.xhtml"));
                    Vigilante objVigilante = vigilanteLogica.consultarxDocumento(documento);
                    if(objVigilante==null){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "El usuario no tiene el rol" ));
                    }else{
                        extContext.getSessionMap().put("usuario", objPersona);
                        extContext.getSessionMap().put("tipo", "V");
                        extContext.redirect(url);
                    }  
                    break;
                case 'C':
                    url = extContext.encodeActionURL(context.getApplication().
                    getViewHandler().getActionURL(context, "/coordinador/indexCoordinador.xhtml"));
                    Coordinador objCoordinador = coordinadorLogica.consultarxDocumento(documento);
                    if(objCoordinador==null){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "El usuario no tiene el rol"));
                    }else{
                        extContext.getSessionMap().put("usuario", objPersona);
                        extContext.getSessionMap().put("tipo", "C");
                        extContext.redirect(url);
                    }  
                    break;
                case 'I':
                    url = extContext.encodeActionURL(context.getApplication().
                    getViewHandler().getActionURL(context, "/instructor/daniel.xhtml"));
                    Instructor objInstructor = instructorLogica.consultarxDocumento(documento);
                    if(objInstructor==null){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "El usuario no tiene el rol"));
                    }else{
                        extContext.getSessionMap().put("usuario", objPersona);
                        extContext.getSessionMap().put("tipo", "I");
                        extContext.redirect(url);
                    }  
                    break;
                case 'A':
                    url = extContext.encodeActionURL(context.getApplication().
                    getViewHandler().getActionURL(context, "/instructor/indexInstructor.xhtml"));
                    Aprendiz objAprendiz = aprendizLogica.consultarxDocumento(documento);
                    if(objAprendiz==null){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "El usuario no tiene el rol"));
                    }else{
                        extContext.getSessionMap().put("usuario", objPersona);
                        extContext.getSessionMap().put("tipo", "A");
                        extContext.redirect(url);
                    }  
                    break;
                 default:
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "No tiene rol"));
            }
        }catch(NumberFormatException e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "El documento debe ser numérico"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
        }
    }
    
     public void cerrarSesion_action()
    {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext extContext= context.getExternalContext();
            extContext.getSessionMap().remove("usuario");
            extContext.getSessionMap().remove("tipo");
            String url=extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context,"../index.xhtml"));
            extContext.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(SesionVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
