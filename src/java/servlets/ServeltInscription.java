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
import utilisateurs.modeles.Enseignant;
import utilisateurs.modeles.Entreprise;
import utilisateurs.modeles.Utilisateur;

/**
 *
 * @author Tom
 */
@WebServlet(name = "ServeltInscription", urlPatterns = {"/Inscription"})
public class ServeltInscription extends MaServlet {

    @EJB
    private GestionnaireEntreprises gestionnaireEntreprises;
    @EJB
    private GestionnaireEnseignants gestionnaireEnseignants;

    /**
     * Processes requests for both HTTP <code>Get</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processRequestGetDeco(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fowardTo = "inscription.jsp";
        String message = "Bienvenu dans la page d'inscription";
        Utilisateur user = (Utilisateur) request.getSession().getAttribute("utilisateur");
        if(user != null){
            request.setAttribute("utilisateur", user);
        }
        request.setAttribute("etape", "etape1");
        request.setAttribute("message", message);
        RequestDispatcher dp = request.getRequestDispatcher(fowardTo);
        dp.forward(request, response);
    }

    /**
     * Processes requests for both HTTP <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processRequestPostDeco(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fowardTo = "inscription.jsp";
        String message = "Inscription en cours.";
        String etape = request.getParameter("etape");

        Utilisateur user;
        if (etape.equals("etape1")) {
            message = "Deuxième étape de l'inscription";
            String mdp = request.getParameter("mdp");
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String email = request.getParameter("email");
            String categorie = request.getParameter("categorie");
            if (categorie.equals("entreprise")) {
                user = new Entreprise(nom, prenom, mdp, email);
            } else if (categorie.equals("enseignant")) {
                user = new Enseignant(nom, prenom, mdp, email);
                gestionnaireEnseignants.insererEnseignant((Enseignant) user);
                request.getSession().setAttribute("connexion", true);
                fowardTo = "Accueil";
            } else {
                user = null;
            }
            request.setAttribute("etape", "etape2");
            request.getSession().setAttribute("utilisateur", user);

        } else if (etape.equals("etape2")) {
            user = (Utilisateur) request.getSession().getAttribute("utilisateur");
            if (user.getClass().getName().equals("utilisateurs.modeles.Entreprise")) {
                Entreprise entreprise = (Entreprise)user;
                //gestionnaireEntreprises.insererEntreprise(entreprise);
            } else {

            }
            request.getSession().setAttribute("utilisateur", user);
            request.getSession().setAttribute("connexion", true);
            fowardTo = "Accueil";
        }
        else {
            
        }
        request.setAttribute("message", message);
        RequestDispatcher dp = request.getRequestDispatcher(fowardTo);
        dp.forward(request, response);
    }

    @Override
    protected void processRequestGetCo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fowardTo = "Accueil";
        RequestDispatcher dp = request.getRequestDispatcher(fowardTo);
        dp.forward(request, response);
    }

    @Override
    protected void processRequestPostCo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fowardTo = "Accueil";
        RequestDispatcher dp = request.getRequestDispatcher(fowardTo);
        dp.forward(request, response);
    }
}
