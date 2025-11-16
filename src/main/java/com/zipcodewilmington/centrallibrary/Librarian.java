package com.zipcodewilmington.centrallibrary;

public class Librarian extends Person {

    private String employeeId;
    private String department;
    private int salary;

    public Librarian(String name, int age, String email, int phoneNumber,
                     String employeeId, String department, int salary) {

        super(name, age, email, phoneNumber);

        setEmployeeId(employeeId);
        setDepartment(department);
        setSalary(salary);
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
        if (employeeId == null || employeeId.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be empty");
        }
        this.employeeId = employeeId.trim();
    }

    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty");
        }
        this.department = department.trim();
    }

    public void setSalary(int salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Librarian)) return false;

        Librarian other = (Librarian) obj;
        return employeeId.equalsIgnoreCase(other.employeeId);
    }

    @Override
    public int hashCode() {
        return employeeId.toLowerCase().hashCode();
    }
}
