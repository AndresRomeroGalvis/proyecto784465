/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtros;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Aprendiz;
import persistencia.AprendizFacadeLocal;

/**
 *
 * @author USUARIO
 */

public class FiltroIndexAprendiz implements Filter{
private FilterConfig configuration;
    @EJB
    private AprendizFacadeLocal aprendizDAO;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.configuration = filterConfig;
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String tipo = (String) ((HttpServletRequest) request).getSession().getAttribute("tipo");
        if (tipo != null) {            
             char t=tipo.charAt(0);
            switch(t){
                case 'A':
                    ((HttpServletResponse) response).sendRedirect("/Proyecto784465/faces/aprendiz/template/plantillaindex.xhtml");
                    break;
            } 
        } else {
            chain.doFilter(request, response); 
        }
    }

    @Override
    public void destroy() {
         this.configuration = null;
    }
    
}
