
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
import modelo.Vigilante;
import persistencia.VigilanteFacadeLocal;


public class FiltroVigilante implements Filter {
    private FilterConfig configuration;

    @EJB
    private VigilanteFacadeLocal vigilanteDAO;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.configuration = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        Vigilante v = (Vigilante) ((HttpServletRequest) request).getSession().getAttribute("usuario");
        if (v != null) {            
             chain.doFilter(request, response);          
        } else {
            ((HttpServletResponse) response).sendRedirect("../faces/SesionInvalida.xhtml");
        }

    }


    @Override
    public void destroy() {
        this.configuration = null;
    }
    
    
    
    
}
