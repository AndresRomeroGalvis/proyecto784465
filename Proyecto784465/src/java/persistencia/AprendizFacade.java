/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Aprendiz;

/**
 *
 * @author ADMIN
 */
@Stateless
public class AprendizFacade extends AbstractFacade<Aprendiz> implements AprendizFacadeLocal {
    @PersistenceContext(unitName = "Proyecto784465PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AprendizFacade() {
        super(Aprendiz.class);
    }
    public List<Aprendiz> consultarDocumento(String documentoPersona) {
        String consulta="select aprendiz from aprendiz.documentoA ='"+ documentoPersona +"'";
        Query query=em.createQuery(consulta);
        return query.getResultList();//retornar una lista cuando retorne un objeto debe ser getsingleResul
    }
    
}
