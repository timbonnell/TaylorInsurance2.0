/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEANS.InfoObjects.Customer;
import BEANS.InfoObjects.House;
import BEANS.InfoObjects.Vehicle;
import BEANS.PolicyObjects.HouseQuote;
import BEANS.PolicyObjects.VehicleQuote;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author timbo
 */
public class QuoteDAO {
    
    static Connection connection = null;
    static ResultSet rs = null;
    static PreparedStatement ps;
    
    public static void createHouseQuote(Customer Client, House house, HouseQuote houseQuote){
        
    }
    
    public static void createVehicleQuote(Customer Client, Vehicle vehicle, VehicleQuote vehicleQuote){
        
    }
    
    
}
