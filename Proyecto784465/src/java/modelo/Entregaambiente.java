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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "entregaambiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entregaambiente.findAll", query = "SELECT e FROM Entregaambiente e"),
    @NamedQuery(name = "Entregaambiente.findByCod", query = "SELECT e FROM Entregaambiente e WHERE e.cod = :cod"),
    @NamedQuery(name = "Entregaambiente.findByFechaEntrega", query = "SELECT e FROM Entregaambiente e WHERE e.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "Entregaambiente.findByHoraEntrega", query = "SELECT e FROM Entregaambiente e WHERE e.horaEntrega = :horaEntrega")})
public class Entregaambiente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod")
    private Integer cod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEntrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaEntrega")
    @Temporal(TemporalType.TIME)
    private Date horaEntrega;
    @JoinColumn(name = "idAmbiente", referencedColumnName = "idAmbiente")
    @ManyToOne(optional = false)
    private Ambiente idAmbiente;
    @JoinColumn(name = "documentoV", referencedColumnName = "documentoV")
    @ManyToOne(optional = false)
    private Vigilante documentoV;
    @JoinColumn(name = "documentoPersona", referencedColumnName = "documentoPersona")
    @ManyToOne(optional = false)
    private Persona documentoPersona;

    public Entregaambiente() {
    }

    public Entregaambiente(Integer cod) {
        this.cod = cod;
    }

    public Entregaambiente(Integer cod, Date fechaEntrega, Date horaEntrega) {
        this.cod = cod;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(Date horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public Ambiente getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(Ambiente idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public Vigilante getDocumentoV() {
        return documentoV;
    }

    public void setDocumentoV(Vigilante documentoV) {
        this.documentoV = documentoV;
    }

    public Persona getDocumentoPersona() {
        return documentoPersona;
    }

    public void setDocumentoPersona(Persona documentoPersona) {
        this.documentoPersona = documentoPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cod != null ? cod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entregaambiente)) {
            return false;
        }
        Entregaambiente other = (Entregaambiente) object;
        if ((this.cod == null && other.cod != null) || (this.cod != null && !this.cod.equals(other.cod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Entregaambiente[ cod=" + cod + " ]";
    }
    
}
