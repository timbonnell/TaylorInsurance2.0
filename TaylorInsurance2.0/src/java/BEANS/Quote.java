package BEANS;


import BEANS.Client;





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
    protected int id;
    protected Client associatedClient;
    protected double basePremium;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getAssociatedClient() {
        return associatedClient;
    }

    public void setAssociatedClient(Client associatedClient) {
        this.associatedClient = associatedClient;
    }

    public double getBasePremium() {
        return basePremium;
    }

    public void setBasePremium(double basePremium) {
        this.basePremium = basePremium;
    }
    
    
}
