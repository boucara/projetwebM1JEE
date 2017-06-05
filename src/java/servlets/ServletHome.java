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
import utilisateurs.gestionnaires.GestionnaireBegin;
import utilisateurs.gestionnaires.GestionnaireEvent;
import utilisateurs.modeles.Event;
import utilisateurs.modeles.Utilisateur;

/**
 *
 * @author Tom
 */
@WebServlet(name = "ServletHome", urlPatterns = {"/Accueil"})
public class ServletHome extends MaServlet {
    @EJB
    private GestionnaireEvent gestionnaireEvents;    
    @EJB
    private GestionnaireBegin gestionnaireBegin;
    
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
        
        Utilisateur user = (Utilisateur) request.getSession().getAttribute("utilisateur");
        request.setAttribute("utilisateur", user);
        request.setAttribute("connexion", true);
        request.setAttribute("message", "Hello " + user.getPrenom());
        request.setAttribute("events", getEvents(request));
        RequestDispatcher dp = request.getRequestDispatcher("home.jsp");
        dp.forward(request, response);
    }

    @Override
    protected void processRequestPostCo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utilisateur user = (Utilisateur) request.getSession().getAttribute("utilisateur");
        request.setAttribute("utilisateur", user);
        request.setAttribute("connexion", true);
        request.setAttribute("message", "Hello " + user.getPrenom());
        request.setAttribute("events", getEvents(request));
        RequestDispatcher dp = request.getRequestDispatcher("home.jsp");
        dp.forward(request, response);
    }

    @Override
    protected void processRequestGetDeco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message", "Hello World");
        request.setAttribute("events", getEvents(request));
        RequestDispatcher dp = request.getRequestDispatcher("home.jsp");
        dp.forward(request, response);
    }

    @Override
    protected void processRequestPostDeco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message", "Hello World");
        request.setAttribute("events", getEvents(request));
        RequestDispatcher dp = request.getRequestDispatcher("home.jsp");
        dp.forward(request, response);
    }

    private Collection<Event> getEvents(HttpServletRequest request) {
        int pagination = 0;
        if (request.getParameter("pagination") != null) {
            pagination = Integer.parseInt(request.getParameter("pagination"));
        }
        request.setAttribute("pagination", pagination);
        request.setAttribute("nombreEvents", gestionnaireEvents.getNumberEvents());
        return gestionnaireEvents.selectEvents(pagination);
    }
}
