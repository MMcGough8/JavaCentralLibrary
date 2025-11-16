package com.zipcodewilmington.centrallibrary;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private String name;
    private Address address;

    private List<Book> books = new ArrayList<>();
    private List<Periodical> periodicals = new ArrayList<>();
    private List<Dvd> dvds = new ArrayList<>();
    private List<LibraryMember> libraryMembers = new ArrayList<>();
    private List<Librarian> librarians = new ArrayList<>();
    private List<LibraryItem> items = new ArrayList<>();


    public Library(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<LibraryItem> getItems() {
        return new ArrayList<>(items);
    }

    public List<Librarian> getLibrarians() {
        return new ArrayList<>(librarians);
    }

    public List<LibraryMember> getLibraryMembers() {
        return new ArrayList<>(libraryMembers);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public List<Periodical> getPeriodicals() {
        return new ArrayList<>(periodicals);
    }

    public List<Dvd> getDvds() {
        return new ArrayList<>(dvds);
    }


    private void addItem(LibraryItem item) {
        if (item != null) {
            items.add(item);
        }
    }

    public void addLibrarian(Librarian librarian) {
        if (librarian == null) return;

        for (Librarian l : librarians) {
            if (l.getEmployeeId().equalsIgnoreCase(librarian.getEmployeeId())) {
                return; 
            }
        }
        librarians.add(librarian);
    }

    public void addLibraryMember(LibraryMember member) {
        if (member == null) return;

        for (LibraryMember m : libraryMembers) {
            if (m.getMemberId().equalsIgnoreCase(member.getMemberId())) {
                return; 
            }
        }
        libraryMembers.add(member);
    }

    public void addBook(Book book) {
        if (book == null || book.getIsbn() == null) return;

        for (Book b : books) {
            if (b.getIsbn().equalsIgnoreCase(book.getIsbn())) {
                return;
            }
        }
        books.add(book);
        addItem(book);
    }

    public void addPeriodical(Periodical periodical) {
        if (periodical == null || periodical.getId() == null) return;

        for (Periodical p : periodicals) {
            if (p.getId().equalsIgnoreCase(periodical.getId())) {
                return; 
            }
        }
        periodicals.add(periodical);
        addItem(periodical);
    }

    public void addDvd(Dvd dvd) {
        if (dvd == null || dvd.getId() == null) return;

        for (Dvd d : dvds) {
            if (d.getId().equalsIgnoreCase(dvd.getId())) {
                return; 
            }
        }
        dvds.add(dvd);
        addItem(dvd);
    }

    public boolean removeItem(String itemId) {
        if (itemId == null) return false;

        LibraryItem toRemove = null;

        for (LibraryItem item : items) {
            if (item.getId().equals(itemId)) {
                toRemove = item;
                break;
            }
        }

        if (toRemove == null) return false;
        items.remove(toRemove);
        books.remove(toRemove);
        periodicals.remove(toRemove);
        dvds.remove(toRemove);

        return true;
    }

    public boolean removeLibrarian(String employeeId) {
        return librarians.removeIf(l -> l.getEmployeeId().equalsIgnoreCase(employeeId));
    }

    public boolean removeLibraryMember(String memberId) {
        return libraryMembers.removeIf(m -> m.getMemberId().equalsIgnoreCase(memberId));
    }

    public Librarian findLibrarian(String employeeId) {
        for (Librarian librarian : librarians) {
            if (librarian.getEmployeeId().equalsIgnoreCase(employeeId)) {
                return librarian;
            }
        }
        return null;
    }

    public LibraryMember findLibraryMember(String memberId) {
        for (LibraryMember member : libraryMembers) {
            if (member.getMemberId().equalsIgnoreCase(memberId)) {
                return member;
            }
        }
        return null;
    }

    public List<LibraryItem> searchItems(String keyword) {
        List<LibraryItem> results = new ArrayList<>();

        if (keyword == null || keyword.trim().isEmpty()) {
            return results;
        }

        for (LibraryItem item : items) {
            if (item.matchesKeyword(keyword)) {
                results.add(item);
            }
        }

        return results;
    }

    public void displayAllItems() {
        System.out.println("=== Library Items ===");
        System.out.printf("%-15s %-30s %-15s%n", "Type", "Title", "Status");
        System.out.println("----------------------------------------------------------");

        for (LibraryItem item : items) {
            String availability = item.isAvailable() ? "Available" : "Checked Out";
            System.out.printf("%-15s %-30s %-15s%n",
                    item.getItemType(), item.getTitle(), availability);
        }

        System.out.println("Total items: " + items.size());
    }

    public void generateLateFeeReport() {
        System.out.println("=== Late Fee Report ===");

        for (LibraryMember member : libraryMembers) {
            System.out.println("\nMember: " + member.getName());
            List<LibraryItem> borrowed = member.getBorrowedItems();

            if (borrowed.isEmpty()) {
                System.out.println("  No borrowed items");
            } else {
                System.out.printf("  %-30s %-20s %-15s%n",
                        "Title", "Max Borrow Days", "Late Fee");
                System.out.println("  ----------------------------------------------------------------------");

                for (LibraryItem item : borrowed) {
                    int daysOverdue = 0; 
                    double lateFee = item.calculateLateFee(daysOverdue);

                    System.out.printf("  %-30s %-20d $%-14.2f%n",
                            item.getTitle(), item.getMaxBorrowDays(), lateFee);
                }
            }
        }
    }
}
