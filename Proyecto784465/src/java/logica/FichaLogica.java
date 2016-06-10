/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Ficha;
import persistencia.FichaFacadeLocal;

/**
 *
 * @author USUARIO
 */
@Stateless
public class FichaLogica implements FichaLogicaLocal {

    @EJB
    private FichaFacadeLocal fichaDAO;

    @Override
    public List<Ficha> consultar() throws Exception {
        return fichaDAO.findAll();
    }

}
