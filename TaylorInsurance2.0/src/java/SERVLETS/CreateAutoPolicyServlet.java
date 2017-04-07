/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import BEANS.BusinessProcessObjects.BusinessProcessManager;
import BEANS.InfoObjects.Customer;
import BEANS.PolicyObjects.Policy;
import BEANS.PolicyObjects.VehicleQuote;
import DAO.PolicyDAO;
import DAO.QuoteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author timbo
 */
public class CreateAutoPolicyServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

        BusinessProcessManager newBusinessProcessManager = (BusinessProcessManager) (request.getSession(false).getAttribute("BusinessProcessManager"));
        String AutoQuoteID = (String) (request.getSession(false).getAttribute("currentsessionAutoQuoteID"));
       System.out.println("CreateAutoPolicyServlet QuoteID: " + AutoQuoteID);
        newBusinessProcessManager.createNewVehiclePolicy(AutoQuoteID);
        
        HttpSession session = request.getSession(true);
        session.setAttribute("BusinessProcessManager", newBusinessProcessManager);
        response.sendRedirect("userprofile.jsp"); //logged-in page  
    }
}
