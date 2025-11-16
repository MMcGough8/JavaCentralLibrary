package com.zipcodewilmington.centrallibrary;

import java.util.ArrayList;
import java.util.List;


public class Dvd extends LibraryItem implements Reservable {
    private String director;
    private long duration;
    private String rating;
    private String genre;
    
    private boolean isReserved;
    private LibraryMember reservedBy;

    public Dvd(String id, String title, String location, String director, long duration, String rating, String genre) {
        super(id, title, location);
        this.director = director;
        this.duration = duration;
        this.rating = rating;
        this.genre = genre;

        this.isReserved = false;
        this.reservedBy = null;
    }


    public String getDirector() {
        return director;
    }

    public long getDuration() {
        return duration;
    }

    public String getRating() {
        return rating;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 1.00; 
    }

    @Override
    public int getMaxBorrowDays() {
        return 7; 
    }

    @Override
    public String getItemType() {
        return "DVD";
    }


    public void setDirector(String director) {
        this.director = director;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    
    @Override
    public List<String> getSearchableFields() {
        List<String> fields = new ArrayList<>();
        fields.add(getTitle());
        fields.add(director);
        fields.add(genre);
        fields.add(rating);
        return fields;
    }

     @Override
    public void reserve(LibraryMember member) {
        if (isReserved) {
            throw new Error("DVD is already reserved.");
        }
        this.isReserved = true;
        this.reservedBy = member;
    }

    @Override
    public void cancelReserve(LibraryMember member) {
        if (!isReserved) {
            throw new Error("DVD is not currently reserved.");
        }
        if (!reservedBy.equals(member)) {
            throw new Error("This DVD was reserved by another member.");
        }
        this.isReserved = false;
        this.reservedBy = null;
    }

     @Override
    public String toString() {
        return "Dvd{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", director='" + director + '\'' +
                ", duration=" + duration +
                ", rating='" + rating + '\'' +
                ", genre='" + genre + '\'' +
                ", isAvailable=" + isAvailable() +
                ", isReserved=" + isReserved +
                '}';
    }
}