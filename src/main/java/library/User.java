package library;

import java.util.Objects;

public class User {

    private final String name;
    private final String username;
    private final String email;

    public User(String name, String username, String email) {
        this.name = name;
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return "name: " + this.name + "\nusername: " + username;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;

        return (Objects.equals(name, user.name) && Objects.equals(username, user.username)) ? true : false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
