package painontarkkailu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servletillä lisätään tietokantaan käyttäjä annetun lomakkeen mukaan
 * Lisäksi tarkistetaan että käyttäjän antamat tiedot ovat oikeellisia
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
        request.setAttribute("kayttajanimiApu", kayttajanimi);
        if (kayttajanimi.length() == 0) {
            sb.append("Anna käyttäjätunnus");
        }
        String nimi = request.getParameter("nimi");
        request.setAttribute("nimiApu", nimi);
        if (nimi.length() == 0) {
            nimi = "-";
        }

        int ika = 0;
        try {
            ika = Integer.parseInt(request.getParameter("ika"));
            request.setAttribute("ikaApu", ika);
        } catch (NumberFormatException e) {
            sb.append("Tarkista, että ikä on ilmoitettu luvulla. ");
        }
        if (0 > ika) {
            sb.append("Ikä ei voi olla negatiivinen. ");
        }

        String sukupuoli = "";
        if (request.getParameter("sex").equals("mies")) {
            sukupuoli = "mies";
            request.setAttribute("miesApu", "checked");
        } else if (request.getParameter("sex").equals("nainen")) {
            sukupuoli = "nainen";
            request.setAttribute("nainenApu", "checked");
        } else {
            sb.append("Valitse sukupuoli");
        }
        int pituus = 0;
        try {
            pituus = Integer.parseInt(request.getParameter("pituus"));
            request.setAttribute("pituusApu", pituus);
        } catch (NumberFormatException e) {
            sb.append("Tarkista, että pituus on ilmoitettu luvulla. ");
        }
        if (0 > pituus) {
            sb.append("Pituus ei voi olla negatiivinen. ");
        }

        double paino = 0;
        try {
            paino = Double.parseDouble(request.getParameter("paino"));
            request.setAttribute("painoApu", paino);
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
            request.setAttribute("kayttajanimiApu", "");
            request.setAttribute("nimiApu", "");
            request.setAttribute("ikaApu", "");
            request.setAttribute("miesApu", "");
            request.setAttribute("naisApu", "");
            request.setAttribute("pituusApu", "");
            request.setAttribute("painoApu", "");
            request.setAttribute("varoitus", "Harjoite lisätty.");
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
