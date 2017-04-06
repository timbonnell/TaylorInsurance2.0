/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEANS.InfoObjects.Customer;
import BEANS.InfoObjects.House;
import BEANS.InfoObjects.Vehicle;
import BEANS.PolicyObjects.HouseQuote;
import BEANS.PolicyObjects.VehicleQuote;
import static DAO.QuoteDAO.connection;
import SERVLETS.ConnectionManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author timbo
 */
public class QuoteDAO {

    static Connection connection = null;
    static ResultSet rs = null;
    static PreparedStatement ps;

    public static HouseQuote createHouseQuote(HouseQuote houseQuote) {
        String SPsql = "EXEC insertHomeQuote ?,?,?,?,?";
        Date exDate = java.sql.Date.valueOf(LocalDate.now().plusDays(30));
        Date createDate = java.sql.Date.valueOf(LocalDate.now());
        try {
            connection = ConnectionManager.getConnection();
            ps = connection.prepareStatement(SPsql);
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
            //Set up params for stored procedure
            ps.setInt(1, Integer.parseInt(houseQuote.getClient().getId()));
            ps.setInt(2, Integer.parseInt(houseQuote.getProperty().getHouseId()));
            ps.setDouble(3, houseQuote.getTotalPremium());
            ps.setDate(4, createDate);
            ps.setDate(5, exDate);

            boolean more = ps.execute();
            more = ps.getMoreResults();
            rs = ps.getResultSet();
            more = rs.next();
            System.out.println(more);
            //Checks to see if house id comes back (house was stored successfully)
            if (!more) {
                System.out.println(rs + "invalid");

            } // If username and password are correct, set client to valid and set up the client
            else if (more) {
                rs = ps.getResultSet();
                System.out.println("House Quote ID: " + rs.getString(1));
                houseQuote.setId(rs.getString(1));
            }

        } catch (NumberFormatException | SQLException ex) {
            System.out.println("Insert House Quote Failed: An Exception has occurred! " + ex);
        } //Exception handling and closing
        finally {
            //Close DB Connections
            ConnectionManager.Dispose(connection, rs, ps);
        }
        return houseQuote;
    }

    public static VehicleQuote createVehicleQuote(VehicleQuote vehicleQuote, int accidents) {
        String SPsql = "EXEC insertAutoQuote ?,?,?,?,?,?";
        Date exDate = java.sql.Date.valueOf(LocalDate.now().plusDays(30));
        Date createDate = java.sql.Date.valueOf(LocalDate.now());
        try {
            connection = ConnectionManager.getConnection();
            ps = connection.prepareStatement(SPsql);
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);

            System.out.println("Create VEhicle QUote" + vehicleQuote.getProperty().getVehicleId());

            //Set up params for stored procedure
            ps.setInt(1, Integer.parseInt(vehicleQuote.getClient().getId()));
            ps.setString(2, vehicleQuote.getProperty().getVehicleId());
            ps.setDouble(3, vehicleQuote.getTotalPremium());
            ps.setDate(4, createDate);
            ps.setDate(5, exDate);
            ps.setInt(6, accidents);

            boolean more = ps.execute();
            more = ps.getMoreResults();
            rs = ps.getResultSet();
            more = rs.next();
            System.out.println(more);
            //Checks to see if house id comes back (house was stored successfully)
            if (!more) {
                System.out.println(rs + "invalid");

            } // If username and password are correct, set client to valid and set up the client
            else if (more) {
                rs = ps.getResultSet();
                System.out.println("Vehicle Quote ID: " + rs.getString(1));
                vehicleQuote.setId(rs.getString(1));
            }
        } catch (Exception ex) {
            System.out.println("Insert Vehicle Quote Failed: An Exception has occurred! " + ex);
        } //Exception handling and closing
        finally {
            //Close DB Connections
            ConnectionManager.Dispose(connection, rs, ps);
        }
        return vehicleQuote;
    }

    public static List<Integer> getHomeQuoteIDbyCustomerID(Customer client) {

        List<Integer> QuoteIDS = new ArrayList<Integer>();
        int CustomerID = Integer.parseInt(client.getId());
        String SPsql = "EXEC getQuoteByCustomerId ?";

        try {
            connection = ConnectionManager.getConnection();
            //stmt = connection.createStatement();
            ps = connection.prepareStatement(SPsql);
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
            //Set up params for stored procedure
            ps.setInt(1, CustomerID);
            //Return sp into a result set
            rs = ps.executeQuery();
            //If the customer doesnt have any quotes 
            if (!rs.next()) {
                System.out.println("No Quotes Found");
            } else {
                do {
                    if (rs.getInt("quote_type") == 15) {
                        QuoteIDS.add(rs.getInt("quote_id"));
                    }
                } while (rs.next());
            }
        } catch (Exception ex) {
            System.out.println("An Exception has occurred! " + ex);
        } //Exception handling and closing
        finally {
            //Close DB Connections
            ConnectionManager.Dispose(connection, rs, ps);
        }
        System.out.println("HomeQuote IDS:" + QuoteIDS);
        return QuoteIDS;
    }

    public static List<Integer> getAutoQuoteIDbyCustomerID(Customer client) {

        List<Integer> QuoteIDS = new ArrayList<Integer>();
        int CustomerID = Integer.parseInt(client.getId());
        String SPsql = "EXEC getQuoteByCustomerId ?";

        try {
            connection = ConnectionManager.getConnection();
            ps = connection.prepareStatement(SPsql);
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
            ps.setInt(1, CustomerID);
            //Return sp into a result set
            rs = ps.executeQuery();
            //If the customer doesnt have any quotes 
            if (!rs.next()) {
                System.out.println("No Quotes Found");
            } else {
                do {
                    if (rs.getInt("quote_type") == 14) {
                        QuoteIDS.add(rs.getInt("quote_id"));
                    }
                } while (rs.next());
            }
        } catch (Exception ex) {
            System.out.println("An Exception has occurred! " + ex);
        } //Exception handling and closing
        finally {
            //Close DB Connections
            ConnectionManager.Dispose(connection, rs, ps);
        }
        System.out.println("AutoQuote IDS:" + QuoteIDS);
        return QuoteIDS;
    }

    public static String getHouseQuote(int QuoteID) {
        String returnResult = "";
        String SPsql = "EXEC getHomeQuoteByQuoteId ?";
        System.out.println(QuoteID);
        try {
            connection = ConnectionManager.getConnection();
            //stmt = connection.createStatement();
            ps = connection.prepareStatement(SPsql);
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
            //Set up params for stored procedure
            ps.setInt(1, QuoteID);
            //Return sp into a result set
            rs = ps.executeQuery();
            while (rs.next()) {
                returnResult = "Quote ID: " + rs.getInt("quote_id") + "<br>" + "Premium: $" + rs.getDouble("quote_rate") + "<br>" + "Expiration Date: " + rs.getDate("date_expired");
            }
        } catch (SQLException ex) {
            System.out.println("Retreive Quote has failed for customer id: " + QuoteID + " reason: " + ex);
            Logger.getLogger(QuoteDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            //Close DB Connections
            ConnectionManager.Dispose(connection, rs, ps);
        }
        System.out.println(returnResult);
        return returnResult;
    }

    public static String getVehicleQuote(int QuoteID) {
        String returnResult = "";
        Statement stmt = null;
        String sql = "SELECT * FROM auto_quote WHERE quote_id = " + QuoteID;
        try {
            connection = ConnectionManager.getConnection();
            stmt = connection.createStatement();
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                returnResult = "Quote ID: " + rs.getInt("quote_id") + "<br>" + "Premium: $" + rs.getDouble("quote_rate") + "<br>" + "Expiration Date: " + rs.getDate("date_expired");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuoteDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Retreive Quote has failed for customer id: " + QuoteID + " reason: " + ex);
        } finally {
            //Close DB Connections
            ConnectionManager.Dispose(connection, rs, ps);
        }
        return returnResult;
    }

}
