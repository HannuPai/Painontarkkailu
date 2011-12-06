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
public class LisaaHarjoiteServlet extends HttpServlet {

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
        
        long kayttajaId = Long.parseLong(request.getParameter("kayttajaId"));
        Kayttaja kayttaja = rekisteri.haeKayttaja(kayttajaId);
        long lajiId = Long.parseLong(request.getParameter("lajiId"));
        Laji laji = rekisteri.haeLaji(lajiId);
        String paivays = request.getParameter("paivays");
        double kestoMinuuteissa = 0;
        try{
            kestoMinuuteissa = Double.parseDouble(request.getParameter("kestoMinuuteissa"));
        }
        catch(NumberFormatException e){
            sb.append("Tarkista, että kesto on ilmoitettu luvulla. ");
        }
        if(0>kestoMinuuteissa) sb.append("Kesto ei voi olla negatiivinen. ");
        
        String kommentti = request.getParameter("kommentti");
        if (kommentti.length()==0) kommentti = "-";
        
        int syke = 0;
         try{
            syke = Integer.parseInt(request.getParameter("syke"));
        }
        catch(NumberFormatException e){
            sb.append("Tarkista, että syke on ilmoitettu luvulla. ");
        }
         if(0>syke) sb.append("Syke ei voi olla negatiivinen. ");
        // TODO: parse päiväys kuntoon
        Harjoite uusi ;
        if(sb.length()==0){
            uusi = new Harjoite(kayttaja, laji, paivays, kestoMinuuteissa, kommentti, syke);
            rekisteri.lisaaHarjoite(uusi);
        }
        else{
            request.setAttribute("varoitus", sb.toString());
            sb.delete(0, sb.length());
        }
        
        request.getRequestDispatcher("/Lista").forward(request, response);
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
