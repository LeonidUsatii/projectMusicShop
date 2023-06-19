package de.ait.services;

import de.ait.models.Book;
import de.ait.repositories.UsersRepository;

import java.util.*;

//public class UsersServiceImpl implements UsersService {

//    private UsersRepository usersRepository;
//
//    public UsersServiceImpl(UsersRepository usersRepository) {
//        this.usersRepository = usersRepository;
//    }

//    @Override
//    public List<String> getNames() {
//        List<Book> users = usersRepository.findAll();
//        List<String> names = new ArrayList<>();
//
//        for (Book user : users) {
//            names.add(user.getFirstName());
//        }
//
//        return names;
//    }

//    @Override
//    public String getLastNameOfMostAging() {
//
//        List<Book> users = usersRepository.findAll();
//        Map<Integer, String> userAge = new HashMap<>();
//
//        for (Book user : users) {
//            userAge.put(user.getAge(), user.getLastName());
//        }
//
//        int maxAge = Collections.max(userAge.keySet());
//
//        return userAge.get(maxAge);
//    }
//}
