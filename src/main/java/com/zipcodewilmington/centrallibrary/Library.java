package com.zipcodewilmington.centrallibrary;



public class Library {
    private String name;

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Temporary main method for testing
    public static void main(String[] args) {
        Library library = new Library("Central Library");
        System.out.println("Library name: " + library.getName());
    }
}
