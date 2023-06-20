package de.ait.services;

import de.ait.models.Genre;

import java.util.List;

public interface BooksService {
    void addBook(String title, String author, double price,
                 String releaseYear, Genre genre);
    List<String> getNames();

}
