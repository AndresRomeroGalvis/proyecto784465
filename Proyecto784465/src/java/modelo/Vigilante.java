/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "vigilante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vigilante.findAll", query = "SELECT v FROM Vigilante v"),
    @NamedQuery(name = "Vigilante.findByDocumentoV", query = "SELECT v FROM Vigilante v WHERE v.documentoV = :documentoV")})
public class Vigilante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentoV")
    private Long documentoV;
    @JoinColumn(name = "documentoV", referencedColumnName = "documentoPersona", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;
    @OneToMany(mappedBy = "documentoV")
    private List<Observaciones> observacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentoV1")
    private List<Entregaambiente> entregaambienteList;

    public Vigilante() {
    }

    public Vigilante(Long documentoV) {
        this.documentoV = documentoV;
    }

    public Long getDocumentoV() {
        return documentoV;
    }

    public void setDocumentoV(Long documentoV) {
        this.documentoV = documentoV;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @XmlTransient
    public List<Observaciones> getObservacionesList() {
        return observacionesList;
    }

    public void setObservacionesList(List<Observaciones> observacionesList) {
        this.observacionesList = observacionesList;
    }

    @XmlTransient
    public List<Entregaambiente> getEntregaambienteList() {
        return entregaambienteList;
    }

    public void setEntregaambienteList(List<Entregaambiente> entregaambienteList) {
        this.entregaambienteList = entregaambienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoV != null ? documentoV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vigilante)) {
            return false;
        }
        Vigilante other = (Vigilante) object;
        if ((this.documentoV == null && other.documentoV != null) || (this.documentoV != null && !this.documentoV.equals(other.documentoV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Vigilante[ documentoV=" + documentoV + " ]";
    }
    
}
