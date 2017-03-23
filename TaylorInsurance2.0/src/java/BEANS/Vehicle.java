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
 * @author SPOO
 */
public class Vehicle implements Insurable {
    private String year;
    private String make;
    private String model;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<InsurableFactor> getInsurableFactors() {
        List<InsurableFactor> factorList = new ArrayList();
        factorList.add(new InsurableFactor(InsurableFactor.SEARCH_EQUAL, "AUTO_YEAR", this.year));
        factorList.add(new InsurableFactor(InsurableFactor.SEARCH_EQUAL, "AUTO_MAKE", this.make));
        factorList.add(new InsurableFactor(InsurableFactor.SEARCH_EQUAL, "AUTO_MODEL", this.model));
        return factorList;
    }

    public double getBasePremium() {
        return 750;
    }
    
    
}
