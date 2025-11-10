package com.zipcodewilmington.centrallibrary;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class SearchableTest {

  
    static class MockSearchable implements Searchable {
        private final List<String> fields;

        public MockSearchable(List<String> fields) {
            this.fields = fields;
        }

        @Override
        public List<String> getSearchableFields() {
            return fields;
        }
    }

    @Test
    public void testKeywordFoundInField() {
        Searchable item = new MockSearchable(List.of("Java Mock Testing", "Devesh Murali", "Front-End Programming"));
        assertTrue(item.matchesKeyword("java"));
        assertTrue(item.matchesKeyword("devesh"));
        assertTrue(item.matchesKeyword("programming"));
    }

    @Test
    public void testKeywordNotFound() {
        Searchable item = new MockSearchable(List.of("Algorithms", "Data Structures"));
        assertFalse(item.matchesKeyword("Python"));
        assertFalse(item.matchesKeyword("C++"));
    }

    @Test
    public void testCaseInsensitiveSearch() {
        Searchable item = new MockSearchable(List.of("SEARCHABLE TESTING"));
        assertTrue(item.matchesKeyword("searchable"));
        assertTrue(item.matchesKeyword("testing"));
    }

    @Test
    public void testHandlesNullAndEmpty() {
        Searchable item = new MockSearchable(List.of("Java", "Coding", "Python"));
        assertFalse(item.matchesKeyword(null));
        assertFalse(item.matchesKeyword(""));
    }

    @Test
    public void testHandlesNullFieldValues() {
        Searchable item = new MockSearchable(Arrays.asList("Group", null, "Programming"));
        assertTrue(item.matchesKeyword("group"));
        assertTrue(item.matchesKeyword("programming"));
    }

    @Test
    public void testMatchesKeywordSimple() {
        Searchable item = new MockSearchable(List.of("The Avengers", "Marvel", "Brothers of Sisters"));
        assertTrue(item.matchesKeyword("avengers"));
        assertTrue(item.matchesKeyword("marvel"));
        assertFalse(item.matchesKeyword("improv"));
    }
}
