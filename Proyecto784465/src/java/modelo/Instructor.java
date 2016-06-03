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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "instructor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i"),
    @NamedQuery(name = "Instructor.findByDocumentoI", query = "SELECT i FROM Instructor i WHERE i.documentoI = :documentoI"),
    @NamedQuery(name = "Instructor.findByTipoInstructor", query = "SELECT i FROM Instructor i WHERE i.tipoInstructor = :tipoInstructor")})
public class Instructor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentoI")
    private Long documentoI;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipoInstructor")
    private String tipoInstructor;
    @JoinTable(name = "pertenece", joinColumns = {
        @JoinColumn(name = "documentoI", referencedColumnName = "documentoI")}, inverseJoinColumns = {
        @JoinColumn(name = "numFicha", referencedColumnName = "numFicha")})
    @ManyToMany
    private List<Ficha> fichaList;
    @JoinColumn(name = "documentoI", referencedColumnName = "documentoPersona", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentoI")
    private List<Ficha> fichaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentoI")
    private List<Permiso> permisoList;

    public Instructor() {
    }

    public Instructor(Long documentoI) {
        this.documentoI = documentoI;
    }

    public Instructor(Long documentoI, String tipoInstructor) {
        this.documentoI = documentoI;
        this.tipoInstructor = tipoInstructor;
    }

    public Long getDocumentoI() {
        return documentoI;
    }

    public void setDocumentoI(Long documentoI) {
        this.documentoI = documentoI;
    }

    public String getTipoInstructor() {
        return tipoInstructor;
    }

    public void setTipoInstructor(String tipoInstructor) {
        this.tipoInstructor = tipoInstructor;
    }

    @XmlTransient
    public List<Ficha> getFichaList() {
        return fichaList;
    }

    public void setFichaList(List<Ficha> fichaList) {
        this.fichaList = fichaList;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @XmlTransient
    public List<Ficha> getFichaList1() {
        return fichaList1;
    }

    public void setFichaList1(List<Ficha> fichaList1) {
        this.fichaList1 = fichaList1;
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
        hash += (documentoI != null ? documentoI.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.documentoI == null && other.documentoI != null) || (this.documentoI != null && !this.documentoI.equals(other.documentoI))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Instructor[ documentoI=" + documentoI + " ]";
    }
    
}
