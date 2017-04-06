/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEANS.InfoObjects.Customer;
import BEANS.PolicyObjects.HousePolicy;
import BEANS.PolicyObjects.HouseQuote;
import BEANS.PolicyObjects.VehiclePolicy;
import BEANS.PolicyObjects.VehicleQuote;
import SERVLETS.ConnectionManager;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author timbo
 */
public class PolicyDAO {

    // Create Auto Policy
    public static VehiclePolicy acceptAutoPolicy(VehicleQuote quote) {
        String sql = "{call acceptAutoPolicy (?)}";
        System.out.println("Accept Policy" + quote);
        try (
                Connection con = ConnectionManager.getConnection();
                CallableStatement stm = con.prepareCall(sql)) {
            stm.setQueryTimeout(30);
            //Set up params for stored procedure
            stm.setInt(1, Integer.parseInt(quote.getId()));
            //Return sp into a result set
            ResultSet rs = stm.executeQuery();
            if (!rs.next()) {
                throw new SQLException("No policy has been created.");
            } else {
                return new VehiclePolicy(rs.getString("policy_id"), quote, rs.getDate("creation_date").toLocalDate(), rs.getDate("expiry_date").toLocalDate());
            }
        } catch (SQLException ex) {
            System.out.println("Retreive Quote has failed for customer id: " + quote + " reason: " + ex);
            Logger.getLogger(QuoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//Create Home Policy
    public static HousePolicy acceptHomePolicy(HouseQuote quote) {
        
        String sql = "{call acceptHomePolicy(?)}";
        System.out.println("Accept Policy" + quote);
        try (
                Connection con = ConnectionManager.getConnection();
                CallableStatement stm = con.prepareCall(sql)) {
            stm.setQueryTimeout(30);
            //Set up params for stored procedure
            stm.setInt(1, Integer.parseInt(quote.getId()));
            ResultSet rs = stm.executeQuery();
            if (!rs.next()) {
                throw new SQLException("No policy has been created.");
            } else {
                return new HousePolicy(rs.getString("policy_id"), quote, rs.getDate("creation_date").toLocalDate(), rs.getDate("expiry_date").toLocalDate());
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static List<HousePolicy> getHomePoliciesByCustomerId(Customer customer, Map<String, HouseQuote> quoteList) {
        String sql = "{call getHomePoliciesByCustomerId(?)}";
        List<HousePolicy> policyList = new ArrayList();
        try (
                Connection con = ConnectionManager.getConnection();
                CallableStatement stm = con.prepareCall(sql)) {
            stm.setInt(1, Integer.parseInt(customer.getId()));
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                HouseQuote quote = quoteList.get(rs.getString("quote_id"));
                if (quote == null) {
                    throw new IndexOutOfBoundsException("Bad quote ID: " + rs.getString("quote_id"));
                }
                policyList.add(new HousePolicy(rs.getString("policy_id"), quote, rs.getDate("creation_date").toLocalDate(), rs.getDate("expiry_date").toLocalDate()));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PolicyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return policyList;
    }
    
    public static List<VehiclePolicy> getVehiclePoliciesByCustomerId(Customer customer, Map<String, VehicleQuote> quoteList) {
        String sql = "{call getVehiclePoliciesByCustomerId(?)}";
        List<VehiclePolicy> policyList = new ArrayList();
        try (
                Connection con = ConnectionManager.getConnection();
                CallableStatement stm = con.prepareCall(sql)) {
            stm.setInt(1, Integer.parseInt(customer.getId()));
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                VehicleQuote quote = quoteList.get(rs.getString("quote_id"));
                if (quote == null) {
                    throw new IndexOutOfBoundsException("Bad quote ID: " + rs.getString("quote_id"));
                }
                policyList.add(new VehiclePolicy(rs.getString("policy_id"), quote, rs.getDate("creation_date").toLocalDate(), rs.getDate("expiry_date").toLocalDate()));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PolicyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return policyList;
    }
    
}
