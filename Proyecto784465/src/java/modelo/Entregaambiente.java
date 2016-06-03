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
 * @author USUARIO
 */
@Entity
@Table(name = "entregaambiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entregaambiente.findAll", query = "SELECT e FROM Entregaambiente e"),
    @NamedQuery(name = "Entregaambiente.findByCod", query = "SELECT e FROM Entregaambiente e WHERE e.cod = :cod"),
    @NamedQuery(name = "Entregaambiente.findByFechaEntrega", query = "SELECT e FROM Entregaambiente e WHERE e.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "Entregaambiente.findByHoraEntrega", query = "SELECT e FROM Entregaambiente e WHERE e.horaEntrega = :horaEntrega"),
    @NamedQuery(name = "Entregaambiente.findByDocumentoPersona", query = "SELECT e FROM Entregaambiente e WHERE e.documentoPersona = :documentoPersona")})
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentoPersona")
    private long documentoPersona;
    @JoinColumn(name = "documentoV", referencedColumnName = "documentoPersona")
    @ManyToOne(optional = false)
    private Persona documentoV;
    @JoinColumn(name = "idAmbiente", referencedColumnName = "idAmbiente")
    @ManyToOne(optional = false)
    private Ambiente idAmbiente;
    @JoinColumn(name = "documentoV", referencedColumnName = "documentoV")
    @ManyToOne(optional = false)
    private Vigilante documentoV1;

    public Entregaambiente() {
    }

    public Entregaambiente(Integer cod) {
        this.cod = cod;
    }

    public Entregaambiente(Integer cod, Date fechaEntrega, Date horaEntrega, long documentoPersona) {
        this.cod = cod;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
        this.documentoPersona = documentoPersona;
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

    public long getDocumentoPersona() {
        return documentoPersona;
    }

    public void setDocumentoPersona(long documentoPersona) {
        this.documentoPersona = documentoPersona;
    }

    public Persona getDocumentoV() {
        return documentoV;
    }

    public void setDocumentoV(Persona documentoV) {
        this.documentoV = documentoV;
    }

    public Ambiente getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(Ambiente idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public Vigilante getDocumentoV1() {
        return documentoV1;
    }

    public void setDocumentoV1(Vigilante documentoV1) {
        this.documentoV1 = documentoV1;
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
