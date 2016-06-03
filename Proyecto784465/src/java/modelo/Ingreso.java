/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "ingreso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingreso.findAll", query = "SELECT i FROM Ingreso i"),
    @NamedQuery(name = "Ingreso.findByNumeroIngreso", query = "SELECT i FROM Ingreso i WHERE i.numeroIngreso = :numeroIngreso"),
    @NamedQuery(name = "Ingreso.findByFechaIngreso", query = "SELECT i FROM Ingreso i WHERE i.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Ingreso.findByHoraIngreso", query = "SELECT i FROM Ingreso i WHERE i.horaIngreso = :horaIngreso"),
    @NamedQuery(name = "Ingreso.findByFechaSalida", query = "SELECT i FROM Ingreso i WHERE i.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "Ingreso.findByHoraSalida", query = "SELECT i FROM Ingreso i WHERE i.horaSalida = :horaSalida")})
public class Ingreso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroIngreso")
    private Long numeroIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaIngreso")
    @Temporal(TemporalType.TIME)
    private Date horaIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaSalida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaSalida")
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    @JoinColumn(name = "documentoPersona", referencedColumnName = "documentoPersona")
    @ManyToOne(optional = false)
    private Persona documentoPersona;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ingreso")
    private Observaciones observaciones;

    public Ingreso() {
    }

    public Ingreso(Long numeroIngreso) {
        this.numeroIngreso = numeroIngreso;
    }

    public Ingreso(Long numeroIngreso, Date fechaIngreso, Date horaIngreso, Date fechaSalida, Date horaSalida) {
        this.numeroIngreso = numeroIngreso;
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso = horaIngreso;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
    }

    public Long getNumeroIngreso() {
        return numeroIngreso;
    }

    public void setNumeroIngreso(Long numeroIngreso) {
        this.numeroIngreso = numeroIngreso;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(Date horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Persona getDocumentoPersona() {
        return documentoPersona;
    }

    public void setDocumentoPersona(Persona documentoPersona) {
        this.documentoPersona = documentoPersona;
    }

    public Observaciones getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(Observaciones observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroIngreso != null ? numeroIngreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingreso)) {
            return false;
        }
        Ingreso other = (Ingreso) object;
        if ((this.numeroIngreso == null && other.numeroIngreso != null) || (this.numeroIngreso != null && !this.numeroIngreso.equals(other.numeroIngreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ingreso[ numeroIngreso=" + numeroIngreso + " ]";
    }
    
}
