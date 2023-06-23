package de.ait.repositories.fakeImpl;

import de.ait.models.User;
import de.ait.repositories.users.UsersRepository;

import java.util.List;

public class UsersRepositoryFakeImpl implements UsersRepository {
    @Override
    public User findByTitle(String title) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public User findByEmail(String email) {
        return null;
    }
}
