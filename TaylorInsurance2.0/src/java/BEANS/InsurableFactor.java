package BEANS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SPOO
 */
class InsurableFactor {
    public static final int SEARCH_EQUAL = 1;
    public static final int SEARCH_GREATER_THAN = 2;
    public static final int SEARCH_LESS_THAN = 3;
    public static final int SEARCH_NOT_EQUAL = 4;
    
    /**
     * 
     */
    public int searchMethod;
    public String dataset;
    public String factor;

    public InsurableFactor(int searchMethod, String dataset, String factor) {
        setSearchMethod(searchMethod);
        setDataset(dataset);
        setFactor(factor);
    }
    
    public final int getSearchMethod() {
        return searchMethod;
    }

    public final void setSearchMethod(int searchMethod) {
        this.searchMethod = searchMethod;
    }

    public final String getDataset() {
        return dataset;
    }

    public final void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public final String getFactor() {
        return factor;
    }

    public final void setFactor(String factor) {
        this.factor = factor;
    }
    
    
}
