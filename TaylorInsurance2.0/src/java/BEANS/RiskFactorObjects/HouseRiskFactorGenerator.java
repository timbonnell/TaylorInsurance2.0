package BEANS.RiskFactorObjects;

import BEANS.InfoObjects.CustomerInsurable;
import BEANS.InfoObjects.HouseInsurable;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author SPOO
 */
public class HouseRiskFactorGenerator extends RiskFactorGenerator {

    public HouseRiskFactorGenerator(CustomerInsurable customer, HouseInsurable house) {
        super(customer, house);
        loadRates();
        loadPremium();
    }

    public double getHouseAgeFactor() {
        Map ageRates = getRatesForGroup("AGE");
        HouseInsurable house = (HouseInsurable) getProperty();

        // House age is calculated from current date
        int houseAge = LocalDate.now().getYear() - house.getYear();

        // Store current applicable factor while looping through the rates.
        // Because the Map may be in an arbitrary order, also check to make sure only the largest applicable age is given.
        double factor = 1.0;
        int lastCompared = 0;

        Iterator<Map.Entry> ageFactors = ageRates.entrySet().iterator();

        for (Map.Entry<String, Double> ageFactor; ageFactors.hasNext();) {
            ageFactor = ageFactors.next();
            int ageToCompare = Integer.parseInt(ageFactor.getKey());
            if (houseAge > ageToCompare && lastCompared < ageToCompare) {
                factor = ageFactor.getValue();
                lastCompared = ageToCompare;
            }
        }

        return factor;
    }

    /**
     * Determines the appropriate risk factor based on the heating type of the
     * house.
     *
     * If heating type is not found in rates, factor returned is 1.0
     *
     * @return
     */
    public double getHouseHeatingTypeFactor() {
        Map<String, Double> heatingRates = getRatesForGroup("HEATING");
        HouseInsurable house = (HouseInsurable) getProperty();
        String heatingType = String.valueOf(house.getHeating());
        return heatingRates.getOrDefault(heatingType, 1.0);
    }

    @Override
    public double getTotalRateFactor() {
        return getHouseAgeFactor() * getHouseHeatingTypeFactor();
    }

    @Override
    void loadPremium() {
        setBasePremium(500);
    }

    @Override
    void loadRates() {
        /**
         * TODO Load rates from database
         */
        // House age rates
        addRate("AGE", "25", 1.25);
        addRate("AGE", "50", 1.5);

        // House heating rates
        addRate("HEATING", "1", 2.0);
        addRate("HEATING", "2", 1.25);
    }

}
