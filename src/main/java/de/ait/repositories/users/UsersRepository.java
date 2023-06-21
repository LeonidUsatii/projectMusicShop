package de.ait.repositories.users;

import de.ait.models.Music;
import de.ait.models.User;
import de.ait.repositories.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<User> {
    @Override
    List<User> findAll();

    @Override
    void save(User model);


    User findByEmail(String email);
}
