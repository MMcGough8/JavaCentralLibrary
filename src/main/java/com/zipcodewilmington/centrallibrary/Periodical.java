package com.zipcodewilmington.centrallibrary;

import java.util.ArrayList;
import java.util.List;

public class Periodical extends LibraryItem implements Reservable{
    
   
    private String issueDate;
    private String publisher;
    private String issn;
    private int volume; 
	private int issueNumber; 
	private String publicationDate; 
    boolean isReserved;
    
 
    public Periodical(String id, String title, String location, String issueDate, String issn, int volume, int issueNumber, String publisher, String publicationDate) {
        super(id, title, location);
        this.issueDate = issueDate;
        this.publisher = publisher;
        this.issn = issn;
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
        this.volume = volume;
    }
    
    @Override
    public String getItemType() {
        return "Periodical";
    }
    
    @Override
    public int getMaxBorrowDays() {
        return 7;  
    }
    
    @Override
    public double calculateLateFee(int daysOverdue) {
        return daysOverdue * 0.50;  
    }
   
    public String getIssueDate() {
        return issueDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIssn() {
        return issn;
    }

    public int getVolume() {
        return volume;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public List<String> getSearchableFields() {
        List<String> fields = new ArrayList<>();
        fields.add(this.title);
        fields.add(this.publisher);
        fields.add(this.issn);
        return fields;
    }

    @Override
    public void reserve(LibraryMember libraryMember) {
        this.isReserved = true;
    }

    @Override
    public void cancelReserve(LibraryMember libraryMember) {
        this.isReserved = false;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }
}