package painontarkkailu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet lisää raaka-aineen tietokantaan ja tarkastaa lomakkeen oikeellisuuden.
 * @author Hannu Päiveröinen
 */
public class LisaaRaakaaineServlet extends HttpServlet {
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
        String nimi = request.getParameter("nimi");
        request.setAttribute("nimiApu", nimi);
        if (nimi.length() == 0) {
            sb.append("Anna raaka-aineen nimi. ");
        }
        
        double energia= 0;
        try {
            energia = Double.parseDouble(request.getParameter("energia"));
            request.setAttribute("energiaApu", energia);
        } catch (NumberFormatException e) {
            sb.append("Tarkista, että energia on ilmoitettu luvulla. ");
        }
        if (0 > energia) {
            sb.append("Energia ei voi olla negatiivinen. ");
        }
        
        RaakaAine uusi;
        if (sb.length() == 0) {
            uusi = new RaakaAine(nimi, energia);
            rekisteri.lisaaRaakaAine(uusi);
            request.setAttribute("nimiApu", "");
            request.setAttribute("energiaApu", "");
            request.setAttribute("varoitus2", "Raaka-aine lisätty.");
        } else {
            request.setAttribute("varoitus2", sb.toString());
            sb.delete(0, sb.length());
        }
        request.getRequestDispatcher("/Ruokailu").forward(request, response);
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
