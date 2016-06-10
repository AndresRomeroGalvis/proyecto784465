/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import logica.AprendizLogica;
import logica.AprendizLogicaLocal;
import logica.FichaLogica;
import logica.FichaLogicaLocal;
import logica.PersonaLogicaLocal;
import modelo.Aprendiz;
import modelo.Ficha;
import modelo.Persona;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;

/**
 *
 * @author USUARIO
 */
@Named(value = "aprendizVista")
@RequestScoped
public class AprendizVistaActualizar {
    private InputText txtDocumento;
    private InputText txtNombre;
    private InputText txtApellidos;
    private InputText txtDireccion;
    private InputText txtEmail;
    private InputText txtLetra;
    private InputText txtContraseña;
    private CommandButton btnregistrar;
    private CommandButton btnModificar;
    private CommandButton btnlimpiar;
    private SelectOneMenu cmbFichas;
    private ArrayList<SelectItem> itemsFichas;
    List<Persona> ListaFicha;
    List<Ficha> ListaFichas;
    @EJB
    private PersonaLogicaLocal personalogica;
    
    @EJB
    private FichaLogicaLocal fichaLogica;
     @EJB
    private AprendizLogicaLocal aprendizlogica;

    public ArrayList<SelectItem> getItemsFichas() {
        try {
            ListaFichas=fichaLogica.consultar();
            itemsFichas = new ArrayList<>();
            for (int i = 0; i< ListaFichas.size(); i++) {
                itemsFichas.add(new SelectItem(ListaFichas.get(i).getNumFicha(), ListaFichas.get(i).getNumFicha().toString()));
            }
        } catch (Exception ex) {
            Logger.getLogger(AprendizVistaActualizar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemsFichas;
    }

    public void setItemsFichas(ArrayList<SelectItem> itemsFichas) {
        this.itemsFichas = itemsFichas;
    }
    
    

    public SelectOneMenu getCmbFichas() {
        return cmbFichas;
    }

    public void setCmbFichas(SelectOneMenu cmbFichas) {
        this.cmbFichas = cmbFichas;
    }
   
    

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

 
  
    public CommandButton getBtnlimpiar() {
        return btnlimpiar;
    }

    public void setBtnlimpiar(CommandButton btnlimpiar) {
        this.btnlimpiar = btnlimpiar;
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
            nuevapersona.setDocumentoPersona(Long.parseLong(txtDocumento.getValue().toString()));
            nuevapersona.setNombresPersona(txtNombre.getValue().toString());
            nuevapersona.setApellidosPersona(txtApellidos.getValue().toString());
            nuevapersona.setDireccionPersona(txtDireccion.getValue().toString());
            nuevapersona.setEmailPersona(txtEmail.getValue().toString());
            personalogica.modificar(nuevapersona);
            System.out.println("Persona");
            Aprendiz nuevoAprendiz= new Aprendiz();
            nuevoAprendiz.setPersona(nuevapersona);
            nuevoAprendiz.setDocumentoA(nuevapersona.getDocumentoPersona());
            Ficha nuevaFicha = new Ficha();
            nuevaFicha.setNumFicha(Integer.parseInt(cmbFichas.getValue().toString()));
            nuevoAprendiz.setNumFicha(nuevaFicha);
            aprendizlogica.modificar(nuevoAprendiz);
            System.out.println("Modifica");
        } catch (Exception ex) {
                  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            Logger.getLogger(AprendizVistaActualizar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    
    /**
     * Creates a new instance of AprendizVista
     */
    public AprendizVistaActualizar() {

    }

}
