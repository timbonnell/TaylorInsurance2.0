package BEANS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BEANS.Rate;
import BEANS.Customer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SPOO
 * @param <Insurable>
 */
public class PremiumCalculator<Insurable> {
    private final Customer client;
    private final Insurable property;
    private static final Map<String, List<Rate>> insuranceRates = new HashMap();
    
    public PremiumCalculator(Customer client, Insurable property) {
        this.client = client;
        this.property = property;
    }

    public Customer getClient() {
        return client;
    }

    public Insurable getProperty() {
        return property;
    }
    
    /**
     * TODO: Add database connection for rates
     */
    private void populateRates() {
        
    }
}
