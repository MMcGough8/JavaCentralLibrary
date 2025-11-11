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
    public void displayAllItems() {
        String header = "=== Library Items ===";
        int totalWidth = 60;
        int padding = (totalWidth - header.length()) / 2;
        System.out.println(" ".repeat(padding) + header);
        System.out.println("----------------------------------------------------------");
        System.out.printf("%-15s %-30s %-15s%n".formatted("Type", "Title", "Status"));
        System.out.println("----------------------------------------------------------");
        for (LibraryItem item : items) {
            String availability = item.isAvailable() ? "Available" : "Checked Out";
            System.out.printf("%-15s %-30s %-15s%n", item.getItemType(), item.getTitle(), availability);
        }
        System.out.println("Total items: " + items.size());
        }
}
