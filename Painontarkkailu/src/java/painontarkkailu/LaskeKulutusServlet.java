/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painontarkkailu;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet laskee laskurit-sivun kulutuslomakkeen tiedoilla kulutuksen ja tarkistaa arvojen oikeellisuuden
 * @author Hannu Päiveröinen
 */
public class LaskeKulutusServlet extends HttpServlet {
     private StringBuilder sb = new StringBuilder();

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long lajiId = Long.parseLong(request.getParameter("lajiId"));
        int ika = 0;
        try {
            ika = Integer.parseInt(request.getParameter("ika"));
        } catch (NumberFormatException e) {
            sb.append("Tarkista, että ikä on ilmoitettu luvulla. ");
        }
        if (0 > ika) {
            sb.append("Ikä ei voi olla negatiivinen. ");
        }

        double kulutus = 0;
        try {
            kulutus = 400;//rekisteri.getKulutus(lajiId); 
        } catch (NumberFormatException e) {
            sb.append("Tarkista, että kulutus on ilmoitettu luvulla. ");
        }
        if (0 > kulutus) {
            sb.append("Kulutus ei voi olla negatiivinen. ");
        }
        double sukupuolikerroin=1;
        String sukupuoli = "";
        if (request.getParameter("sex").equals("mies")) {
            sukupuoli = "mies";
            sukupuolikerroin = 1.05;
        } else if (request.getParameter("sex").equals("nainen")) {
            sukupuoli = "nainen";
            sukupuolikerroin = 0.95;
        } else {
            sb.append("Valitse sukupuoli");
        }
        int pituus = 0;
        try {
            pituus = Integer.parseInt(request.getParameter("pituus"));
        } catch (NumberFormatException e) {
            sb.append("Tarkista, että pituus on ilmoitettu luvulla. ");
        }
        if (0 > pituus) {
            sb.append("Pituus ei voi olla negatiivinen. ");
        }
        double paino = 0;
        try {
            paino = Double.parseDouble(request.getParameter("paino"));
        } catch (NumberFormatException e) {
            sb.append("Tarkista, että paino on ilmoitettu luvulla. ");
        }
        if (0 > paino) {
            sb.append("Paino ei voi olla negatiivinen. ");
        }
        double kestoMinuuteissa = 0;
        try {
            kestoMinuuteissa = Double.parseDouble(request.getParameter("kestoMinuuteissa"));
        } catch (NumberFormatException e) {
            sb.append("Tarkista, että kesto on ilmoitettu luvulla. ");
        }
        if (0 > kestoMinuuteissa) {
            sb.append("Kesto ei voi olla negatiivinen. ");
        }
        
        double painoindeksi = paino/((pituus*0.01)*(pituus*0.01));
        
        
        double kalorimaara = kulutus*ika*(painoindeksi*0.03)*kestoMinuuteissa*0.004*sukupuolikerroin;
        request.setAttribute("kulutus", kalorimaara+"");
        request.getRequestDispatcher("/Laskurit").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
