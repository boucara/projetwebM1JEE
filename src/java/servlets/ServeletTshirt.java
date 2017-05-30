/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;

import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilisateurs.gestionnaires.GestionnaireTshirt;
import utilisateurs.modeles.Tshirt;

/**
 *
 * @author Aicha
 */
@WebServlet(name = "serveletTshirt", urlPatterns = {"/Tshirt"})
public class ServeletTshirt extends HttpServlet {

    @EJB
    private GestionnaireTshirt gestionnaireTshirt;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String forwardTo = "tshirt.jsp";
        String message = "salut";

        if (action != null) {
            if (action.equals("creerTshirtconcour")) {
                gestionnaireTshirt.creerTshirtconcour();

                

                forwardTo = "tshirt.jsp?action=creerTshirtconcour";
                message = "Concour Tshirt";
            }
        }

        

    }
}
