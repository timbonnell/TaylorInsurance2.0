/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEANS.InfoObjects.House;
import SERVLETS.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author timbo
 */
public class HouseDAO {

    public static House createHouse(House house) {

        // Set up house attributes
        int houseType = house.getType();
        int houseYear = house.getYear();
        int houseHeating = house.getHeating();
        String houseCity = house.getAddress().getCity();
        //String houseProv = house.getAddress().getProvince();
        String houseStreet = house.getAddress().getStreetAddress1();
        String housePostal = house.getAddress().getPostalCode();
        String houseCountry = house.getAddress().getCountry();

        String SPsql = "EXEC insertHouse ?,?,?,?,?,?,?,?";

        try (Connection con = ConnectionManager.getConnection();
                PreparedStatement ps = con.prepareStatement(SPsql)) {
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(30);
            //Set up params for stored procedure
            ps.setInt(1, houseType);
            ps.setInt(2, houseYear);
            ps.setInt(3, houseHeating);
            ps.setString(4, houseCity);
            ps.setInt(5, 10);
            ps.setString(6, houseStreet);
            ps.setString(7, housePostal);
            ps.setString(8, houseCountry);
            System.out.println("EXEC insertHouse" + houseType + "," + houseYear + "," + houseHeating + "," + houseCity + "," + 10 + "," + houseStreet + "," + housePostal + "," + houseCountry);

            //rs = ps.execute();
            System.out.println("EXEC insertHouse" + houseType + "," + houseYear + "," + houseHeating + "," + houseCity + "," + 10 + "," + houseStreet + "," + housePostal + "," + houseCountry);

            ps.execute();
            ResultSet rs = ps.getResultSet();
            boolean more = rs.next();
            System.out.println(more);
            //Checks to see if house id comes back (house was stored successfully)
            if (!more) {
                System.out.println(rs + "invalid");

            } // If username and password are correct, set client to valid and set up the client
            else if (more) {
                rs = ps.getResultSet();
                System.out.println("House ID: " + rs.getString(1));
                house.setHouseID(Integer.parseInt(rs.getString(1)));
            }
        } catch (Exception ex) {
            System.out.println("createHouse: An Exception has occurred! " + ex);
        } //Exception handling and closing

        return house;
    }

}
