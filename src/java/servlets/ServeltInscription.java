/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.text.ParseException;
import javax.ejb.EJB;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilisateurs.gestionnaires.GestionnaireEnseignants;
import utilisateurs.gestionnaires.GestionnaireEntreprises;
import utilisateurs.gestionnaires.GestionnaireEtudiants;
import utilisateurs.modeles.Enseignant;
import utilisateurs.modeles.Entreprise;
import utilisateurs.modeles.Etudiant;
import utilisateurs.modeles.Utilisateur;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    @EJB
    private GestionnaireEtudiants gestionnaireEtudiants;

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
        String etape = request.getParameter("etape");
        String fowardTo = "inscription.jsp";
        if (etape != null && etape.equals("verificationEmail")) {
            String email = request.getParameter("email");
            if (gestionnaireEnseignants.selectEnseignant(email) != null || gestionnaireEntreprises.selectEntreprise(email) != null || gestionnaireEtudiants.selectEtudiant(email) != null) {
                response.setStatus(500);
            }
        } else {
            String message = "Bienvenu dans la page d'inscription";
            Utilisateur user = (Utilisateur) request.getSession().getAttribute("utilisateur");
            if (user != null) {
                request.setAttribute("utilisateur", user);
            }
            request.setAttribute("etape", "etape1");
            request.setAttribute("message", message);
        }

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
                request.getSession().setAttribute("categorie", "entreprise");
                request.setAttribute("categorie", "entreprise");
            } else if (categorie.equals("enseignant")) {
                user = new Enseignant(nom, prenom, mdp, email);
                gestionnaireEnseignants.insererEnseignant((Enseignant) user);
                request.getSession().setAttribute("connexion", true);
                fowardTo = "Accueil";
            } else {
                user = new Etudiant(email, nom, prenom, mdp);
                request.getSession().setAttribute("categorie", "etudiant");
                request.setAttribute("categorie", "etudiant");
            }
            request.setAttribute("etape", "etape2");
            request.getSession().setAttribute("utilisateur", user);
        } else if (etape.equals("etape2")) {
            user = (Utilisateur) request.getSession().getAttribute("utilisateur");
            if (user.getClass().getName().equals("utilisateurs.modeles.Entreprise")) {
                Entreprise entreprise = (Entreprise) user;
                entreprise.setFonction(request.getParameter("function"));
                entreprise.setTel(request.getParameter("tel"));
                entreprise.setNomEntreprise(request.getParameter("nomEntreprise"));
                entreprise.setSecteurActiviteEntreprise(request.getParameter("secteurActivite"));
                gestionnaireEntreprises.insererEntreprise(entreprise);
                request.getSession().setAttribute("utilisateur", entreprise);
            } else {
                Etudiant etudiant = (Etudiant) user;
                etudiant.setAncien(request.getParameter("ancien") != null);
                etudiant.setVilEtu(request.getParameter("miage"));
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                Date date;
                try {
                    date = formatter.parse(request.getParameter("date"));
                    etudiant.setDateNaissance(date);
                } catch (ParseException ex) {
                    Logger.getLogger(ServeltInscription.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("photo : " + request.getParameter("photo"));
                etudiant.setImage(request.getParameter("photo").getBytes());
                gestionnaireEtudiants.insererEtudiant(etudiant);
                request.getSession().setAttribute("utilisateur", etudiant);
            }
            request.getSession().setAttribute("connexion", true);
            fowardTo = "Accueil";
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
