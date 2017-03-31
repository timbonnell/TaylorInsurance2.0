package DAO;

import BEANS.RiskFactorObjects.RiskFactorGenerator;
import SERVLETS.ConnectionManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SPOO
 */
public class RiskFactorGeneratorDAO {

    public static final int RATE_TYPE_VEHICLE = 14;
    public static final int RATE_TYPE_HOUSE = 15;

    public static RiskFactorGenerator getRiskFactors(RiskFactorGenerator generator, int rateType) {

        try (CallableStatement stm = ConnectionManager.getConnection().prepareCall("getRiskFactors(?)")) {
            stm.setInt(1, rateType);
            ResultSet results = stm.executeQuery();
            while (results.next()) {
                String group = results.getString("rate_group");
                String key = results.getString("rate_key");
                Double value = results.getDouble("rate_value");
                generator.addRate(group, key, value);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RiskFactorGeneratorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return generator;
    }

}
