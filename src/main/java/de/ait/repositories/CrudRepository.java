package de.ait.repositories;

import de.ait.models.Book;

import java.util.List;
import java.util.Optional;

// Create, Read, Update, Delete
public interface CrudRepository<T> {

    List<T> findAll();
    void save(T model);
    T findById(String id);
}
