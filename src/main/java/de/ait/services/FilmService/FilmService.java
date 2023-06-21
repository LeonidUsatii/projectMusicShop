package de.ait.services.FilmService;

import de.ait.models.Category;
import de.ait.models.Film;
import de.ait.models.GenreOfFilm;
import de.ait.models.Product;
import de.ait.services.EService;

import java.util.List;

public interface FilmService extends EService<Film> {
    void addFilm(Category category, String title,  double price,String releaseYear,
                 GenreOfFilm genreOfFilm);

    List<Film> getProducts();

}
