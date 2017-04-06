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
import java.sql.CallableStatement;
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

    public static HouseQuote createHouseQuote(Customer customer, House house) {
        String sql = "{call insertHomeQuote (?,?,?)";
        HouseQuote quote = new HouseQuote(null, null, null, customer, house);
        try (
                Connection con = ConnectionManager.getConnection();
                CallableStatement stm = con.prepareCall(sql)) {

            stm.setQueryTimeout(30);

            //Set up params for stored procedure
            stm.setInt(1, Integer.parseInt(customer.getId()));
            stm.setInt(2, Integer.parseInt(house.getHouseId()));
            stm.setDouble(3, quote.getTotalPremium());

            ResultSet rs = stm.executeQuery();
            //Checks to see if house id comes back (house was stored successfully)
            if (!rs.next()) {
                throw new SQLException("No quote was created.");
            } // If username and password are correct, set client to valid and set up the client
            else {
                System.out.println("House Quote ID: " + rs.getString(1));
                quote.setId(rs.getString("policy_id"));
                quote.setCreationDate(rs.getDate("creation_date").toLocalDate());
                quote.setExpiryDate(rs.getDate("expiration_date").toLocalDate());
            }

        } catch (NumberFormatException | SQLException ex) {
            System.out.println("Insert House Quote Failed: An Exception has occurred! " + ex);
            quote = null;
        }
        return quote;
    }

    public static VehicleQuote createVehicleQuote(Customer customer, Vehicle vehicle) {
        String sql = "{call insertAutoQuote(?,?,?)";
        VehicleQuote quote = new VehicleQuote(null, null, null, customer, vehicle);
        try (
                Connection con = ConnectionManager.getConnection();
                CallableStatement stm = con.prepareCall(sql)) {

            stm.setQueryTimeout(30);

            System.out.println("Create Vehicle Quote" + vehicle.getVehicleId());

            //Set up params for stored procedure
            stm.setInt(1, Integer.parseInt(customer.getId()));
            stm.setString(2, vehicle.getVehicleId());
            stm.setDouble(3, quote.getTotalPremium());
            
            ResultSet rs = stm.executeQuery();
            //Checks to see if house id comes back (house was stored successfully)
            if (!rs.next()) {
                throw new SQLException("Vehicle quote not created.");
            } // If username and password are correct, set client to valid and set up the client
            else {
                System.out.println("Vehicle Quote ID: " + rs.getString(1));
                quote.setId(rs.getString("policy_id"));
                quote.setCreationDate(rs.getDate("creation_date").toLocalDate());
                quote.setExpiryDate(rs.getDate("expiry_date").toLocalDate());
            }
            
        } catch (NumberFormatException | SQLException ex) {
            System.out.println("Insert Vehicle Quote Failed: An Exception has occurred! " + ex);
            quote = null;
        }
        return quote;
    }

    public static List<HouseQuote> getHouseQuotesByCustomerId(Customer customer, Map<String, House> houseList) {
        String sql = "{call getHouseQuotesByCustomerId(?)}";
        List<HouseQuote> quoteList = new ArrayList<>();
        try (
                Connection con = ConnectionManager.getConnection();
                CallableStatement stm = con.prepareCall(sql)) {
            
            stm.setInt(1, Integer.parseInt(customer.getId()));
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                House house = houseList.get(rs.getString("house_id"));
                if (house == null) {
                    throw new IndexOutOfBoundsException("Bad house ID: " + rs.getString("house_id"));
                }
                quoteList.add(new HouseQuote(rs.getString("quote_id"), rs.getDate("creation_date").toLocalDate(), rs.getDate("expiry_date").toLocalDate(), customer, house));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(QuoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return quoteList;
    }
    
    public static List<VehicleQuote> getVehicleQuotesByCustomerId(Customer customer, Map<String, Vehicle> vehicleList) {
        String sql = "{call getVehicleQuotesByCustomerId(?)}";
        List<VehicleQuote> quoteList = new ArrayList<>();
        try (
                Connection con = ConnectionManager.getConnection();
                CallableStatement stm = con.prepareCall(sql)) {
            
            stm.setInt(1, Integer.parseInt(customer.getId()));
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                Vehicle vehicle = vehicleList.get(rs.getString("house_id"));
                if (vehicle == null) {
                    throw new IndexOutOfBoundsException("Bad house ID: " + rs.getString("house_id"));
                }
                quoteList.add(new VehicleQuote(rs.getString("quote_id"), rs.getDate("creation_date").toLocalDate(), rs.getDate("expiry_date").toLocalDate(), customer, vehicle));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(QuoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return quoteList;
    }
}
