/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilisateurs.gestionnaires.GestionnaireUtilisateur;
import utilisateurs.modeles.Utilisateur;

/**
 *
 * @author Aicha
 */
@WebServlet(name = "ServeletConnexion", urlPatterns = {"/ServeletConnexion"})
public class ServeletConnexion extends HttpServlet {
     @EJB
    private GestionnaireUtilisateur gestionnaireUtilisateur;

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
       String action = request.getParameter("action");  
        String forwardTo = "home.jsp";  
        String message = "en attente de connexion";
       
        Utilisateur user = (Utilisateur)request.getSession().getAttribute("user");
        if (action != null) { 
            if (action.equals("seConnecter")) {
                String login = request.getParameter("login");
                String mdp = request.getParameter("mdp");
                Utilisateur utilsateur = gestionnaireUtilisateur.getUser(login, mdp);
                if(utilsateur!= null)
                {
                    request.getSession().setAttribute("user", utilsateur);
                    message = "Utilisateur connecté";
                    user = utilsateur;
                }
                else
                {
                    message = "Mot de passe ou login incorrect";
                }
                forwardTo = "home.jsp?action=connexion";
            }
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
