
/*******************************************************************
 * Name: Anosha Naseri
 * Date: 10/21/2026
 * Assignment: C330L Week 3 Course Project
 * Title: Abstraction, Constructors, & Access Specifiers
 *
 * Description:
 * This class represents an employee's address in the
 * Employee Management System.
 *
 * It stores the street, city, state, and ZIP code.
 * The abstract Employee superclass contains an Address
 * object to demonstrate composition.
 *
 * This class demonstrates overloaded constructors,
 * encapsulation, access specifiers, and composition.
 *******************************************************************/

public class Address {

    // ACCESS SPECIFIERS:
    // Private fields protect address information from
    // direct modification outside this class.
    private String street;
    private String city;
    private String state;
    private String zipCode;

    // PARAMETERIZED CONSTRUCTOR:
    // Initializes all address information.
    public Address(String street, String city,
                   String state, String zipCode) {

        setStreet(street);
        setCity(city);
        setState(state);
        setZipCode(zipCode);
    }

    // OVERLOADED CONSTRUCTOR:
    // Allows an address to be created without a street.
    // This is useful when only the city, state, and
    // ZIP code are available.
    public Address(String city, String state, String zipCode) {
        this("Not Provided", city, state, zipCode);
    }

    // Public getter for street.
    public String getStreet() {
        return street;
    }

    // Public setter validates street information.
    public void setStreet(String street) {
        if (street == null || street.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Street cannot be empty.");
        }

        this.street = street.trim();
    }

    // Public getter for city.
    public String getCity() {
        return city;
    }

    // Public setter validates city information.
    public void setCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "City cannot be empty.");
        }

        this.city = city.trim();
    }

    // Public getter for state.
    public String getState() {
        return state;
    }

    // Public setter validates state information.
    public void setState(String state) {
        if (state == null || state.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "State cannot be empty.");
        }

        this.state = state.trim();
    }

    // Public getter for ZIP code.
    public String getZipCode() {
        return zipCode;
    }

    // Public setter validates ZIP code information.
    // ZIP codes are stored as strings to preserve
    // leading zeros.
    public void setZipCode(String zipCode) {
        if (zipCode == null || zipCode.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "ZIP code cannot be empty.");
        }

        this.zipCode = zipCode.trim();
    }

    // METHOD OVERRIDING:
    // Displays the complete employee address.
    @Override
    public String toString() {
        return street + ", " + city + ", "
                + state + " " + zipCode;
    }
}
