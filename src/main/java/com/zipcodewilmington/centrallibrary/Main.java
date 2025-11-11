package com.zipcodewilmington.centrallibrary;

// Parent class
class LibraryItems {
    private String title;
    private String itemId;
    private boolean isCheckedOut;
    
    public LibraryItem (String title, String itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isCheckedOut = false;
    }
    
    public void checkOut() {
        isCheckedOut = true;
        System.out.println(title + " has been checked out.");
    }
    
    public void returnItem() {
        isCheckedOut = false;
        System.out.println(title + " has been returned.");
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getItemId() {
        return itemId;
    }
    
    public boolean isCheckedOut() {
        return isCheckedOut;
    }
}

// DVD class that extends LibraryItems
class DVD extends LibraryItems {
    private String director;
    private int runtime; // in minutes
    private String genre;
    
    public DVD(String title, String itemId, String director, int runtime, String genre) {
        super(title, itemId); // Call parent constructor
        this.director = director;
        this.runtime = runtime;
        this.genre = genre;
    }
    
    // DVD-specific methods
    public void play() {
        System.out.println("Now playing: " + getTitle() + " directed by " + director);
    }
    
    public void displayInfo() {
        System.out.println("=== DVD Information ===");
        System.out.println("Title: " + getTitle());
        System.out.println("ID: " + getItemId());
        System.out.println("Director: " + director);
        System.out.println("Runtime: " + runtime + " minutes");
        System.out.println("Genre: " + genre);
        System.out.println("Status: " + (isCheckedOut() ? "Checked Out" : "Available"));
    }
    
    // Getters
    public String getDirector() {
        return director;
    }
    
    public int getRuntime() {
        return runtime;
    }
    
    public String getGenre() {
        return genre;
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        DVD movie = new DVD("Inception", "DVD001", "Christopher Nolan", 148, "Sci-Fi");
        
        movie.displayInfo();
        System.out.println();
        
        movie.checkOut();
        movie.play();
        System.out.println();
        
        movie.returnItem();
    }
}