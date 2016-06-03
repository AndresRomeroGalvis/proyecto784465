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
@Table(name = "visitante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visitante.findAll", query = "SELECT v FROM Visitante v"),
    @NamedQuery(name = "Visitante.findByDocumentoV", query = "SELECT v FROM Visitante v WHERE v.documentoV = :documentoV")})
public class Visitante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentoV")
    private Long documentoV;
    @JoinColumn(name = "documentoV", referencedColumnName = "documentoPersona", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;

    public Visitante() {
    }

    public Visitante(Long documentoV) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoV != null ? documentoV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitante)) {
            return false;
        }
        Visitante other = (Visitante) object;
        if ((this.documentoV == null && other.documentoV != null) || (this.documentoV != null && !this.documentoV.equals(other.documentoV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Visitante[ documentoV=" + documentoV + " ]";
    }
    
}
