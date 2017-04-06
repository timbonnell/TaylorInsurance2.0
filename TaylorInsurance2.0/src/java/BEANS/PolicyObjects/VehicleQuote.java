package BEANS.PolicyObjects;

import BEANS.InfoObjects.CustomerInsurable;
import BEANS.InfoObjects.Insurable;
import BEANS.InfoObjects.VehicleInsurable;
import BEANS.RiskFactorObjects.VehicleRiskFactorGenerator;
import java.time.LocalDate;

/**
 *
 * @author SPOO
 */
public class VehicleQuote extends Quote {

    public VehicleQuote(String id, LocalDate creationDate, LocalDate expiryDate, CustomerInsurable client, VehicleInsurable property) {
        super(id, creationDate, expiryDate, client, property);
        setCalculator(new VehicleRiskFactorGenerator(client, property));
    }

    @Override
    public VehicleInsurable getProperty() {
        return (VehicleInsurable) super.getProperty();
    }

}
