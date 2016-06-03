/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Vigilante;

/**
 *
 * @author ADMIN
 */
@Stateless
public class VigilanteFacade extends AbstractFacade<Vigilante> implements VigilanteFacadeLocal {
    @PersistenceContext(unitName = "Proyecto784465PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VigilanteFacade() {
        super(Vigilante.class);
    }
    
}