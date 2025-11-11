package com.zipcodewilmington.centrallibrary;

public class Periodical extends LibraryItem {
    
   
    private String issueDate;
    
    public Periodical(String id, String title, String location) {
        super(id, title, location);
    }
    
 
    public Periodical(String id, String title, String location, String issueDate) {
        super(id, title, location);
        this.issueDate = issueDate;
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
}