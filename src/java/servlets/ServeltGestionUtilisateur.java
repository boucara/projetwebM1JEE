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
import utilisateurs.modeles.Etudiant;

/**
 *
 * @author Tom
 */
@WebServlet(name = "ServeltGestionUtilisateur", urlPatterns = {"/GestionUtilisateur"})
public class ServeltGestionUtilisateur extends MaServlet {

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
        if (request.getSession().getAttribute("admin") != null && (boolean) request.getSession().getAttribute("admin")) {
            request.setAttribute("admin", true);
            String forwardTo = "gestionUtilisateur.jsp";
            int pagination = 0;
            if (request.getParameter("pagination") != null) {
                pagination = Integer.parseInt(request.getParameter("pagination"));
            }
            String action = request.getParameter("action");
            if(action != null){
                if(action.equals("deleteEtudiant")){
                    int idEtud = Integer.parseInt(request.getParameter("idEtudiant"));
                    gestionnaireEtudiants.deleteEtudiant(idEtud);
                }
            }
            request.setAttribute("action", "listerLesEtudiants");
            request.setAttribute("listeEtudiants", gestionnaireEtudiants.getAllUsers(pagination));
            request.setAttribute("nombreEtudiants", gestionnaireEtudiants.getNumberUsers());
            request.setAttribute("pagination", pagination);
            RequestDispatcher dp = request.getRequestDispatcher(forwardTo);
            dp.forward(request, response);
        } else {
            String forwardTo = "Accueil";
            RequestDispatcher dp = request.getRequestDispatcher(forwardTo);
            dp.forward(request, response);
        }
    }

    @Override
    protected void processRequestPostDeco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("admin") != null && (boolean) request.getSession().getAttribute("admin")) {
            request.setAttribute("admin", true);
            String forwardTo = "gestionUtilisateur.jsp";
            int pagination = 0;
            if (request.getParameter("pagination") != null) {
                pagination = Integer.parseInt(request.getParameter("pagination"));
            }
            String action = request.getParameter("action");
            if(action != null){
                if(action.equals("ajouterEtudiant")){
                    String nom = request.getParameter("nom");
                    String prenom = request.getParameter("prenom");
                    String email = request.getParameter("email");
                    String vilEtud = request.getParameter("vilEtu");
                    String photo = request.getParameter("photo");
                    String pwd = request.getParameter("mdp");
                    Etudiant etud = new Etudiant(email, nom, prenom, pwd);
                    etud.setVilEtu(vilEtud);
                    etud.setImage(photo.getBytes());
                    gestionnaireEtudiants.insererEtudiant(etud);
                }else if(action.equals("updateEtudiant")){
                    String nom = request.getParameter("nom");
                    String prenom = request.getParameter("prenom");
                    String email = request.getParameter("email");
                    String vilEtud = request.getParameter("vilEtu");
                    gestionnaireEtudiants.modifEtudiant(nom, prenom, email, vilEtud);
                }
            }
            request.setAttribute("action", "listerLesEtudiants");
            request.setAttribute("listeEtudiants", gestionnaireEtudiants.getAllUsers(pagination));
            request.setAttribute("nombreEtudiants", gestionnaireEtudiants.getNumberUsers());
            request.setAttribute("pagination", pagination);
            RequestDispatcher dp = request.getRequestDispatcher(forwardTo);
            dp.forward(request, response);
        } else {
            String forwardTo = "Accueil";
            RequestDispatcher dp = request.getRequestDispatcher(forwardTo);
            dp.forward(request, response);
        }
    }

}
