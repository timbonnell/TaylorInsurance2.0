/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import BEANS.BusinessProcessObjects.BusinessProcessManager;
import BEANS.InfoObjects.Customer;
import BEANS.InfoObjects.Vehicle;
import BEANS.PolicyObjects.VehicleQuote;
import DAO.PolicyDAO;
import DAO.QuoteDAO;
import DAO.VehicleDAO;
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
public class ExistingAutoQuoteServlet extends HttpServlet {

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
        Customer newCustomer = newBusinessProcessManager.getCustomer();
        
        //Retreive Vehicle Attributes
        int vehicleType = Integer.parseInt(request.getParameter("type"));
        String vehicleMake = request.getParameter("make");
        String vehicleModel = request.getParameter("model");
        int vehicleYear = Integer.parseInt(request.getParameter("year"));
        int vehicleColor = Integer.parseInt(request.getParameter("color"));
        String vehicleVIN = request.getParameter("vin");
        int vehicleAccidents = Integer.parseInt(request.getParameter("accidents"));
        double estimatedValue = Double.parseDouble(request.getParameter("estValue"));

        //Build Birthday for Customer
        String enteredDateOfBirth = request.getParameter("dateofbirth");
        String[] splitDate = enteredDateOfBirth.split("-");
        int yearInt = Integer.parseInt(splitDate[0]);
        int monthInt = Integer.parseInt(splitDate[1]);
        int dayInt = Integer.parseInt(splitDate[2]);
        LocalDate localDateBirth = LocalDate.of(yearInt, monthInt, dayInt);
        newCustomer.setBirthDate(localDateBirth);

        //Build Vehicle Object
        Vehicle quoteVehicle = new Vehicle();
        quoteVehicle.setType(vehicleType);
        quoteVehicle.setMake(vehicleMake);
        quoteVehicle.setModel(vehicleModel);
        quoteVehicle.setYear(vehicleYear);
        quoteVehicle.setColor(vehicleColor);
        quoteVehicle.setVin(vehicleVIN);
        quoteVehicle.setNumAccidents(vehicleAccidents);
        quoteVehicle.setEstimated_value(estimatedValue);
        
        //Store Objects in Database
        Vehicle newQuoteVehicle = newBusinessProcessManager.createNewVehicle(quoteVehicle);
        VehicleQuote vehicleQuote = newBusinessProcessManager.createNewVehicleQuote(newQuoteVehicle.getVehicleId());
       

        //Set up sessions
        HttpSession session = request.getSession(true);
        session.setAttribute("BusinessProcessManager", BusinessProcessManager.getInstance());
        response.sendRedirect("existingAutoQuoteResult.jsp");

    }

}
