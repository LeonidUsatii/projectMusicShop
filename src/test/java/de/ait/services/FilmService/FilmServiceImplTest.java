package de.ait.services.FilmService;

import de.ait.models.*;
import de.ait.repositories.fakeImpl.FilmsRepositoryFakeImpl;
import de.ait.repositories.fakeImpl.ProductsRepositoryFakeImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilmServiceImplTest {
    private FilmServiceImpl filmService;
    @BeforeEach
    void setUp() {
        this.filmService = new FilmServiceImpl(new FilmsRepositoryFakeImpl(),
                new ProductsRepositoryFakeImpl());
    }

    @Test
    void getProducts() {
        List<Film> expectedFilms = new ArrayList<>();

        Film film1 = new Film((new Product("Title1",20,"1998")),
                GenreOfFilm.COMEDY);
        Film film2 = new Film((new Product
                ("Title2",10.0,"2020")),
                GenreOfFilm.ACTION);
        Film film3 = new Film((new Product
                ("Title3",15.0,"2020")),
                GenreOfFilm.COMEDY);

        expectedFilms.add(film1);
        expectedFilms.add(film2);
        expectedFilms.add(film3);

        List<Film> actualFilms = filmService.getProducts();

        assertEquals(expectedFilms, actualFilms);
    }

    @Test
    void sortByPrice() {
        List<Film> films = new ArrayList<>();

        Film film1 = new Film((new Product("Title1",20,"1998")),
                GenreOfFilm.COMEDY);
        Film film2 = new Film((new Product
                ("Title2",10.0,"2020")),
                GenreOfFilm.ACTION);
        Film film3 = new Film((new Product
                ("Title3",15.0,"2020")),
                GenreOfFilm.COMEDY);

        films.add(film1);
        films.add(film2);
        films.add(film3);

        List<Film> expectedFilms = films.stream().sorted().toList();
        List<Film> actualBooks = filmService.sortByPrice();
        assertEquals(expectedFilms, actualBooks);
    }

    @Test
    void filterByValue() {
        List<Film> films = new ArrayList<>();

        Film film1 = new Film((new Product("Title1",20,"1998")),
                GenreOfFilm.COMEDY);
        Film film2 = new Film((new Product
                ("Title2",10.0,"2020")),
                GenreOfFilm.ACTION);
        Film film3 = new Film((new Product
                ("Title3",15.0,"2020")),
                GenreOfFilm.COMEDY);

        films.add(film1);
        films.add(film2);
        films.add(film3);

        String value = "COMEDY";


        List<Film> expectedFilms = films.stream()
                .filter(((film) -> film.getGenre().name().equals(value)))
                .toList();

        List<Film> actualFilms = filmService.filterByValue(value);

        assertEquals(expectedFilms, actualFilms);
    }
}