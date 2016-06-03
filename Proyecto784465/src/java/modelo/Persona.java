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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByDocumentoPersona", query = "SELECT p FROM Persona p WHERE p.documentoPersona = :documentoPersona"),
    @NamedQuery(name = "Persona.findByNombresPersona", query = "SELECT p FROM Persona p WHERE p.nombresPersona = :nombresPersona"),
    @NamedQuery(name = "Persona.findByApellidosPersona", query = "SELECT p FROM Persona p WHERE p.apellidosPersona = :apellidosPersona"),
    @NamedQuery(name = "Persona.findByDireccionPersona", query = "SELECT p FROM Persona p WHERE p.direccionPersona = :direccionPersona"),
    @NamedQuery(name = "Persona.findByEmailPersona", query = "SELECT p FROM Persona p WHERE p.emailPersona = :emailPersona"),
    @NamedQuery(name = "Persona.findByContrasenaPersona", query = "SELECT p FROM Persona p WHERE p.contrasenaPersona = :contrasenaPersona")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentoPersona")
    private Long documentoPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombresPersona")
    private String nombresPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellidosPersona")
    private String apellidosPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "direccionPersona")
    private String direccionPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "emailPersona")
    private String emailPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contrasenaPersona")
    private String contrasenaPersona;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    private Vigilante vigilante;
    @JoinColumn(name = "letraTU", referencedColumnName = "letraTU")
    @ManyToOne(optional = false)
    private Tipousuario letraTU;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    private Coordinador coordinador;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    private Instructor instructor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    private Empleado empleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentoPersona")
    private List<Ingreso> ingresoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    private Visitante visitante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentoPersona")
    private List<Entregaambiente> entregaambienteList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    private Aprendiz aprendiz;

    public Persona() {
    }

    public Persona(Long documentoPersona) {
        this.documentoPersona = documentoPersona;
    }

    public Persona(Long documentoPersona, String nombresPersona, String apellidosPersona, String direccionPersona, String emailPersona, String contrasenaPersona) {
        this.documentoPersona = documentoPersona;
        this.nombresPersona = nombresPersona;
        this.apellidosPersona = apellidosPersona;
        this.direccionPersona = direccionPersona;
        this.emailPersona = emailPersona;
        this.contrasenaPersona = contrasenaPersona;
    }

    public Long getDocumentoPersona() {
        return documentoPersona;
    }

    public void setDocumentoPersona(Long documentoPersona) {
        this.documentoPersona = documentoPersona;
    }

    public String getNombresPersona() {
        return nombresPersona;
    }

    public void setNombresPersona(String nombresPersona) {
        this.nombresPersona = nombresPersona;
    }

    public String getApellidosPersona() {
        return apellidosPersona;
    }

    public void setApellidosPersona(String apellidosPersona) {
        this.apellidosPersona = apellidosPersona;
    }

    public String getDireccionPersona() {
        return direccionPersona;
    }

    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }

    public String getEmailPersona() {
        return emailPersona;
    }

    public void setEmailPersona(String emailPersona) {
        this.emailPersona = emailPersona;
    }

    public String getContrasenaPersona() {
        return contrasenaPersona;
    }

    public void setContrasenaPersona(String contrasenaPersona) {
        this.contrasenaPersona = contrasenaPersona;
    }

    public Vigilante getVigilante() {
        return vigilante;
    }

    public void setVigilante(Vigilante vigilante) {
        this.vigilante = vigilante;
    }

    public Tipousuario getLetraTU() {
        return letraTU;
    }

    public void setLetraTU(Tipousuario letraTU) {
        this.letraTU = letraTU;
    }

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @XmlTransient
    public List<Ingreso> getIngresoList() {
        return ingresoList;
    }

    public void setIngresoList(List<Ingreso> ingresoList) {
        this.ingresoList = ingresoList;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
    }

    @XmlTransient
    public List<Entregaambiente> getEntregaambienteList() {
        return entregaambienteList;
    }

    public void setEntregaambienteList(List<Entregaambiente> entregaambienteList) {
        this.entregaambienteList = entregaambienteList;
    }

    public Aprendiz getAprendiz() {
        return aprendiz;
    }

    public void setAprendiz(Aprendiz aprendiz) {
        this.aprendiz = aprendiz;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoPersona != null ? documentoPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.documentoPersona == null && other.documentoPersona != null) || (this.documentoPersona != null && !this.documentoPersona.equals(other.documentoPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Persona[ documentoPersona=" + documentoPersona + " ]";
    }
    
}
