package com.zipcodewilmington.centrallibrary;

/**
 * Created by n3pjk on 6/9/2025.
 */
public class Address {

    // Private fields

    private String streetName;
    private String city;
    private String state;
    private int zipCode;
    
    
    // Default constructor
    public Address() {
    }
    
    // Parameterized constructor
    public Address(String streetName, String city, String state, String zipCode) {
    
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        
    }
    
    // Getters
    public String getStreetName() {
        return streetName;
    }

    
    public String getCity() {
        return city;
    }
    
    public String getState() {
        return state;
    }
    
    public int getZipCode() {
        return zipCode;
    }
    
    
    
    // Setters

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    
    




    //or override toString method

    //toString method for easy printing;

    //@Override
    //public String toString() {
        //return streetName + "\n" + 
               //city + ", " + state + " " + zipCode;
    //}


    // or override equals method
    // equals method for comparing addresses
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Address address = (Address) obj;
        return streetName.equals(address.streetName) &&
               city.equals(address.city) &&
               state.equals(address.state) &&
               //?zipCode.equals(address.zipCode);
            
    }
    


    // or hashCode method
    //@Override
   //public int hashCode() {
        //int result = 31 * result + (streetName  != null ? streetName.hashCode() : 0);
        //result = 31 * result + (city != null ? city.hashCode() : 0);
        //result = 31 * result + (state != null ? state.hashCode() : 0);
        //result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        //return result;
    //}
    
    // test Example usage
    //? public static void main(String[] args) {
        // Creating an address using the parameterized constructor
        Address address1 = new Address(
            "123 Main Street",
            "Springfield",
            "IL",
            "62701",
    
        );
        
        // Creating an address using default constructor and setters
        Address address2 = new Address();
        address2.setStreetName("456 Oak Avenue");
        address2.setCity("Portland");
        address2.setState("OR");
        address2.setZipCode("97201");

        
        // Printing addresses
        
        System.out.println("Address 1:");
        System.out.println(address1);
        System.out.println("\nAddress 2:");
    
        
        // Accessing individual fields
        System.out.println("\nCity from Address 1: " + address1.getCity());
    }
}

