package BEANS.InfoObjects;

import java.time.LocalDate;

/**
 *
 * @author 20124135
 */
public class Customer implements CustomerInsurable {

    public boolean valid;
    private Address address;
    private LocalDate birthDate;
    private String email;
    private String firstName;
    private String id;
    private String lastName;
    private String password;
    private String phoneNumber;

    public Customer() {
    }

    public Customer(String id, String firstName, String lastName, LocalDate birthDate, Address address, String email, String password, String phoneNumber, boolean valid) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
        setAddress(address);
        setPassword(password);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setValid(valid);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getIdentifier() {
        return "CUSTOMER";
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean newValid) {
        valid = newValid;
    }

}
