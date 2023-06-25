package de.ait.services.BookService;

import de.ait.models.*;
import de.ait.services.EService;
import java.util.List;

public interface BookService extends EService <Book>{
    void addBook(Category category, String title,  double price,
                 String releaseYear, String author,
                  GenreOfBook genreOfBook);
    @Override
    List<Book> getProducts();
    @Override
    List<Book> sortByPrice();
    @Override
    List<Book> filterByValue(String value);
}
