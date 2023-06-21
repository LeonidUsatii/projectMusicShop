package de.ait.services;

import de.ait.models.*;

import java.util.List;

public interface Service {
    void addBook(Category category, String title,  double price,String releaseYear, String author,
                  GenreOfBook genreOfBook);

    void addMusic(Category category, String title,  double price,String releaseYear,
                  String executor);


    void addFilm(Category category, String title,  double price,String releaseYear,
                 GenreOfFilm genreOfFilm);

    List<Product> getProducts();

}
