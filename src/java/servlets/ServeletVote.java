/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilisateurs.gestionnaires.GestionnaireTshirt;
import utilisateurs.gestionnaires.GestionnaireVote;
import utilisateurs.modeles.Tshirt;
import utilisateurs.modeles.Utilisateur;

/**
 *
 * @author Aicha
 */
@WebServlet(name = "ServeletVote", urlPatterns = {"/Vote"})
public class ServeletVote extends MaServlet {

    @EJB
    private GestionnaireVote gestionnaireVote;
     @EJB
    private GestionnaireTshirt gestionnaireTshirt;

    @Override
    protected void processRequestGetCo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processRequestPostCo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forwardTo = "classementVote.jsp";
        String message = "Resultat vote";

        int id = Integer.parseInt(request.getParameter("typeTshirt"));
        Utilisateur user = (Utilisateur) request.getSession().getAttribute("utilisateur");
        Tshirt t = gestionnaireVote.getTshirt(id);
        gestionnaireVote.creeVote(t, user);
        int result = gestionnaireVote.compterVote(id);
        Collection<Tshirt> listshirt = gestionnaireTshirt.getTshirtConcour();
        
        request.setAttribute("voteTotal", result);
        
        
        request.setAttribute("utilisateur", user);
        request.setAttribute("tshirt",listshirt);
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
