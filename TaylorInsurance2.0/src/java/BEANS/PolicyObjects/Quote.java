package BEANS.PolicyObjects;

import BEANS.InfoObjects.CustomerInsurable;
import BEANS.InfoObjects.Insurable;
import BEANS.RiskFactorObjects.RiskFactorGenerator;
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 20124135
 */
public abstract class Quote {

    protected String id;
    protected LocalDate created;
    private CustomerInsurable client;
    private Insurable property;
    private RiskFactorGenerator calculator;

    public Quote(String id, LocalDate created, CustomerInsurable client, Insurable property) {
        this.id = id;
        this.created = created;
        this.client = client;
        this.property = property;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerInsurable getClient() {
        return client;
    }

    public void setClient(CustomerInsurable client) {
        this.client = client;
    }

    public Insurable getProperty() {
        return property;
    }

    public void setProperty(Insurable property) {
        this.property = property;
    }

    public RiskFactorGenerator getCalculator() {
        return calculator;
    }

    public void setCalculator(RiskFactorGenerator calculator) {
        this.calculator = calculator;
    }
    
    public double getTotalPremium() {
        return getCalculator().getBasePremium() * getCalculator().getTotalRateFactor();
    }
}
