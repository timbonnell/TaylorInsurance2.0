package BEANS.RiskFactorObjects;

import BEANS.InfoObjects.CustomerInsurable;
import BEANS.InfoObjects.HouseInsurable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SPOO
 */
public class HouseRiskFactorGenerator extends RiskFactorGenerator {

    private final List<Rate> rates;

    public HouseRiskFactorGenerator(CustomerInsurable customer, HouseInsurable house) {
        super(customer, house);
        rates = new ArrayList();
    }

    public double getHouseAgeFactor() {
        return 1.0;
    }

    public double getHouseHeatingTypeFactor() {
        return 1.0;
    }

    @Override
    void loadRates() {
        /**
         * TODO Load rates from database
         */
    }
}
