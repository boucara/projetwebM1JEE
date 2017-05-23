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
import javax.servlet.http.HttpServlet;
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
public class ServeltInscription extends HttpServlet {

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
    private void processRequestGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fowardTo = "inscription.jsp";
        String message = "Bienvenu dans la page d'inscription";
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
    protected void processRequestPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fowardTo = "inscription.jsp";
        String message;
        boolean testconnexion = (boolean) request.getSession().getAttribute("connexion");
        String etape = request.getParameter("etape");
        if (testconnexion) {
            message = "Utilisateur déjà connecté !";
            request.setAttribute("utilisateur", request.getSession().getAttribute("utilisateur"));
            fowardTo = "Accueil";
        } else {
            Utilisateur user;
            if (etape.equals("etape1")) {
                String mdp = request.getParameter("mdp");
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String email = request.getParameter("email");
                String categorie = request.getParameter("categorie");
                if(categorie.equals("entreprise")){
                    user = new Entreprise(nom, prenom, mdp, email);
                }else if(categorie.equals("enseignant")){
                    user = new Enseignant(nom, prenom, mdp, email);
                }else{
                    user = null;
                }
                message = "Deuxième étape de l'inscription";
                request.getSession().setAttribute("utilisateur", user);
            } else {
                user = (Utilisateur) request.getSession().getAttribute("utilisateur");
                if(user.getClass().getName().equals("utilisateurs.modeles.Enseignant")){
                    gestionnaireEnseignants.insererEnseignant((Enseignant)user);
                }else if(user.getClass().getName().equals("utilisateurs.modeles.Entreprise")){
                    gestionnaireEntreprises.insererEntreprise((Entreprise)user);
                }else{
                    
                }
                request.setAttribute("utilisateur", user);
                message = "Inscription terminée !";
                fowardTo = "Accueil";
            }

        }

        request.setAttribute("message", message);
        RequestDispatcher dp = request.getRequestDispatcher(fowardTo);
        dp.forward(request, response);
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
        processRequestGet(request, response);
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
        processRequestPost(request, response);
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
