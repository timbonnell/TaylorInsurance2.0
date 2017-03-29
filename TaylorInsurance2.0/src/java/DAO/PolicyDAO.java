/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import SERVLETS.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public static void createAutoPolicy() {

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
            rs = ps.executeQuery();
            while (rs.next()) {
                returnResult = rs.getInt(1);
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
}
