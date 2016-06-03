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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "tipousuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipousuario.findAll", query = "SELECT t FROM Tipousuario t"),
    @NamedQuery(name = "Tipousuario.findByLetraTU", query = "SELECT t FROM Tipousuario t WHERE t.letraTU = :letraTU"),
    @NamedQuery(name = "Tipousuario.findByDescripcionTU", query = "SELECT t FROM Tipousuario t WHERE t.descripcionTU = :descripcionTU")})
public class Tipousuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "letraTU")
    private String letraTU;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcionTU")
    private String descripcionTU;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "letraTU")
    private List<Persona> personaList;

    public Tipousuario() {
    }

    public Tipousuario(String letraTU) {
        this.letraTU = letraTU;
    }

    public Tipousuario(String letraTU, String descripcionTU) {
        this.letraTU = letraTU;
        this.descripcionTU = descripcionTU;
    }

    public String getLetraTU() {
        return letraTU;
    }

    public void setLetraTU(String letraTU) {
        this.letraTU = letraTU;
    }

    public String getDescripcionTU() {
        return descripcionTU;
    }

    public void setDescripcionTU(String descripcionTU) {
        this.descripcionTU = descripcionTU;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (letraTU != null ? letraTU.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipousuario)) {
            return false;
        }
        Tipousuario other = (Tipousuario) object;
        if ((this.letraTU == null && other.letraTU != null) || (this.letraTU != null && !this.letraTU.equals(other.letraTU))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tipousuario[ letraTU=" + letraTU + " ]";
    }
    
}
