/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aicha
 */
@WebServlet(name = "ServeletInformation", urlPatterns = {"/DesInformation"})
public class ServeletInformation extends MaServlet {

    @Override
    protected void processRequestGetCo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         String action = request.getParameter("action");
        String forwardTo = "information.jsp";
        String message = "";
        if (action != null) {
            if (action.equals("info")) {
                forwardTo = "information.jsp";
                message = "Bienvenue! sur la page d'information";

            }
        }
        
      
        
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo);  
        dp.forward(request, response);
        
        

    }

    @Override
    protected void processRequestPostCo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void processRequestGetDeco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        
    }

    @Override
    protected void processRequestPostDeco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        String action = request.getParameter("action");
        String forwardTo = "information.jsp";
        String message = "";
        if (action != null) {
            if (action.equals("info")) {
                forwardTo = "information.jsp";
                message = "Bienvenue! sur la page d'information";

            }
        }
        
      
        
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo);  
        dp.forward(request, response);
    }
}
