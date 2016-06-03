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
import javax.persistence.ManyToOne;
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
 * @author ADMIN
 */
@Entity
@Table(name = "aprendiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aprendiz.findAll", query = "SELECT a FROM Aprendiz a"),
    @NamedQuery(name = "Aprendiz.findByDocumentoA", query = "SELECT a FROM Aprendiz a WHERE a.documentoA = :documentoA")})
public class Aprendiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentoA")
    private Long documentoA;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentoA")
    private List<Inasistencias> inasistenciasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentoA")
    private List<Permiso> permisoList;
    @JoinColumn(name = "documentoA", referencedColumnName = "documentoPersona", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "numFicha", referencedColumnName = "numFicha")
    @ManyToOne(optional = false)
    private Ficha numFicha;

    public Aprendiz() {
    }

    public Aprendiz(Long documentoA) {
        this.documentoA = documentoA;
    }

    public Long getDocumentoA() {
        return documentoA;
    }

    public void setDocumentoA(Long documentoA) {
        this.documentoA = documentoA;
    }

    @XmlTransient
    public List<Inasistencias> getInasistenciasList() {
        return inasistenciasList;
    }

    public void setInasistenciasList(List<Inasistencias> inasistenciasList) {
        this.inasistenciasList = inasistenciasList;
    }

    @XmlTransient
    public List<Permiso> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<Permiso> permisoList) {
        this.permisoList = permisoList;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Ficha getNumFicha() {
        return numFicha;
    }

    public void setNumFicha(Ficha numFicha) {
        this.numFicha = numFicha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoA != null ? documentoA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aprendiz)) {
            return false;
        }
        Aprendiz other = (Aprendiz) object;
        if ((this.documentoA == null && other.documentoA != null) || (this.documentoA != null && !this.documentoA.equals(other.documentoA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Aprendiz[ documentoA=" + documentoA + " ]";
    }
    
}
