/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEANS.TestObjects;



import BEANS.PolicyObjects.Quote;
import BEANS.InfoObjects.Customer;
import BEANS.InfoObjects.Vehicle;
import BEANS.InfoObjects.Address;
import BEANS.PolicyObjects.VehicleQuote;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author SPOO
 */
public class Tester {
    
    
    public static Customer getTestClient() {
        Customer customer = new Customer();
        customer.setId("100");
        customer.setPhoneNumber("7095551234");
        customer.setFirstName("John");
        customer.setLastName("Smith");
        customer.setEmail("john.smith@gmail.com");
        customer.setBirthDate(LocalDate.of(1991, Month.MAY, 23));
        Address address = new Address("St John's", "NL", "22 Doris Place", "Canada", "A1A 1A1");
        customer.setAddress(address);
        return customer;
    }
    
    public static Vehicle getTestVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake("Toyota");
        vehicle.setModel("Matrix");
        vehicle.setYear(2014);
        return vehicle;
    }
    
    public static Quote getTestVehicleQuote() {
        
        return new VehicleQuote("2000", LocalDate.of(2010, 8, 8), getTestClient(), getTestVehicle());
    }
}
