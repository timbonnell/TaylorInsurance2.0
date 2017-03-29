package BEANS.PolicyObjects;

import BEANS.InfoObjects.CustomerInsurable;
import BEANS.InfoObjects.HouseInsurable;
import BEANS.RiskFactorObjects.HouseRiskFactorGenerator;
import java.time.LocalDate;

/**
 *
 * @author SPOO
 */
public class HouseQuote extends Quote {

    public HouseQuote(String id, LocalDate created, CustomerInsurable client, HouseInsurable house) {
        super(id, created, client, house);
        setCalculator(new HouseRiskFactorGenerator(client, house));
    }

}
