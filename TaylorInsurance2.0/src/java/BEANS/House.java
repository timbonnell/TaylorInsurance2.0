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

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    public String getHeating() {
        return heating;
    }
    public void setHeating(String heating) {
        this.heating = heating;
    }

    public House(Address address, String type, String year, String heating) {
        this.setAddress(address);
        this.setType(type);
        this.setYear(year);
        this.setHeating(heating);
    }
    
    public List<InsurableFactor> getInsurableFactors() {
        List<InsurableFactor> factorList = new ArrayList();
        factorList.add(new InsurableFactor(InsurableFactor.SEARCH_EQUAL, "HOUSE_YEAR", this.year));
        factorList.add(new InsurableFactor(InsurableFactor.SEARCH_EQUAL, "HOUSE_HEATING_TYPE", this.heating));
        factorList.add(new InsurableFactor(InsurableFactor.SEARCH_EQUAL, "HOUSE_TYPE", this.type));
        factorList.add(new InsurableFactor(InsurableFactor.SEARCH_EQUAL, "HOUSE_CITY", this.address.getCity()));        
        factorList.add(new InsurableFactor(InsurableFactor.SEARCH_EQUAL, "HOUSE_PROVINCE", this.address.getProvince()));        
        factorList.add(new InsurableFactor(InsurableFactor.SEARCH_EQUAL, "HOUSE_COUNTRY", this.address.getCountry()));        
        return factorList;
    }

    public double getBasePremium() {
        return 750;
    }
    
    
}
