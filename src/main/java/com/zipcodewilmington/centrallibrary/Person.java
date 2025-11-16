package com.zipcodewilmington.centrallibrary;

public class Person {

    private String name;
    private int age;
    private String email;
    private int phoneNumber;

    public Person(String name, int age, String email, int phoneNumber) {
        setName(name);
        setAge(age);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

  
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }


    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name.trim();
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120");
        }
        this.age = age;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Email must contain @ and a domain");
        }
        this.email = email.trim();
    }

    public void setPhoneNumber(int phoneNumber) {
        if (phoneNumber <= 0) {
            throw new IllegalArgumentException("Phone number must be a positive integer");
        }
        this.phoneNumber = phoneNumber;
    }
}
