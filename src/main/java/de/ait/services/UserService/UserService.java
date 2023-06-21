package de.ait.services.UserService;

import de.ait.models.Category;
import de.ait.models.GenreOfMusic;
import de.ait.models.Music;
import de.ait.models.User;
import de.ait.services.EService;

import java.util.List;

public interface UserService  {
    void addUser(String firstName, String lastName, String email, String password);

    List<User> getUser();

}
