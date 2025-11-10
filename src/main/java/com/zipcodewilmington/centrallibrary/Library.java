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
}
