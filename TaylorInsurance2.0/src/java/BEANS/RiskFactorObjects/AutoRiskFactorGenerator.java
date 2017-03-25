package BEANS.RiskFactorObjects;

import BEANS.InfoObjects.AutoInsurable;
import BEANS.InfoObjects.CustomerInsurable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SPOO
 */
public class AutoRiskFactorGenerator extends RiskFactorGenerator {

    private final List<Rate> rates;
    
    public AutoRiskFactorGenerator(CustomerInsurable customer, AutoInsurable property) {
        super(customer, property);
        rates = new ArrayList();
    }
      
    public double getYearRate() {
        
        return 1.0;
    }
    
    public double getDriverAgeRate() {
        
        return 1.0;
    }
    
    public double getDriverAccidents() {
        
        return 1.0;
    }

    @Override
    void loadRates() {
        /**
         * TODO Load rates from database
         */
    }
}
