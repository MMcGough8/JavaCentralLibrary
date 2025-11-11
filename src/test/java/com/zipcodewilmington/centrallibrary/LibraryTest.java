package com.zipcodewilmington.centrallibrary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private LibraryItem item1;
    private LibraryItem item2;
    private LibraryItem item3;

    private static class TestBook extends LibraryItem {
        public TestBook(String id, String title, String location) {
            super(id, title, location);
        }
        
        @Override
        public double calculateLateFee(int daysOverdue) {
            return daysOverdue * 0.50;
        }
        
        @Override
        public int getMaxBorrowDays() {
            return 14;
        }
        
        @Override
        public String getItemType() {
            return "Book";
        }
    }

    @BeforeEach
    public void setUp() {
        Address address = new Address("123 Main St", "Wilmington", "DE", 19801);
        library = new Library("Central Library", address);
        
        item1 = new TestBook("B001", "Java Programming", "Shelf A1");
        item2 = new TestBook("B002", "Python Basics", "Shelf A2");
        item3 = new TestBook("B003", "Data Structures", "Shelf B1");
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Central Library", library.getName());
        assertNotNull(library.getAddress());
        assertNotNull(library.getItems());
        assertEquals(0, library.getItems().size());
    }

    @Test
    public void testAddItem() {
        library.addItem(item1);
        library.addItem(item2);
        
        assertEquals(2, library.getItems().size());
        assertTrue(library.getItems().contains(item1));
        assertTrue(library.getItems().contains(item2));
    }

    @Test
    public void testRemoveItem_Success() {
        library.addItem(item1);
        library.addItem(item2);
        
        assertTrue(library.removeItem("B001"));
        assertEquals(1, library.getItems().size());
        assertFalse(library.getItems().contains(item1));
    }

    @Test
    public void testRemoveItem_NotFound() {
        library.addItem(item1);
        
        assertFalse(library.removeItem("B999"));
        assertEquals(1, library.getItems().size());
    }

    @Test
    public void testSearchItems_Found() {
        library.addItem(item1);
        library.addItem(item2);
        
        List<LibraryItem> results = library.searchItems("Java");
        
        assertEquals(1, results.size());
        assertTrue(results.contains(item1));
    }

    @Test
    public void testSearchItems_NoMatches() {
        library.addItem(item1);
        
        List<LibraryItem> results = library.searchItems("Nonexistent");
        
        assertEquals(0, results.size());
    }

    @Test
    public void testSearchItems_CaseInsensitive() {
        library.addItem(item1);
        
        assertEquals(1, library.searchItems("java").size());
        assertEquals(1, library.searchItems("JAVA").size());
    }

    @Test
    public void testDisplayAllItems() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        
        library.addItem(item1);
        library.displayAllItems();
        
        System.setOut(System.out);
        String result = output.toString();
        
        assertTrue(result.contains("=== Library Items ==="));
        assertTrue(result.contains("Total items: 1"));
        assertTrue(result.contains("Available"));
    }
}