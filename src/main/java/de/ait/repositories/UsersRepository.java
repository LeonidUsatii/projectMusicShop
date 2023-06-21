package de.ait.repositories;


public interface UsersRepository extends CrudRepository<User> {
    User findByEmail(String email);
}
