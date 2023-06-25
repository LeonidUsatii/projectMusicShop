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
    void getProducts() {
        List<Book> expectedBooks = new ArrayList<>();

        Book book1 = new Book((new Product("Title1",20,"1998"))
                ,"Author3", GenreOfBook.POETRY);
        Book book2 = new Book((new Product
                ("Title2",10.0,"2020"))
                ,"Author1", GenreOfBook.FANTASY);
        Book book3 = new Book((new Product
                ("Title3",15.0,"2020"))
                ,"Author3", GenreOfBook.FANTASY);

        expectedBooks.add(book1);
        expectedBooks.add(book2);
        expectedBooks.add(book3);

        List<Book> actualBooks = bookService.getProducts();

        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    void sortByPrice() {
        List<Book> books = new ArrayList<>();

        Book book1 = new Book((new Product("Title1",20,"1998"))
                ,"Author3", GenreOfBook.POETRY);
        Book book2 = new Book((new Product
                ("Title2",10.0,"2020"))
                ,"Author1", GenreOfBook.FANTASY);
        Book book3 = new Book((new Product
                ("Title3",15.0,"2020"))
                ,"Author3", GenreOfBook.FANTASY);

        books.add(book1);
        books.add(book2);
        books.add(book3);

        List<Book> expectedBooks = books.stream().sorted().toList();
        List<Book> actualBooks = bookService.sortByPrice();
        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    void filterByValue() {
        List<Book> books = new ArrayList<>();

        Book book1 = new Book((new Product("Title1",20,"1998"))
                ,"Author3", GenreOfBook.POETRY);
        Book book2 = new Book((new Product
                ("Title2",10.0,"2020"))
                ,"Author1", GenreOfBook.FANTASY);
        Book book3 = new Book((new Product
                ("Title3",15.0,"2020"))
                ,"Author3", GenreOfBook.FANTASY);

        books.add(book1);
        books.add(book2);
        books.add(book3);

        String value = "Author3";

        List<Book> expectedBooks = books.stream()
                .filter(((book) -> book.getAuthor().equals(value)))
                .toList();

        List<Book> actualBooks = bookService.filterByValue(value);

        assertEquals(expectedBooks, actualBooks);
    }
}