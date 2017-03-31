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
public class Vehicle implements VehicleInsurable {

    private String make;
    private String model;
    private int year;
    private int type;
    private String vin;
    private int vehicleID;
    private int color;
    private int numAccidents;
    private double estimated_value;

    public double getEstimated_value() {
        return estimated_value;
    }

    public void setEstimated_value(double estimated_value) {
        this.estimated_value = estimated_value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getNumAccidents() {
        return numAccidents;
    }

    public void setNumAccidents(int numAccidents) {
        this.numAccidents = numAccidents;
    }

    @Override
    public String getIdentifier() {
        return "AUTO";
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "make=" + make + ", model=" + model + ", year=" + year + ", type=" + type + ", vin=" + vin + ", vehicleID=" + vehicleID + ", color=" + color + ", numAccidents=" + numAccidents + '}';
    }

}
