package com.zipcodewilmington.centrallibrary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by n3pjk on 6/9/2025.
 */
public class AddressTest {

    @Test
    public void shouldAnswerWithTrue() {
        // Creating an address using the parameterized constructor
        Address address1 = new Address( "123 Main Street",
                                        "Springfield",
                                        "IL",
                                        62701);

        Address address2 = new Address();address2.setStreetName("456 Oak Avenue");
        address2.setCity("Portland");
        address2.setState("OR");
        address2.setZipCode(97201);
        
        Assertions.assertTrue(true);
    }

}
