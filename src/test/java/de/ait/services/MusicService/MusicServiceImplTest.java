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
        expectedMusic.add(new Music(new Product("Title",12,"1982"),
                GenreOfMusic.CLASSIC,"Executor"));
        expectedMusic.add(new Music(new Product("Another title",9,"2019"),
                GenreOfMusic.CLASSIC,"Another executor"));
        List<Music> actualMusic = musicService.getProducts();

        assertEquals(expectedMusic, actualMusic);

    }

    @Test
    void sortByPrice() {
        List<Music> expectedMusic = new ArrayList<>();
        expectedMusic.add(new Music(new Product("Another title",9,"2019"),
                GenreOfMusic.CLASSIC,"Another executor"));
        expectedMusic.add(new Music(new Product("Title",12,"1982"),
                GenreOfMusic.CLASSIC,"Executor"));

        List<Music> actualMusic = musicService.sortByPrice();

        assertEquals(expectedMusic, actualMusic);


    }
}