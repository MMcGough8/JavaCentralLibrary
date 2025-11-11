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
    public Address(String streetName, String city, String state, int zipCode) {
    
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
    
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

}

