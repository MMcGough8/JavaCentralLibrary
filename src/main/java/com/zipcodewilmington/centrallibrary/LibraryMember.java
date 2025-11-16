package com.zipcodewilmington.centrallibrary;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibraryMember extends Person {
    
    private String memberId;
    private Date membershipDate;
    private List<LibraryItem> borrowedItems;
    private double outstandingFees;
    private Address address;
    
    public LibraryMember(String name, int age, String email, int phoneNumber, 
                        String memberId, Date membershipDate, Address address) {
        
        super(name, age, email, phoneNumber);
        
        setMemberId(memberId);
        setMembershipDate(membershipDate);
        setAddress(address);
        
        this.borrowedItems = new ArrayList<>();
        this.outstandingFees = 0.0;
    }
    

    public String getMemberId() {
        return memberId;
    }
    
    public Date getMembershipDate() {
        return membershipDate;
    }
    
    public List<LibraryItem> getBorrowedItems() {
        return new ArrayList<>(borrowedItems);
    }
    
    public double getOutstandingFees() {
        return outstandingFees;
    }
    
    public Address getAddress() {
        return address;
    }
    

    public void setMemberId(String memberId) {
        if (memberId == null || memberId.trim().isEmpty()) {
            throw new IllegalArgumentException("Member ID cannot be null or empty");            
        }
        this.memberId = memberId.trim();
    }
    
    public void setMembershipDate(Date membershipDate) {
        if (membershipDate == null) {
            throw new IllegalArgumentException("Membership date cannot be null");
        }
        this.membershipDate = membershipDate;
    }
    
    public void setAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");

        }
        this.address = address;
    }

    
     public void borrowItem(LibraryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (!item.isAvailable()) {
            throw new IllegalArgumentException("Item is not available for checkout");
        }

        item.checkOut();
        borrowedItems.add(item);
    }
    
    public void returnItem(LibraryItem item, int daysLate) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (!borrowedItems.contains(item)) {
            throw new IllegalArgumentException("Item is not in this member's borrowed items");
        }
        if (daysLate < 0) {
            throw new IllegalArgumentException("Days late cannot be negative");
        }

        item.checkIn();
        borrowedItems.remove(item);

        if (daysLate > 0) {
            outstandingFees += item.calculateLateFee(daysLate);
        }
    }
    
    public void payFees(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Payment amount cannot be negative");
        }
        if (amount > outstandingFees) {
            throw new IllegalArgumentException("Payment amount cannot exceed outstanding fees");
        }

        outstandingFees -= amount;
    } 

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof LibraryMember)) return false;
        LibraryMember other = (LibraryMember) obj;
        return memberId.equalsIgnoreCase(other.memberId);
    }

    @Override
    public int hashCode() {
        return memberId.toLowerCase().hashCode();
    }

    public LibraryMember() {
        super("Test User", 30, "test@example.com", 1234567890);
        this.memberId = "TEST123";
        this.membershipDate = new Date();
        this.address = new Address("Test St", "Test City", "TS", 00000);
        this.borrowedItems = new ArrayList<>();
        this.outstandingFees = 0.0;
}



}
