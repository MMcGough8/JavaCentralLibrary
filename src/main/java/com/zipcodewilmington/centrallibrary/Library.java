package com.zipcodewilmington.centrallibrary;

import java.util.List;
import java.util.ArrayList;

public class Library {
    // Private fields to store library info.
    private String name;
    private Address address;
    private List<LibraryItem> items; 
    private List<Librarian> librarians;
    private List<LibraryMember> libraryMembers;

    //Constructor to initialize a new library with a name and address
    public Library(String name, Address address) {
        this.name = name;
        this.address = address;
        this.items = new ArrayList<>();
        this.librarians = new ArrayList<>();
        this.libraryMembers = new ArrayList<>();
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

    public List<Librarian> getLibrarians() {
        return librarians;
    }

    public List<LibraryMember> getLibraryMembers() {
        return libraryMembers;
    }

    //Method to add a new item to the library's collection
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
    }

    public void addLibraryMember(LibraryMember member) {
        libraryMembers.add(member);
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

    public boolean removeLibrarian(String employeeId) {
        for (int i = 0; i < librarians.size(); i++) {
            if (librarians.get(i).getEmployeeId().equals(employeeId)) {
                librarians.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeLibraryMember(String memberId) {
        for (int i = 0; i < libraryMembers.size(); i++) {
            if (libraryMembers.get(i).getMemberId().equals (memberId)) {
                libraryMembers.remove(i);
                return true;
            }
        }
        return false;
    }

    public Librarian findLibrarian(String employeeId) {
        for (Librarian librarian : librarians) {
            if (librarian.getEmployeeId().equals (employeeId)) {
                return librarian;
            }
        }
        return null;
    }

    public LibraryMember findLibraryMember(String memberId) {
        for (LibraryMember member : libraryMembers) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
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
        
    public void generateLateFeeReport() {
        String header = "=== Late Fee Report ===";
        int totalWidth = 80;
        int padding = (totalWidth - header.length()) / 2;
        System.out.println(" ".repeat(padding) + header);
        System.out.println("--------------------------------------------------------------------------------");

        for (LibraryMember member : libraryMembers) {
            System.out.println("\nMember: " + member.getName());
            List<LibraryItem> borrowed = member.getBorrowedItems();

                if (borrowed.isEmpty()) {
                    System.out.println("  No borrowed items");
                } else {
                    System.out.printf("  %-30s %-20s %-15s%n", "Title", "Max Borrow Days", "Late Fee");
                    System.out.println("  ----------------------------------------------------------------------");

                for (LibraryItem item : borrowed) {
                    int daysOverdue = 0;
                    double lateFee = item.calculateLateFee(daysOverdue);
                    System.out.printf("  %-30s %-20d $%-14.2f%n", item.getTitle(), item.getMaxBorrowDays(), lateFee);
                }
            }
        }
        System.out.println("--------------------------------------------------------------------------------");
    }
}