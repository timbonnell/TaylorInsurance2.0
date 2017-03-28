package DAO;

import SERVLETS.ConnectionManager;
import BEANS.InfoObjects.Address;
import BEANS.InfoObjects.Customer;
import static java.lang.Math.random;
import java.text.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tim
 */
public class CustomerDAO {

    static Connection connection = null;
    static ResultSet rs = null;
    static PreparedStatement ps;

    public static Customer login(Customer client) {
        //preparing some objects for connection 
        Statement stmt = null;

        String username = client.getEmail();
        String password = client.getPassword();

        //Needs to be changed to an SP
//        String searchQuery = "SELECT * FROM customer where email = '"
//                + username
//                + "' AND password = '"
//                + password + "';";
        String SPsql = "EXEC loginValidation ?,?";

        // Try to connect to database and login
        try {
            connection = ConnectionManager.getConnection();
            //stmt = connection.createStatement();
            ps = connection.prepareStatement(SPsql);
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();
            boolean more = rs.next();

            //Checks to see if user exists and will set the isValid variable to false if it does not exist
            if (!more) {
                System.out.println("Invalid Username or Password");
                client.setValid(false);
            } // If username and password are correct, set client to valid and set up the client
            else if (more) {

                // All of the gets
                String id = rs.getString("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                //  LocalDate birthDate = rs.getDate(customer_birthdate);
                Address mailingAddress = new Address(rs.getString("city"),
                        rs.getString("province"),
                        rs.getString("street"),
                        rs.getString("country"),
                        rs.getString("postalcode"));
                //Address billingAddress;               
                String phoneNumber = rs.getString("contact");

                // All of the sets
                client.setId(id);
                client.setFirstName(firstName);
                client.setLastName(lastName);
                client.setAddress(mailingAddress);
                client.setPhoneNumber(phoneNumber);
                // Set client to valid
                client.setValid(true);
            }

        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } //Exception handling and closing
        finally {
            //Close DB Connections
            ConnectionManager.Dispose(connection, rs, ps);
        }

        return client;
    }

    public static Customer createInit(Customer customer) {
        //preparing some objects for connection 
        Statement stmt = null;

        String email = customer.getEmail();
        String password = customer.getPassword();
        String first_name = customer.getFirstName();
        String last_name = customer.getLastName();

        //Handle city for database
        String city = customer.getAddress().getCity();
        if (city.contains("'")) {
            city = city.replaceAll("'", "''");
        }

        String province = customer.getAddress().getProvince();
        String street = customer.getAddress().getStreetAddress1();
        String country = customer.getAddress().getCountry();
        String postal = customer.getAddress().getPostalCode();
        LocalDate birthday = customer.getBirthDate();
        String contact = customer.getPhoneNumber();

        String SPsql = "EXEC insertCustomer ?,?,?,?,?,?,?,?,?,?";

        try {

            Date date = java.sql.Date.valueOf(birthday);

            connection = ConnectionManager.getConnection();
            ps = connection.prepareStatement(SPsql);
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
            //Set up params for the Stored Procedure
            ps.setString(1, first_name);
            ps.setString(2, last_name);
            ps.setString(3, email);
            ps.setString(4, street);
            ps.setString(5, city);
            ps.setString(6, province);
            ps.setString(7, postal);
            ps.setString(8, country);
            ps.setString(9, contact);
            ps.setDate(10, date);

            rs = ps.executeQuery();
            boolean more = rs.next();
            //Checks to see if user exists and will set the isValid variable to false if it does not exist
            if (!more) {
                System.out.println("Invalid Customer Creation");
                //customer.setValid(false);
            } // If username and password are correct, set client to valid and set up the client
            else if (more) {
                customer.setId((rs.getString(1)));
            }
            }catch (Exception ex) {
            System.out.println("Create user has failed: " + ex);
        }finally {
            //Close DB Connections
            ConnectionManager.Dispose(connection, rs, ps);
        }
            return customer;
        }

    }
