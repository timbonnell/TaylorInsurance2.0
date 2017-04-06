package BEANS.BusinessProcessObjects;

import BEANS.InfoObjects.*;
import BEANS.PolicyObjects.*;
import DAO.CustomerDAO;
import DAO.HouseDAO;
import DAO.PolicyDAO;
import DAO.QuoteDAO;
import DAO.VehicleDAO;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * The BusinessProcessManager class is intended to be a central convenience
 * object which holds all the necessary business objects and performs tasks in
 * accordance with business processes.
 *
 * Some functions require certain things be in place before other operations
 * take
 *
 * @author SPOO
 */
public class BusinessProcessManager {

    private Customer customer;

    private final Map<String, House> houseList = new HashMap();
    private final Map<String, HousePolicy> housePolicyList = new HashMap();

    private final Map<String, HouseQuote> houseQuoteList = new HashMap();
    private final Map<String, Vehicle> vehicleList = new HashMap();

    private final Map<String, VehiclePolicy> vehiclePolicyList = new HashMap();
    private final Map<String, VehicleQuote> vehicleQuoteList = new HashMap();

    public void addExistingHouse(House house) {
        houseList.put(house.getHouseId(), house);
    }

    public void addExistingHousePolicy(String houseQuoteId, String policyId, LocalDate creationDate, LocalDate expiryDate) {
        HousePolicy policy = new HousePolicy(policyId, houseQuoteList.get(houseQuoteId), creationDate, expiryDate);
        housePolicyList.put(policyId, policy);
    }

    public void addExistingHouseQuote(String houseId, String quoteId, LocalDate creationDate, LocalDate expiryDate) {
        HouseQuote quote = new HouseQuote(quoteId, creationDate, expiryDate, customer, getHouse(houseId));
        houseQuoteList.put(quoteId, quote);
    }

    public void addExistingVehicle(Vehicle vehicle) {
        vehicleList.put(vehicle.getVehicleId(), vehicle);
    }

    public void addExistingVehiclePolicy(String vehicleQuoteId, String policyId, LocalDate creationDate, LocalDate expiryDate) {
        VehiclePolicy policy = new VehiclePolicy(policyId, vehicleQuoteList.get(vehicleQuoteId), creationDate, expiryDate);
        vehiclePolicyList.put(policyId, policy);
    }

    public void addExistingVehicleQuote(String vehicleId, String quoteId, LocalDate creationDate, LocalDate expiryDate) {
        VehicleQuote quote = new VehicleQuote(quoteId, creationDate, expiryDate, customer, getVehicle(vehicleId));
        vehicleQuoteList.put(quoteId, quote);
    }

    public Customer createNewCustomer(Customer customer) {
        setCustomer(customer);
        return CustomerDAO.createInit(customer);
    }

    public House createNewHouse(House house) {
        HouseDAO.createHouse(house);
        houseList.put(house.getHouseId(), house);
        return house;
    }

    public HousePolicy createNewHousePolicy(String quoteId) {

        HouseQuote quote = houseQuoteList.get(quoteId);
        if (quote == null) {
            throw new IndexOutOfBoundsException("Bad house quote ID: " + quoteId);
        } else {
            HousePolicy policy = new HousePolicy("0", quote, LocalDate.now(), LocalDate.now().plusYears(1));
            policy.setId(PolicyDAO.acceptHomePolicy(quoteId));
            housePolicyList.put(policy.getId(), policy);
            return policy;
        }
    }

    public HouseQuote createNewHouseQuote(String houseID) {
        House house = houseList.get(houseID);
        if (house == null) {
            throw new IndexOutOfBoundsException("Bad house ID: " + houseID);
        } else {
            HouseQuote quote = new HouseQuote("0", LocalDate.now(), LocalDate.now().plusDays(30), customer, house);
            QuoteDAO.createHouseQuote(quote);
            houseQuoteList.put(quote.getId(), quote);
            return quote;
        }
    }

    public Vehicle createNewVehicle(Vehicle vehicle) {
        VehicleDAO.createVehicle(vehicle);
        vehicleList.put(vehicle.getVehicleId(), vehicle);
        return vehicle;
    }

    public VehiclePolicy createNewVehiclePolicy(String quoteId) {

        VehicleQuote quote = vehicleQuoteList.get(quoteId);
        if (quote == null) {
            throw new IndexOutOfBoundsException("Bad vehicle quote ID: " + quoteId);
        } else {
            VehiclePolicy policy = new VehiclePolicy("0", quote, LocalDate.now(), LocalDate.now().plusYears(1));
            policy.setId(PolicyDAO.acceptAutoPolicy(quoteId));
            vehiclePolicyList.put(policy.getId(), policy);
            return policy;
        }
    }

    public VehicleQuote createNewVehicleQuote(String vehicleID, int accidents) {

        Vehicle vehicle = vehicleList.get(vehicleID);
        if (vehicle == null) {
            throw new IndexOutOfBoundsException("Bad vehicle ID: " + vehicleID);
        } else {
            VehicleQuote quote = new VehicleQuote("0", LocalDate.now(), LocalDate.now().plusDays(30), customer, vehicle);
            QuoteDAO.createVehicleQuote(quote, accidents);
            vehicleQuoteList.put(quote.getId(), quote);
            return quote;
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public House getHouse(String houseId) {
        return houseList.get(houseId);
    }

    public Map<String, House> getHouseList() {
        return houseList;
    }

    public HousePolicy getHousePolicy(String policyId) {
        return housePolicyList.get(policyId);
    }

    public Map<String, HousePolicy> getHousePolicyList() {
        return housePolicyList;
    }

    public HouseQuote getHouseQuote(String quoteId) {
        return houseQuoteList.get(quoteId);
    }

    public Map<String, HouseQuote> getHouseQuoteList() {
        return houseQuoteList;
    }

    public Vehicle getVehicle(String vehicleId) {
        return vehicleList.get(vehicleId);
    }

    public Map<String, Vehicle> getVehicleList() {
        return vehicleList;
    }

    public VehiclePolicy getVehiclePolicy(String policyId) {
        return vehiclePolicyList.get(policyId);
    }

    public Map<String, VehiclePolicy> getVehiclePolicyList() {
        return vehiclePolicyList;
    }

    public VehicleQuote getVehicleQuote(String quoteId) {
        return vehicleQuoteList.get(quoteId);
    }

    public Map<String, VehicleQuote> getVehicleQuoteList() {
        return vehicleQuoteList;
    }

    /**
     * Convenience function that uses the stored customer to load all the
     * objects from the database.
     *
     */
    public void loadAllCustomerInformation() {
        CustomerDAO.login(customer);
    }

    public boolean registerCustomer(String password) {
        this.customer.setPassword(password);
        return CustomerDAO.register(customer);
    }

}
