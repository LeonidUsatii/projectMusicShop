package de.ait.services.MusicService;

import de.ait.models.*;
import de.ait.services.EService;

import java.util.List;

public interface MusicService extends EService<Music> {
    void addMusic(Category category, String title, double price, String releaseYear,
                  GenreOfMusic genre, String executor);

    List<Music> getProducts();

}
