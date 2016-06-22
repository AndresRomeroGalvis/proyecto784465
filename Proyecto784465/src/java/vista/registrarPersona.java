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
import logica.PersonaLogicaLocal;
import logica.TipoUsuarioLogicaLocal;
import modelo.Persona;
import modelo.Tipousuario;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;

/**
 *
 * @author USUARIO
 */
@Named(value = "registrarPersona")
@RequestScoped
public class registrarPersona {

    /**
     * Creates a new instance of registrarPersona
     */
    private InputText txtDocumentoNuevo;
    private SelectOneMenu cmbLetraTU;
    private InputText txtValidarcontraseña;
    private ArrayList<SelectItem> itemsLetraIU;

    public InputText getTxtValidarcontraseña() {
        return txtValidarcontraseña;
    }

    public void setTxtValidarcontraseña(InputText txtValidarcontraseña) {
        this.txtValidarcontraseña = txtValidarcontraseña;
    }
    List<Tipousuario> ListaTipousuario;
    private CommandButton btnregistrarNuevo;
    @EJB
    private PersonaLogicaLocal personalogica;
    @EJB
    private TipoUsuarioLogicaLocal tipousuarioLogica;

    public registrarPersona() {
    }

    public InputText getTxtDocumentoNuevo() {
        return txtDocumentoNuevo;
    }

    public void setTxtDocumentoNuevo(InputText txtDocumentoNuevo) {
        this.txtDocumentoNuevo = txtDocumentoNuevo;
    }

    public SelectOneMenu getCmbLetraTU() {
        return cmbLetraTU;
    }

    public void setCmbLetraTU(SelectOneMenu cmbLetraTU) {
        this.cmbLetraTU = cmbLetraTU;
    }

    public ArrayList<SelectItem> getItemsLetraIU() throws Exception {
        try {
            ListaTipousuario = tipousuarioLogica.consultar();
            itemsLetraIU = new ArrayList<>();
            for (int i = 0; i < ListaTipousuario.size(); i++) {
                itemsLetraIU.add(new SelectItem(ListaTipousuario.get(i).getLetraTU(), ListaTipousuario.get(i).getLetraTU()));
            }
        } catch (Exception ex) {
            Logger.getLogger(AprendizVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemsLetraIU;
    }

    public void setItemsLetraIU(ArrayList<SelectItem> itemsLetraIU) {
        this.itemsLetraIU = itemsLetraIU;
    }

    public List<Tipousuario> getListaTipousuario() {
        return ListaTipousuario;
    }

    public void setListaTipousuario(List<Tipousuario> ListaTipousuario) {
        this.ListaTipousuario = ListaTipousuario;
    }

    public CommandButton getBtnregistrarNuevo() {
        return btnregistrarNuevo;
    }

    public void setBtnregistrarNuevo(CommandButton btnregistrarNuevo) {
        this.btnregistrarNuevo = btnregistrarNuevo;
    }

    public void action_crear() throws Exception {//registrar aprendiz 
       
       String documentoNuevo=(txtDocumentoNuevo.getValue().toString());
       String validardocumentoNuevo=(txtValidarcontraseña.getValue().toString());
       if(!documentoNuevo.equals(documentoNuevo)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", " Las cedulas no cinciden"));
        }else{
            try {
              
                 personalogica.crear(documentoNuevo, validardocumentoNuevo);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", " La edula se registro con exito"));
            } catch (Exception ex) {
                Logger.getLogger(AprendizVistaModificar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
  
 
    }
    
}

    

