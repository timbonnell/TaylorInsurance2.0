package DAO;


import SERVLETS.ConnectionManager;
import BEANS.Address;
import BEANS.Customer;
import java.text.*;
import java.util.*;
import java.sql.*;
import java.time.LocalDate;

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

    public static Customer login(Customer client) {
        //preparing some objects for connection 
        Statement stmt = null;

        String username = client.getEmail();
        String password = client.getPassword();

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
            connection = ConnectionManager.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            //Checks to see if user exists and will set the isValid variable to false if it does not exist
            if (!more) {
                System.out.println("Invalid Username or Password");
                client.setValid(false);
            } // If username and password are correct, set client to valid and set up the client
            else if (more) {

                // All of the gets
                String id = rs.getString("customer_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                //  LocalDate birthDate = rs.getDate(customer_birthdate);
                Address mailingAddress = new Address(rs.getString("customer_city"),
                        rs.getString("customer_province"),
                        rs.getString("customer_street"),
                        "Canada",
                        "A1A-1A1");
                //Address billingAddress;               
                String phoneNumber = rs.getString("customer_contact");

                // All of the sets
                client.setId(id);
                client.setFirstName(firstName);
                client.setLastName(lastName);
                client.setMailingAddress(mailingAddress);
                client.setPhoneNumber(phoneNumber);
                // Set client to valid
                client.setValid(true);
            }

        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } 
        //Exception handling and closing
        finally {
            //Result Set
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }
          //Statement
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }
          //Connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                }

                connection = null;
            }
        }

        return client;
    }
}
