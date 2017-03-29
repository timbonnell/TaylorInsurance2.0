package BEANS.RiskFactorObjects;

import BEANS.InfoObjects.CustomerInsurable;
import java.util.Map;
import BEANS.InfoObjects.VehicleInsurable;
import java.time.LocalDate;
import java.util.Iterator;

/**
 *
 * @author SPOO
 */
public class VehicleRiskFactorGenerator extends RiskFactorGenerator {

    public VehicleRiskFactorGenerator(CustomerInsurable customer, VehicleInsurable property) {
        super(customer, property);
        loadRates();
        loadPremium();
    }

    public double getDriverAccidentsFactor() {
        Map accidentRates = getRatesForGroup("VEHICLE_AGE");

        int accidents = getNumberOfDriverAccidents();

        // Store current applicable factor while looping through the rates.
        // Because the Map may be in an arbitrary order, also check to make sure only the largest applicable rate is given.
        double factor = 1.0;
        int lastCompared = 0;

        Iterator<Map.Entry> accidentFactors = accidentRates.entrySet().iterator();

        for (Map.Entry<String, Double> accidentFactor; accidentFactors.hasNext();) {
            accidentFactor = accidentFactors.next();
            int numAccidents = Integer.parseInt(accidentFactor.getKey());
            if (accidents > numAccidents && lastCompared < numAccidents) {
                factor = accidentFactor.getValue();
                lastCompared = numAccidents;
            }
        }

        return factor;
    }

    public double getDriverAgeFactor() {
        Map ageRates = getRatesForGroup("DRIVER_AGE");
        CustomerInsurable driver = getCustomer();

        // House age is calculated from current date
        int driverAge = driver.getBirthDate().until(LocalDate.now()).getYears();

        // Store current applicable factor while looping through the rates.
        // Because the Map may be in an arbitrary order, also check to make sure only the largest applicable age is given.
        double factor = 1.0;
        int lastCompared = 0;

        Iterator<Map.Entry> ageFactors = ageRates.entrySet().iterator();

        for (Map.Entry<String, Double> ageFactor; ageFactors.hasNext();) {
            ageFactor = ageFactors.next();
            int ageToCompare = Integer.parseInt(ageFactor.getKey());
            if (driverAge > ageToCompare && lastCompared < ageToCompare) {
                factor = ageFactor.getValue();
                lastCompared = ageToCompare;
            }
        }

        return factor;
    }

    @Override
    public double getTotalRateFactor() {
        return getDriverAgeFactor() * getDriverAccidentsFactor() * getVehicleAgeFactor();
    }

    public double getVehicleAgeFactor() {
        Map ageRates = getRatesForGroup("VEHICLE_AGE");
        VehicleInsurable vehicle = (VehicleInsurable) getProperty();

        // House age is calculated from current date
        int vehicleAge = LocalDate.now().getYear() - vehicle.getYear();

        // Store current applicable factor while looping through the rates.
        // Because the Map may be in an arbitrary order, also check to make sure only the largest applicable age is given.
        double factor = 1.0;
        int lastCompared = 0;

        Iterator<Map.Entry> ageFactors = ageRates.entrySet().iterator();

        for (Map.Entry<String, Double> ageFactor; ageFactors.hasNext();) {
            ageFactor = ageFactors.next();
            int ageToCompare = Integer.parseInt(ageFactor.getKey());
            if (vehicleAge > ageToCompare && lastCompared < ageToCompare) {
                factor = ageFactor.getValue();
                lastCompared = ageToCompare;
            }
        }

        return factor;
    }

    /**
     * TODO: retrieve number of accidents from database
     */
    private int getNumberOfDriverAccidents() {
        return 0;
    }

    @Override
    void loadPremium() {
        setBasePremium(750);
    }

    @Override
    void loadRates() {
        /**
         * TODO Load rates from database
         */
        addRate("DRIVER_AGE", "25", 2);

        addRate("NUM_ACCIDENTS", "2", 2.5);
        addRate("NUM_ACCIDENTS", "1", 1.25);

        addRate("VEHICLE_AGE", "10", 2);
        addRate("VEHICLE_AGE", "5", 1.5);
    }

}
