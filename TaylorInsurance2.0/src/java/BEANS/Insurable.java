package BEANS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BEANS.InsurableFactor;
import java.util.List;

/**
 * The Insurable interface is used to identify a property, such as a house or vehicle, that can be insured.
 * 
 * An insurable property consists of a base premium and a list of insurable factors, which are used by the PremiumCalculator class to calculate the premium for the property.
 * @author SPOO
 */
interface Insurable {
    
    /**
     * Compiles an insurable property's list of factors
     * @return 
     */
    public List<InsurableFactor> getInsurableFactors();
    
    /**
     * Gets an insurable property's base premium
     * @return 
     */
    public double getBasePremium();
}
