/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import SERVLETS.ConnectionManager;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class DatasetDAO {
    static Connection connection = null;
    static ResultSet rs = null;
    static PreparedStatement ps;
    
    public static String resolveDatasetLabel(int datasetID) {
        String sql = "{call getDataLabel (?)}";
        String result = "";
        try (
                Connection con = ConnectionManager.getConnection();
                CallableStatement stm = con.prepareCall(sql)
                ) {

            stm.setInt(1, datasetID);
            ResultSet results = stm.executeQuery();
            if (results.next()) {
                result = results.getString("label");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

        
    }
}
