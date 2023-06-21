package de.ait.services.BookService;

import de.ait.models.Category;
import de.ait.models.GenreOfBook;
import de.ait.models.GenreOfFilm;
import de.ait.models.Product;

import java.util.List;

public interface BookService {
    void addBook(Category category, String title,  double price,String releaseYear, String author,
                  GenreOfBook genreOfBook);

    List<Product> getProducts();

}
