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
import SERVLETS.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
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

    public static void createHouseQuote(Customer Client, House house, HouseQuote houseQuote) {

    }

    public static void createVehicleQuote(Customer Client, Vehicle vehicle, VehicleQuote vehicleQuote) {

    }

    public static Map<Integer, Integer> getQuoteIDbyCustomerID(Customer client) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
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
            boolean more = rs.next();
            //If the customer doesnt have any quotes 
            if (!more) {
                System.out.println("No Quotes Found");
            } else {
                do {
                    map.put(rs.getInt("quote_type"), rs.getInt("quote_id"));
                } while (rs.next());
            }
        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } //Exception handling and closing
        finally {
            //Close DB Connections
            ConnectionManager.Dispose(connection, rs, ps);
        }
        boolean val = map.isEmpty();
        System.out.println("Initial Map Empty: " + val + CustomerID);
        return map;
    }

    public static String getHouseQuote(int QuoteID) {
        String returnResult = "";
        Statement stmt = null;
        String sql = "SELECT * FROM home_quote WHERE quote_id = " + QuoteID;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                returnResult = "Quote ID: " + rs.getInt("quote_id") + "<br>" + "Premium: $" + rs.getDouble("quote_rate") + "<br>" + "Expiration Date: " + rs.getDate("date_expired");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Close DB Connections
            ConnectionManager.Dispose(connection, rs, ps);
        }
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
        } finally {
            //Close DB Connections
            ConnectionManager.Dispose(connection, rs, ps);
        }
        return returnResult;
    }
}
