package model;


//Represents an admin user with username and password
public class Admin {
	private String username;
    private String password;
    

//    Constructs a new Admin with the specified username and password
public Admin(String username, String password) {
    this.username = username;
    this.password = password;
}
// Getters and setters
public String getUsername() {
    return username;
}

// Sets the username of the admin
public void setUsername(String username) {
    this.username = username;
}

//Returns the password of the admin
public String getPassword() {
    return password;
}

//Sets the password of the admin
public void setPassword(String password) {
    this.password = password;
}

@Override
public String toString() {
    return "Admin{" +
            "username='" + username + '\'' +
            ", password='" + password + '\'' +
            '}';
}
}
