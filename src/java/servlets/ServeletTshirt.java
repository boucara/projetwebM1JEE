/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;

import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilisateurs.gestionnaires.GestionnaireTshirt;
import utilisateurs.modeles.Tshirt;
import utilisateurs.modeles.Utilisateur;

/**
 *
 * @author Aicha
 */
@WebServlet(name = "serveletTshirt", urlPatterns = {"/Tshirt"})
public class ServeletTshirt extends MaServlet {

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
    @Override
    protected void processRequestGetCo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String forwardTo = "tshirt.jsp";
        String message = "salut";

        if (action != null) {
            if (action.equals("creerTshirtconcour")) {
                gestionnaireTshirt.creerTshirtconcour();

                Collection<Tshirt> listshirt = gestionnaireTshirt.getTshirtConcour();
                request.setAttribute("concour", listshirt);

                forwardTo = "tshirt.jsp?action=creerTshirtconcour";
                message = "Concour Tshirt";
                System.out.println(forwardTo);
            }
        }
        Utilisateur user = (Utilisateur)request.getSession().getAttribute("utilisateur");
        request.setAttribute("utilisateur", user);
        request.setAttribute("connexion", true);
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo);  
        dp.forward(request, response);
    }

    @Override
    protected void processRequestPostCo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processRequestGetDeco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processRequestPostDeco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
