/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEANS.InfoObjects.Vehicle;
import SERVLETS.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author timbo
 */
public class VehicleDAO {

    static Connection connection = null;
    static ResultSet rs = null;
    static PreparedStatement ps;

    public static Vehicle createVehicle(Vehicle vehicle) {
         // Set up Vehicle attributes


        String SPsql = "EXEC insertVehicle ?,?,?,?,?,?,?";

        try {
            connection = ConnectionManager.getConnection();
            //stmt = connection.createStatement();
            ps = connection.prepareStatement(SPsql);
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
           
            //Set up params for stored procedure
            ps.setString(1, vehicle.getVin());
            ps.setInt(2, vehicle.getType());
            ps.setString(3, vehicle.getMake());
            ps.setString(4, vehicle.getModel());
            ps.setInt(5, vehicle.getYear());
            ps.setInt(6, vehicle.getColor());
            ps.setDouble(7, vehicle.getEstimated_value());
            
            boolean more = ps.execute();
             more = ps.getMoreResults();
            rs = ps.getResultSet();
            more = rs.next();
            System.out.println(more);
            //Checks to see if house id comes back (house was stored successfully)
            if (!more) {
                System.out.println("invalid vehicle creation");

            } // If username and password are correct, set client to valid and set up the client
            else if (more) {
                rs = ps.getResultSet();
                System.out.println("Vehicle ID: " + rs.getString(1));
                vehicle.setVehicleID(Integer.parseInt(rs.getString(1)));
            }
        } catch (Exception ex) {
            System.out.println("createVehicle: An Exception has occurred! " + ex);
        } //Exception handling and closing
        finally {
            //Close DB Connections
            ConnectionManager.Dispose(connection, rs, ps);

        }
        
        
        
        return vehicle;
    }
}
