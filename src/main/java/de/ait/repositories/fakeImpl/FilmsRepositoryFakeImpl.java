package de.ait.repositories.fakeImpl;

import de.ait.models.Film;
import de.ait.repositories.films.FilmsRepository;

import java.util.List;

public class FilmsRepositoryFakeImpl implements FilmsRepository {
    @Override
    public List<Film> findAll() {
        return null;
    }

    @Override
    public void save(Film model) {

    }

    @Override
    public Film findByTitle(String title) {
        return null;
    }
}
