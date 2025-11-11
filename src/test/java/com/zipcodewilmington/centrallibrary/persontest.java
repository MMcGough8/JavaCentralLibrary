package com.zipcodewilmington.centrallibrary;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Persontest {
    
    @Test
    public void testConstructorAndGetters() { 
        Person person = new Person("Alice Johnson", 25, "alice@email.com", "555-1234");
        assertEquals("Alice Johnson", person.getName());
        assertEquals(25, person.getAge());
        assertEquals("alice@email.com", person.getEmail());
        assertEquals("555-1234", person.getPhoneNumber());
    }
    
    @Test
    public void testSetNameWithValidName() {
        Person person = new Person("Alice", 25, "alice@email.com", "555-1234");
        person.setName("Bob Wilson");
        assertEquals("Bob Wilson", person.getName());
    }
    
    @Test
    public void testSetAgeWithValidAge() {
        Person person = new Person("Alice", 25, "alice@email.com", "555-1234");
        person.setAge(30);
        assertEquals(30, person.getAge());
    }
}

