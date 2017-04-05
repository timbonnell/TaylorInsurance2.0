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
public class Policy {

    public final double TAX_RATE = 0.15;

    private Quote associatedQuote;
    private LocalDate creationDate;
    private LocalDate expiryDate;
    private String id;

    public Policy(String id, Quote associatedQuote, LocalDate creationDate, LocalDate expiryDate) {
        this.associatedQuote = associatedQuote;
        this.creationDate = creationDate;
        this.expiryDate = expiryDate;
        this.id = id;
    }

    public CustomerInsurable getClient() {
        return associatedQuote.getClient();
    }

    public Quote getAssociatedQuote() {
        return associatedQuote;
    }

    public void setAssociatedQuote(Quote associatedQuote) {
        this.associatedQuote = associatedQuote;
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

    public double getPremium() {
        return associatedQuote.getTotalPremium();
    }

    public double getPremiumPlusTax() {
        return getPremium() * TAX_RATE;
    }

}
