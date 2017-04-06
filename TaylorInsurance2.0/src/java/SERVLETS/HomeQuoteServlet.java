/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import BEANS.BusinessProcessObjects.BusinessProcessManager;
import BEANS.InfoObjects.House;
import BEANS.InfoObjects.Address;
import BEANS.InfoObjects.Customer;
import BEANS.PolicyObjects.HouseQuote;
import BEANS.PolicyObjects.Quote;
import DAO.CustomerDAO;
import DAO.HouseDAO;
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
        BusinessProcessManager newBusinessProcessManager = new BusinessProcessManager();
        
        // Set up customer information
        Customer client = new Customer();
        client.setFirstName(request.getParameter("firstName"));
        client.setLastName(request.getParameter("lastName"));
        client.setEmail(request.getParameter("email"));
        client.setPhoneNumber(request.getParameter("phone"));
        String enteredDateOfBirth = request.getParameter("dateofbirth");

        //Puts birthdate in correct format
        String[] splitDate = enteredDateOfBirth.split("-");

        int yearInt = Integer.parseInt(splitDate[0]);
        int monthInt = Integer.parseInt(splitDate[1]);
        int dayInt = Integer.parseInt(splitDate[2]);
        LocalDate localDateBirth = LocalDate.of(yearInt, monthInt, dayInt);

        client.setBirthDate(localDateBirth);

        //Set up customer Address
        Address address = new Address(request.getParameter("city"),
                request.getParameter("province"),
                request.getParameter("address"),
                request.getParameter("country"),
                request.getParameter("postal"));

        client.setAddress(address);

        //Store initial customer in database
        //Creates House Object
        House newHouse = new House();
        newHouse.setHeating(Integer.parseInt(request.getParameter("heatsource")));
        newHouse.setType(Integer.parseInt(request.getParameter("building")));
        newHouse.setYear(Integer.parseInt(request.getParameter("yearBuilt")));
        newHouse.setAddress(address);
         
        //Create a House Quote
        //HouseQuote houseQuote = new HouseQuote("0", LocalDate.now(), client, newHouse);
        newBusinessProcessManager.createNewCustomer(client);
        newHouse = newBusinessProcessManager.createNewHouse(newHouse);
        HouseQuote newHouseQuote = newBusinessProcessManager.createNewHouseQuote(newHouse.getHouseId());

       
        //Set up sessions
        HttpSession session = request.getSession(true);
        session.setAttribute("HouseID", newHouse.getHouseId());
        session.setAttribute("HouseQuoteID", newHouseQuote.getId());
        session.setAttribute("BusinessProcessManager", newBusinessProcessManager);
        //Redirects to Create Customer Page
        response.sendRedirect("HomeQuoteResult.jsp");

    }
}
