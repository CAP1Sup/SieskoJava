package Inheritance;

public class Login {
    private String username;
    private int password;

    public Login(String username, int password) {
        this.username = username;
        this.password = password;
    }

    /** @return String return the username */
    public String getUsername() {
        return username;
    }

    /** @param username the username to set */
    public void setUsername(String username) {
        this.username = username;
    }

    /** @return String return the password */
    public int getPassword() {
        return password;
    }

    /** @param password the password to set */
    public void setPassword(int password) {
        this.password = password;
    }
}
