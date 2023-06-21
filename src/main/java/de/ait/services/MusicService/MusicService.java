package de.ait.services.MusicService;

import de.ait.models.Category;
import de.ait.models.GenreOfBook;
import de.ait.models.GenreOfMusic;
import de.ait.models.Product;

import java.util.List;

public interface MusicService {
    void addMusic(Category category, String title, double price, String releaseYear,
                  GenreOfMusic genre, String executor);

    List<Product> getProducts();

}
