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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "coordinador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coordinador.findAll", query = "SELECT c FROM Coordinador c"),
    @NamedQuery(name = "Coordinador.findByDocumentoC", query = "SELECT c FROM Coordinador c WHERE c.documentoC = :documentoC"),
    @NamedQuery(name = "Coordinador.findByTipoCoordinador", query = "SELECT c FROM Coordinador c WHERE c.tipoCoordinador = :tipoCoordinador")})
public class Coordinador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentoC")
    private Long documentoC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipoCoordinador")
    private String tipoCoordinador;
    @JoinColumn(name = "documentoC", referencedColumnName = "documentoPersona", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentoC")
    private List<Permiso> permisoList;

    public Coordinador() {
    }

    public Coordinador(Long documentoC) {
        this.documentoC = documentoC;
    }

    public Coordinador(Long documentoC, String tipoCoordinador) {
        this.documentoC = documentoC;
        this.tipoCoordinador = tipoCoordinador;
    }

    public Long getDocumentoC() {
        return documentoC;
    }

    public void setDocumentoC(Long documentoC) {
        this.documentoC = documentoC;
    }

    public String getTipoCoordinador() {
        return tipoCoordinador;
    }

    public void setTipoCoordinador(String tipoCoordinador) {
        this.tipoCoordinador = tipoCoordinador;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @XmlTransient
    public List<Permiso> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<Permiso> permisoList) {
        this.permisoList = permisoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoC != null ? documentoC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coordinador)) {
            return false;
        }
        Coordinador other = (Coordinador) object;
        if ((this.documentoC == null && other.documentoC != null) || (this.documentoC != null && !this.documentoC.equals(other.documentoC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Coordinador[ documentoC=" + documentoC + " ]";
    }
    
}
