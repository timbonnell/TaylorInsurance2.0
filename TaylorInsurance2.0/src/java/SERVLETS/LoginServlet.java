package SERVLETS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import BEANS.BusinessProcessObjects.BusinessProcessManager;
import DAO.CustomerDAO;
import BEANS.InfoObjects.Customer;
import DAO.PolicyDAO;
import DAO.QuoteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tim
 */
public class LoginServlet extends HttpServlet {


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
        BusinessProcessManager newBusinessProcessManager = new BusinessProcessManager();
        try {
            Customer client = new Customer();
            client.setEmail(request.getParameter("inputEmail"));
            client.setPassword(request.getParameter("inputPassword"));
            client = CustomerDAO.login(client);
            newBusinessProcessManager.setCustomer(client);
            
            if (client.isValid()) {
                newBusinessProcessManager.loadAllCustomerInformation();
                System.out.println("Login good");
                HttpSession session = request.getSession(true);
                session.setAttribute("BusinessProcessManager", newBusinessProcessManager);
                response.sendRedirect("userprofile.jsp"); //logged-in page      		
            } else {
                response.sendRedirect("invalidLogin.jsp"); //error page 
            }
        } catch (Throwable theException) {
            System.out.println(theException);
        }
    }

}
