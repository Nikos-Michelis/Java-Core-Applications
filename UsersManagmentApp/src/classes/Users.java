package classes;

import java.io.Serializable;

public class Users implements Serializable {
    String fullName;
    String username;
    String password;
    int role;
    public Users(String fullName, String username, String password, int role) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + (role == 1? "admin":"user") +
                '}';
    }
}