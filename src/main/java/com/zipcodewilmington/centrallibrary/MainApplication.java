package com.zipcodewilmington.centrallibrary;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainApplication {
    
    private static Library centralLibrary;
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("🏛️ === CENTRAL LIBRARY MANAGEMENT SYSTEM === 🏛️");
        System.out.println();

        runMainApplication();
        
        scanner.close();
        System.out.println("📚 Thank you for using Central Library! 📚");
    }
    
    private static void initializeLibrarySystem() {
    }
    
    private static void displaySystemStatus() {
        System.out.println("\n📊 SYSTEM STATUS:");
        System.out.println("Library: " + centralLibrary.getName());
        Address addr = centralLibrary.getAddress();
        System.out.printf("Address: %s, %s, %s %d%n", 
                         addr.getStreetName(), addr.getCity(), addr.getState(), addr.getZipCode());
        System.out.println("📚 Items: " + centralLibrary.getItems().size());
        System.out.println("👥 Members: " + centralLibrary.getLibraryMembers().size());
        System.out.println("👨‍💼 Librarians: " + centralLibrary.getLibrarians().size());
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
            System.out.println("❌ Invalid selection.\n");
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

    }

    private static void returnItem(LibraryMember member) {

    }

    private static void showBorrowedItems(LibraryMember member) {

    }

    private static void payFees(LibraryMember member) {
        
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
}
