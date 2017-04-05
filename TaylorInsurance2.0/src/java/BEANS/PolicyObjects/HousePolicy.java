/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEANS.PolicyObjects;

import java.time.LocalDate;

/**
 *
 * @author SPOO
 */
public class HousePolicy extends Policy {

    public HousePolicy(String id, Quote associatedQuote, LocalDate creationDate, LocalDate expiryDate) {
        super(id, associatedQuote, creationDate, expiryDate);
    }

    @Override
    public HouseQuote getAssociatedQuote() {
        return (HouseQuote) super.getAssociatedQuote();
    }

}
