/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Tipousuario;

/**
 *
 * @author USUARIO
 */
@Local
public interface TipoUsuarioLogicaLocal {
    public Tipousuario consultarxTipoUsuario(String letraTU) throws Exception;
    public List<Tipousuario> consultar() throws Exception;
     public void modificar(Tipousuario tipousuario) throws Exception;
    
}
