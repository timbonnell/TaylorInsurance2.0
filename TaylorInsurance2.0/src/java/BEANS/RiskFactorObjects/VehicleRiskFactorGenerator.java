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

        for (Map.Entry<Integer, Double> ageFactor; ageFactors.hasNext();) {
            ageFactor = ageFactors.next();
            if (vehicleAge > ageFactor.getKey() && lastCompared < ageFactor.getKey()) {
                factor = ageFactor.getValue();
                lastCompared = ageFactor.getKey();
            }
        }

        return factor;
    }

    public double getDriverAgeFactor() {
        Map ageRates = getRatesForGroup("DRIVER_AGE");
        CustomerInsurable customer = getCustomer();

        // House age is calculated from current date
        int driverAge = customer.getBirthDate().until(LocalDate.now()).getYears();

        // Store current applicable factor while looping through the rates.
        // Because the Map may be in an arbitrary order, also check to make sure only the largest applicable age is given.
        double factor = 1.0;
        int lastCompared = 0;

        Iterator<Map.Entry> ageFactors = ageRates.entrySet().iterator();

        for (Map.Entry<Integer, Double> ageFactor; ageFactors.hasNext();) {
            ageFactor = ageFactors.next();
            if (driverAge > ageFactor.getKey() && lastCompared < ageFactor.getKey()) {
                factor = ageFactor.getValue();
                lastCompared = ageFactor.getKey();
            }
        }

        return factor;
    }

    public double getDriverAccidentsFactor() {
        Map accidentRates = getRatesForGroup("VEHICLE_AGE");
        CustomerInsurable customer = getCustomer();

        int accidents = getNumberOfDriverAccidents();

        // Store current applicable factor while looping through the rates.
        // Because the Map may be in an arbitrary order, also check to make sure only the largest applicable rate is given.
        double factor = 1.0;
        int lastCompared = 0;

        Iterator<Map.Entry> accidentFactors = accidentRates.entrySet().iterator();

        for (Map.Entry<Integer, Double> accidentFactor; accidentFactors.hasNext();) {
            accidentFactor = accidentFactors.next();
            if (accidents > accidentFactor.getKey() && lastCompared < accidentFactor.getKey()) {
                factor = accidentFactor.getValue();
                lastCompared = accidentFactor.getKey();
            }
        }

        return factor;
    }

    @Override
    void loadRates() {
        /**
         * TODO Load rates from database
         */
        addRate("DRIVER_AGE", 25, 2);

        addRate("NUM_ACCIDENTS", 2, 2.5);
        addRate("NUM_ACCIDENTS", 1, 1.25);

        addRate("VEHICLE_AGE", 10, 2);
        addRate("VEHICLE_AGE", 5, 1.5);
    }

    @Override
    void loadPremium() {
        setBasePremium(750);
    }

    /**
     * TODO: retrieve number of accidents from database
     */
    private int getNumberOfDriverAccidents() {
        return 0;
    }

    @Override
    public double getTotalRateFactor() {
        return getDriverAgeFactor() * getDriverAccidentsFactor() * getVehicleAgeFactor();
    }
}
