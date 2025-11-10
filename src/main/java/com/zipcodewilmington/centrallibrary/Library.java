package com.zipcodewilmington.centrallibrary;

import java.util.List;
import java.util.ArrayList;

public class Library {
    private String name;
    private Address address;
    private List<LibraryItem> items;

    public Library(String name, Address address) {
        this.name = name;
        this.address = address;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<LibraryItem> getItems() {
        return items;
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void displayAllItems() {
        System.out.println("=== Library Items ===");
        System.out.printf("%-15s %-30s %-15s%n".formatted("Type", "Title", "Status"));
        System.out.println("----------------------------------------------------------");
        for (LibraryItem item : items) {
            String availability = item.isAvailable() ? "Available" : "Checked Out";
            System.out.printf("%-15s %-30s %-15s%n", item.getItemType(), item.getTitle(), availability);
        }
        System.out.println("Total items: " + items.size());
        }
}
