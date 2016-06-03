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
import javax.persistence.Lob;
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
@Table(name = "ambiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ambiente.findAll", query = "SELECT a FROM Ambiente a"),
    @NamedQuery(name = "Ambiente.findByIdAmbiente", query = "SELECT a FROM Ambiente a WHERE a.idAmbiente = :idAmbiente"),
    @NamedQuery(name = "Ambiente.findByNombreAmbiente", query = "SELECT a FROM Ambiente a WHERE a.nombreAmbiente = :nombreAmbiente"),
    @NamedQuery(name = "Ambiente.findByAreaAmbiente", query = "SELECT a FROM Ambiente a WHERE a.areaAmbiente = :areaAmbiente")})
public class Ambiente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAmbiente")
    private Integer idAmbiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombreAmbiente")
    private String nombreAmbiente;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcionAmbiente")
    private String descripcionAmbiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "areaAmbiente")
    private String areaAmbiente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAmbiente")
    private List<Entregaambiente> entregaambienteList;

    public Ambiente() {
    }

    public Ambiente(Integer idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public Ambiente(Integer idAmbiente, String nombreAmbiente, String descripcionAmbiente, String areaAmbiente) {
        this.idAmbiente = idAmbiente;
        this.nombreAmbiente = nombreAmbiente;
        this.descripcionAmbiente = descripcionAmbiente;
        this.areaAmbiente = areaAmbiente;
    }

    public Integer getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(Integer idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public String getNombreAmbiente() {
        return nombreAmbiente;
    }

    public void setNombreAmbiente(String nombreAmbiente) {
        this.nombreAmbiente = nombreAmbiente;
    }

    public String getDescripcionAmbiente() {
        return descripcionAmbiente;
    }

    public void setDescripcionAmbiente(String descripcionAmbiente) {
        this.descripcionAmbiente = descripcionAmbiente;
    }

    public String getAreaAmbiente() {
        return areaAmbiente;
    }

    public void setAreaAmbiente(String areaAmbiente) {
        this.areaAmbiente = areaAmbiente;
    }

    @XmlTransient
    public List<Entregaambiente> getEntregaambienteList() {
        return entregaambienteList;
    }

    public void setEntregaambienteList(List<Entregaambiente> entregaambienteList) {
        this.entregaambienteList = entregaambienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAmbiente != null ? idAmbiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ambiente)) {
            return false;
        }
        Ambiente other = (Ambiente) object;
        if ((this.idAmbiente == null && other.idAmbiente != null) || (this.idAmbiente != null && !this.idAmbiente.equals(other.idAmbiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ambiente[ idAmbiente=" + idAmbiente + " ]";
    }
    
}
