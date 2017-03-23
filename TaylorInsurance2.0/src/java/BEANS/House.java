package BEANS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MW
 */
public class House implements Insurable {

    private Address address;
    private String type;
    private String year;
    private String heating;

    public List<InsurableFactor> getInsurableFactors() {
        List<InsurableFactor> factorList = new ArrayList();
        factorList.add(new InsurableFactor(InsurableFactor.SEARCH_EQUAL, "HOUSE_YEAR", this.year));
        factorList.add(new InsurableFactor(InsurableFactor.SEARCH_EQUAL, "HOUSE_HEATING_TYPE", this.heating));
        factorList.add(new InsurableFactor(InsurableFactor.SEARCH_EQUAL, "HOUSE_TYPE", this.type));
        factorList.add(new InsurableFactor(InsurableFactor.SEARCH_EQUAL, "HOUSE_CITY", this.address.getCity()));        
        factorList.add(new InsurableFactor(InsurableFactor.SEARCH_EQUAL, "HOUSE_PROVINCE", this.address.getProvince()));        
        factorList.add(new InsurableFactor(InsurableFactor.SEARCH_EQUAL, "HOUSE_ADDRESS1", this.address.getStreetAddress1()));        
        factorList.add(new InsurableFactor(InsurableFactor.SEARCH_EQUAL, "HOUSE_ADDRESS2", this.address.getStreetAddress2()));        
        factorList.add(new InsurableFactor(InsurableFactor.SEARCH_EQUAL, "HOUSE_COUNTRY", this.address.getCountry()));        
        factorList.add(new InsurableFactor(InsurableFactor.SEARCH_EQUAL, "HOUSE_POSTALCODE", this.address.getPostalCode()));
        return factorList;
    }

    public double getBasePremium() {
        return 750;
    }
    
    
}
