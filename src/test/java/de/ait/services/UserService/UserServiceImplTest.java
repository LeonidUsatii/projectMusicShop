package de.ait.services.UserService;


import de.ait.models.User;
import de.ait.repositories.fakeImpl.UsersRepositoryFakeImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        List<User> expectedUser =List.of(
                new User("First name1","Last name1","1.@mail.com"),
                new User("First name2","Last name2","2.@mail.com"));

        List<User> actualUser = userService.getUser();

        assertEquals(expectedUser,actualUser);
    }
}