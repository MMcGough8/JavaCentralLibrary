package com.zipcodewilmington.centrallibrary;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSON {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("file.json"));


            String libraryName = (String) jsonObject.get("libraryName");
            String address = (String) jsonObject.get("address");

            System.out.println("Library Name: " + libraryName);
            System.out.println("Address: " + address);
            System.out.println();


            System.out.println("=== LIBRARIANS ===");
            JSONArray librarians = (JSONArray) jsonObject.get("librarians");
            for (Object obj : librarians) {
                JSONObject librarian = (JSONObject) obj;

                System.out.println("Name: " + librarian.get("name"));
                System.out.println("Age: " + librarian.get("age"));
                System.out.println("Email: " + librarian.get("email"));
                System.out.println("Phone: " + librarian.get("phonenumber"));
                System.out.println("Employee ID: " + librarian.get("employeeId"));
                System.out.println("Salary: " + librarian.get("salary"));
                System.out.println();
            }

            System.out.println("=== MEMBERS ===");
            JSONArray members = (JSONArray) jsonObject.get("members");
            for (Object obj : members) {
                JSONObject member = (JSONObject) obj;

                System.out.println("Name: " + member.get("name"));
                System.out.println("Age: " + member.get("age"));
                System.out.println("Email: " + member.get("email"));
                System.out.println("Phone: " + member.get("phonenumber"));
                System.out.println("Member ID: " + member.get("memberId"));
                System.out.println("Membership Date: " + member.get("membershipDate"));

                JSONArray borrowedItems = (JSONArray) member.get("borrowedItems");
                System.out.println("Borrowed Items Count: " + borrowedItems.size());
                System.out.println();
            }


            System.out.println("=== BOOKS ===");
            JSONArray books = (JSONArray) jsonObject.get("books");
            for (Object obj : books) {
                JSONObject book = (JSONObject) obj;

                System.out.println("ID: " + book.get("id"));
                System.out.println("Title: " + book.get("title"));
                System.out.println("Location: " + book.get("location"));
                System.out.println("Author: " + book.get("author"));
                System.out.println("ISBN: " + book.get("isbn"));
                System.out.println("Pages: " + book.get("pages"));
                System.out.println("Genre: " + book.get("genre"));
                System.out.println();
            }

            System.out.println("=== PERIODICALS ===");
            JSONArray periodicals = (JSONArray) jsonObject.get("periodicals");
            for (Object obj : periodicals) {
                JSONObject p = (JSONObject) obj;

                System.out.println("ID: " + p.get("id"));
                System.out.println("Title: " + p.get("title"));
                System.out.println("Location: " + p.get("location"));
                System.out.println("Publisher: " + p.get("publisher"));
                System.out.println("ISSN: " + p.get("issn"));
                System.out.println("Volume: " + p.get("volume"));
                System.out.println("Issue Number: " + p.get("issueNumber"));
                System.out.println("Publication Date: " + p.get("publicationDate"));
                System.out.println();
            }

        
            System.out.println("=== MOVIES ===");
            JSONArray movies = (JSONArray) jsonObject.get("movies");
            for (Object obj : movies) {
                JSONObject movie = (JSONObject) obj;

                System.out.println("ID: " + movie.get("id"));
                System.out.println("Title: " + movie.get("title"));
                System.out.println("Location: " + movie.get("location"));
                System.out.println("Director: " + movie.get("director"));
                System.out.println("Duration: " + movie.get("duration"));
                System.out.println("Rating: " + movie.get("rating"));
                System.out.println("Genre: " + movie.get("genre"));
                System.out.println();
            }

        } 
        
        
        catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
