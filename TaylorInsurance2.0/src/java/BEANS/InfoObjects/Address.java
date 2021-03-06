package BEANS.InfoObjects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SPOO
 */
public class Address {

    private String city;
    private String country;
    private String postalCode;
    private String province;
    private String streetAddress1;
    private String streetAddress2;

    public Address(String city, String province, String streetAddress1, String country, String postalCode) {
        setCity(city);
        setProvince(province);
        setStreetAddress1(streetAddress1);
        setCountry(country);
        setPostalCode(postalCode);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    @Override
    public String toString() {
        return streetAddress1 + "<br>" + city + ", " + province + ", " + country + "<br>" + postalCode;
    }

}
