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
        super("UNKNOWN", title, "UNKNOWN");   
       
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
   
    @Override
    public String getTitle() {
        return super.getTitle();
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public String getIsbn() {
    return isbn;
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
        if (!reservedBy.equals(libraryMember)) {
            throw new Error("Book is reserved by someone else");
        }
        this.isReserved = false; 
        this.reservedBy = null;
    }

    @Override
    public List<String> getSearchableFields() {
        List<String> fields = new ArrayList<>();
        fields.add(getTitle());
        fields.add(author);
        fields.add(isbn);
        fields.add(genre);
        return fields;
    }

}
 