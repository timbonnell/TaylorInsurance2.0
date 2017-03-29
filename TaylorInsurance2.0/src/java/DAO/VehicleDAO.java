package DAO;

import SERVLETS.ConnectionManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SPOO
 */
public class VehicleDAO {

    static ConnectionManager manager = ConnectionManager.getManager();

    public static int getDriverAccidents(String customerID) throws SQLException {
        String sql = "getDriverAccidents(?)";

        try (CallableStatement stm = manager.getConnection().prepareCall(sql);) {
            stm.setString(0, customerID);
            ResultSet rs = stm.executeQuery();
            return rs.getInt(1);
        }

    }

}
