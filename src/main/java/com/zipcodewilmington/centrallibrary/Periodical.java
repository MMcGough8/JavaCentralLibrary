package com.zipcodewilmington.centrallibrary;

import java.util.ArrayList;
import java.util.List;

public class Periodical extends LibraryItem implements Reservable {

    private String issueDate;
    private String publisher;
    private String issn;
    private int volume;
    private int issueNumber;
    private String publicationDate;

    private boolean isReserved;
    private LibraryMember reservedBy;

 
    public Periodical(String id, String title, String location, String issueDate, String issn,
                      int volume, int issueNumber, String publisher, String publicationDate) {

        super(id, title, location);

        this.issueDate = issueDate;
        this.publisher = publisher;
        this.issn = issn;
        this.volume = volume;
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;

        this.isReserved = false;
        this.reservedBy = null;
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

    public int getIssueNumber() {
        return issueNumber;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    @Override
    public List<String> getSearchableFields() {
        List<String> fields = new ArrayList<>();
        fields.add(getTitle());
        fields.add(publisher);
        fields.add(issn);
        return fields;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public void reserve(LibraryMember libraryMember) {
        if (isReserved) {
            throw new Error("Periodical is already reserved.");
        }
        this.isReserved = true;
        this.reservedBy = libraryMember;
    }

    @Override
    public void cancelReserve(LibraryMember libraryMember) {
        if (!isReserved) {
            throw new Error("Periodical is not currently reserved.");
        }
        if (!reservedBy.equals(libraryMember)) {
            throw new Error("This periodical was reserved by another member.");
        }
        this.isReserved = false;
        this.reservedBy = null;
    }
}