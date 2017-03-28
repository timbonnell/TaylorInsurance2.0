package BEANS.InfoObjects;

/**
 *
 * @author MW
 */
public class House implements HouseInsurable {

    private Address address;
    private int type;
    private int year;
    private int heating;
    private int houseID;

    public int getHouseID() {
        return houseID;
    }

    public void setHouseID(int houseID) {
        this.houseID = houseID;
    }

    public House() {
    }

    public House(Address address, int type, int year, int heating) {
        this.setAddress(address);
        this.setType(type);
        this.setYear(year);
        this.setHeating(heating);
    }

    public final Address getAddress() {
        return address;
    }

    public final void setAddress(Address address) {
        this.address = address;
    }

    public final int getType() {
        return type;
    }

    public final void setType(int type) {
        this.type = type;
    }

    public final int getYear() {
        return year;
    }

    public final void setYear(int year) {
        this.year = year;
    }

    public final int getHeating() {
        return heating;
    }

    public final void setHeating(int heating) {
        this.heating = heating;
    }

    @Override
    public String getIdentifier() {
        return "HOUSE";
    }

}
