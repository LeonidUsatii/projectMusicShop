package de.ait.repositories.fakeImpl;

import de.ait.models.GenreOfMusic;
import de.ait.models.Music;
import de.ait.models.Product;
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

        User user1 = new User("First name1", "Last name1", "1.@mail.com");
        User user2 = new User("First name2", "Last name2", "2.@mail.com");
        User user3 = new User("First name3", "Last name3", "3.@mail.com");

        return List.of(user1, user2, user3);

    }

    @Override
    public void save(User user) {

    }

    @Override
    public User findByEmail(String email) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

}
