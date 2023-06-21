package de.ait.models;

import java.util.UUID;

/**
 * 6/20/2023
 * cohort25
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class User { // пользователь
    private String id;
    private String email;
    private String password;
    private PersonalArea personalArea;

    public User(String email, String password, PersonalArea personalArea) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.password = password;
        this.personalArea = personalArea;
    }

    public User(String email, String password) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.password = password;
    }




    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public PersonalArea getPersonalArea() {
        return personalArea;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
