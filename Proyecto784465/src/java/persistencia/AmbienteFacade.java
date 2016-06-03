/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Ambiente;

/**
 *
 * @author USUARIO
 */
@Stateless
public class AmbienteFacade extends AbstractFacade<Ambiente> implements AmbienteFacadeLocal {
    @PersistenceContext(unitName = "Proyecto784465PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AmbienteFacade() {
        super(Ambiente.class);
    }
    
}
