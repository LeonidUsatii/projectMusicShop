package de.ait.repositories.users;

import de.ait.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryTextFileImpl implements UsersRepository {

    private String fileName;

    public UsersRepositoryTextFileImpl(String fileName) {

        this.fileName = fileName;
    }

    @Override
    public List<User> findAll() {

        List<User> users = new ArrayList<>();

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = bufferedReader.readLine();

            while (line != null) {
                String[] parsed = line.split("\\|");
                String id = parsed[0];
                String firstName = parsed[1];
                String lastName = parsed[2];
                String email = parsed[3];
                String password = parsed[4];
                users.add(new User(id, firstName, lastName, email, password));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }

        return users;
    }

    @Override
    public void save(User user) {
        try (BufferedWriter bufferedWriter = new BufferedWriter
                (new FileWriter(fileName, true));) {
            String userObject = "";

            userObject = user.getId() + "|" + user.getFirstName() + "|" + user.getLastName()
                    + "|" + user.getEmail() + "|" + user.getPassword();

            bufferedWriter.write(userObject);
            bufferedWriter.newLine();

        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }
    }

    @Override
    public User findByTitle(String title) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }
}
