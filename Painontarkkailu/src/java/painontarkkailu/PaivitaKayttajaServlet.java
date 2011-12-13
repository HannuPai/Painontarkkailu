package painontarkkailu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet on vastuussa päivittäjän tietojen hausta ja lomakkeen esitäytöstä
 * @author Hannu Päiveröinen
 */
public class PaivitaKayttajaServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        long kayttajaId = Long.parseLong(request.getParameter("kayttajaId"));
        request.setAttribute("apuIka", rekisteri.getKayttajanIka(kayttajaId));
        request.setAttribute("apuPituus", rekisteri.getKayttajanPituus(kayttajaId));
        request.setAttribute("apuPaino", rekisteri.getKayttajanPaino(kayttajaId));
        String apu = rekisteri.getKayttajanSP(kayttajaId);
        if (apu.equals("mies")) {
            request.setAttribute("miesApu", "checked");
            request.setAttribute("nainenApu", "");
        } else {
            request.setAttribute("miesApu", "");
            request.setAttribute("nainenApu", "checked");
        }
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
