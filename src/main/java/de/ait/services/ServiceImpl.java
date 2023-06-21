package de.ait.services;

import de.ait.models.*;
import de.ait.repositories.books.BooksRepository;

import java.util.List;

public class ServiceImpl implements Service {

    private final BooksRepository booksRepository;

    public ServiceImpl(BooksRepository booksRepository) {

        this.booksRepository = booksRepository;
    }

//    @Override
//    public void addBook(Category category, String title,  double price, String releaseYear,
//                        String author, GenreOfBook genreOfBook) {
//
//        booksRepository.writeBookToFile(new Book(title, author,
//                price, releaseYear, genreOfBook));
//    }

    @Override
    public void addBook(Category category, String title, double price, String releaseYear, String author, GenreOfBook genreOfBook) {

    }

    @Override
    public void addMusic(Category category, String title, double price,
                         String releaseYear, String executor) {

    }

    @Override
    public void addFilm(Category category, String title, double price,
                        String releaseYear, GenreOfFilm genreOfFilm) {

    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

//    @Override
//    public List<Book> getBooks() {
//
//        return booksRepository.findAll();
//
//    }
}
