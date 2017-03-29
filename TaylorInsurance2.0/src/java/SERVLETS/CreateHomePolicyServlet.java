/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import BEANS.InfoObjects.Customer;
import BEANS.PolicyObjects.HouseQuote;
import DAO.PolicyDAO;
import DAO.QuoteDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
public class CreateHomePolicyServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateHomePolicyServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateHomePolicyServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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

        int houseQuoteID = (int) (request.getSession(false).getAttribute("currentsessionHomeQuoteID"));
        int result = PolicyDAO.acceptHomePolicy((houseQuoteID));

        System.out.println(result);
        Customer client = (Customer) (request.getSession(false).getAttribute("currentSessionClient"));
        //Quote IDS for Dropdown List
        Map<Integer, Integer> map = QuoteDAO.getQuoteIDbyCustomerID(client);
        Map<Integer, Integer> mapPolicy = PolicyDAO.getPolicyByCustomerId(client);
        boolean val = map.isEmpty();
        System.out.println("Quote Map Empty: " + val);
        boolean valPolicy = mapPolicy.isEmpty();
        System.out.println("Policy Map Empty: " + valPolicy);
        //Policy IDS for Dropdown List

        HttpSession session = request.getSession(true);
        HttpSession sessionQuoteID = request.getSession(true);
        HttpSession sessionPolicyID = request.getSession(true);

        session.setAttribute("currentSessionClient", client);

        sessionQuoteID.setAttribute("currentQuoteID", map);

        sessionPolicyID.setAttribute("currentPolicyID", mapPolicy);
        response.sendRedirect("userprofile.jsp"); //logged-in page  
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
