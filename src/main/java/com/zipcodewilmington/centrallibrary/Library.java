package com.zipcodewilmington.centrallibrary;



public class Library {
    private String name;
    private Address address;

    public Library(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

}
