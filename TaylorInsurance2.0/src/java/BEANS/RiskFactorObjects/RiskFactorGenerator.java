package BEANS.RiskFactorObjects;

import BEANS.InfoObjects.CustomerInsurable;
import BEANS.InfoObjects.Insurable;

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
    private double basePremium;
    
    public RiskFactorGenerator(CustomerInsurable customer, Insurable property) {
        this.customer = customer;
        this.property = property;
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

    abstract void loadRates();
}
