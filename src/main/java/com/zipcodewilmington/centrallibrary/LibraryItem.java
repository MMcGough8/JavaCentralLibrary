package com.zipcodewilmington.centrallibrary;

/**
 * Abstract LibraryItem class representing an item in the library.
 * Implements Searchable interface and serves as base class for Book, Periodical, and DVD.
 */
public abstract class LibraryItem implements Searchable {
    
    protected String id;
    protected String title;
    protected String location;
    protected boolean isAvailable;
    
    /**
     * Constructor for LibraryItem
     */
    public LibraryItem(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.isAvailable = true; // Item is available when created
    }
    
    // Getters
    public String getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getLocation() {
        return location;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    // Setters
    public void setId(String id) {
        this.id = id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    
    /**
     * Check out an item (makes it unavailable)
     */
    public boolean checkOut() {
        if (this.isAvailable) {
            this.isAvailable = false;
        }
        return this.isAvailable;
    }
    
    /**
     * Check in an item (makes it available)
     */
    public boolean checkIn() {
        this.isAvailable = true;
        return this.isAvailable;
    }
    
    /**
     * Abstract method for calculating late fees
     */
    public abstract double calculateLateFee(int daysLate);
    
    /**
     * Abstract method for getting max borrow days
     */
    public abstract int getMaxBorrowDays();
    
    /**
     * Abstract method for getting item type
     */
    public abstract String getItemType();
    
    @Override
    public abstract java.util.List<String> getSearchableFields();
}
