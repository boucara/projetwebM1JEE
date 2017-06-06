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
import utilisateurs.gestionnaires.GestionnaireEnseignants;
import utilisateurs.gestionnaires.GestionnaireEntreprises;
import utilisateurs.gestionnaires.GestionnaireEtudiants;
import utilisateurs.modeles.Utilisateur;

/**
 *
 * @author Aicha
 */
@WebServlet(name = "ServeletConnexion", urlPatterns = {"/Connexion"})
public class ServeletConnexion extends MaServlet {

    @EJB
    private GestionnaireEntreprises gestionnaireEntreprises;
    @EJB
    private GestionnaireEnseignants gestionnaireEnseignants;
    @EJB
    private GestionnaireEtudiants gestionnaireEtudiants;

    @Override
    protected void processRequestGetCo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forwardTo = "Accueil";
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo);
        dp.forward(request, response);
    }

    @Override
    protected void processRequestPostCo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forwardTo = "Accueil";
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo);
        dp.forward(request, response);
    }

    @Override
    protected void processRequestGetDeco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forwardTo = "Accueil";
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo);
        dp.forward(request, response);
    }

    @Override
    protected void processRequestPostDeco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String forwardTo = "Accueil";

        String mail = request.getParameter("mail");
        String mdp = request.getParameter("mdpco");
        if (!mail.equals("admin_jnm") && !mdp.equals("admin_jnm")) {
            Utilisateur user = gestionnaireEnseignants.selectEnseignant(mail, mdp);
            if (user != null) {
                request.getSession().setAttribute("utilisateur", user);
                request.getSession().setAttribute("connexion", true);
            }
            user = gestionnaireEntreprises.selectEntreprise(mail, mdp);
            if (user != null) {
                request.getSession().setAttribute("utilisateur", user);
                request.getSession().setAttribute("connexion", true);
            }
            user = gestionnaireEtudiants.selectEtudiant(mail, mdp);
            if (user != null) {
                request.getSession().setAttribute("utilisateur", user);
                request.getSession().setAttribute("connexion", true);
            }
        }else{
            request.getSession().setAttribute("admin", true);
        }

        RequestDispatcher dp = request.getRequestDispatcher(forwardTo);
        dp.forward(request, response);
    }

}
