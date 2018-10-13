package parse.json.com.jsonparse;

public class Company {
    private String name;
    private  String location;

    public Company(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
