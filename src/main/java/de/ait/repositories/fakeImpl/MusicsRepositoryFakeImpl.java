package de.ait.repositories.fakeImpl;

import de.ait.models.*;
import de.ait.repositories.musics.MusicsRepository;

import java.util.List;

public class MusicsRepositoryFakeImpl implements MusicsRepository {
    @Override
    public Music findByTitle(String title) {
        return null;
    }

    @Override
    public void update(Music updatedGood) {

    }

    @Override
    public void delete(Music deleteGood) {

    }

    @Override
    public List<Music> findAll() {
        Music music1 = new Music((new Product("Title",12,"1982"))
                , GenreOfMusic.CLASSIC,"Executor");
        Music music2 = new Music((new Product("Another title",9,"2019"))
                ,GenreOfMusic.CLASSIC,"Another executor");
        List<Music> music = List.of(music1,music2);

        return music;

    }

    @Override
    public void save(Music model) {

    }
}
