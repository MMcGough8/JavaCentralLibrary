package com.zipcodewilmington.centrallibrary;

import java.util.List;

public class Librarian extends Person {

    private String employeeId;
    private String department;
    private int salary;
    private List<LibraryItem> items;
    
    
    public Librarian(String name, int age, String email, int phoneNumber, String employeeId, String department, int salary) {         
        super(name, age, email, phoneNumber);
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary; 
                                                  
    }

      public String getEmployeeId() {               
        return employeeId;
    }

    public String getDepartment() {                               
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setEmployeeId(String employeeId) {                      
        
        this.employeeId = employeeId;
    }

    public void setDepertmant(String department) {                                      
        
        this.department = department;
    
    }

    public List<LibraryItem> getItems() {
        return items;
    }

     //Method to add a new item to the library's collection
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    // Metho to remove an item from the library by its ID 
    // Returns true if item was found and removed, otherwise false
    public boolean removeItem(String itemId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(itemId)) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }


}



