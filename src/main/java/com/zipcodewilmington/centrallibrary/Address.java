package com.zipcodewilmington.centrallibrary;

public class Address {

    private String streetName;
    private String city;
    private String state;
    private int zipCode;

    
    public Address() {
        this("Unknown", "Unknown", "UN", 0);
    }
 
    public Address(String streetName, String city, String state, int zipCode) {
        setStreetName(streetName);
        setCity(city);
        setState(state);
        setZipCode(zipCode);
    }


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


    public void setStreetName(String streetName) {
        if (streetName == null || streetName.trim().isEmpty()) {
            throw new IllegalArgumentException("Street name cannot be empty");
        }
        this.streetName = streetName.trim();
    }

    public void setCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty");
        }
        this.city = city.trim();
    }

    public void setState(String state) {
        if (state == null || state.trim().isEmpty()) {
            throw new IllegalArgumentException("State cannot be empty");
        }
        if (state.length() != 2) {
            throw new IllegalArgumentException("State must be 2 letters (ex: NY, CA)");
        }
        this.state = state.toUpperCase();
    }

    public void setZipCode(int zipCode) {
        if (zipCode < 0) {
            throw new IllegalArgumentException("Zip code cannot be negative");
        }
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return streetName + ", " + city + ", " + state + " " + zipCode;
    }
}
