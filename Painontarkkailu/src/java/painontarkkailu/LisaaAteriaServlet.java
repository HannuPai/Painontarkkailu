package painontarkkailu;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servletin vastuulla on aterian lisääminen tietokantaan
 * @author Hannu Päiveröinen
 */
public class LisaaAteriaServlet extends HttpServlet {
    private StringBuilder sb = new StringBuilder();
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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
        long kayttajaId = Long.parseLong(request.getParameter("kayttajaId"));
        Kayttaja kayttaja = rekisteri.haeKayttaja(kayttajaId);
        long ruokaId = Long.parseLong(request.getParameter("ruokaId"));
        Ruoka ruoka = rekisteri.haeRuoka(ruokaId);
        String paivays = request.getParameter("paivays");
        request.setAttribute("paivays", paivays);
        double maara = 0;
        try{
            maara = Double.parseDouble(request.getParameter("maara"));
            request.setAttribute("maara", maara);
        }
        catch(NumberFormatException e){
            sb.append("Tarkista, että määrä on ilmoitettu luvulla. ");
        }
        if(0>maara) sb.append("Määrä ei voi olla negatiivinen. ");
        
        Ateria ateria;
        if(sb.length()==0){
            ateria = new Ateria(kayttaja, ruoka, paivays, maara);
            rekisteri.lisaaAteria(ateria);
            request.setAttribute("maara", "");
            request.setAttribute("paivays", dateFormat.format(calendar.getTime()));
            request.setAttribute("varoitus", "Ateria lisätty.");
        }
        else{
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
