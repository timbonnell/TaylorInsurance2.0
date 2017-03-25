package BEANS.PolicyObjects;

import BEANS.InfoObjects.CustomerInsurable;
import BEANS.InfoObjects.Insurable;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 20124135
 */
public class Quote {

    protected int id;
    protected CustomerInsurable associatedClient;
    protected Insurable associatedProperty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerInsurable getAssociatedClient() {
        return associatedClient;
    }

    public void setAssociatedClient(CustomerInsurable associatedClient) {
        this.associatedClient = associatedClient;
    }

    public Insurable getAssociatedProperty() {
        return associatedProperty;
    }

    public void setAssociatedProperty(Insurable associatedProperty) {
        this.associatedProperty = associatedProperty;
    }

}
