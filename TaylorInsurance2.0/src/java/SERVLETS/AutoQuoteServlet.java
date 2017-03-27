/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import BEANS.InfoObjects.Address;
import BEANS.InfoObjects.Customer;
import BEANS.InfoObjects.Vehicle;
import BEANS.PolicyObjects.Quote;
import BEANS.PolicyObjects.VehicleQuote;
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
public class AutoQuoteServlet extends HttpServlet {

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
            out.println("<title>Servlet AutoQuoteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AutoQuoteServlet at " + request.getContextPath() + "</h1>");
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
        System.out.println("doGet function of AutoQuoteServlet has begun execution");
        // Build a vehicle object (Year, Make, Model)
        Vehicle quoteVehicle = new Vehicle();
        quoteVehicle.setMake(request.getParameter("make"));
        System.out.println("Make: " + request.getParameter("make"));
        quoteVehicle.setYear(Integer.parseInt(request.getParameter("year"))); // May need to fix this later
        System.out.println("Year: " + request.getParameter("year"));
        quoteVehicle.setModel(request.getParameter("model"));
        System.out.println("Model: " + request.getParameter("model"));
        
        // Build a Customer object
        Customer quoteCustomer = new Customer();
        
        quoteCustomer.setFirstName(request.getParameter("firstName"));
        System.out.println("First Name: " + request.getParameter("firstName"));
        quoteCustomer.setLastName(request.getParameter("lastName"));
        System.out.println("Last Name: " + request.getParameter("lastName"));
        quoteCustomer.setEmail(request.getParameter("email"));
        System.out.println("Email: " + request.getParameter("email"));
        
        String enteredStreetAddress = request.getParameter("address");
        System.out.println("Street Address: " + enteredStreetAddress);
        String enteredCity = request.getParameter("city");
        System.out.println("City: " + enteredCity);
        String enteredProvince = request.getParameter("province");
        System.out.println("Province: " + enteredProvince);
        String enteredCountry = request.getParameter("country");
        System.out.println("Country: " + enteredCountry);
        String enteredPostalCode = request.getParameter("postalcode");
        System.out.println("Postal Code: " + enteredPostalCode);
        String enteredDateOfBirth = request.getParameter("dateofbirth");
        System.out.println("Date of Birth: " + enteredDateOfBirth);
        String[] splitDate = enteredDateOfBirth.split("-");
        
        System.out.println("Values in split date are: " + 
                splitDate[0] + " " + splitDate[1] + " " + splitDate[2]);
        int yearInt = Integer.parseInt(splitDate[0]);
        int monthInt = Integer.parseInt(splitDate[1]);
        int dayInt = Integer.parseInt(splitDate[2]);
        LocalDate localDateBirth = LocalDate.of(yearInt, monthInt, dayInt);
        
        quoteCustomer.setBirthDate(localDateBirth);
        Address address = new Address(enteredCity, enteredProvince, enteredStreetAddress, enteredCountry, enteredPostalCode);
        quoteCustomer.setAddress(address);
        
        String enteredAccidents = request.getParameter("accidents");
        System.out.println("Number of Accidents: " + enteredAccidents); // Where does this go? TODO
        
        VehicleQuote vehicleQuote = new VehicleQuote("0", LocalDate.now(), quoteCustomer, quoteVehicle);

          //Set up sessions
          HttpSession sessionClient = request.getSession(true);
          HttpSession sessionVehicle = request.getSession(true);
          HttpSession sessionVehicleQuote = request.getSession(true);
        
          sessionClient.setAttribute("currentSessionClient",quoteCustomer); 
          sessionVehicle.setAttribute("currentSessionVehicle", quoteVehicle);
          sessionVehicleQuote.setAttribute("currentSessionVehicleQuote", vehicleQuote);
        
          System.out.println("Vehicle Premium:  $" + vehicleQuote.getTotalPremium());
       
                
        response.sendRedirect("AutoQuoteResult.jsp"); 
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
