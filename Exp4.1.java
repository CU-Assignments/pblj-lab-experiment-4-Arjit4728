Experiment 4.1: Employee Management System

import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagementSystem {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void addEmployee(int id, String name, double salary) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                System.out.println("Error: Employee with ID " + id + " already exists.");
                return;
            }
        }
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee Added: ID=" + id + ", Name=" + name + ", Salary=" + salary);
    }

    public static void updateEmployee(int id, double newSalary) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                emp.salary = newSalary;
                System.out.println("Employee ID " + id + " updated successfully.");
                return;
            }
        }
        System.out.println("Employee ID " + id + " not found.");
    }

    public static void removeEmployee(int id) {
        employees.removeIf(emp -> {
            if (emp.id == id) {
                System.out.println("Employee ID " + id + " removed successfully.");
                return true;
            }
            return false;
        });
    }

    public static void searchEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                System.out.println("Employee Found: " + emp);
                return;
            }
        }
        System.out.println("Employee ID " + id + " not found.");
    }

    public static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }

    public static void main(String[] args) {
        // Test Case 1: No Employees Initially
        System.out.println("Test Case 1: Display Employees (No Employees Initially)");
        displayEmployees();

        // Test Case 2: Add Employees
        System.out.println("\nTest Case 2: Add Employees");
        addEmployee(101, "Anish", 50000);
        addEmployee(102, "Bobby", 60000);

        // Test Case 3: Update Employee Salary
        System.out.println("\nTest Case 3: Update Employee Salary");
        updateEmployee(101, 55000);

        // Test Case 4: Search Employee by ID
        System.out.println("\nTest Case 4: Search Employee by ID");
        searchEmployeeById(102);

        // Test Case 5: Remove Employee
        System.out.println("\nTest Case 5: Remove Employee");
        removeEmployee(101);

        // Test Case 6: Display All Employees
        System.out.println("\nTest Case 6: Display All Employees");
        displayEmployees();

        // Test Case 7: Adding Duplicate Employee ID
        System.out.println("\nTest Case 7: Adding Duplicate Employee ID");
        addEmployee(101, "Charlie", 70000);
    }
}


Test Cases

Test Case 1: Adding Employees (No Employees Initially)
Display Employees
Expected Output:
No employees found.
  
Test Case 2: Add Employees
Input:
Add Employee (ID=101, Name="Anish", Salary=50000)
Add Employee (ID=102, Name="Bobby", Salary=60000)
Expected Output:
Employee Added: ID=101, Name=Anish, Salary=50000
Employee Added: ID=102, Name=Bobby, Salary=60000

Test Case 3: Update Employee Salary
Input:
Update Employee (ID=101, New Salary=55000)
Expected Output:
Employee ID 101 updated successfully.

Test Case 4: Search Employee by ID
Input:
Search Employee by ID=102
Expected Output:
Employee Found: ID=102, Name=Bobby, Salary=60000

Test Case 5: Remove Employee
Input:
Remove Employee (ID=101)
Expected Output:
Employee ID 101 removed successfully.

Test Case 6: Display All Employees
Input:
Display Employees
Expected Output:
ID: 102, Name: Bobby, Salary: 60000

Test Case 7: Adding Duplicate Employee ID
Input:
Add Employee (ID=101, Name="Charlie", Salary=70000)
Expected Output:
Error: Employee with ID 101 already exists.


