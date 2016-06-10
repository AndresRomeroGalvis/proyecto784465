/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.Local;
import modelo.Aprendiz;

/**
 *
 * @author USER
 */
@Local
public interface AprendizLogicaLocal {
    public Aprendiz consultarxDocumento(Long documento) throws Exception;
    public void modificar(Aprendiz aprendiz) throws Exception;
    public void modificarContraseña(String claveVieja, String claveNueva)throws Exception;
}
