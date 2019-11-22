package proxy;

public class SecurityContext {

    private String user;

    private String role;

    public SecurityContext(String user, String role) {
        this.user = user;
        this.role = role;
    }

    public String getUser() {
        return user;
    }

    public String getRole() {
        return role;
    }
}
