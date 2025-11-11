package com.zipcodewilmington.centrallibrary;

public abstract class LibraryItem {
    
    protected String id;
    protected String title;
    protected String location;
    protected boolean isAvailable;
    
    public LibraryItem(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.isAvailable = true;
    }
    
    public String getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public boolean checkOut() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }
    
    public boolean checkIn() {
        if (!isAvailable) {
            isAvailable = true;
            return true;
        }
        return false;
    }
    
    public abstract double calculateLateFee(int daysOverdue);
    
    public abstract int getMaxBorrowDays();
    
    public abstract String getItemType();
    
    public boolean matchesKeyword(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return false;
        }
        
        String lowerKeyword = keyword.toLowerCase();
        return title.toLowerCase().contains(lowerKeyword) ||
               id.toLowerCase().contains(lowerKeyword);
    }
    
    @Override
    public String toString() {
        return String.format("%s: %s (ID: %s, Location: %s, Available: %s)",
                getItemType(), title, id, location, isAvailable ? "Yes" : "No");
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        LibraryItem that = (LibraryItem) obj;
        return id.equals(that.id);
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
