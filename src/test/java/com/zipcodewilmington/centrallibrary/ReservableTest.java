package com.zipcodewilmington.centrallibrary;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ReservableTest { 
    static class MockReservable implements Reservable {
        private final List<String> fields;
        public MockReservable(List<String> fields) {
            this.fields = fields;
        }
        @Override
        public List<String> getReservableFields() {
            return fields;
        }
    }
    @Test public void Test(R)

    
}
