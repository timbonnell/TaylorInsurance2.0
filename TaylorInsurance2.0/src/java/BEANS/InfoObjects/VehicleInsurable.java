package BEANS.InfoObjects;

/**
 *
 * @author SPOO
 */
public interface VehicleInsurable extends Insurable {
    
    public String getVehicleId();
    public int getYear();
    public int getNumAccidents();
}
