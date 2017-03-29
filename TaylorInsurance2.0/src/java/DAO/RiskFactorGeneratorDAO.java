package DAO;

import BEANS.RiskFactorObjects.RiskFactorGenerator;
import SERVLETS.ConnectionManager;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SPOO
 */
public class RiskFactorGeneratorDAO {

    public static final int RATE_TYPE_VEHICLE = 0;
    public static final int RATE_TYPE_HOUSE = 0;

    static ConnectionManager manager = ConnectionManager.getManager();

    public static RiskFactorGenerator getRiskFactors(RiskFactorGenerator generator, int rateType) {
        // Prepare variables

        try (CallableStatement stm = manager.getConnection().prepareCall("getRiskFactors(?)");) {
            stm.setInt(0, rateType);
            ResultSet results = stm.executeQuery();
            while (results.next()) {
                String group = results.getString("group");
                String key = results.getString("key");
                Double value = results.getDouble("value");
                generator.addRate(group, key, value);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RiskFactorGeneratorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return generator;
    }

}
