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

        Music music1 = new Music((new Product("Title1",20,"1998")),
                GenreOfMusic.CLASSIC,"Executor1");
        Music music2 = new Music((new Product
                ("Title2",10.0,"2020")),
                GenreOfMusic.ROCK, "Executor2");
        Music music3 = new Music((new Product
                ("Title3",15.0,"2020")),
                GenreOfMusic.POP, "Executor1");

        return List.of(music1, music2, music3);
    }

    @Override
    public void save(Music model) {

    }
}
