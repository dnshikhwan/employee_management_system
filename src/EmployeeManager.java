import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    HashMap<String, Employee> employees;

    public EmployeeManager() {
        employees = new HashMap<String, Employee>();
    }

    public void addEmployee(Scanner scanner) {
        System.out.println("Please enter employee's name: ");
        String name = scanner.nextLine();

        int age = 0;

        boolean isAgeOkay = false;
        while (!isAgeOkay){
            try {
                System.out.println("Please enter employee's age: ");
                age = Integer.parseInt(scanner.nextLine());
                isAgeOkay = true;
            } catch (NumberFormatException e) {
                System.out.println("---INVALID INPUT---");
            }
        }

        System.out.println("Please enter employee's department: ");
        String department = scanner.nextLine();

        float salary = 0;

        boolean isSalaryOkay = false;
        while (!isSalaryOkay) {
            try {
                System.out.println("Please enter employee's salary: ");
                salary = Float.parseFloat(scanner.nextLine());
                isSalaryOkay = true;
            } catch (NumberFormatException e) {
                System.out.println("---INVALID INPUT---");
            }
        }

        Employee employee = new Employee(name, age, department, salary);
        employees.put(employee.getEmployeeId(), employee);
        System.out.println("---EMPLOYEE CREATED---\n");
    }

    public void removeEmployee(Scanner scanner) {
        if (!employees.isEmpty()) {
            displayAllEmployees();
            System.out.println("Please enter employee's id: ");
            String employeeId = scanner.nextLine();

            for (String i : employees.keySet()) {
                if (i.equals(employeeId)) {
                    employees.remove(i);
                    break;
                }
            }

            System.out.println("---EMPLOYEE DATA REMOVED---\n");
        } else {
            System.out.println("No employee data, please add one.\n");
        }
    }

    public void updateByField(Scanner scanner) {
        if (!employees.isEmpty()) {
            displayAllEmployees();
            Employee employee = searchByEmployeeId(scanner);

            System.out.println("Update an employee's details by (age, department, or salary) ?");
            String field = scanner.nextLine();

            if (field.equals("age")) {
                int age = 0;
                boolean isAgeOkay = false;
                while (!isAgeOkay){
                    try {
                        System.out.println("Update age to: ");
                        age = Integer.parseInt(scanner.nextLine());
                        isAgeOkay = true;
                    } catch (NumberFormatException e) {
                        System.out.println("---INVALID INPUT---");
                    }
                }

                employee.setAge(age);
                System.out.println("---EMPLOYEE'S AGE UPDATED---\n");

            } else if (field.equals("department")) {
                System.out.println("Update department to: ");
                String department = scanner.nextLine();

                employee.setDepartment(department);
                System.out.println("---EMPLOYEE'S DEPARTMENT UPDATED---\n");

            } else if (field.equals("salary")) {

                float salary = 0;

                boolean isSalaryOkay = false;
                while (!isSalaryOkay) {
                    try {
                        System.out.println("Update salary to: ");
                        salary = Float.parseFloat(scanner.nextLine());
                        isSalaryOkay = true;
                    } catch (NumberFormatException e) {
                        System.out.println("---INVALID INPUT---");
                    }
                }

                employee.setSalary(salary);
                System.out.println("---EMPLOYEE'S SALARY UPDATED---\n");

            } else {
                System.out.println("---INVALID INPUT---\n");
            }

        } else {
            System.out.println("No employee data, please add one.\n");
        }
    }

    public Employee searchByEmployeeId(Scanner scanner) {
        if (!employees.isEmpty()) {
            System.out.println("Please enter employee's Id: ");
            String uuid = scanner.nextLine();

            for (String id : employees.keySet()) {
                if (id.equals(uuid)) {
                    return employees.get(id);
                }
            }
        } else {
            System.out.println("No employee data, please add one.\n");
        }

        return null;
    }

    public void searchEmployee(Scanner scanner) {
        if (!employees.isEmpty()) {
            System.out.println("Search an employee by (name or department) ?");
            String param = scanner.nextLine();

            if (param.equals("name")) {
                displayEmployee(searchByName(scanner));
            } else if (param.equals("department")) {
                List<Employee> foundEmployee = searchByDepartment(scanner);
                for (Employee employee : foundEmployee) {
                    displayEmployee(employee);
                }
            } else {
                System.out.println("---INVALID INPUT---\n");
            }
        } else {
            System.out.println("No employee data, please add one.\n");
        }
    }

    public Employee searchByName(Scanner scanner) {
        if (!employees.isEmpty()) {
            System.out.println("Please enter employee's name: ");
            String name = scanner.nextLine();

            for (Employee employee : employees.values()) {
                if (employee.getName().equalsIgnoreCase(name)) {
                    return employee;
                }
            }
        } else {
            System.out.println("No employee data, please add one.\n");
        }

        return null;
    }

    public List<Employee> searchByDepartment(Scanner scanner) {
        List<Employee> foundEmployee = new ArrayList<>();
        if (!employees.isEmpty()) {
            System.out.println("Please enter employee's department: ");
            String department = scanner.nextLine();

            for (Employee employee : employees.values()) {
                if (employee.getDepartment().equalsIgnoreCase(department)) {
                    foundEmployee.add(employee);
                }
            }
        } else {
            System.out.println("No employee data, please add one.\n");
        }

        return foundEmployee;
    }

    public void averageSalaryByDepartment(Scanner scanner) {
        if (!employees.isEmpty()) {
            List<Employee> foundEmployee = searchByDepartment(scanner);
            float totalSalary = 0;
            for (Employee employee : foundEmployee) {
                totalSalary += employee.getSalary();
            }

            System.out.println("Total salary: $" + totalSalary);
            System.out.println("Average salary: $" + (totalSalary / foundEmployee.size() + "\n"));
        } else {
            System.out.println("No employee data, please add one.\n");
        }
    }

    public void displayEmployee(Employee employee) {
        if (employee != null) {
            System.out.println("Name: " + employee.getName());
            System.out.println("Employee Id: " + employee.getEmployeeId());
            System.out.println("Age: " + employee.getAge());
            System.out.println("Department: " + employee.getDepartment());
            System.out.println("Salary: $" + employee.getSalary());
            System.out.println();
        } else {
            System.out.println("---EMPLOYEE NOT FOUND---\n");
        }
    }

    public void displayAllEmployees() {
        if (!employees.isEmpty()) {
            for (Employee employee : employees.values()) {
                System.out.println("Name: " + employee.getName());
                System.out.println("Employee Id: " + employee.getEmployeeId());
                System.out.println("Age: " + employee.getAge());
                System.out.println("Department: " + employee.getDepartment());
                System.out.println("Salary: $" + employee.getSalary());
                System.out.println();
            }
        } else {
            System.out.println("No employee data, please add one.\n");
        }
    }
}
