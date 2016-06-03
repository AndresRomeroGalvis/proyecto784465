/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "inasistencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inasistencias.findAll", query = "SELECT i FROM Inasistencias i"),
    @NamedQuery(name = "Inasistencias.findByNumeroInasistencia", query = "SELECT i FROM Inasistencias i WHERE i.numeroInasistencia = :numeroInasistencia"),
    @NamedQuery(name = "Inasistencias.findByFechaInasistencia", query = "SELECT i FROM Inasistencias i WHERE i.fechaInasistencia = :fechaInasistencia"),
    @NamedQuery(name = "Inasistencias.findByHorasInasistencia", query = "SELECT i FROM Inasistencias i WHERE i.horasInasistencia = :horasInasistencia")})
public class Inasistencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroInasistencia")
    private Integer numeroInasistencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaInasistencia")
    @Temporal(TemporalType.DATE)
    private Date fechaInasistencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horasInasistencia")
    @Temporal(TemporalType.TIME)
    private Date horasInasistencia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "excusaInasistencia")
    private String excusaInasistencia;
    @JoinColumn(name = "documentoA", referencedColumnName = "documentoA")
    @ManyToOne(optional = false)
    private Aprendiz documentoA;

    public Inasistencias() {
    }

    public Inasistencias(Integer numeroInasistencia) {
        this.numeroInasistencia = numeroInasistencia;
    }

    public Inasistencias(Integer numeroInasistencia, Date fechaInasistencia, Date horasInasistencia, String excusaInasistencia) {
        this.numeroInasistencia = numeroInasistencia;
        this.fechaInasistencia = fechaInasistencia;
        this.horasInasistencia = horasInasistencia;
        this.excusaInasistencia = excusaInasistencia;
    }

    public Integer getNumeroInasistencia() {
        return numeroInasistencia;
    }

    public void setNumeroInasistencia(Integer numeroInasistencia) {
        this.numeroInasistencia = numeroInasistencia;
    }

    public Date getFechaInasistencia() {
        return fechaInasistencia;
    }

    public void setFechaInasistencia(Date fechaInasistencia) {
        this.fechaInasistencia = fechaInasistencia;
    }

    public Date getHorasInasistencia() {
        return horasInasistencia;
    }

    public void setHorasInasistencia(Date horasInasistencia) {
        this.horasInasistencia = horasInasistencia;
    }

    public String getExcusaInasistencia() {
        return excusaInasistencia;
    }

    public void setExcusaInasistencia(String excusaInasistencia) {
        this.excusaInasistencia = excusaInasistencia;
    }

    public Aprendiz getDocumentoA() {
        return documentoA;
    }

    public void setDocumentoA(Aprendiz documentoA) {
        this.documentoA = documentoA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroInasistencia != null ? numeroInasistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inasistencias)) {
            return false;
        }
        Inasistencias other = (Inasistencias) object;
        if ((this.numeroInasistencia == null && other.numeroInasistencia != null) || (this.numeroInasistencia != null && !this.numeroInasistencia.equals(other.numeroInasistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Inasistencias[ numeroInasistencia=" + numeroInasistencia + " ]";
    }
    
}
