package auth;

public class User {

    private String name;
    private String email;
    private String password;
    private String uidUser;

    public User(String name, String email, String password, String uidUser) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.uidUser = uidUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUidUser() {
        return uidUser;
    }

    public void setUidUser(String uidUser) {
        this.uidUser = uidUser;
    }

}
