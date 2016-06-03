/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.Local;
import modelo.Aprendiz;
import modelo.Persona;

/**
 *
 * @author USUARIO
 */
@Local
public interface AprendizLogicaLocal {
    public Aprendiz consultarxDocumentoA(Long documentoA) throws Exception;
    public Persona consultarxDocumento(Long documento) throws Exception;
    public Persona Modificar(Long documento) throws Exception;
    
     
}
