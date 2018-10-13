package parse.json.com.jsonparse;

import java.util.Arrays;

public class Employees {
    private Employee[] employees;

    public Employees(Employee[] employees) {
        this.employees = employees;
    }

    public String getEmployees() {
        return Arrays.toString(employees);
    }
}
