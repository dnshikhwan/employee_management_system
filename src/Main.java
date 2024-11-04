/*
1. Add a new employee (name, employee ID, age, department, salary) [X]
2. Remove an existing employee by ID [X]
3. Update an employee's details (change age, department, salary) [X]
4. View all employees [X]
5. Search for an employee by name or department [X]
6. Calculate average salary for all employees by department []
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EmployeeManager employeeManager = new EmployeeManager();

        boolean flag = true;
        while (flag) {
            printMenu();

            int command = 0;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("---INVALID INPUT---\n");
            }

            switch (command) {
                case 1:
                    System.out.println("\n---ADD EMPLOYEE---");
                    employeeManager.addEmployee(scanner);
                    break;
                case 2:
                    System.out.println("\n---REMOVE EMPLOYEE---");
                    employeeManager.removeEmployee(scanner);
                    break;
                case 3:
                    System.out.println("\n---UPDATE AN EMPLOYEE---");
                    employeeManager.updateByField(scanner);
                    break;
                case 4:
                    System.out.println("\n---VIEW ALL EMPLOYEE---");
                    employeeManager.displayAllEmployees();
                    break;
                case 5:
                    System.out.println("\n---SEARCH FOR AN EMPLOYEE---");
                    employeeManager.searchEmployee(scanner);
                    break;
                case 6:
                    System.out.println("\n---AVERAGE SALARY BY DEPARTMENT---");
                    employeeManager.averageSalaryByDepartment(scanner);
                    break;
                case 7:
                    System.out.println("\n---GOODBYE---");
                    flag = false;
                    break;
                default:
                    System.out.println("\n---INVALID INPUT---");
                    break;
            }
        }

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("Please choose a command: ");
        System.out.println("1. Add a new employee");
        System.out.println("2. Remove an employee");
        System.out.println("3. Update an employee's details");
        System.out.println("4. View all employees");
        System.out.println("5. Search for an employee");
        System.out.println("6. Average salary by department");
        System.out.println("7. Exit");
    }
}