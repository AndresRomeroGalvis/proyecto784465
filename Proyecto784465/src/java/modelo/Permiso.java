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
 * @author ADMIN
 */
@Entity
@Table(name = "permiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p"),
    @NamedQuery(name = "Permiso.findByNumeroPermiso", query = "SELECT p FROM Permiso p WHERE p.numeroPermiso = :numeroPermiso"),
    @NamedQuery(name = "Permiso.findByFechaPermiso", query = "SELECT p FROM Permiso p WHERE p.fechaPermiso = :fechaPermiso"),
    @NamedQuery(name = "Permiso.findByHoraInicioPermiso", query = "SELECT p FROM Permiso p WHERE p.horaInicioPermiso = :horaInicioPermiso"),
    @NamedQuery(name = "Permiso.findByHoraFinPermiso", query = "SELECT p FROM Permiso p WHERE p.horaFinPermiso = :horaFinPermiso"),
    @NamedQuery(name = "Permiso.findByMotivoPermiso", query = "SELECT p FROM Permiso p WHERE p.motivoPermiso = :motivoPermiso"),
    @NamedQuery(name = "Permiso.findByTotalHorasPermiso", query = "SELECT p FROM Permiso p WHERE p.totalHorasPermiso = :totalHorasPermiso")})
public class Permiso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroPermiso")
    private Integer numeroPermiso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaPermiso")
    @Temporal(TemporalType.DATE)
    private Date fechaPermiso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaInicioPermiso")
    @Temporal(TemporalType.TIME)
    private Date horaInicioPermiso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaFinPermiso")
    @Temporal(TemporalType.TIME)
    private Date horaFinPermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "motivoPermiso")
    private String motivoPermiso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalHorasPermiso")
    private int totalHorasPermiso;
    @JoinColumn(name = "documentoA", referencedColumnName = "documentoA")
    @ManyToOne(optional = false)
    private Aprendiz documentoA;
    @JoinColumn(name = "documentoI", referencedColumnName = "documentoI")
    @ManyToOne(optional = false)
    private Instructor documentoI;
    @JoinColumn(name = "documentoC", referencedColumnName = "documentoC")
    @ManyToOne(optional = false)
    private Coordinador documentoC;

    public Permiso() {
    }

    public Permiso(Integer numeroPermiso) {
        this.numeroPermiso = numeroPermiso;
    }

    public Permiso(Integer numeroPermiso, Date fechaPermiso, Date horaInicioPermiso, Date horaFinPermiso, String motivoPermiso, int totalHorasPermiso) {
        this.numeroPermiso = numeroPermiso;
        this.fechaPermiso = fechaPermiso;
        this.horaInicioPermiso = horaInicioPermiso;
        this.horaFinPermiso = horaFinPermiso;
        this.motivoPermiso = motivoPermiso;
        this.totalHorasPermiso = totalHorasPermiso;
    }

    public Integer getNumeroPermiso() {
        return numeroPermiso;
    }

    public void setNumeroPermiso(Integer numeroPermiso) {
        this.numeroPermiso = numeroPermiso;
    }

    public Date getFechaPermiso() {
        return fechaPermiso;
    }

    public void setFechaPermiso(Date fechaPermiso) {
        this.fechaPermiso = fechaPermiso;
    }

    public Date getHoraInicioPermiso() {
        return horaInicioPermiso;
    }

    public void setHoraInicioPermiso(Date horaInicioPermiso) {
        this.horaInicioPermiso = horaInicioPermiso;
    }

    public Date getHoraFinPermiso() {
        return horaFinPermiso;
    }

    public void setHoraFinPermiso(Date horaFinPermiso) {
        this.horaFinPermiso = horaFinPermiso;
    }

    public String getMotivoPermiso() {
        return motivoPermiso;
    }

    public void setMotivoPermiso(String motivoPermiso) {
        this.motivoPermiso = motivoPermiso;
    }

    public int getTotalHorasPermiso() {
        return totalHorasPermiso;
    }

    public void setTotalHorasPermiso(int totalHorasPermiso) {
        this.totalHorasPermiso = totalHorasPermiso;
    }

    public Aprendiz getDocumentoA() {
        return documentoA;
    }

    public void setDocumentoA(Aprendiz documentoA) {
        this.documentoA = documentoA;
    }

    public Instructor getDocumentoI() {
        return documentoI;
    }

    public void setDocumentoI(Instructor documentoI) {
        this.documentoI = documentoI;
    }

    public Coordinador getDocumentoC() {
        return documentoC;
    }

    public void setDocumentoC(Coordinador documentoC) {
        this.documentoC = documentoC;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroPermiso != null ? numeroPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.numeroPermiso == null && other.numeroPermiso != null) || (this.numeroPermiso != null && !this.numeroPermiso.equals(other.numeroPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Permiso[ numeroPermiso=" + numeroPermiso + " ]";
    }
    
}
