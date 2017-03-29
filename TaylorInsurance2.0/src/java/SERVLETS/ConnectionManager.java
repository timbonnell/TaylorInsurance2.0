
package SERVLETS;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 20110176
 */
public class ConnectionManager {
    
    private static final ConnectionManager cm = new ConnectionManager();
    private SQLServerDataSource ds;
    private boolean isAuthenticated = false;
    
    private final String DATABASE = "TaylorInsurance";
    private final String USERNAME = "appuser";
    private final String PASSWORD = "beepBEEPlettuce9";
    
    private ConnectionManager() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ConnectionManager getManager() {
        return cm;
    }
    
    public Connection getConnection() throws SQLServerException {
        return ds.getConnection();
    }
    
    public boolean sqlLogin(String username, String password, String server, String database, int port) {
        ds = new SQLServerDataSource();
        ds.setUser(username);
        ds.setPassword(password);
        ds.setServerName(server);
        ds.setDatabaseName(database);
        ds.setPortNumber(port);
        try (Connection c = ds.getConnection();){
            isAuthenticated = true;
            return true;
        } catch (SQLServerException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public ResultSet query(String query) {
        if (isAuthenticated) {
            try (Connection con = ds.getConnection();
                    Statement st = con.createStatement()) {
                return st.executeQuery(query);
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        } else {
            return null;
        }
    }
}
