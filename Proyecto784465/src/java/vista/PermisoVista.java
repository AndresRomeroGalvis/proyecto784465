/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import logica.AprendizLogicaLocal;
import logica.PermisoLogicaLocal;
import modelo.Aprendiz;
import modelo.Empleado;
import modelo.Ficha;
import modelo.Instructor;
import modelo.Permiso;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.inputtext.InputText;

/**
 *
 * @author USER
 */
@Named(value = "permisoVista")
@Dependent
public class PermisoVista {

    private InputText txtNpermiso;
    private Calendar txtFechapermiso;
    private Calendar txtHoraInicio;
    private Calendar txtHoraFin;
    private InputText txtMotivoPermiso;
    private InputText txtTotalHoras;
    List<Aprendiz> ListaAprendices;
    private ArrayList<SelectItem> itemsFichas;
    @EJB
    private PermisoLogicaLocal permisoLogica;
    
    
    public InputText getTxtNpermiso() {
        return txtNpermiso;
    }

    public void setTxtNpermiso(InputText txtNpermiso) {
        this.txtNpermiso = txtNpermiso;
    }

    public Calendar getTxtFechapermiso() {
        return txtFechapermiso;
    }

    public void setTxtFechapermiso(Calendar txtFechapermiso) {
        this.txtFechapermiso = txtFechapermiso;
    }

    public Calendar getTxtHoraInicio() {
        return txtHoraInicio;
    }

    public void setTxtHoraInicio(Calendar txtHoraInicio) {
        this.txtHoraInicio = txtHoraInicio;
    }

    public Calendar getTxtHoraFin() {
        return txtHoraFin;
    }

    public void setTxtHoraFin(Calendar txtHoraFin) {
        this.txtHoraFin = txtHoraFin;
    }

    public InputText getTxtMotivoPermiso() {
        return txtMotivoPermiso;
    }

    public void setTxtMotivoPermiso(InputText txtMotivoPermiso) {
        this.txtMotivoPermiso = txtMotivoPermiso;
    }

    public InputText getTxtTotalHoras() {
        return txtTotalHoras;
    }

    public void setTxtTotalHoras(InputText txtTotalHoras) {
        this.txtTotalHoras = txtTotalHoras;
    }

    

    public void setListaAprendices(List<Aprendiz> ListaAprendices) {
        this.ListaAprendices = ListaAprendices;
    }
    public void action_registrar() {
        try {
            //metodo registrar
            Permiso nuevoPermiso = new Permiso();//instancia
            nuevoPermiso.setNumeroPermiso(Integer.parseInt(txtNpermiso.getValue().toString()));//adiccionar el nss del empleado a las variables de la vista hacciendo el casting
            nuevoPermiso.setFechaPermiso((Date)txtFechapermiso.getValue());
            nuevoPermiso.setHoraInicioPermiso((Date)txtHoraInicio.getValue());
            nuevoPermiso.setHoraFinPermiso((Date)txtHoraFin.getValue());
            nuevoPermiso.setMotivoPermiso(txtMotivoPermiso.getValue().toString());
           

            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", " Empleado se registro con exito"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            Logger.getLogger(PermisoVista.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public ArrayList<SelectItem> getItemsFichas() {
        Instructor instructor=(Instructor) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        List<Ficha> listaFichas = instructor.getFichaList();
        itemsFichas = new ArrayList<>();
        for (int i = 0; i < listaFichas.size(); i++) {
            itemsFichas.add(new SelectItem(listaFichas.get(i).getNumFicha(),listaFichas.get(i).getNumFicha().toString()));
        }
        return itemsFichas;
    }

    public void setItemsFichas(ArrayList<SelectItem> itemsFichas) {
        this.itemsFichas = itemsFichas;
    }
    
    
    
    
  public PermisoVista() {
    }
    
}
