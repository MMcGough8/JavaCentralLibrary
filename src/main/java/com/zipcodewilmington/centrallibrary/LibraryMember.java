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
            throw new Error("Member ID cannot be null or empty");
        }
        this.memberId = memberId.trim();
    }
    
    public void setMembershipDate(Date membershipDate) {
        if (membershipDate == null) {
            throw new Error("Membership date cannot be null");
        }
        this.membershipDate = membershipDate;
    }
    
    public void setAddress(Address address) {
        if (address == null) {
            throw new Error("Address cannot be null");
        }
        this.address = address;
    }
    
    public void borrowItem(LibraryItem item) {
        if (item == null) {
            throw new Error("Item cannot be null");
        }
        if (!item.isAvailable()) {
            throw new Error("Item is not available for checkout");
        }
        
        item.checkOut();
        borrowedItems.add(item);
    }
    
    public void returnItem(LibraryItem item, int daysLate) {
        if (item == null) {
            throw new Error("Item cannot be null");
        }
        if (!borrowedItems.contains(item)) {
            throw new Error("Item is not in this member's borrowed items");
        }
        if (daysLate < 0) {
            throw new Error("Days late cannot be negative");
        }
        
        item.checkIn();
        borrowedItems.remove(item);
        
        if (daysLate > 0) {
            double lateFee = item.calculateLateFee(daysLate);
            outstandingFees += lateFee;
        }
    }
    
    public void payFees(double amount) {
        if (amount < 0) {
            throw new Error("Payment amount cannot be negative");
        }
        if (amount > outstandingFees) {
            throw new Error("Payment amount cannot exceed outstanding fees");
        }
        outstandingFees -= amount;
    }   
}
