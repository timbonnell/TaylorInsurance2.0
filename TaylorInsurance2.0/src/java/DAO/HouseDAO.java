/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEANS.InfoObjects.House;
import SERVLETS.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author timbo
 */
public class HouseDAO {
    static Connection connection = null;
    static ResultSet rs = null;
    static PreparedStatement ps;
    
    
    public static void createHouse(House house){

        // Set up house attributes
        int houseType = house.getType();
        int houseYear = house.getYear();
        int houseHeating = house.getHeating();
        String houseCity = house.getAddress().getCity();
        //String houseProv = house.getAddress().getProvince();
        String houseStreet = house.getAddress().getStreetAddress1();
        String housePostal = house.getAddress().getPostalCode();
        String houseCountry = house.getAddress().getCountry();
        
        String SPsql = "EXEC insertHouse ?,?,?,?,?,?,?,?";
        
        try {
            connection = ConnectionManager.getConnection();
            //stmt = connection.createStatement();
            ps = connection.prepareStatement(SPsql);
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
            //Set up params for stored procedure
            ps.setInt(1, houseType);
            ps.setInt(2, houseYear);
            ps.setInt(3, houseHeating);
            ps.setString(4, houseCity);
            ps.setInt(5, 10);
            ps.setString(6, houseStreet);
            ps.setString(7, housePostal);
            ps.setString(8, houseCountry);
            
            ps.executeUpdate();
            
            } catch (Exception ex) {
            System.out.println("createHouse: An Exception has occurred! " + ex);
        } //Exception handling and closing
        finally {
            //Close DB Connections
            ConnectionManager.Dispose(connection, rs, ps);
        
        }
    }
        
        
 }

