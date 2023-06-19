package de.ait.repositories;

import de.ait.models.Book;

import java.util.List;

public interface BooksRepository {
    List<Book> findAll();
    void writeBookToFile(Book book);
}
