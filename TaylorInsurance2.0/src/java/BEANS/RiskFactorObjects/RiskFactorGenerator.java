package BEANS.RiskFactorObjects;

import BEANS.InfoObjects.CustomerInsurable;
import BEANS.InfoObjects.Insurable;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SPOO
 */
public abstract class RiskFactorGenerator {
    
    private final CustomerInsurable customer;
    private final Insurable property;
    private final Map<String, Map<Integer, Double>> rates;
    private double basePremium;
    
    public RiskFactorGenerator(CustomerInsurable customer, Insurable property) {
        this.customer = customer;
        this.property = property;
        rates = new HashMap();
    }

    public CustomerInsurable getCustomer() {
        return customer;
    }

    public Insurable getProperty() {
        return property;
    }

    public double getBasePremium() {
        return basePremium;
    }

    public void setBasePremium(double basePremium) {
        this.basePremium = basePremium;
    }    

    public void addRate(String group, int key, double value) {
        if (rates.get(group) == null) {
            rates.put(group, new HashMap());
        }
        rates.get(group).put(key, value);
    }
    
    public Map<Integer, Double> getRatesForGroup(String group) {
        return rates.getOrDefault(group, new HashMap());
    }
    
    abstract void loadRates();
    abstract void loadPremium();
    public abstract double getTotalRateFactor();
}
