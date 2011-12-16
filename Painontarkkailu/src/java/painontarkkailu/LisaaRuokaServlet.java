package painontarkkailu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet vastaa ruokailu-sivulla lisätyn ruoan lisäämisestä tietokantaan
 * @author Hannu Päiveröinen
 */
public class LisaaRuokaServlet extends HttpServlet {
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
        
        long raakaaineID = Long.parseLong(request.getParameter("raakaaineId"));
        String ruoannimi = request.getParameter("nimi");
        request.setAttribute("ruoannimiApu", ruoannimi);
        if (ruoannimi.length() == 0) {
            sb.append("Anna ruoan nimi. ");
        }
        RaakaAine raakaaine = rekisteri.haeRaakaaine(raakaaineID);
        Ruoka ruoka = new Ruoka(ruoannimi);
        request.getParameterMap();
        double maara= 0;
        try {
            maara = Double.parseDouble(request.getParameter("maara"));
            request.setAttribute("maaraApu", maara);
        } catch (NumberFormatException e) {
            sb.append("Tarkista, että määrä on ilmoitettu luvulla. ");
        }
        if (0 > maara) {
            sb.append("Määrä ei voi olla negatiivinen. ");
        }
        
        Ruokaliitos ruokaliitos;
        if (sb.length() == 0) {
            rekisteri.lisaaRuoka(ruoka);
            long ruokaID = ruoka.getId();
            ruokaliitos = new Ruokaliitos(raakaaine, maara, ruoka);
            rekisteri.lisaaRuokaliitos(ruokaliitos);
            
            request.setAttribute("ruoannimiApu", "");
            request.setAttribute("maaraApu", "");
            request.setAttribute("varoitus", "Ruoka lisätty.");
        } else {
            request.setAttribute("varoitus", sb.toString());
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
