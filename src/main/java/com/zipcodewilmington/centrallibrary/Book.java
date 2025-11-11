package com.zipcodewilmington.centrallibrary;

public class Book extends LibraryItem {
    
    private String isbn;
    private String author;
    private String genre;
    private int numOfPages;
    
    public Book(String author, String title, String isbn, String genre, int numOfPages) {
        super(author, title, genre);
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
        this.numOfPages = numOfPages;
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
}

