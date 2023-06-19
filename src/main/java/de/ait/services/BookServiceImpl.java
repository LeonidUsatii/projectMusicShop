package de.ait.services;

import de.ait.models.Book;
import de.ait.repositories.BooksRepository;

public class BookServiceImpl implements BooksService{

    private final BooksRepository booksRepository;

    public BookServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public void addBook(String title) {
        booksRepository.writeBookToFile(new Book(title));
    }
}
