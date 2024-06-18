/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.reportes;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.awt.Image;

import java.sql.Connection;

import java.util.HashMap;

import javax.swing.ImageIcon;

import net.sf.jasperreports.engine.JRException;

import net.sf.jasperreports.engine.JasperExportManager;

import net.sf.jasperreports.engine.JasperFillManager;

import net.sf.jasperreports.engine.JasperPrint;

import net.sf.jasperreports.engine.JasperReport;

import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import pe.edu.pucp.ZAP2.servlet.ReportProductosMasConsumidos;
import pe.edu.pucp.ZAP2.servlet.ReporteBoletaVenta;

@WebService(serviceName = "ReportesFrontWS")
public class ReportesFrontWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "generarReporteProductosConsumidos")

    public byte[] generarReporteProductosConsumidos() {

        byte[] reporte = null;

        try {

            Connection con = DBManager.getInstance().getConnection();
            JasperReport jr
                    =(JasperReport) JRLoader.loadObject(
                            ReportProductosMasConsumidos.class.getResource("/pe/edu/pucp/ZAP2/reportes"
                                    + "/ProductoMasConsumidos.jasper"));
            HashMap hm = new HashMap();
            String rutaLogo = ReportProductosMasConsumidos.class.getResource(
                    "/pe/edu/pucp/ZAP2/images/zap2Logo.png").getPath();
            Image imagen = (new  ImageIcon(rutaLogo)).getImage();
            hm.put("logo", imagen);
            JasperPrint jp =
                    JasperFillManager.fillReport(jr, hm, con);
                            
            
            reporte  = JasperExportManager.exportReportToPdf(jp);
                    

        }catch(JRException ex){

            System.out.println(ex.getMessage());

        }

        return reporte;

    }
    
    
    @WebMethod(operationName = "generarBoletaVenta")

    public byte[] generarBoletaVenta(@WebParam(name = "idBoleta") int idBoleta) {

        byte[] reporte = null;

        try {

            Connection con = DBManager.getInstance().getConnection();
            JasperReport jr
                    =(JasperReport) JRLoader.loadObject(
                            ReporteBoletaVenta.class.getResource("/pe/edu/pucp/ZAP2/reportes"
                                    + "/BoletaVenta.jasper"));
            HashMap hm = new HashMap();
            String rutaSubreporte = ReporteBoletaVenta.class.getResource(
                    "/pe/edu/pucp/ZAP2/reportes/DetalleBoletaVenta.jasper").getPath();
            hm.put("BoletaID", idBoleta);
            hm.put("RutaSubReporte", rutaSubreporte);
            JasperPrint jp =
                    JasperFillManager.fillReport(jr, hm, con);

            reporte = JasperExportManager.exportReportToPdf(jp);
        }catch(JRException ex){
            System.out.println(ex.getMessage());
        }
        return reporte;
    }
}
