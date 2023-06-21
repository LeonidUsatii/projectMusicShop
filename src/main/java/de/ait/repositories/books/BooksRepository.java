package de.ait.repositories.books;

import de.ait.models.Book;
import de.ait.repositories.CrudRepository;

import java.util.List;

public interface BooksRepository extends CrudRepository<Book> {
    @Override
    List<Book> findAll();
    @Override
    void save(Book book);
    @Override
    Book findByTitle(String title);

}
