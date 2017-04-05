/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import BEANS.BusinessProcessObjects.BusinessProcessManager;
import BEANS.InfoObjects.Address;
import BEANS.InfoObjects.Customer;
import BEANS.InfoObjects.House;
import BEANS.PolicyObjects.HouseQuote;
import DAO.HouseDAO;
import DAO.PolicyDAO;
import DAO.QuoteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
        House newQuoteHouse = newBusinessProcessManager.createNewHouse(newHouse);
        HouseQuote houseQuote = newBusinessProcessManager.createNewHouseQuote(newQuoteHouse.getHouseId());

        //Set up sessions
        HttpSession session = request.getSession(true);
        session.setAttribute("BusinessProcessManager", newBusinessProcessManager);
        response.sendRedirect("existingHomeQuoteResult.jsp"); //logged-in page

    }

}
