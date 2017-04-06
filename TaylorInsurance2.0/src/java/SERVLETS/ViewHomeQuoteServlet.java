/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import BEANS.BusinessProcessObjects.BusinessProcessManager;
import DAO.QuoteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tim
 */
public class ViewHomeQuoteServlet extends HttpServlet {


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
        BusinessProcessManager newBusinessProcessManager = (BusinessProcessManager) (request.getSession(false).getAttribute("BusinessProcessManager"));
        String quoteID = (request.getParameter("homeQuotes"));
        
        //Set up sessions
        HttpSession session= request.getSession(true);
        session.setAttribute("BusinessProcessManager", newBusinessProcessManager);
        session.setAttribute("currentsessionHomeQuoteID", quoteID);
        
        response.sendRedirect("viewHomeQuote.jsp");
    }

}
