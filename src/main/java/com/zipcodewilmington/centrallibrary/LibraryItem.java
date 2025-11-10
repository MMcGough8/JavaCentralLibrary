package com.zipcodewilmington.centrallibrary;

// TEMPORARY SUB 
public class LibraryItem {
    private String id;
    private String title;
    private String itemType;
    private boolean isAvailable;
    
    public LibraryItem(String id, String title, String itemType) {
        this.id = id;
        this.title = title;
        this.itemType = itemType;
        this.isAvailable = true;  // Default to available
    }
    
    public String getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getItemType() {
        return itemType;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}
