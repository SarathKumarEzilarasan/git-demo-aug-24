package demo;

public class User {

    // default constructor
    public User(){

    }

    // parametrised constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String username;
    private String password;

    // getter method
    public String getPassword() {
        return password;
    }

    // setter method
    public void setPassword(String password) {
        this.password = password;
    }
}
