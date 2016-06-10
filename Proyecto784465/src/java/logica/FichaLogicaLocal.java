/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Ficha;

/**
 *
 * @author USUARIO
 */
@Local
public interface FichaLogicaLocal {
     public List<Ficha> consultar() throws Exception;
     public Ficha consultarxCodigo(Integer ficha) throws Exception;
}
