package com.zipcodewilmington.centrallibrary;

public class Periodical extends LibraryItem {
    
   
    private String issueDate;
    private String publisher;
    private String issn;
    private int volume; 
	private int issueNumber; 
	private String publicationDate; 
    
 
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

    public boolean matchesKeyword(String keyword) {
    if (keyword == null || keyword.trim().isEmpty()) {
        return false; 
    }
    
    String lower = keyword.toLowerCase();
    return getTitle().toLowerCase().contains(lower)
            || publisher.toLowerCase().contains(lower)
            || issn.toLowerCase().contains(lower);
}
}