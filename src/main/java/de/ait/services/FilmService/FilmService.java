package de.ait.services.FilmService;

import de.ait.models.*;
import de.ait.services.EService;

import java.util.List;

public interface FilmService extends EService<Film> {
    void addFilm(Category category, String title,  double price,String releaseYear,
                 GenreOfFilm genreOfFilm);
    @Override
    List<Film> getProducts();
    @Override
    List<Film> sortByPrice();
    @Override
    List<Film> filterByValue(String value);

}
