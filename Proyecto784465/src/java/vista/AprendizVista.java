/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import logica.AprendizLogica;
import logica.AprendizLogicaLocal;
import logica.PersonaLogicaLocal;
import modelo.Persona;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

/**
 *
 * @author USUARIO
 */
@Named(value = "aprendizVista")
@RequestScoped
public class AprendizVista {
    private InputText txtDocumento;
    private InputText txtNombre;
    private InputText txtApellidos;
    private InputText txtDireccion;
    private InputText txtEmail;
    private InputText txtLetra;
    private InputText txtContraseña;
    private CommandButton btnregistrar;
    private CommandButton btnEliminar;
    private CommandButton btnModificar;
    private CommandButton btnlimpiar;
    List<Persona> ListaPersonas;
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

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtApellidos() {
        return txtApellidos;
    }

    public void setTxtApellidos(InputText txtApellidos) {
        this.txtApellidos = txtApellidos;
    }

    public InputText getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(InputText txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public InputText getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(InputText txtEmail) {
        this.txtEmail = txtEmail;
    }

    public InputText getTxtLetra() {
        return txtLetra;
    }

    public void setTxtLetra(InputText txtLetra) {
        this.txtLetra = txtLetra;
    }

    public InputText getTxtContraseña() {
        return txtContraseña;
    }

    public void setTxtContraseña(InputText txtContraseña) {
        this.txtContraseña = txtContraseña;
    }

    public CommandButton getBtnregistrar() {
        return btnregistrar;
    }

    public void setBtnregistrar(CommandButton btnregistrar) {
        this.btnregistrar = btnregistrar;
    }

    public CommandButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(CommandButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public CommandButton getBtnlimpiar() {
        return btnlimpiar;
    }

    public void setBtnlimpiar(CommandButton btnlimpiar) {
        this.btnlimpiar = btnlimpiar;
    }

    public List<Persona> getListaPersonas() {
        return ListaPersonas;
    }

    public void setListaPersonas(List<Persona> ListaPersonas) {
        this.ListaPersonas = ListaPersonas;
    }

    public PersonaLogicaLocal getPersonalogica() {
        return personalogica;
    }

    public void setPersonalogica(PersonaLogicaLocal personalogica) {
        this.personalogica = personalogica;
    }
    
    public void action_registrar() {//registrar aprendiz 
        try {
            Persona nuevapersona = new Persona();
            nuevapersona.setNombresPersona(txtNombre.getValue().toString());
            nuevapersona.setApellidosPersona(txtApellidos.getValue().toString());
            nuevapersona.setDireccionPersona(txtDireccion.getValue().toString());
            nuevapersona.setEmailPersona(txtEmail.getValue().toString());
            aprendizlogica.registrar(nuevapersona);
        } catch (Exception ex) {
                  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            Logger.getLogger(AprendizVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Creates a new instance of AprendizVista
     */
    public AprendizVista() {

    }

}
