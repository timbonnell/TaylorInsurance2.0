/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEANS.InfoObjects.Customer;
import SERVLETS.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class PolicyDAO {

    static Connection connection = null;
    static ResultSet rs = null;
    static PreparedStatement ps;

    // Create Auto Policy
    public static int acceptAutoPolicy(int QuoteID) {
        int returnResult = 0;
        String SPsql = "EXEC acceptAutoPolicy ?";
        System.out.println("Accept Policy" + QuoteID);
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
             if(rs.next()){
            while (rs.next()) {
                returnResult = rs.getInt(1);
            }}
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


//Create Home Policy
public static int acceptHomePolicy(int QuoteID) {
        int returnResult = 0;
        String SPsql = "EXEC acceptHomePolicy ?";
        System.out.println("Accept Policy" + QuoteID);
        try {
            connection = ConnectionManager.getConnection();
            //stmt = connection.createStatement();
            ps = connection.prepareStatement(SPsql);
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
            //Set up params for stored procedure
            ps.setInt(1, QuoteID);
            //Return sp into a result set
             //boolean more = ps.execute();
             //more = ps.getMoreResults();
             rs = ps.executeQuery();
             if(rs.next()){
             while (rs.next()) {
                returnResult = rs.getInt(1);
            }}
        } catch (SQLException ex) {
            System.out.println("Retreive Quote has failed for customer id: " + QuoteID + " reason: " + ex);
            Logger

.getLogger(QuoteDAO.class
.getName()).log(Level.SEVERE, null, ex);

        } finally {
            //Close DB Connections
            ConnectionManager.Dispose(connection, rs, ps);
        }
        System.out.println("REturn Results" + returnResult);
        return returnResult;
    }

    public static List<Integer> getAutoPolicyByCustomerId(Customer client) {

        List<Integer> PolicyIDS = new ArrayList<Integer>();
        int CustomerID = Integer.parseInt(client.getId());
        String SPsql = "EXEC getPolicyByCustomerId ?";
        try {
            connection = ConnectionManager.getConnection();
            ps = connection.prepareStatement(SPsql);
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
            ps.setInt(1, CustomerID);
            //Return sp into a result set
            rs = ps.executeQuery();
            boolean more = rs.next();
            //If the customer doesnt have any quotes 
            if (!more) {
                System.out.println("No policies Found");
            } else {
                do {
                    if(rs.getInt("policy_type") == 14){
                    PolicyIDS.add(rs.getInt("policy_id"));
                    }
                } while (rs.next());
            }
        } catch (Exception ex) {
            System.out.println("getAutoPolicyByCustomerId has failed " + ex);
        } //Exception handling and closing
        finally {
            ConnectionManager.Dispose(connection, rs, ps);
        }
        return PolicyIDS;
    }

        public static List<Integer> getHomePolicyByCustomerId(Customer client) {

        List<Integer> PolicyIDS = new ArrayList<Integer>();
        int CustomerID = Integer.parseInt(client.getId());
        String SPsql = "EXEC getPolicyByCustomerId ?";
        try {
            connection = ConnectionManager.getConnection();
            ps = connection.prepareStatement(SPsql);
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
            ps.setInt(1, CustomerID);
            //Return sp into a result set
            rs = ps.executeQuery();
            boolean more = rs.next();
            //If the customer doesnt have any quotes 
            if (!more) {
                System.out.println("No policies Found");
            } else {
                do {
                    if(rs.getInt("policy_type") == 15){
                    PolicyIDS.add(rs.getInt("policy_id"));
                    }
                } while (rs.next());
            }
        } catch (Exception ex) {
            System.out.println("getHomePolicyByCustomerId has failed " + ex);
        } //Exception handling and closing
        finally {
            ConnectionManager.Dispose(connection, rs, ps);
        }
        return PolicyIDS;
    }
        
    public static String getHousePolicy(int policyID) {
                String returnResult = "";
        String SPsql = "EXEC getHomePolicyByPolicyId ?";
        System.out.println(policyID);
        try {
            connection = ConnectionManager.getConnection();
            //stmt = connection.createStatement();
            ps = connection.prepareStatement(SPsql);
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
            //Set up params for stored procedure
            ps.setInt(1, policyID);
            //Return sp into a result set
            rs = ps.executeQuery();
            while(rs.next()) {
                returnResult = "Home Policy ID: " + rs.getInt("policy_id") + "<br>" + "Annual Premium: $" + rs.getDouble("premium") + "<br>" + "Expiration Date: " + rs.getDate("date_expired");
            }
        } catch (SQLException ex) {
            System.out.println("Retreive Home Policy has failed for customer id: " + policyID + " reason: " + ex);
            Logger.getLogger(QuoteDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            //Close DB Connections
            ConnectionManager.Dispose(connection, rs, ps);
        }
        System.out.println(returnResult);
        return returnResult;
    }

        public static String getAutoPolicy(int policyID) {
                String returnResult = "";
        String SPsql = "EXEC getAutoPolicyByPolicyId ?";
        System.out.println(policyID);
        try {
            connection = ConnectionManager.getConnection();
            //stmt = connection.createStatement();
            ps = connection.prepareStatement(SPsql);
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
            //Set up params for stored procedure
            ps.setInt(1, policyID);
            //Return sp into a result set
            rs = ps.executeQuery();
            while(rs.next()) {
                returnResult = " Auto Policy ID: " + rs.getInt("policy_id") + "<br>" + " Annual Premium: $" + rs.getDouble("premium") + "<br>" + " Expiration Date: " + rs.getDate("date_expired");
            }
        } catch (SQLException ex) {
            System.out.println("Retreive Auto Policy has failed for customer id: " + policyID + " reason: " + ex);
            Logger.getLogger(QuoteDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            //Close DB Connections
            ConnectionManager.Dispose(connection, rs, ps);
        }
        System.out.println(returnResult);
        return returnResult;
    }


}
