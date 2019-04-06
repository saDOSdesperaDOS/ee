package entities;

import java.util.Objects;

public class User {

    private String name;
    private String email;
    private String pass;

    public User(String naame, String email, String pass) {
        this.name = naame;
        this.email = email;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setNaame(String naame) {
        this.name = naame;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPass(), user.getPass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getEmail(), getPass());
    }
}
