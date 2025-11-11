package com.zipcodewilmington.centrallibrary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by n3pjk on 6/9/2025.
 */
public class MainApplicationTest {

    MainApplication app = new MainApplication();

    @Test
    public void shouldAnswerWithTrue() {
        Assertions.assertTrue(true);
    }

}



public static void main(String[] args) {
        // Creating an address using the parameterized constructor
        Address address1 = new Address(
            "123 Main Street",
            "Springfield",
            "IL",
            "62701",
            "USA"
        );
        
        // Creating an address using default constructor and setters
        Address address2 = new Address();
        address2.setStreet("456 Oak Avenue");
        address2.setCity("Portland");
        address2.setState("OR");
        address2.setZipCode("97201");
        address2.setCountry("USA");
        
        // Printing addresses
        System.out.println("Address 1:");
        System.out.println(address1);
        System.out.println("\nAddress 2:");
        System.out.println(address2);
        
        // Accessing individual fields
        System.out.println("\nCity from Address 1: " + address1.getCity());
    }
