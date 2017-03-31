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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author timbo
 */
public class PolicyDAO {

    // Create Auto Policy
    public static int acceptAutoPolicy(int QuoteID) {
        int returnResult = 0;
        String SPsql = "EXEC acceptAutoPolicy ?";
        System.out.println("Accept Policy" + QuoteID);
        try (Connection con = ConnectionManager.getConnection();
                PreparedStatement ps = con.prepareStatement(SPsql)) {
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
            //Set up params for stored procedure
            ps.setInt(1, QuoteID);
            //Return sp into a result set
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                returnResult = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("Retreive Quote has failed for customer id: " + QuoteID + " reason: " + ex);
            Logger.getLogger(QuoteDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        System.out.println(returnResult);
        return returnResult;
    }

//Create Home Policy
    public static int acceptHomePolicy(int QuoteID) {
        int returnResult = 0;
        String SPsql = "EXEC acceptHomePolicy ?";
        System.out.println("Accept Policy" + QuoteID);
        try (Connection con = ConnectionManager.getConnection();
                PreparedStatement ps = con.prepareStatement(SPsql)) {
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
            //Set up params for stored procedure
            ps.setInt(1, QuoteID);
            //Return sp into a result set
            //boolean more = ps.execute();
            //more = ps.getMoreResults();
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                returnResult = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("Retreive Quote has failed for customer id: " + QuoteID + " reason: " + ex);
            Logger
                    .getLogger(QuoteDAO.class
                            .getName()).log(Level.SEVERE, null, ex);

        }
        System.out.println("Return Results" + returnResult);
        return returnResult;
    }

    public static List<Integer> getAutoPolicyByCustomerId(Customer client) {

        List<Integer> PolicyIDS = new ArrayList<>();
        int CustomerID = Integer.parseInt(client.getId());
        String SPsql = "EXEC getPolicyByCustomerId ?";
        try (Connection con = ConnectionManager.getConnection();
                PreparedStatement ps = con.prepareStatement(SPsql)) {
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
            ps.setInt(1, CustomerID);
            //Return sp into a result set
            ResultSet rs = ps.executeQuery();

            //If the customer doesnt have any quotes 
            if (!rs.next()) {
                System.out.println("No policies Found");
            } else {
                do {
                    if (rs.getInt("policy_type") == 14) {
                        PolicyIDS.add(rs.getInt("policy_id"));
                    }
                } while (rs.next());
            }
        } catch (SQLException ex) {
            System.out.println("getAutoPolicyByCustomerId has failed " + ex);
        }
        return PolicyIDS;
    }

    public static List<Integer> getHomePolicyByCustomerId(Customer client) {

        List<Integer> PolicyIDS = new ArrayList<>();
        int CustomerID = Integer.parseInt(client.getId());
        String SPsql = "EXEC getPolicyByCustomerId ?";
        try (Connection con = ConnectionManager.getConnection();
                PreparedStatement ps = con.prepareStatement(SPsql)) {
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
            ps.setInt(1, CustomerID);
            //Return sp into a result set
            ResultSet rs = ps.executeQuery();

            //If the customer doesnt have any quotes 
            if (!rs.next()) {
                System.out.println("No policies Found");
            } else {
                do {
                    if (rs.getInt("policy_type") == 15) {
                        PolicyIDS.add(rs.getInt("policy_id"));
                    }
                } while (rs.next());
            }
        } catch (Exception ex) {
            System.out.println("getHomePolicyByCustomerId has failed " + ex);
        }
        return PolicyIDS;
    }

    public static String getHousePolicy(int policyID) {
        String returnResult = "";
        String SPsql = "EXEC getHomePolicyByPolicyId ?";
        System.out.println(policyID);
        try (Connection con = ConnectionManager.getConnection();
                PreparedStatement ps = con.prepareStatement(SPsql)) {
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
            //Set up params for stored procedure
            ps.setInt(1, policyID);
            //Return sp into a result set
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                returnResult = "Home Policy ID: " + rs.getInt("policy_id") + "<br>" + "Annual Premium: $" + rs.getDouble("premium") + "<br>" + "Expiration Date: " + rs.getDate("date_expired");
            }
        } catch (SQLException ex) {
            System.out.println("Retreive Home Policy has failed for customer id: " + policyID + " reason: " + ex);
            Logger.getLogger(QuoteDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        System.out.println(returnResult);
        return returnResult;
    }

    public static String getAutoPolicy(int policyID) {
        String returnResult = "";
        String SPsql = "EXEC getAutoPolicyByPolicyId ?";
        System.out.println(policyID);
        try (Connection con = ConnectionManager.getConnection();
                PreparedStatement ps = con.prepareStatement(SPsql)) {
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
            //Set up params for stored procedure
            ps.setInt(1, policyID);
            //Return sp into a result set
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                returnResult = " Auto Policy ID: " + rs.getInt("policy_id") + "<br>" + " Annual Premium: $" + rs.getDouble("premium") + "<br>" + " Expiration Date: " + rs.getDate("date_expired");
            }
        } catch (SQLException ex) {
            System.out.println("Retreive Auto Policy has failed for customer id: " + policyID + " reason: " + ex);
            Logger.getLogger(QuoteDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        System.out.println(returnResult);
        return returnResult;
    }

}
