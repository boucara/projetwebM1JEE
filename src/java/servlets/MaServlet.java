/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tom
 */
public abstract class MaServlet extends HttpServlet {

    protected abstract void processRequestGetCo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    
    protected abstract void processRequestPostCo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected abstract void processRequestGetDeco(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    
    protected abstract void processRequestPostDeco(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

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
        try {
            boolean testconnexion = false;
            if(request.getSession().getAttribute("connexion") != null)
            {
                testconnexion = (boolean) request.getSession().getAttribute("connexion");
            }
            if (testconnexion) {
                processRequestGetCo(request, response);
            }else{
                processRequestGetDeco(request, response);
            }
        } catch (ServletException ex) {
            System.err.println("Erreur get : " + ex);
        } catch (IOException ex) {
            System.err.println("Erreur get : " + ex);
        }
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

        try {
            boolean testconnexion = false;
            if(request.getSession().getAttribute("connexion") != null)
            {
                testconnexion = (boolean) request.getSession().getAttribute("connexion");
            }
            if (testconnexion) {
                processRequestPostCo(request, response);
            }else{
                processRequestPostDeco(request, response);
            }
        } catch (ServletException ex) {
            System.err.println("Erreur post : " + ex);
        } catch (IOException ex) {
            System.err.println("Erreur post : " + ex);
        }
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
