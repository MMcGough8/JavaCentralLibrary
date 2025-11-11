package com.zipcodewilmington.centrallibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Dvd class represents a DVD item in the library.
 * It extends LibraryItem and implements Reservable interface.
 */
public class Dvd extends LibraryItem implements Reservable {
    private String director;
    private int duration; // in m
    private String rating;
    private String genre;
    private boolean isReserved;

    /**
     * Constructor for Dvd
     */
    public Dvd(String id, String title, String location, String director, int duration, String rating, String genre) {
        super(id, title, location);
        this.director = director;
        this.duration = duration;
        this.rating = rating;
        this.genre = genre;
        this.isReserved = false;
    }

    // Getters
    public String getDirector() {
        return director;
    }

    public int getDuration() {
        return duration;
    }

    public String getRating() {
        return rating;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isReserved() {
        return isReserved;
    }

    // Setters
    public void setDirector(String director) {
        this.director = director;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 1.00; // $1.00 per day
    }

    @Override
    public int getMaxBorrowDays() {
        return 7; // Can be borrowed for 7 days
    }

    @Override
    public String getItemType() {
        return "DVD";
    }

    @Override
    public List<String> getSearchableFields() {
        List<String> fields = new ArrayList<>();
        fields.add(getTitle());
        fields.add(director);
        fields.add(genre);
        return fields;
    }

    @Override
    public void reserve(LibraryMember member) {
        if (!isReserved) {
            isReserved = true;
        }
    }

    @Override
    public void cancelReserve(LibraryMember member) {
        isReserved = false;
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
