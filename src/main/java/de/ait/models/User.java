package de.ait.models;

import java.util.UUID;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private  String email;
    private  String password;

    public User(String id, String firstName, String lastName,  String email, String password) {

        if (id != null) {
            this.id = id;
        } else {
            System.err.println("Введите id");
        }

        if (firstName != null) {
            this.firstName = firstName;
        } else {
            System.err.println("Введите firstName");
        }

        if (lastName != null) {
            this.lastName = email;
        } else {
            System.err.println("Введите lastName");
        }

        if (email != null) {
            this.email = email;
        } else {
            System.err.println("Введите email");
        }

        if (password != null) {
            this.password = password;
        } else {
            System.err.println("Введите password");
        }
    }

    public User(String firstName, String lastName, String email, String password) {

        this.id = UUID.randomUUID().toString();

        if (firstName != null) {
            this.firstName = firstName;
        } else {
            System.err.println("Введите firstName");
        }

        if (lastName != null) {
            this.lastName = lastName;
        } else {
            System.err.println("Введите lastName");
        }

        if (email != null) {
            this.email = email;
        } else {
            System.err.println("Введите email");
        }

        if (password != null) {
            this.password = password;
        } else {
            System.err.println("Введите password");
        }

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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
