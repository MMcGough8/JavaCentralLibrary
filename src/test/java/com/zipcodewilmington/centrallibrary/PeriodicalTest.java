package com.zipcodewilmington.centrallibrary;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;

public class PeriodicalTest {
 
void testConstructorAndGetters() {
    Periodical per = new Periodical(
        "DM001",  
        "Periodical Title Test",  
        "Shelf Test 1",
        "October 2020",
        "5000-1000",
        1234,
        100,
        "Test Publishing",
        "11/11/25"
    );

        assertEquals("DM001",per.getId());
        assertEquals("Periodical Title Test",per.getTitle());
        assertEquals("Shelf Test 1",per.getLocation());
        assertEquals("October 2020", per.getIssueDate());
        assertEquals("5000-1000",per.getIssn());
        assertEquals(1234,per.getVolume());
        assertEquals(100,per.getIssueNumber());
        assertEquals("Test Publishing",per.getPublisher());
        assertEquals("11/11/25",per.getPublicationDate());
        assertTrue(per.isAvailable());
}
        

    @Test
    @DisplayName("Max borrow days should be 7")
    public void testGetMaxBorrowDays() {
        Periodical per = new Periodical ("DM001", "Journal", "Shelf Test 1", "November 2020", "4321-43211", 123, 10, "Hamurabi Publishing" , "11/10/25");
        assertEquals(7, per.getMaxBorrowDays());
 }
    @Test
    void testCalculateLateFee() {
        Periodical per = new Periodical ("DM001", "Journal", "Shelf Test 1", "November 2020", "4321-43211", 123, 10, "Hamurabi Publishing" , "11/10/25");
        double fee = per.calculateLateFee(1);
        assertEquals(0.50, per.calculateLateFee(1));

    }
    

    @Test
    void testGetId() {
        Periodical per = new Periodical ("DM001", "Journal", "Shelf Test 1", "November 2020", "4321-43211", 123, 10, "Hamurabi Publishing" , "11/10/25");
        assertEquals("DM001", per.getId());


    }


    @Test
    void testMatchesKeyword_Title() {
        Periodical per = new Periodical ("DM001", "Journal", "Shelf Test 1", "November 2020", "4321-43211", 123, 10, "Hamurabi Publishing" , "11/10/25");
        assertEquals("Journal", per.getTitle());
    }

    @Test 
    void testMatchesKeyword_Location() {
        Periodical per = new Periodical ("DM001", "Journal", "Shelf Test 1", "November 2020", "4321-43211", 123, 10, "Hamurabi Publishing" , "11/10/25");
        assertEquals("Shelf Test 1", per.getLocation());

    }

    @Test
    void testIssueDate() {
        Periodical per = new Periodical ("DM001", "Journal", "Shelf Test 1", "November 2020", "5000-1000", 123, 10, "Hamurabi Publishing" , "11/10/25");
        assertEquals("November 2020", per.getIssueDate()); 
    }

    @Test
    void testMatchesKeyword_Issn() {
        Periodical per = new Periodical ("DM001", "Journal", "Shelf Test 1", "November 2020", "5000-1000", 123, 10, "Hamurabi Publishing" , "11/10/25");
        assertEquals("5000-1000", per.getIssn()); 
    }

    @Test
    void testGetVolume(){
        Periodical per = new Periodical ("DM001", "Journal", "Shelf Test 1", "November 2020", "5000-1000", 1234, 10, "Hamurabi Publishing" , "11/10/25");
        assertEquals(1234, per.getVolume()); 
    }

    @Test
    void testGetIssueNumber(){
        Periodical per = new Periodical ("DM001", "Journal", "Shelf Test 1", "November 2020", "5000-1000", 123, 100, "Hamurabi Publishing" , "11/10/25");
        assertEquals(100, per.getIssueNumber()); 
    }

    @Test
    void testGetPublisher(){
        Periodical per = new Periodical ("DM001", "Journal", "Shelf Test 1", "November 2020", "5000-1000", 123, 10, "Hamurabi Publishing" , "11/10/25");
        assertEquals("Hamurabi Publishing", per.getPublisher()); 
    }

    @Test
    void testGetPublicationDate(){
        Periodical per = new Periodical ("DM001", "Journal", "Shelf Test 1", "November 2020", "5000-1000", 123, 10, "Hamurabi Publishing" , "11/10/25");
        assertEquals("11/10/25", per.getPublicationDate()); 
    }

  





}
