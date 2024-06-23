/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ZAP2.reportes;

import jakarta.activation.DataHandler;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.mail.util.ByteArrayDataSource;
import jakarta.activation.DataSource;


import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Properties;
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
    
    
    @WebMethod(operationName = "generarReporteProductosConsumidosYmandarPorCorreo")
    public String generarReporteProductosConsumidosYmandarPorCorreo(String correo) {
        int resultado = 0;
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
            resultado = enviarCorreoConAdjunto(correo,reporte);        

        }catch(JRException ex){

            System.out.println(ex.getMessage());

        }
        String cad;
        if(resultado == 1){
            cad = "Se ha enviado correctamente el correo a: " + correo;
        }else{
            cad= "No se ha enviado correctamente el correo a: " + correo;
        }
        
        return cad;

    }
    
   private int enviarCorreoConAdjunto(String to, byte[] archivoAdjunto) {
        int resultado = 0;
        String from = "correoszap2@gmail.com"; // Tu correo
        String host = "smtp.gmail.com"; // Servidor SMTP (por ejemplo, Gmail)
        final String username = "correoszap2@gmail.com"; // Tu correo (el mismo que `from`)
        final String password = "trgp fimh qpqe nojj"; // Tu contraseña
        //trgp fimh qpqe nojj
        Properties properties = System.getProperties();
//        properties.setProperty("mail.smtp.host", host);
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.port", "587");
//        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.ssl.trust",host);
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.user", from);
        properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.setProperty("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Reporte de Productos Consumidos");

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Adjunto encontrarás el reporte de productos consumidos.");

            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            DataSource source = new ByteArrayDataSource(archivoAdjunto, "application/pdf");
            attachmentBodyPart.setDataHandler(new DataHandler(source));
            attachmentBodyPart.setFileName("reporte.pdf");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentBodyPart);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Correo enviado exitosamente....");
            resultado = 1;
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return resultado;
    }
}
