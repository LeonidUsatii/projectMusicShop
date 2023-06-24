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
        expectedFilms.add(new Film(new Product("Title",4,"2022"), GenreOfFilm.COMEDY));
        expectedFilms.add(new Film(new Product("Another title",6,"2012"),GenreOfFilm.ACTION));
        List<Film> actualFilms = filmService.getProducts();

        assertEquals(expectedFilms, actualFilms);
    }

    @Test
    void sortByPrice() {
        List<Film> expectedFilms = new ArrayList<>();
        expectedFilms.add(new Film(new Product("Title",4,"2022"), GenreOfFilm.COMEDY));
        expectedFilms.add(new Film(new Product("Another title",6,"2012"),GenreOfFilm.ACTION));
        List<Film> actualFilms = filmService.sortByPrice();

        assertEquals(expectedFilms, actualFilms);
    }
}