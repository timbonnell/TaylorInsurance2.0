/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import BEANS.InfoObjects.Customer;
import DAO.CustomerDAO;
import DAO.QuoteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tim
 */
public class CreateCustomerServlet extends HttpServlet {

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

        Customer client = (Customer) request.getSession(false).getAttribute("currentSessionClient");
        client.setPassword(request.getParameter("password"));

        CustomerDAO.register(client);

        client = CustomerDAO.login(client);

        if (client.isValid()) {
            System.out.println("Login good");
            Map<Integer, Integer> map = QuoteDAO.getQuoteIDbyCustomerID(client);
            boolean val = map.isEmpty();
            System.out.println("Map Empty: " + val);

            for (Entry<Integer, Integer> maps : map.entrySet()) {
                System.out.println(maps.getKey());
                System.out.println(maps.getValue());
            }

            HttpSession session = request.getSession(true);
            HttpSession sessionQuoteID = request.getSession(true);

            sessionQuoteID.setAttribute("currentQuoteID", map);
            session.setAttribute("currentSessionClient", client);
            response.sendRedirect("userprofile.jsp"); //logged-in page      		
        } else {
            response.sendRedirect("invalidLogin.jsp"); //error page 
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
