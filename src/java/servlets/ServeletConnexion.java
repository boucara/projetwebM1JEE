/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilisateurs.gestionnaires.GestionnaireUtilisateur;
import utilisateurs.modeles.Utilisateur;

/**
 *
 * @author Aicha
 */
@WebServlet(name = "ServeletConnexion", urlPatterns = {"/ServeletConnexion"})
public class ServeletConnexion extends MaServlet {

    @EJB
    private GestionnaireUtilisateur gestionnaireUtilisateur;

    @Override
    protected void processRequestGetCo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void processRequestPostCo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String forwardTo = "home.jsp";
        String message = "en attente de connexion";

        Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
        if (action != null) {
            if (action.equals("seConnecter")) {
                String mail = request.getParameter("mail");
                String mdp = request.getParameter("mdp");
                Utilisateur user = gestionnaireUtilisateur.getUser(mail, mdp);
                if (user != null) {
                    request.getSession().setAttribute("utilisateur", user);
                    message = "Utilisateur connecté";
                    utilisateur = user;

                } else {
                    message = "Mot de passe ou mail incorrect";

                }
                forwardTo = "home.jsp?action=seConnecter";
            }
        }

        
        request.setAttribute("connexion", true);
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo);
        dp.forward(request, response);
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
