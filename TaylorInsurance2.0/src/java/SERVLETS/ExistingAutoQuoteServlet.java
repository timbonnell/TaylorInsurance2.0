/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import BEANS.InfoObjects.Customer;
import BEANS.InfoObjects.Vehicle;
import BEANS.PolicyObjects.VehicleQuote;
import DAO.QuoteDAO;
import DAO.VehicleDAO;
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
public class ExistingAutoQuoteServlet extends HttpServlet {

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

        Customer newCustomer = (Customer) (request.getSession(false).getAttribute("currentSessionClient"));

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

        VehicleQuote vehicleQuote = new VehicleQuote("0", LocalDate.now(), newCustomer, quoteVehicle);

        //Store Objects in Database
        Vehicle newQuoteVehicle = VehicleDAO.createVehicle(quoteVehicle);
        VehicleQuote newVehicleQuote = QuoteDAO.createVehicleQuote(newCustomer, newQuoteVehicle, vehicleQuote);

        //Set up sessions
        HttpSession sessionClient = request.getSession(true);
        HttpSession sessionVehicle = request.getSession(true);
        HttpSession sessionVehicleQuote = request.getSession(true);

        sessionClient.setAttribute("currentSessionClient", newCustomer);
        sessionVehicle.setAttribute("currentSessionVehicle", quoteVehicle);
        sessionVehicleQuote.setAttribute("currentSessionVehicleQuote", newVehicleQuote);

        System.out.println("Vehicle Premium:  $" + vehicleQuote.getTotalPremium());

        response.sendRedirect("userprofile.jsp");

    }

}