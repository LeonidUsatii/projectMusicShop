package de.ait.repositories;

import de.ait.models.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//public class UsersRepositoryTextFileImpl implements UsersRepository {

//    private String fileName;
//
//    public UsersRepositoryTextFileImpl(String fileName) {
//        this.fileName = fileName;
//    }

    //@Override
//    public List<Book> findAll() {
//        List<Book> users = new ArrayList<>(); // делаем список для всех пользователей
//
//        // try-with-resources
//        try (FileReader fileReader = new FileReader(fileName);
//             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
//
//            String line = bufferedReader.readLine(); // считываем строку
//
//            while (line != null) {  // если строку смогли считать
//                Book user = parseLine(line); // преобразуем пользователя в строку
//                users.add(user); // положили пользователя в список
//                line = bufferedReader.readLine(); // считали следующую строку
//            }
//        } catch (IOException e) {
//            System.err.println("Произошла ошибка");
//        }
//
//        return users;
//    }

//    private static Book parseLine(String line) {
//        String[] parsed = line.split("\\|");
//        String firstName = parsed[0];
//        String lastName = parsed[1];
//        int age = Integer.parseInt(parsed[2]);
//        double height = Double.parseDouble(parsed[3]);
//
//        return new Book(
//                firstName, lastName, age, height
//        );
//    }
//}
