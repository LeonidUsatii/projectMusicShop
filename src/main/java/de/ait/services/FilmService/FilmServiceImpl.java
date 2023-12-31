package de.ait.services.FilmService;

import de.ait.models.*;
import de.ait.repositories.films.FilmsRepository;
import de.ait.repositories.musics.MusicsRepository;
import de.ait.repositories.products.ProductsRepository;

import java.util.List;

public class FilmServiceImpl implements FilmService {

    private final FilmsRepository filmsRepository;
    private final ProductsRepository productsRepository;

    public FilmServiceImpl(FilmsRepository filmsRepository, ProductsRepository productsRepository) {
        this.filmsRepository = filmsRepository;
        this.productsRepository = productsRepository;
    }

    @Override
    public void addFilm(Category category, String title, double price,
                        String releaseYear, GenreOfFilm genreOfFilm) {
        Product productInfo = new Product(category, title, price, releaseYear);
        productsRepository.save(productInfo);
        filmsRepository.save(new Film(productInfo, genreOfFilm));
    }

    @Override
    public List<Film> getProducts() {

        return filmsRepository.findAll();
    }

    @Override
    public List<Film> sortByPrice() {
        List<Film> films = filmsRepository.findAll();
        return films.stream().sorted().toList();
    }

    @Override
    public List<Film> filterByValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Жанр не найден");
        }
        List<Film> films = filmsRepository.findAll();
        return  films.stream()
                .filter(((film) -> film.getGenre().name().equals(value)))
                .toList();
    }
}
