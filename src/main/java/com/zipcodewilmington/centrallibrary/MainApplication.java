package com.zipcodewilmington.centrallibrary;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.List.*;
import java.util.Date;


public class MainApplication {

    private static Library centralLibrary;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("🏛️ === Welcome to the Central Library System! === 🏛️");
        System.out.println();
        initializeLibrarySystem(); 
        loginMenu();





        System.out.println("📚 Thank you for using Central Library! 📚");
    }  
    
    public static void loginMenu() {
        while (true) {
            System.out.println("\n============= LOGIN MENU ===============");
            System.out.println("PLEASE PICK THE COORESPONDING OPTION NUMBER");
            System.out.println("1. Member Login");
            System.out.println("2. Librarian Login");
            System.out.println("3. Quit Program");
            System.out.println("========================================");

            int choice = getIntInput("Choose option (1-3): ");

            switch (choice) {
                case 1:
                    LibraryMember member = memberLogin();
                   if (member != null) {
                        System.out.println("Login successful! Welcome, " + member.getName());
                        memberMenu(member); 
                    }
                    break;

                case 2:
                    Librarian librarian = librarianLogin();
                    if (librarian != null) {
                        System.out.println("Login successful! Welcome, " + librarian.getName());
                        librarianOperations();
                    }
                    break;

                case 3:
                    System.out.println("Quitting program. Goodbye!");
                    System.exit(0);
                    break;
            }
        }
    }

    private static LibraryMember memberLogin() {
        System.out.print("\nEnter Member ID: ");
        String memberId = scanner.nextLine().trim();

        for (LibraryMember member : centralLibrary.getLibraryMembers()) {
            if (member.getMemberId().equalsIgnoreCase(memberId)) {
                return member;
            }
        }

        System.out.println("Member ID not found. Try again.\n");
        return null;   
    }

    private static Librarian librarianLogin() {
        System.out.print("\nEnter Librarian Employee ID: ");
        String employeeId = scanner.nextLine().trim();

        for (Librarian librarian : centralLibrary.getLibrarians()) {
             if (librarian.getEmployeeId().equalsIgnoreCase(employeeId)) {
                return librarian;
            }  
        }
        System.out.println("Employee ID not found. Try again.\n");
            return null;
    }


    private static void initializeLibrarySystem() {
        JSONParser parser = new JSONParser();
        try {
            InputStream inputStream = MainApplication.class
                .getClassLoader()
                .getResourceAsStream("file.json");

        if (inputStream == null) {
            throw new FileNotFoundException("file.json not found in resources folder!");
        }

        JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream));


            String libraryName = (String) jsonObject.get("libraryName");
            String addressStr = (String) jsonObject.get("address");
            String[] parts = addressStr.split(",");
            Address address = new Address();

            centralLibrary = new Library(libraryName, address); 

            JSONArray librarians = (JSONArray) jsonObject.get("librarians"); 
            for (Object obj : librarians) {
                JSONObject librarianJson = (JSONObject) obj;
                
                Librarian librarian = new Librarian(
                    (String) librarianJson.get("name"),            
                    ((Long) librarianJson.get("age")).intValue(),    
                    (String) librarianJson.get("email"),             
                    ((Long) librarianJson.get("phonenumber")).intValue(), 
                    (String) librarianJson.get("employeeId"),        
                    (String) librarianJson.get("department"),        
                    ((Long) librarianJson.get("salary")).intValue());
            
                centralLibrary.addLibrarian(librarian);
            }

            JSONArray members = (JSONArray) jsonObject.get("members");
            if (members != null) {
                for (Object obj : members) {
                    JSONObject memberJson = (JSONObject) obj;
                    
                    Date membershipDate = new Date();

                    LibraryMember member = new LibraryMember(
                        (String) memberJson.get("name"),
                        ((Long) memberJson.get("age")).intValue(),
                        (String) memberJson.get("email"),
                        ((Long) memberJson.get("phonenumber")).intValue(),
                        (String) memberJson.get("memberId"),
                        membershipDate,
                        new Address("Unknown", "Unknown", "UN", 0));

                    centralLibrary.addLibraryMember(member);
                }
            }

            JSONArray books = (JSONArray) jsonObject.get("books");
            for (Object obj : books) {
                JSONObject bookJson = (JSONObject) obj;
    
                Book book = new Book(
                    (String) bookJson.get("author"),
                    (String) bookJson.get("title"),
                    (String) bookJson.get("isbn"),
                    (String) bookJson.get("genre"),      
                    ((Long) bookJson.get("pages")).intValue());
    
                centralLibrary.addItem(book);
            }

            JSONArray periodicals = (JSONArray) jsonObject.get("periodicals");
            for (Object obj : periodicals) {
                JSONObject periodicalJson = (JSONObject) obj;
    
                Periodical periodical = new Periodical(
                    (String) periodicalJson.get("id"),                  
                    (String) periodicalJson.get("title"),              
                    (String) periodicalJson.get("location"),          
                    (String) periodicalJson.get("issueDate"),            
                    (String) periodicalJson.get("issn"),                  
                    ((Long) periodicalJson.get("volume")).intValue(),  
                    ((Long) periodicalJson.get("issueNumber")).intValue(),
                    (String) periodicalJson.get("publisher"),
                    (String) periodicalJson.get("publicationDate"));
    
                centralLibrary.addItem(periodical);
            }

            JSONArray movies = (JSONArray) jsonObject.get("movies");
            for (Object obj : movies) {
                JSONObject movieJson = (JSONObject) obj;
    
                Dvd dvd = new Dvd(
                    (String) movieJson.get("id"),
                    (String) movieJson.get("title"),
                    (String) movieJson.get("location"),
                    (String) movieJson.get("director"),
                    ((Long) movieJson.get("duration")).intValue(),
                    (String) movieJson.get("rating"),
                    (String) movieJson.get("genre"));
    
                centralLibrary.addItem(dvd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }







    private static void displaySystemStatus() {
        System.out.println("\n:bar_chart: SYSTEM STATUS:");
        System.out.println("Library: " + centralLibrary.getName());
        Address addr = centralLibrary.getAddress();
        System.out.printf("Address: %s, %s, %s %d%n",
                         addr.getStreetName(), addr.getCity(), addr.getState(), addr.getZipCode());
        System.out.println(":books: Items: " + centralLibrary.getItems().size());
        System.out.println(":busts_in_silhouette: Members: " + centralLibrary.getLibraryMembers().size());
        System.out.println(":male-office-worker: Librarians: " + centralLibrary.getLibrarians().size());
        System.out.println();
    }

    private static void runMainApplication() {
        while (true) {
            showMainMenu();

            int choice = getIntInput("Choose option (1-6): ");
            
            switch (choice) {
                case 1:
                    memberOperations();
                    break;
                case 2:
                    librarianOperations();
                    break;
                case 3:
                    searchLibrary();
                    break;
                case 4:
                    centralLibrary.displayAllItems();
                    break;
                case 5:
                    displaySystemStatus();
                    break;
                case 6:
                    System.out.println("👋 Goodbye!");
                    return;
                default:
                    System.out.println("❌ Invalid choice. Please try again.\n");
            }
        }
    }
    
    private static void showMainMenu() {
        System.out.println("════════════════════════════════════");
        System.out.println("        CENTRAL LIBRARY MAIN MENU");
        System.out.println("════════════════════════════════════");
        System.out.println("1. 👤 Member Operations");
        System.out.println("2. 👨‍💼 Librarian Operations");
        System.out.println("3. 🔍 Search Library");
        System.out.println("4. 📋 View All Items");
        System.out.println("5. ℹ️  System Status");
        System.out.println("6. 🚪 Exit");
        System.out.println("════════════════════════════════════");
    }
    
    private static void memberOperations() {
        System.out.println("\n👤 MEMBER OPERATIONS:");
        System.out.println("Available Members:");
        List<LibraryMember> members = centralLibrary.getLibraryMembers();
        for (int i = 0; i < members.size(); i++) {
            LibraryMember member = members.get(i);
            System.out.printf("%d. %s (ID: %s) - Fees: $%.2f%n", 
                             i + 1, member.getName(), member.getMemberId(), member.getOutstandingFees());
        }
        
        int choice = getIntInput("Select member (1-" + members.size() + "): ") - 1;
        if (choice >= 0 && choice < members.size()) {
            LibraryMember selectedMember = members.get(choice);
            memberMenu(selectedMember);
        } else {
            System.out.println("Invalid selection.\n");
        }
    }
    
    private static void memberMenu(LibraryMember member) {
        while (true) {
            System.out.printf("\n👤 MEMBER MENU - %s\n", member.getName());
            System.out.println("══════════════════════════════════════");
            System.out.println("1. 📖 Borrow Item");
            System.out.println("2. 📚 Return Item");
            System.out.println("3. 📋 My Borrowed Items");
            System.out.println("4. 💰 Check Outstanding Fees");
            System.out.println("5. 💳 Pay Fees");
            System.out.println("6. 👤 My Account Info");
            System.out.println("7. 🔙 Back to Main Menu");
            System.out.println("══════════════════════════════════════");
            
            int choice = getIntInput("Choose option (1-7): ");
            
            switch (choice) {
                case 1:
                    borrowItem(member);
                    break;
                case 2:
                    returnItem(member);
                    break;
                case 3:
                    showBorrowedItems(member);
                    break;
                case 4:
                    System.out.printf("💰 Outstanding fees: $%.2f%n%n", member.getOutstandingFees());
                    break;
                case 5:
                    payFees(member);
                    break;
                case 6:
                    showMemberInfo(member);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("❌ Invalid choice.\n");
            }
        }
    }
    
    private static void librarianOperations() {
        System.out.println("\n👨‍💼 LIBRARIAN OPERATIONS:");
        System.out.println("1. 📚 Add/Remove Items");
        System.out.println("2. 👥 View All Members");
        System.out.println("3. 📊 Generate Late Fee Report");
        System.out.println("4. 🔙 Back to Main Menu");
        
        int choice = getIntInput("Choose option (1-4): ");
        
        switch (choice) {
            case 1:
                itemManagement();
                break;
            case 2:
                viewAllMembers();
                break;
            case 3:
                centralLibrary.generateLateFeeReport();
                break;
            case 4:
                return;
            default:
                System.out.println("❌ Invalid choice.\n");
        }
    }

    private static void showMemberInfo(LibraryMember member) {
        System.out.printf("\n👤 ACCOUNT INFO - %s:%n", member.getName());
        System.out.println("─".repeat(40));
        System.out.println("Member ID: " + member.getMemberId());
        System.out.println("Email: " + member.getEmail());
        System.out.println("Phone: " + member.getPhoneNumber());
        Address addr = member.getAddress();
        System.out.printf("Address: %s, %s, %s %d%n", 
                         addr.getStreetName(), addr.getCity(), addr.getState(), addr.getZipCode());
        System.out.printf("Outstanding Fees: $%.2f%n", member.getOutstandingFees());
        System.out.println("Borrowed Items: " + member.getBorrowedItems().size());
        System.out.println();
    }




    private static void borrowItem(LibraryMember member) {
        System.out.println("\nBorrow an item");
        displayItemsWithIds();
        System.out.print("Enter the ID of the item to borrow: ");
        String itemId = scanner.nextLine().trim();
        
        LibraryItem item = findItemById(itemId);
        if (item == null) {
            System.out.println("No item found with this ID: " + itemId);
            return;
        }
        if (!item.isAvailable()) {
            System.out.println("This item is already checked out.");
            return;
        }
        member.borrowItem(item);
        System.out.println("You borrowed " + item.getTitle() + "\n");
    }

    private static void returnItem(LibraryMember member) {
        List<LibraryItem> borrowed = member.getBorrowedItems();
        if (borrowed.isEmpty()) {
            System.out.println("You have no items to return.\n");
            return;
        }
        System.out.println("Your Borrowed Items:");
        for (LibraryItem item : borrowed) {
            System.out.println("- " + item.getId() + " : " + item.getTitle());
        }
        System.out.print("Enter the ID of the item to return: ");
        String itemId = scanner.nextLine().trim();
        
        LibraryItem toReturn = null;
        for (LibraryItem item : borrowed) {
            if (item.getId().equals(itemId)) {
                toReturn = item;
                break;
            }
        }
        if (toReturn == null) {
            System.out.println("You do not have an item with that ID.\n");
            return;
        }
        int daysLate = getIntInput("Enter the number of days late: ");
        member.returnItem(toReturn, daysLate);
        System.out.println("Returned: " + toReturn.getTitle() + "\n");
    }

    private static void showBorrowedItems(LibraryMember member) {
        System.out.println("\nYour Borrowed Items:");
        List<LibraryItem> items = member.getBorrowedItems();
        if (items.isEmpty()) {
            System.out.println("You have not borrowed any items.\n");
            return;
        }
        System.out.println("-".repeat(60));
        for (LibraryItem item : items) {
            System.out.printf("%-10s %-30s %-10s%n",
                item.getId(),
                item.getTitle(),
                item.getItemType()
            );
        }
        System.out.println("-".repeat(60) + "\n");
    }

    private static void payFees(LibraryMember member) {
        System.out.println("\nPay Outstanding Fees");
        double fees = member.getOutstandingFees();
        if (fees <= 0) {
            System.out.println("You have no outstanding fees!\n");
            return;
        }
        System.out.println("You currently owe: $" + fees);
        System.out.print("Enter amount to pay: ");
        double amount = getDoubleInput("Enter amount to pay: ");
        
        if (amount <= 0) {
            System.out.println("Invalid amount.\n");
            return;
        }
        member.payFees(amount);
        System.out.println("Payment processed.");
        System.out.println("Remaining balance: $" + member.getOutstandingFees() + "\n");
    }
    
    private static void itemManagement() {
        System.out.println("\n📚 ITEM MANAGEMENT:");
        System.out.println("1. View All Items");
        System.out.println("2. Remove Item by ID");
        
        int choice = getIntInput("Choose option (1-2): ");
        
        switch (choice) {
            case 1:
                centralLibrary.displayAllItems();
                break;
            case 2:
                System.out.print("Enter Item ID to remove: ");
                String itemId = scanner.nextLine().trim();
                if (centralLibrary.removeItem(itemId)) {
                    System.out.println("✅ Item removed successfully!\n");
                } else {
                    System.out.println("❌ Item not found.\n");
                }
                break;
        }
    }

    private static void viewAllMembers() {
        System.out.println("\n👥 ALL LIBRARY MEMBERS:");
        System.out.println("─".repeat(60));
        for (LibraryMember member : centralLibrary.getLibraryMembers()) {
            System.out.printf("• %s (ID: %s) - Fees: $%.2f - Items: %d%n", 
                             member.getName(), member.getMemberId(), 
                             member.getOutstandingFees(), member.getBorrowedItems().size());
        }
        System.out.println();
    }

    private static void searchLibrary() {
        System.out.print("\n🔍 Enter search keyword: ");
        String keyword = scanner.nextLine().trim();
        
        List<LibraryItem> results = centralLibrary.searchItems(keyword);
        
        if (results.isEmpty()) {
            System.out.println("❌ No items found matching '" + keyword + "'.\n");
            return;
        }
        
        System.out.println("\n🔍 SEARCH RESULTS for '" + keyword + "':");
        System.out.println("─".repeat(60));
        for (LibraryItem item : results) {
            String status = item.isAvailable() ? "✅ Available" : "❌ Checked Out";
            System.out.printf("• %s (%s) - ID: %s - %s%n", 
                             item.getTitle(), item.getItemType(), item.getId(), status);
        }
        System.out.println();
    }

    private static void displayItemsWithIds() {
        System.out.println("📚 AVAILABLE LIBRARY ITEMS:");
        System.out.println("─".repeat(70));
        System.out.printf("%-8s %-15s %-30s %-15s%n", "ID", "Type", "Title", "Status");
        System.out.println("─".repeat(70));
        for (LibraryItem item : centralLibrary.getItems()) {
            String availability = item.isAvailable() ? "✅ Available" : "❌ Checked Out";
            System.out.printf("%-8s %-15s %-30s %-15s%n", 
                             item.getId(), item.getItemType(), item.getTitle(), availability);
        }
        System.out.println("─".repeat(70));
        System.out.println("Total items: " + centralLibrary.getItems().size() + "\n");
    }

    private static LibraryItem findItemById(String itemId) {
        for (LibraryItem item : centralLibrary.getItems()) {
            if (item.getId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}