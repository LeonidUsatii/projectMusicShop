package de.ait.services.MusicService;

import de.ait.models.*;
import de.ait.repositories.books.BooksRepository;
import de.ait.repositories.musics.MusicsRepository;
import de.ait.repositories.products.ProductsRepository;

import java.util.List;

public class MusicServiceImpl implements MusicService {
    private final MusicsRepository musicsRepository;
    private final ProductsRepository productsRepository;

    public MusicServiceImpl(MusicsRepository musicsRepository, ProductsRepository productsRepository) {
        this.musicsRepository = musicsRepository;
        this.productsRepository = productsRepository;
    }

    @Override
    public void addMusic(Category category, String title, double price,
                         String releaseYear, GenreOfMusic genre, String executor) {
        Product productInfo = new Product(category, title, price, releaseYear);
        productsRepository.save(productInfo);
        musicsRepository.save(new Music(productInfo, genre, executor));
    }

    @Override
    public List<Music> getProducts() {
        return musicsRepository.findAll();
    }

    @Override
    public List<Music> sortByPrice() {
        List<Music> musics = musicsRepository.findAll();
        return musics.stream().sorted().toList();

    }

    @Override
    public List<Music> filterByValue(String value) {

        if (value == null) {
            throw new IllegalArgumentException("Автор не найден");
        }
        List<Music> musics = musicsRepository.findAll();
        return musics.stream()
                .filter(((music) -> music.getExecutor().equals(value)))
                .toList();
    }
}
