/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pe.edu.pucp.ZAP2.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.awt.Image;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.pucp.ZAP2.DBManager.DBManager;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.ImageIcon;

//ProductoMasConsumidos.jasper
public class ReportProductosMasConsumidos extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
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
                            
            
            JasperExportManager.exportReportToPdfStream(
                    jp,response.getOutputStream());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
