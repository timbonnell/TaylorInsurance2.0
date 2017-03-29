package BEANS.RiskFactorObjects;

import BEANS.InfoObjects.CustomerInsurable;
import BEANS.InfoObjects.Insurable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SPOO
 */
public abstract class RiskFactorGenerator {

    private double basePremium;

    private final CustomerInsurable customer;
    private final Insurable property;
    private final Map<String, Map<String, Double>> rates;

    public RiskFactorGenerator(CustomerInsurable customer, Insurable property) {
        this.customer = customer;
        this.property = property;
        rates = new HashMap();
    }

    public void addRate(String group, String key, double value) {
        if (rates.get(group) == null) {
            rates.put(group, new HashMap());
        }
        rates.get(group).put(key, value);
    }

    public double getBasePremium() {
        return basePremium;
    }

    public void setBasePremium(double basePremium) {
        this.basePremium = basePremium;
    }

    public CustomerInsurable getCustomer() {
        return customer;
    }

    public Insurable getProperty() {
        return property;
    }

    public Map<String, Double> getRatesForGroup(String group) {
        return rates.getOrDefault(group, new HashMap());
    }

    public abstract double getTotalRateFactor();

    abstract void loadPremium();

    abstract void loadRates();

}
