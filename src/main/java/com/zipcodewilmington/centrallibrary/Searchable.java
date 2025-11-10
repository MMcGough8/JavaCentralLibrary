package com.zipcodewilmington.centrallibrary;

import java.util.List;

public interface Searchable {
        List<String> getSearchableFields();
        
        default boolean matchesKeyword(String keyword) {
            if (keyword == null || keyword.isEmpty()) return false;
            String lowerKeyword = keyword.toLowerCase();

            for (String field : getSearchableFields()) {
                if (field != null && field.toLowerCase().contains(lowerKeyword)) {
                    return true;
                }
            }
            return false;
        }
}
