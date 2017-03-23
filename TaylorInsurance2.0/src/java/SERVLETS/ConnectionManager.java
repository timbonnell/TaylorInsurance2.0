package SERVLETS;


import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tim
 */
public class ConnectionManager {

    static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;DatabaseName=TaylorInsurance";
    static final String USERNAME = "adminTaylor";
    static final String PASSWORD = "password";
    static Connection connection;

    public static Connection getConnection() {
        // Not sure if needed anymore
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

}
