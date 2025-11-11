package com.zipcodewilmington.centrallibrary;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.beancontext.BeanContext;
import java.util.List;

public class ReservableTest {
    
    // Simple mock LibraryMember for testing
    static class MockLibraryMember {
        private String name;
        public MockLibraryMember(String name) {
            this.name = name;
        }
    }
    
    // Mock implementation of Reservable
    static class MockReservable implements Reservable {
        private boolean reserved = false;        // asks "is it reserved?"
        private MockLibraryMember reservedBy = null;    // tracks who reserved it
        
        @Override
        public void reserve(MockLibraryMember libraryMember) {
            this.reserved = true;
            this.reservedBy = libraryMember;
        }
        
        @Override
        public void cancelReserve(MockLibraryMember libraryMember) {
            this.reserved = false;   // item is cancelled, so reservation is removed
            this.reservedBy = null;  // reserved by is null because the item is longer reserved
        }
        
        @Override
        public boolean isReserved() {
            return this.reserved; 
        }
    }
    
    @Test
    public void testReserveItem() {
        MockLibraryMember member = new MockLibraryMember("Ben");
        MockReservable item = new MockReservable();    // creates an item to reserve

        item.reserve(member);  

        assertTrue(item.isReserved());
    }

    @Test
    public void testCancelReserve() {
        MockLibraryMember member = new MockLibraryMember("Ben");
        MockReservable item = new MockReservable();

        item.reserve(member);  
        
        item.cancelReserve(member);

        assertFalse(item.isReserved());

    }

    @Test
    public void testIsReservedInitially() {
        MockReservable item = new MockReservable();
        assertFalse(item.isReserved());
    }    
}
