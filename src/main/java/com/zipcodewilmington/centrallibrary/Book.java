package com.zipcodewilmington.centrallibrary;

import java.util.ArrayList;
import java.util.List;

public class Book extends LibraryItem implements Reservable {
    
    private String isbn;
    private String author;
    private String genre;
    private int numOfPages;
    private boolean isReserved;
    private LibraryMember reservedBy;
    
    
    public Book(String author, String title, String isbn, String genre, int numOfPages) {
        super(author, title, genre);
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
        this.numOfPages = numOfPages;
        this.isReserved = false;
        this.reservedBy = null;
    }
    
    @Override
    public String getItemType() {
        return "Book";
    }
    
    @Override
    public int getMaxBorrowDays() {
        return 14;  
    }
    
    @Override
    public double calculateLateFee(int daysOverdue) {
        return daysOverdue * 0.50;  
    }
   
    public String getGenre() {
        return genre;
    }

    public int numOfPages() {
        return numOfPages;
    }

    public boolean matchesKeyword(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return false; 
    }

    String lower = keyword.toLowerCase();
        return getTitle().toLowerCase().contains(lower)
                || author.toLowerCase().contains(lower)
                || isbn.toLowerCase().contains(lower)
                || genre.toLowerCase().contains(lower);
    }

    public boolean isReserved() {
        return isReserved;
    } 

    public void reserve(LibraryMember libraryMember) {
        if (isReserved) { 
            throw new Error("Book is already reserved");
        } else {
            this.isReserved = true;  // 
            this.reservedBy = libraryMember; 
        }
    }

    public void cancelReserve(LibraryMember libraryMember) {
        if (!isReserved) {
            throw new Error("Book is not currently reserved");
        }
        if (reservedBy != libraryMember) {
            throw new Error("Book is reserved by someone else");
        }
        this.isReserved = false; 
        this.reservedBy = null;
    }

    @Override
    public List<String> getSearchableFields() {
        List<String> fields = new ArrayList<>();
        fields.add(this.title);
        fields.add(this.author);
        fields.add(this.isbn);
        fields.add(this.genre);
        return fields;
    }
}
 







