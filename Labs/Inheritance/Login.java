package Inheritance;

public class Login {
    private String username;
    private int passwordHash;

    public Login(String username, int passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public Login(String username, String password) {
        this.username = username;
        this.passwordHash = password.hashCode();
    }

    /**
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String return the password
     */
    public int getPasswordHash() {
        return passwordHash;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.passwordHash = password.hashCode();
    }

    /**
     * @param passwordHash the password to set
     */
    public void setPasswordHash(int passwordHash) {
        this.passwordHash = passwordHash;
    }
}
