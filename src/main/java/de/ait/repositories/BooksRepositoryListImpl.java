package de.ait.repositories;

import de.ait.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BooksRepositoryListImpl implements BooksRepository {
    @Override
    public List<Book> findAll() {

        Book book1  = new Book("title1");
        Book book2  = new Book("title2");
        Book book3  = new Book("title3");

        List<Book> books = new ArrayList<>();

        books.add(book1);
        books.add(book2);
        books.add(book3);

        return books;
    }

    @Override
    public void writeBookToFile(Book book) {

    }
}
