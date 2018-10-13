package parse.json.com.jsonparse;

import java.util.Arrays;

public class Employee {
    private String name;
    private int age;
    private String location;
    private Company[] companies;

    public Employee(String name, int age, String location, Company[] companies) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.companies = companies;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getLocation(){
        return location;
    }


    public String getComplanies(){
        return  Arrays.toString(companies);
    }

}
