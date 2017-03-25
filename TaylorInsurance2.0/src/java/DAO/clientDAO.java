package DAO;


import SERVLETS.ConnectionManager;
import BEANS.InfoObjects.Address;
import BEANS.InfoObjects.Customer;
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tim
 */
public class clientDAO {

    static Connection connection = null;
    static ResultSet rs = null;

    public static Customer login(Customer customer) {
        //preparing some objects for connection 
        Statement stmt = null;

        String username = customer.getEmail();
        String password = customer.getPassword();

        //Needs to be changed to an SP
        String searchQuery = "SELECT * FROM customer where customer_email = '"
                + username
                + "' AND customer_password = '"
                + password + "';";

        //Tracker Prints
        System.out.println("Your user name is " + username);
        System.out.println("Your password is " + password);
        System.out.println("Query: " + searchQuery);

        // Try to connect to database and login
        try {
            connection = ConnectionManager.getManager().getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            //Checks to see if user exists and will set the isValid variable to false if it does not exist
            if (!more) {
                System.out.println("Invalid Username or Password");
                customer.setValid(false);
            } // If username and password are correct, set customer to valid and set up the customer
            else if (more) {

                // All of the gets
                String id = rs.getString("customer_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                //  LocalDate birthDate = rs.getDate(customer_birthdate);
                Address address = new Address(rs.getString("customer_city"),
                        rs.getString("customer_province"),
                        rs.getString("customer_street"),
                        "Canada",
                        "A1A-1A1");
                //Address billingAddress;               
                String phoneNumber = rs.getString("customer_contact");

                // All of the sets
                customer.setId(id);
                customer.setFirstName(firstName);
                customer.setLastName(lastName);
                customer.setAddress(address);
                customer.setPhoneNumber(phoneNumber);
                // Set customer to valid
                customer.setValid(true);
            }

        } catch (SQLException ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } 
        //Exception handling and closing
        finally {
            //Result Set
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                rs = null;
            }
          //Statement
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                }
                stmt = null;
            }
          //Connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }

                connection = null;
            }
        }

        return customer;
    }
}
