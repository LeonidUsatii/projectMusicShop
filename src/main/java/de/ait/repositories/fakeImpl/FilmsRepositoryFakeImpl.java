package de.ait.repositories.fakeImpl;

import de.ait.models.*;
import de.ait.repositories.films.FilmsRepository;

import java.util.List;

public class FilmsRepositoryFakeImpl implements FilmsRepository {
    @Override
    public List<Film> findAll() {

        Film film1 = new Film((new Product("Title1",20,"1998")),
                GenreOfFilm.COMEDY);
        Film film2 = new Film((new Product
                ("Title2",10.0,"2020")),
                GenreOfFilm.ACTION);
        Film film3 = new Film((new Product
                ("Title3",15.0,"2020")),
                GenreOfFilm.COMEDY);

        return List.of(film1, film2, film3);
    }

    @Override
    public void save(Film model) {

    }

    @Override
    public Film findByTitle(String title) {
        return null;
    }

    @Override
    public void update(Film updatedGood) {

    }

    @Override
    public void delete(Film deleteGood) {

    }
}
