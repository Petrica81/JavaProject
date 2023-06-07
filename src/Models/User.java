package Models;

import java.util.Comparator;

public abstract class User {
    private String firstName, lastName, email;
    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Comparator<User> nameComparator() {
        return Comparator.comparing(User::getFirstName, String.CASE_INSENSITIVE_ORDER).thenComparing(User::getLastName, String.CASE_INSENSITIVE_ORDER);
    }
}
