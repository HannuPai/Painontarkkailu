/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painontarkkailu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hannu Päiveröinen
 */
public class LisaaKayttajaServlet extends HttpServlet {

    private StringBuilder sb = new StringBuilder();
    private Rekisteri rekisteri = new Rekisteri();

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String kayttajanimi = request.getParameter("kayttajanimi");
        if (kayttajanimi.length() == 0) {
            sb.append("Anna käyttäjätunnus");
        }
        String nimi = request.getParameter("nimi");
        if (nimi.length() == 0) {
            nimi = "-";
        }

        int ika = 0;
        try {
            ika = Integer.parseInt(request.getParameter("ika"));
        } catch (NumberFormatException e) {
            sb.append("Tarkista, että ikä on ilmoitettu luvulla. ");
        }
        if (0 > ika) {
            sb.append("Ikä ei voi olla negatiivinen. ");
        }

        String sukupuoli = "";
        if (request.getParameter("sex").equals("mies")) {
            sukupuoli = "mies";
        } else if (request.getParameter("sex").equals("nainen")) {
            sukupuoli = "nainen";
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
        Kayttaja uusi;
        if (sb.length() == 0) {
            uusi = new Kayttaja(nimi, kayttajanimi, ika, sukupuoli, pituus, paino);
            rekisteri.lisaaKayttaja(uusi);
        } else {
            request.setAttribute("varoitus", sb.toString());
            sb.delete(0, sb.length());
        }


        request.getRequestDispatcher("/UusiKayttaja").forward(request, response);
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
