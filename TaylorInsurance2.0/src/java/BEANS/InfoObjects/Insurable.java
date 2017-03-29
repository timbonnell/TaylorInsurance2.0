package BEANS.InfoObjects;

/**
 * 
 * An insurable property consists of a base premium and a list of insurable factors, which are used by the PremiumCalculator class to calculate the premium for the property.
 * @author SPOO
 */
public interface Insurable {
    
    /**
     * 
     * @return 
     */
    public String getIdentifier();
}
