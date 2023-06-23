package de.ait.repositories.fakeImpl;

import de.ait.models.Music;
import de.ait.repositories.musics.MusicsRepository;

import java.util.List;

public class MusicsRepositoryFakeImpl implements MusicsRepository {
    @Override
    public Music findByTitle(String title) {
        return null;
    }

    @Override
    public List<Music> findAll() {
        return null;
    }

    @Override
    public void save(Music model) {

    }
}
