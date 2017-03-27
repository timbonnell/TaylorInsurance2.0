/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import BEANS.InfoObjects.House;
import BEANS.InfoObjects.Address;
import BEANS.InfoObjects.Customer;
import BEANS.PolicyObjects.HouseQuote;
import BEANS.PolicyObjects.Quote;
import DAO.CustomerDAO;
import DAO.QuoteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tim
 */
public class HomeQuoteServlet extends HttpServlet {

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

        // Set up customer information
        Customer client = new Customer();
        client.setFirstName(request.getParameter("firstName"));
        client.setLastName(request.getParameter("lastName"));
        client.setEmail(request.getParameter("email"));
        client.setPhoneNumber(request.getParameter("phone"));

        //Set up customer Address
        Address address = new Address(request.getParameter("city"),
                request.getParameter("province"),
                request.getParameter("address"),
                request.getParameter("country"),
                request.getParameter("postal"));

        client.setAddress(address);

        CustomerDAO.create(client);

        //Creates House Object
        House newHouse = new House();
        newHouse.setHeating(Integer.parseInt(request.getParameter("heatsource")));
        newHouse.setType(Integer.parseInt(request.getParameter("building")));
        newHouse.setYear(Integer.parseInt(request.getParameter("yearBuilt")));
        newHouse.setAddress(address);

        //Create a House Quote
        HouseQuote houseQuote = new HouseQuote("0", LocalDate.now(), client, newHouse);
        
        //Set up sessions
          HttpSession sessionClient = request.getSession(true);
          HttpSession sessionHouse = request.getSession(true);
          HttpSession sessionHouseQuote = request.getSession(true);	 
         
          sessionClient.setAttribute("currentSessionClient",client); 
          sessionHouse.setAttribute("currentSessionHouse", newHouse);
          sessionHouseQuote.setAttribute("currentSessionHouseQuote", houseQuote);
          
          QuoteDAO.createHouseQuote(client, newHouse, houseQuote);
          
          
          
        
        
        //Redirects to Create Customer Page
        response.sendRedirect("HomeQuoteResult.jsp");


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