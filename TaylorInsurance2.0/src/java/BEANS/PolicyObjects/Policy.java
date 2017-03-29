package BEANS.PolicyObjects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import BEANS.InfoObjects.CustomerInsurable;
import java.time.LocalDate;

/**
 *
 * @author 20124135
 */
public abstract class Policy {

    public final double TAX_RATE = 0.15;

    private CustomerInsurable associatedCustomer;
    private Quote associatedQuote;
    private LocalDate endDate;
    private String id;
    private LocalDate startDate;

    public Policy(String id, CustomerInsurable associatedCustomer, Quote associatedQuote, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.associatedCustomer = associatedCustomer;
        this.associatedQuote = associatedQuote;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public CustomerInsurable getAssociatedCustomer() {
        return associatedCustomer;
    }

    public void setAssociatedCustomer(CustomerInsurable associatedCustomer) {
        this.associatedCustomer = associatedCustomer;
    }

    public Quote getAssociatedQuote() {
        return associatedQuote;
    }

    public void setAssociatedQuote(Quote associatedQuote) {
        this.associatedQuote = associatedQuote;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPremium() {
        return associatedQuote.getTotalPremium();
    }

    public double getPremiumPlusTax() {
        return getPremium() * TAX_RATE;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

}
