package library;

import java.util.Objects;

public class User {

    private final int id;

    private final String name;
    private final String username;
    private final String email;
    private final String phone;
    private final String website;



    public User(int id, String name, String username, String email, String phone, String website) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
    }

    @Override
    public String toString() {
        return "id: " + this.id
                + "\nname: " + name
                + "\nusername: " + username
                + "\nemail: " + email
                + "\nphone: " + phone
                + "\nwebsite: " + website;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;

        return (Objects.equals(name, user.name)
                && Objects.equals(username, user.username)
                && Objects.equals(email, user.email)
                && Objects.equals(phone, user.phone)
                && Objects.equals(website, user.website))
                ? true
                : false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }
}
