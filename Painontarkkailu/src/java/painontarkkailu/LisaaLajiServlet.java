package painontarkkailu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet lisää lajin tietokantaan ja tarkastaa lomakkeen oikeellisuuden.
 * @author Hannu Päiveröinen
 */
public class LisaaLajiServlet extends HttpServlet {
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
        double kulutus  = 0;
        try{
            kulutus = Double.parseDouble(request.getParameter("kulutus"));
            request.setAttribute("kulutusApu", kulutus);
        }
        catch(NumberFormatException e){
            sb.append("Tarkista, että kulutus on ilmoitettu luvulla. ");
        }
        if(0>kulutus) sb.append("Kulutus ei voi olla negatiivinen. ");
        
        Laji uusi ;
        if(sb.length()==0){
            uusi = new Laji(nimi, kulutus);
            rekisteri.lisaaLaji(uusi);
            request.setAttribute("kulutusApu", "");
            request.setAttribute("nimiApu", "");
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
