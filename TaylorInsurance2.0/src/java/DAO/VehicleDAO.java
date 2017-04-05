/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEANS.InfoObjects.House;
import BEANS.InfoObjects.Vehicle;
import SERVLETS.ConnectionManager;
import java.sql.CallableStatement;
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

            System.out.println(vehicle.toString());

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
                vehicle.setVehicleID(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println("createVehicle: An Exception has occurred! " + ex);
        } //Exception handling and closing
        finally {
            //Close DB Connections
            ConnectionManager.Dispose(connection, rs, ps);

        }

        return vehicle;
    }

    /**
     * Creates a list of vehicles
     * 
     * Stored procedure getVehiclesByCustomerId:
     * 
     * Parameter: 
     * INTEGER customerId
     * 
     * Return:
     * INTEGER vehicleId
     * VARCHAR make;
     * VARCHAR model;
     * INTEGER year;
     * INTEGER type;
     * VARCHAR vin;
     * INTEGER color;
     * INTEGER numAccidents;
     * DOUBLE estimated_value;
     * 
     * @param customerId
     * @return 
     */
    public static List<Vehicle> getVehiclesForCustomer(String customerId) {
        String sql = "{call getVehiclesByCustomerId (?)}";
        List<Vehicle> list = new ArrayList();
        try (
                Connection con = ConnectionManager.getConnection();
                CallableStatement stm = con.prepareCall(sql)) {

            stm.setInt(1, Integer.parseInt(customerId));
            ResultSet results = stm.executeQuery();
            while (results.next()) {
                // populate vehicle list
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
