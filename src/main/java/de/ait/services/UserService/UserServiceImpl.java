package de.ait.services.UserService;

import de.ait.models.*;
import de.ait.repositories.users.UsersRepository;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void addUser(String firstName, String lastName, String email, String password) {

        usersRepository.save(new User(firstName, lastName, email, password));

    }

    @Override
    public List<User> getUser() {

        return usersRepository.findAll();
    }




}
