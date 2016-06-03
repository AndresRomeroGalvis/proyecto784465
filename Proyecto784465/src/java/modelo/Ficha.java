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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "ficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ficha.findAll", query = "SELECT f FROM Ficha f"),
    @NamedQuery(name = "Ficha.findByNumFicha", query = "SELECT f FROM Ficha f WHERE f.numFicha = :numFicha"),
    @NamedQuery(name = "Ficha.findBySede", query = "SELECT f FROM Ficha f WHERE f.sede = :sede")})
public class Ficha implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numFicha")
    private Integer numFicha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sede")
    private String sede;
    @ManyToMany(mappedBy = "fichaList")
    private List<Instructor> instructorList;
    @JoinColumn(name = "codigoPrograma", referencedColumnName = "codigoPrograma")
    @ManyToOne(optional = false)
    private Programa codigoPrograma;
    @JoinColumn(name = "documentoI", referencedColumnName = "documentoI")
    @ManyToOne(optional = false)
    private Instructor documentoI;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numFicha")
    private List<Aprendiz> aprendizList;

    public Ficha() {
    }

    public Ficha(Integer numFicha) {
        this.numFicha = numFicha;
    }

    public Ficha(Integer numFicha, String sede) {
        this.numFicha = numFicha;
        this.sede = sede;
    }

    public Integer getNumFicha() {
        return numFicha;
    }

    public void setNumFicha(Integer numFicha) {
        this.numFicha = numFicha;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    @XmlTransient
    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }

    public Programa getCodigoPrograma() {
        return codigoPrograma;
    }

    public void setCodigoPrograma(Programa codigoPrograma) {
        this.codigoPrograma = codigoPrograma;
    }

    public Instructor getDocumentoI() {
        return documentoI;
    }

    public void setDocumentoI(Instructor documentoI) {
        this.documentoI = documentoI;
    }

    @XmlTransient
    public List<Aprendiz> getAprendizList() {
        return aprendizList;
    }

    public void setAprendizList(List<Aprendiz> aprendizList) {
        this.aprendizList = aprendizList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numFicha != null ? numFicha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ficha)) {
            return false;
        }
        Ficha other = (Ficha) object;
        if ((this.numFicha == null && other.numFicha != null) || (this.numFicha != null && !this.numFicha.equals(other.numFicha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ficha[ numFicha=" + numFicha + " ]";
    }
    
}
