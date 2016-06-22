/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

/**
 *
 * @author ADMIN
 */
@ManagedBean
@ViewScoped
public class ReporteVista {

    private InputText txtDocumento;
    private CommandButton botonReporte;

    public InputText getTxtDocumento() {
        return txtDocumento;
    }

    public void setTxtDocumento(InputText txtDocumento) {
        this.txtDocumento = txtDocumento;
    }

    public CommandButton getBotonReporte() {
        return botonReporte;
    }

    public void setBotonReporte(CommandButton botonReporte) {
        this.botonReporte = botonReporte;
    }

   

    /**
     * Creates a new instance of ReporteVista
     */
    public ReporteVista() {
    }

    public void generarReporteAprendiz() {
        try {
            Connection conn = null;
            Context initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("jdbc/proyecto784465");
            conn = ds.getConnection();
            Integer documentoPersona = Integer.parseInt(txtDocumento.getValue().toString());
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("documento", documentoPersona);
            File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("ReportesAprendiz/ReporteAprendizInasistencias.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, conn);
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.addHeader("Content-disposition", "attachment; filename=ReporteAprendiz" + documentoPersona + ".pdf");
            ServletOutputStream stream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            FacesContext.getCurrentInstance().responseComplete();
        } catch (NamingException ex) {
            Logger.getLogger(ReporteVista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReporteVista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(ReporteVista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReporteVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
