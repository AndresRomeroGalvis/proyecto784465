/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Aprendiz;
import modelo.Permiso;
import persistencia.AprendizFacadeLocal;
import persistencia.PermisoFacadeLocal;


/**
 *
 * @author USER
 */
@Stateless
public class PermisoLogica implements PermisoLogicaLocal {
@EJB// se utiliza para que no se tenga que instanciar los oobjetos 
    private PermisoFacadeLocal PermisoDAO;

@EJB// se utiliza para que no se tenga que instanciar los oobjetos 
    private AprendizFacadeLocal aprendizDAO;
    
       public void Registrar(Permiso permiso) throws Exception{
        if(permiso== null){
           throw new Exception(" Campo vacios ");
        }
        else{
            PermisoDAO.create(permiso);
        }
   }
       
       public List<Aprendiz> consultartodos() throws Exception {
       return aprendizDAO.findAll();
    }

    @Override
    public void create(Permiso permiso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Permiso permiso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Permiso permiso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Permiso find(Object numFicha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Permiso> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
