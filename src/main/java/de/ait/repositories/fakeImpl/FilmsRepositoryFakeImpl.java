package de.ait.repositories.fakeImpl;

import de.ait.models.*;
import de.ait.repositories.films.FilmsRepository;

import java.util.List;

public class FilmsRepositoryFakeImpl implements FilmsRepository {
    @Override
    public List<Film> findAll() {
        Film film1 = new Film((new Product("Title",4,"2022")),GenreOfFilm.COMEDY);
        Film film2 = new Film((new Product("Another title",6,"2012")),GenreOfFilm.ACTION);
        List<Film> films = List.of(film1,film2);

        return films;
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
