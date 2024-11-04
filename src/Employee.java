import java.util.UUID;

public class Employee {
    private final String name;
    private final String employeeId;
    private int age;
    private String department;
    private float salary;

    public Employee(String name, int age, String department, float salary) {
        this.name = name;
        this.employeeId = UUID.randomUUID().toString();
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public float getSalary() {
        return salary;
    }

    // setters
    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
