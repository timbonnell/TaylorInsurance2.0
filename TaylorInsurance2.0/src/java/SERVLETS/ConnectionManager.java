package SERVLETS;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.*;
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

    

    private static final String DATABASE = "TaylorInsurance";
    private static final String USERNAME = "AdminTaylor";
    private static final String PASSWORD = "password";
    private static final String SERVER = "localhost";
    private static final int PORT = 1433;
    private static boolean isAuthenticated = false;

    private static final SQLServerDataSource ds = new SQLServerDataSource();
    private static final ConnectionManager manager = new ConnectionManager();
    
    private ConnectionManager() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            sqlLogin(USERNAME, PASSWORD, SERVER, DATABASE, PORT);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        // Not sure if needed anymore
        if (!isAuthenticated) {
            return null;
        } else {
            try {
                return ds.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
    }

    public final boolean sqlLogin(String username, String password, String server, String database, int port) {
        ds.setUser(username);
        ds.setPassword(password);
        ds.setServerName(server);
        ds.setDatabaseName(database);
        try (Connection c = ds.getConnection()) {
            isAuthenticated = true;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            isAuthenticated = false;
        } finally {
            return isAuthenticated;
        }
    }

}
