package BEANS.PolicyObjects;

import BEANS.InfoObjects.CustomerInsurable;
import BEANS.InfoObjects.HouseInsurable;
import BEANS.InfoObjects.Insurable;
import BEANS.RiskFactorObjects.HouseRiskFactorGenerator;
import java.time.LocalDate;

/**
 *
 * @author SPOO
 */
public class HouseQuote extends Quote {

    public HouseQuote(String id, LocalDate creationDate, LocalDate expiryDate, CustomerInsurable client, HouseInsurable property) {
        super(id, creationDate, expiryDate, client, property);
        setCalculator(new HouseRiskFactorGenerator(client, property));
    }

    @Override
    public HouseInsurable getProperty() {
        return (HouseInsurable) super.getProperty();
    }

}
