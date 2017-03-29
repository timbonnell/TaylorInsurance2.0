package BEANS.PolicyObjects;

import BEANS.InfoObjects.CustomerInsurable;
import BEANS.InfoObjects.VehicleInsurable;
import BEANS.RiskFactorObjects.VehicleRiskFactorGenerator;
import java.time.LocalDate;

/**
 *
 * @author SPOO
 */
public class VehicleQuote extends Quote {

    public VehicleQuote(String id, LocalDate created, CustomerInsurable customer, VehicleInsurable vehicle) {
        super(id, created, customer, vehicle);
        setCalculator(new VehicleRiskFactorGenerator(customer, vehicle));
    }

}
