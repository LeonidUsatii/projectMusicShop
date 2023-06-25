package de.ait.services.UserService;


import de.ait.models.User;
import de.ait.repositories.fakeImpl.UsersRepositoryFakeImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        this.userService = new UserServiceImpl(new UsersRepositoryFakeImpl());
    }
    @Test
    void getUser() {
        List<User> expectedUsers = new ArrayList<>();

        User user1 = new User("First name1","Last name1","1.@mail.com");
        User user2 = new User("First name2","Last name2","2.@mail.com");
        User user3 = new User("First name3","Last name3","3.@mail.com");

        expectedUsers.add(user1);
        expectedUsers.add(user2);
        expectedUsers.add(user3);

        List<User> actualUser = userService.getUser();
        assertEquals(expectedUsers,actualUser);
    }
    @Test
    void findByEmail() {
        List<User> users = new ArrayList<>();

        User user1 = new User("First name1","Last name1","1.@mail.com");
        User user2 = new User("First name2","Last name2","2.@mail.com");
        User user3 = new User("First name3","Last name3","3.@mail.com");

        users.add(user1);
        users.add(user2);
        users.add(user3);

        String email = "1.@mail.com";

        User actualUser = userService.findByEmail(email);
        User expectedUser = null;

        for (User user : users) {
            if (user.getEmail().equals(email)) {
                expectedUser = user;
            }
        }
        assertEquals(expectedUser, actualUser);
    }
}