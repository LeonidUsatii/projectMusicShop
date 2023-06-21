package de.ait.services.BookService;

import de.ait.models.*;
import de.ait.repositories.books.BooksRepository;
import de.ait.repositories.products.ProductsRepository;
import de.ait.services.Service;

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
