package de.ait.services.MusicService;

import de.ait.models.*;
import de.ait.repositories.fakeImpl.MusicsRepositoryFakeImpl;
import de.ait.repositories.fakeImpl.ProductsRepositoryFakeImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MusicServiceImplTest {
    private MusicServiceImpl musicService;
    @BeforeEach
    void setUp() {
        this.musicService = new MusicServiceImpl(new MusicsRepositoryFakeImpl(),
                new ProductsRepositoryFakeImpl());
    }

    @Test
    void getProducts() {
        List<Music> expectedMusic = new ArrayList<>();

        Music music1 = new Music((new Product("Title1",20,"1998")),
                GenreOfMusic.CLASSIC,"Executor1");
        Music music2 = new Music((new Product
                ("Title2",10.0,"2020")),
                GenreOfMusic.ROCK, "Executor2");
        Music music3 = new Music((new Product
                ("Title3",15.0,"2020")),
                GenreOfMusic.POP, "Executor1");

        expectedMusic.add(music1);
        expectedMusic.add(music2);
        expectedMusic.add(music3);

        List<Music> actualMusic = musicService.getProducts();

        assertEquals(expectedMusic, actualMusic);

    }

    @Test
    void sortByPrice() {
        List<Music> musics = new ArrayList<>();

        Music music1 = new Music((new Product("Title1",20,"1998")),
                GenreOfMusic.CLASSIC,"Executor1");
        Music music2 = new Music((new Product
                ("Title2",10.0,"2020")),
                GenreOfMusic.ROCK, "Executor2");
        Music music3 = new Music((new Product
                ("Title3",15.0,"2020")),
                GenreOfMusic.POP, "Executor1");

        musics.add(music1);
        musics.add(music2);
        musics.add(music3);

        List<Music> expectedMusic = musics.stream().sorted().toList();
        List<Music> actualMusic = musicService.sortByPrice();
        assertEquals(expectedMusic, actualMusic);
    }

    @Test
    void filterByValue() {
        List<Music> musics = new ArrayList<>();

        Music music1 = new Music((new Product("Title1",20,"1998")),
                GenreOfMusic.CLASSIC,"Executor1");
        Music music2 = new Music((new Product
                ("Title2",10.0,"2020")),
                GenreOfMusic.ROCK, "Executor2");
        Music music3 = new Music((new Product
                ("Title3",15.0,"2020")),
                GenreOfMusic.POP, "Executor1");

        musics.add(music1);
        musics.add(music2);
        musics.add(music3);

        String value = "Executor1";

        List<Music> expectedMusic = musics.stream()
                .filter(((music) -> music.getExecutor().equals(value)))
                .toList();
        List<Music> actualMusic = musicService.filterByValue(value);
        assertEquals(expectedMusic, actualMusic);
    }
}