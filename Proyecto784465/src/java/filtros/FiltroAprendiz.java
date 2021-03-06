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

public class FiltroAprendiz implements Filter{
    private FilterConfig configuration;
    @EJB
    private AprendizFacadeLocal aprendizDAO;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.configuration = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       Aprendiz a = (Aprendiz) ((HttpServletRequest) request).getSession().getAttribute("usuario");
        if (a != null) {            
             chain.doFilter(request, response);          
        } else {
            ((HttpServletResponse) response).sendRedirect("../../SesionInvalida.xhtml");
        }
        
    }

    @Override
    public void destroy() {
        this.configuration = null;
    }
}
