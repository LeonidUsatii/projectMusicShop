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

        Book book1 = new Book((new Product("Title1",20,"1998"))
                ,"Author3", GenreOfBook.POETRY);
        Book book2 = new Book((new Product
                ("Title2",10.0,"2020"))
                ,"Author1", GenreOfBook.FANTASY);
        Book book3 = new Book((new Product
                ("Title3",15.0,"2020"))
                ,"Author3", GenreOfBook.FANTASY);

        return List.of(book1, book2, book3);
    }

    @Override
    public void save(Book book) {

    }


//    public Book save(Book book) {
//        return book;
//    }

    @Override
    public Book findByTitle(String title) {
        return null;
    }

    @Override
    public void update(Book updatedGood) {

    }
    @Override
    public void delete(Book deleteGood) {

    }
}
