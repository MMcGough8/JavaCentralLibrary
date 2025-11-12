package com.zipcodewilmington.centrallibrary;

public class Person {

    protected String name;                // created with private fields to prevent access from outside the class
    protected int age;
    protected String email;
    protected String phoneNumber;
    
    public Person(String name, int age, String email, int phoneNumber) {         // constructor with necessary fields
        setName(name);                                                              // using constructor call setter methods
        setAge(age);                                                                // allows for validation checks (no negative ages, invalid phone numbers etc.)
        setEmail(email);                                
        setPhoneNumber(phoneNumber);                    
    }

    public String getName() {               // these are the getters: provide READ access to each private field
        return name;
    }

    public int getAge() {                               
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }                                      // end of getters

    public void setName(String name) {                      // Setters with validation as to not set things to unusable values
        if (name == null || name.trim().isEmpty()) {        // if name is null or empty, throws an error
            throw new Error("Name cannot be null or empty");
        }
        this.name = name.trim();
    }

    public void setAge(int age) {                                      
        if (age < 0 || age > 120) {                                           
            throw new Error("Age must be between 0 and 120");   // age must be between 0 and 120 or else you get an error (sorry 121 year olds)
        }
        this.age = age;
    }


    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new Error("Email cannot be null or empty");
        }
        if (!email.contains("@") || !email.contains(".")) {             // if email is empty, null, doesnt contain an @, or doesnt contain a '.' : throw an error
            throw new Error("Email must contain @ and a domain");
        }
        this.email = email.trim();
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {                      // if phone number is null or empty, throw an error
            throw new Error("Phone number cannot be null or empty");
        }
        String digitsOnly = phoneNumber.replaceAll("[^0-9]", "");   // replace all the non-digits with empty space
        if (digitsOnly.length() < 7 || digitsOnly.length() > 15) {                      // number must be between 7 and 15 digits
            throw new Error("Phone number must contain 7-15 digits");
        }
        this.phoneNumber = phoneNumber.trim();                                          // using .trim in all the string setters to get rid of any accidental blank spaces from user input
    }                                                   // end of setters
}
