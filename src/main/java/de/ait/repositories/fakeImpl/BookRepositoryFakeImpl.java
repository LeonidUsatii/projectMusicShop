package de.ait.repositories.fakeImpl;

import de.ait.models.Book;
import de.ait.models.Category;
import de.ait.models.GenreOfBook;
import de.ait.models.Product;
import de.ait.repositories.books.BooksRepository;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryFakeImpl implements BooksRepository {



    @Override
    public List<Book> findAll() {
        Book book1 = new Book((new Product
                (Category.BOOK,"Title",20,"1998"))
                ,"Author", GenreOfBook.POETRY);
        Book book2 = new Book((new Product
                (Category.BOOK,"Another title",15.0,"2020"))
                ,"Another author", GenreOfBook.FANTASY);
        List<Book> books = List.of(book1,book2);

        return books;
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public Book findByTitle(String title) {
        return null;
    }
}
