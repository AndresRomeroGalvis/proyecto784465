/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.Local;
import modelo.Vigilante;

/**
 *
 * @author ADMIN
 */
@Local
public interface VigilanteLogicaLocal {
    public Vigilante  consultarxDocumento(Long documentoV) throws Exception;
}
