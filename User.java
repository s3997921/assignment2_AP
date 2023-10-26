package application;

public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isVIP;

    public User(String username, String password, String firstName, String lastName, boolean isVIP) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isVIP = isVIP;
    }

    // Getter and setter methods

    @Override
    public String toString() {
        return "Username: " + username + ", First Name: " + firstName + ", Last Name: " + lastName + ", VIP: " + isVIP;
    }

	public String getUsername() {
    return this.username; // or appropriate field name

	
	}
}
