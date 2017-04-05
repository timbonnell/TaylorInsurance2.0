/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEANS.PolicyObjects;

import BEANS.InfoObjects.CustomerInsurable;
import java.time.LocalDate;

/**
 *
 * @author SPOO
 */
public class VehiclePolicy extends Policy {
    
    public VehiclePolicy(String id, VehicleQuote associatedQuote, LocalDate startDate, LocalDate endDate) {
        super(id, associatedQuote, startDate, endDate);
    }
    
    @Override
    public VehicleQuote getAssociatedQuote() {
        return (VehicleQuote) super.getAssociatedQuote();
    }
}
