package BEANS.PolicyObjects;

import BEANS.InfoObjects.CustomerInsurable;
import BEANS.InfoObjects.Insurable;
import BEANS.RiskFactorObjects.RiskFactorGenerator;
import java.time.LocalDate;

/**
 *
 * @author 20124135
 */
public abstract class Quote {

    private RiskFactorGenerator calculator;
    private CustomerInsurable client;
    private LocalDate creationDate;
    private LocalDate expiryDate;
    private String id;
    private Insurable property;

    public Quote(String id, LocalDate creationDate, CustomerInsurable client, Insurable property) {
        this.id = id;
        this.creationDate = creationDate;
        this.client = client;
        this.property = property;
    }

    public RiskFactorGenerator getCalculator() {
        return calculator;
    }

    public void setCalculator(RiskFactorGenerator calculator) {
        this.calculator = calculator;
    }

    public CustomerInsurable getClient() {
        return client;
    }

    public void setClient(CustomerInsurable client) {
        this.client = client;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Insurable getProperty() {
        return property;
    }

    public void setProperty(Insurable property) {
        this.property = property;
    }

    public double getTotalPremium() {
        return getCalculator().getBasePremium() * getCalculator().getTotalRateFactor();
    }

}
