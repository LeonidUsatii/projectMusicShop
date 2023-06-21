package de.ait.services.FilmService;

import de.ait.models.Category;
import de.ait.models.GenreOfFilm;
import de.ait.models.Product;

import java.util.List;

public interface FilmService {
    void addFilm(Category category, String title,  double price,String releaseYear,
                 GenreOfFilm genreOfFilm);

    List<Product> getProducts();

}
