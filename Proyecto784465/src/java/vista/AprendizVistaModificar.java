/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import logica.AprendizLogicaLocal;
import logica.PersonaLogicaLocal;
import modelo.Persona;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

/**
 *
 * @author USUARIO
 */
@Named(value = "aprendizVistaModificar")
@RequestScoped
public class AprendizVistaModificar {

    /**
     * Creates a new instance of AprendizVistaModificar
     */
    private InputText txtDocumento;
    private InputText txtContraseña;
    private InputText txtContraseñaNueva1;
    private InputText txtValidarContraseñaNueva;
    private CommandButton btnModificarContraseña;
    private CommandButton btnlimpiar;
    @EJB
    private PersonaLogicaLocal personalogica;
    @EJB
    private AprendizLogicaLocal aprendizlogica;

    public InputText getTxtDocumento() {
        return txtDocumento;
    }

    public void setTxtDocumento(InputText txtDocumento) {
        this.txtDocumento = txtDocumento;
    }

    public InputText getTxtContraseña() {
        return txtContraseña;
    }

    public void setTxtContraseña(InputText txtContraseña) {
        this.txtContraseña = txtContraseña;
    }

    public InputText getTxtContraseñaNueva1() {
        return txtContraseñaNueva1;
    }

    public void setTxtContraseñaNueva1(InputText txtContraseñaNueva1) {
        this.txtContraseñaNueva1 = txtContraseñaNueva1;
    }

    public InputText getTxtValidarContraseñaNueva() {
        return txtValidarContraseñaNueva;
    }

    public void setTxtValidarContraseñaNueva(InputText txtValidarContraseñaNueva) {
        this.txtValidarContraseñaNueva = txtValidarContraseñaNueva;
    }

    public CommandButton getBtnModificar() {
        return btnModificarContraseña;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificarContraseña = btnModificar;
    }

    public CommandButton getBtnlimpiar() {
        return btnlimpiar;
    }

    public void setBtnlimpiar(CommandButton btnlimpiar) {
        this.btnlimpiar = btnlimpiar;
    }

    
    public void action_modificar(){//cambiar contraseña del aprendiz
        String claveNueva = txtContraseñaNueva1.getValue().toString();
        String claveRepetida = txtValidarContraseñaNueva.getValue().toString();
        String claveVieja = txtContraseña.getValue().toString();
        if(!claveNueva.equals(claveRepetida)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", " Las contraseñas no cinciden"));
        }else{
            try {
                aprendizlogica.modificarContraseña(claveVieja, claveNueva);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", " La contraseña se registro con exito"));
            } catch (Exception ex) {
                Logger.getLogger(AprendizVistaModificar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                
    }
    
    public AprendizVistaModificar() {//constructor
    }

}
