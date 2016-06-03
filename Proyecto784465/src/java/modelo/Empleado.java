/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByDocumentoE", query = "SELECT e FROM Empleado e WHERE e.documentoE = :documentoE"),
    @NamedQuery(name = "Empleado.findByCargoEmpleado", query = "SELECT e FROM Empleado e WHERE e.cargoEmpleado = :cargoEmpleado")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentoE")
    private Long documentoE;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cargoEmpleado")
    private String cargoEmpleado;
    @JoinColumn(name = "documentoE", referencedColumnName = "documentoPersona", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;

    public Empleado() {
    }

    public Empleado(Long documentoE) {
        this.documentoE = documentoE;
    }

    public Empleado(Long documentoE, String cargoEmpleado) {
        this.documentoE = documentoE;
        this.cargoEmpleado = cargoEmpleado;
    }

    public Long getDocumentoE() {
        return documentoE;
    }

    public void setDocumentoE(Long documentoE) {
        this.documentoE = documentoE;
    }

    public String getCargoEmpleado() {
        return cargoEmpleado;
    }

    public void setCargoEmpleado(String cargoEmpleado) {
        this.cargoEmpleado = cargoEmpleado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoE != null ? documentoE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.documentoE == null && other.documentoE != null) || (this.documentoE != null && !this.documentoE.equals(other.documentoE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Empleado[ documentoE=" + documentoE + " ]";
    }
    
}
