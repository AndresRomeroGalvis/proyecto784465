/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Tipousuario;
import persistencia.TipousuarioFacadeLocal;

/**
 *
 * @author USUARIO
 */
@Stateless
public class TipoUsuarioLogica implements TipoUsuarioLogicaLocal {
  @EJB
    private TipousuarioFacadeLocal tipousuarioDAO;
    @Override
    public Tipousuario consultarxTipoUsuario(String letraTU) throws Exception {
       return tipousuarioDAO.find(letraTU);
//tipousuarioDAO.find(this);
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Tipousuario> consultar() throws Exception {
         return tipousuarioDAO.findAll();
    }

    @Override
    public void modificar(Tipousuario tipousuario) throws Exception {
     
        if(tipousuario.getLetraTU()==null || tipousuario.getDescripcionTU().equals("")){
            throw new Exception(" Campos es obligatorios ");   
        
        }else{
            tipousuarioDAO.edit(tipousuario);
        }
    }
}
