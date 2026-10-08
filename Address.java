/*******************************************************************
 * Name: Anosha Naseri
 * Date: 10/08/2026
 * Assignment: C330L Week 1 Project
 * Title: Inheritance, Composition, and User Interactions
 *
 * Description:
 * This class represents an employee's address. It stores the
 * street, city, state, and ZIP code. The Employee class contains
 * an Address object to demonstrate composition.
 *******************************************************************/

public class Address {

    private String street;
    private String city;
    private String state;
    private String zipCode;

    // Constructor
    public Address(String street, String city, String state,
                   String zipCode) {

        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Getter and setter methods
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    // Display the complete address
    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " " + zipCode;
    }
}