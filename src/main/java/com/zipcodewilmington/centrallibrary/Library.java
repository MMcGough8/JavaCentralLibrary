package com.zipcodewilmington.centrallibrary;

import java.util.List;
import java.util.ArrayList;

public class Library {
    // Private fields to store library info.
    private String name;
    private Address address;
    private List<LibraryItem> items; 
    private List<LibraryMember> librarymember;

    //Constructor to initialize a new library with a name and address
    public Library(String name, Address address) {
        this.name = name;
        this.address = address;
        this.items = new ArrayList<>();
        this.librarymember = new ArrayList<>();
    }

    // Start of getter methods
    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<LibraryItem> getItems() {
        return items;
    }

    //Method to add a new item to the library's collection
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    // Metho to remove an item from the library by its ID 
    // Returns true if item was found and removed, otherwise false
    public boolean removeItem(String itemId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(itemId)) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

public List<LibraryItem> searchItems(String keyword) {
    List<LibraryItem> results = new ArrayList<>();
    for (LibraryItem item : items) {
        if (item.matchesKeyword(keyword)) {
            results.add(item);
        }
    }
    return results;
}

    //Method to display all items in the library.
    public void displayAllItems() {
        String header = "=== Library Items ===";
        int totalWidth = 60;
        int padding = (totalWidth - header.length()) / 2;
        System.out.println(" ".repeat(padding) + header);
        System.out.println("----------------------------------------------------------");
        System.out.printf("%-15s %-30s %-15s%n", "Type", "Title", "Status");
        System.out.println("----------------------------------------------------------");
        for (LibraryItem item : items) {
            String availability = item.isAvailable() ? "Available" : "Checked Out";
            System.out.printf("%-15s %-30s %-15s%n", item.getItemType(), item.getTitle(), availability);
        }
        System.out.println("Total items: " + items.size());
        }
}
