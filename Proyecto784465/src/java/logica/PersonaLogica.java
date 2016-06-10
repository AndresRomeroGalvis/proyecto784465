/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Persona;
import persistencia.PersonaFacadeLocal;

/**
 *
 * @author ADMIN
 */
@Stateless
public class PersonaLogica implements PersonaLogicaLocal {
    @EJB
    private PersonaFacadeLocal personaDAO;

    @Override
    public Persona consultarxDocumento(Long documento) throws Exception {
        if(documento==null){
            throw new Exception("El documento es Obligatorio");
        }
        return personaDAO.find(documento);
    }

    @Override
    public void registrar(Persona persona) throws Exception {
       
        if(persona== null){
           throw new Exception(" Campo vacios ");
       }
       if(persona.getNombresPersona()== null || persona.getNombresPersona().equals("")){
     throw new Exception(" El nombre es obligatorio ");   
    }
      Persona objEmpleado = personaDAO.find(persona.getDocumentoPersona());
    if(objEmpleado !=null){
      throw new Exception(" la persona ya existe");  
    }else{
       personaDAO.edit(persona);
    }
    }

    @Override
    public void modificar(Persona persona) throws Exception {
           if(persona== null){
           throw new Exception(" Campo vacios ");
       }
       if(persona.getNombresPersona()== null || persona.getNombresPersona().equals("")){
     throw new Exception(" El nombre es obligatorio ");   
    }
      Persona objEmpleado = personaDAO.find(persona.getDocumentoPersona());
      
    if(objEmpleado ==null){
      throw new Exception(" la persona ya existe");  
    }else{
       objEmpleado.setNombresPersona(persona.getNombresPersona());
       objEmpleado.setApellidosPersona(persona.getApellidosPersona());
       objEmpleado.setDireccionPersona(persona.getDireccionPersona());
       objEmpleado.setEmailPersona(persona.getEmailPersona());
       personaDAO.edit(objEmpleado);
    }
    }
}
