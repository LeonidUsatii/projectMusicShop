package de.ait.services.BookService;

import de.ait.models.Book;
import de.ait.models.Category;
import de.ait.models.GenreOfBook;
import de.ait.models.Product;
import de.ait.repositories.books.BooksRepository;
import de.ait.repositories.fakeImpl.BookRepositoryFakeImpl;
import de.ait.repositories.fakeImpl.ProductsRepositoryFakeImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BookServiceImplTest {
    private BookServiceImpl bookService;
    @BeforeEach
    void setUp() {
        this.bookService = new BookServiceImpl(new BookRepositoryFakeImpl(),
                new ProductsRepositoryFakeImpl());
    }

    @Test
    void addBook() {
    }

    @Test
    void getProducts() {
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book(new Product( "Title",20,"1998")
                ,"Author", GenreOfBook.POETRY));
        expectedBooks.add(new Book(new Product( "Another title", 15.0, "2020")
                , "Another author", GenreOfBook.FANTASY));
        List<Book> actualBooks = bookService.getProducts();

        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    void sortByPrice() {
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book(new Product(Category.BOOK, "Another title", 15.0, "2020")
                , "Another author", GenreOfBook.FANTASY));
        expectedBooks.add(new Book(new Product( Category.BOOK,"Title",20,"1998")
                ,"Author", GenreOfBook.POETRY));

        List<Book> actualBooks = bookService.sortByPrice();

        
        assertEquals(expectedBooks, actualBooks);

    }



    @Test
    void filterByValue() {
    }
}