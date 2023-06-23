package de.ait.services.BookService;

import de.ait.models.*;
import de.ait.repositories.books.BooksRepository;
import de.ait.repositories.products.ProductsRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookServiceImpl implements BookService {

    private final BooksRepository booksRepository;
    private final ProductsRepository productsRepository;

    public BookServiceImpl(BooksRepository booksRepository, ProductsRepository productsRepository) {
        this.booksRepository = booksRepository;
        this.productsRepository = productsRepository;
    }

    @Override
    public void addBook(Category category, String title,  double price, String releaseYear,
                        String author, GenreOfBook genreOfBook) {
        Product productInfo = new Product(category, title, price, releaseYear);
        productsRepository.save(productInfo);
        booksRepository.save(new Book(productInfo, author, genreOfBook));
    }

    @Override
    public List<Book> getProducts() {

        return booksRepository.findAll();
    }


    @Override
    public List<Book> sortByPrice() {
        List<Book> books = booksRepository.findAll();
        return books.stream().sorted().toList();
    }

    @Override
    public List<Book> filterByValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Автор не найден");
        }
        List<Book> books = booksRepository.findAll();
        return  books.stream()
                .filter(((book) -> book.getAuthor().equals(value)))
                .toList();
    }



}
