package de.ait.services;

import de.ait.models.Book;
import de.ait.models.Genre;
import de.ait.repositories.BooksRepository;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BooksService{

    private final BooksRepository booksRepository;

    public BookServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public void addBook(String title, String author, double price,
                        String releaseYear, Genre genre) {

        booksRepository.writeBookToFile(new Book(title, author, price, releaseYear, genre));
    }

    @Override
    public List<String> getNames() {
            List<Book> books = booksRepository.findAll();
            List<String> names = new ArrayList<>();

            for (Book book : books) {
                names.add(book.getTitle());
            }
            return names;

    }
}
