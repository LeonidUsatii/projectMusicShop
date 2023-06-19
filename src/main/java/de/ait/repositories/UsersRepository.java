package de.ait.repositories;

import de.ait.models.Book;

import java.util.List;

public interface UsersRepository {
    List<Book> findAll();
}
