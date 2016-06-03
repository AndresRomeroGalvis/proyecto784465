/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "observaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Observaciones.findAll", query = "SELECT o FROM Observaciones o"),
    @NamedQuery(name = "Observaciones.findByNumeroObservacion", query = "SELECT o FROM Observaciones o WHERE o.numeroObservacion = :numeroObservacion"),
    @NamedQuery(name = "Observaciones.findByNumeroIngreso", query = "SELECT o FROM Observaciones o WHERE o.numeroIngreso = :numeroIngreso")})
public class Observaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroObservacion")
    private Long numeroObservacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroIngreso")
    private int numeroIngreso;
    @JoinColumn(name = "numeroObservacion", referencedColumnName = "numeroIngreso", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Ingreso ingreso;
    @JoinColumn(name = "documentoV", referencedColumnName = "documentoV")
    @ManyToOne
    private Vigilante documentoV;

    public Observaciones() {
    }

    public Observaciones(Long numeroObservacion) {
        this.numeroObservacion = numeroObservacion;
    }

    public Observaciones(Long numeroObservacion, int numeroIngreso) {
        this.numeroObservacion = numeroObservacion;
        this.numeroIngreso = numeroIngreso;
    }

    public Long getNumeroObservacion() {
        return numeroObservacion;
    }

    public void setNumeroObservacion(Long numeroObservacion) {
        this.numeroObservacion = numeroObservacion;
    }

    public int getNumeroIngreso() {
        return numeroIngreso;
    }

    public void setNumeroIngreso(int numeroIngreso) {
        this.numeroIngreso = numeroIngreso;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }

    public Vigilante getDocumentoV() {
        return documentoV;
    }

    public void setDocumentoV(Vigilante documentoV) {
        this.documentoV = documentoV;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroObservacion != null ? numeroObservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observaciones)) {
            return false;
        }
        Observaciones other = (Observaciones) object;
        if ((this.numeroObservacion == null && other.numeroObservacion != null) || (this.numeroObservacion != null && !this.numeroObservacion.equals(other.numeroObservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Observaciones[ numeroObservacion=" + numeroObservacion + " ]";
    }
    
}
