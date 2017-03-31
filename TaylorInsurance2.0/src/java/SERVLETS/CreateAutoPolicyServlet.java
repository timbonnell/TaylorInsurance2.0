/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import BEANS.InfoObjects.Customer;
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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        List<Integer> HomeQuoteIDS = new ArrayList<Integer>();
        List<Integer> AutoQuoteIDS = new ArrayList<Integer>();
        List<Integer> HomePolicyIDS = new ArrayList<Integer>();
        List<Integer> AutoPolicyIDS = new ArrayList<Integer>();

        int autoQuoteID = (int) (request.getSession(false).getAttribute("currentsessionAutoQuoteID"));
        int result = PolicyDAO.acceptAutoPolicy(autoQuoteID);
        System.out.println("Customer ID for Auto Policy Post" + result);

        Customer client = (Customer) (request.getSession(false).getAttribute("currentSessionClient"));
        //Quote IDS for Dropdown List
        HomeQuoteIDS = QuoteDAO.getHomeQuoteIDbyCustomerID(client);
        AutoQuoteIDS = QuoteDAO.getAutoQuoteIDbyCustomerID(client);

        HomePolicyIDS = PolicyDAO.getHomePolicyByCustomerId(client);
        AutoPolicyIDS = PolicyDAO.getAutoPolicyByCustomerId(client);

        HttpSession session = request.getSession(true);
        HttpSession sessionHomeQuoteID = request.getSession(true);
        HttpSession sessionAutoQuoteID = request.getSession(true);
        HttpSession sessionAutoPolicyID = request.getSession(true);
        HttpSession sessionHomePolicyID = request.getSession(true);

        session.setAttribute("currentSessionClient", client);

        sessionHomeQuoteID.setAttribute("currentHomeQuoteID", HomeQuoteIDS);
        sessionAutoQuoteID.setAttribute("currentAutoQuoteID", AutoQuoteIDS);

        sessionHomePolicyID.setAttribute("currentHomePolicyID", HomePolicyIDS);
        sessionAutoPolicyID.setAttribute("currentAutoPolicyID", AutoPolicyIDS);
        response.sendRedirect("userprofile.jsp"); //logged-in page  
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
        processRequest(request, response);
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
