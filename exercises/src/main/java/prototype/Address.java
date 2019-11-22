package prototype;

public class Address {

    private final String name;

    private final String email;

    public Address(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
