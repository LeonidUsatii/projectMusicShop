package de.ait.repositories.films;

import de.ait.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilmsRepositoryTextFileImpl implements FilmsRepository{

    private String fileName;

    public FilmsRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Film> findAll() {
        List<Film> films = new ArrayList<>();

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = bufferedReader.readLine();

            while (line != null) {
                String[] parsed = line.split("\\|");
                String id  = parsed[0];
                Category category = Category.valueOf(parsed[1]);
                String title = parsed[2];
                double price  = Double.parseDouble(parsed[3]);
                String releaseYear  = parsed[4];
                GenreOfFilm genreOfFilm = GenreOfFilm.valueOf(parsed[5]);
                films.add(new Film(new Product(id, category, title, price, releaseYear), genreOfFilm));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }

        return films;
    }

    @Override
    public void save(Film film) {

        try (BufferedWriter bufferedWriter = new BufferedWriter
                (new FileWriter(fileName, true));) {

            String filmObject = "";

            filmObject = film.getProductInfo().getId() + "|" + film.getProductInfo().getCategory()
                    + "|" + film.getProductInfo().getTitle() + "|" + film.getProductInfo().getPrice()
                    + "|" + film.getProductInfo().getReleaseYear() + "|" + film.getGenre();

            bufferedWriter.write(filmObject);
            bufferedWriter.newLine();

        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }

    }

    @Override
    public Film findByTitle(String title) {
        return null;
    }
}
