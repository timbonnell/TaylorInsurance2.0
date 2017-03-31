/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import BEANS.InfoObjects.Address;
import BEANS.InfoObjects.Customer;
import BEANS.InfoObjects.House;
import BEANS.PolicyObjects.HouseQuote;
import DAO.HouseDAO;
import DAO.QuoteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tim
 */
public class ExistingHomeQuoteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
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
        Customer newCustomer = (Customer) (request.getSession(false).getAttribute("currentSessionClient"));
                //Set up customer Address
        Address address = new Address(request.getParameter("city"),
                request.getParameter("province"),
                request.getParameter("address"),
                request.getParameter("country"),
                request.getParameter("postal"));
        
        
        //Creates House Object
        House newHouse = new House();
        newHouse.setHeating(Integer.parseInt(request.getParameter("heatsource")));
        newHouse.setType(Integer.parseInt(request.getParameter("building")));
        newHouse.setYear(Integer.parseInt(request.getParameter("yearBuilt")));
        newHouse.setAddress(address);

        //Create a House Quote
        HouseQuote houseQuote = new HouseQuote("0", LocalDate.now(), newCustomer, newHouse);

        //Test Quote
        System.out.println("House Premium:  $" + houseQuote.getTotalPremium());

        //Store Objects in Database
        House newQuoteHouse = HouseDAO.createHouse(newHouse);


        HouseQuote newHouseQuote = QuoteDAO.createHouseQuote(newCustomer, newQuoteHouse, houseQuote);
        
        
        //Set up sessions
        HttpSession sessionClient = request.getSession(true);
        HttpSession sessionHouse = request.getSession(true);
        HttpSession sessionHouseQuote = request.getSession(true);

        sessionClient.setAttribute("currentSessionClient", newCustomer);
        sessionHouse.setAttribute("currentSessionHouse", newQuoteHouse);
        sessionHouseQuote.setAttribute("currentSessionHouseQuote", newHouseQuote);
        
        response.sendRedirect("userprofile.jsp"); //logged-in page
        
    }

}
