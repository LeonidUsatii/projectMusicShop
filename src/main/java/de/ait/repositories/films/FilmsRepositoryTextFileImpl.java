package de.ait.repositories.films;

import de.ait.models.Film;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FilmsRepositoryTextFileImpl implements FilmsRepository{

    private String fileName;

    public FilmsRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Film> findAll() {
        return null;
    }

    @Override
    public void save(Film film) {

        try (BufferedWriter bufferedWriter = new BufferedWriter
                (new FileWriter(fileName, true));) {

            String filmObject = "";

            filmObject = film.getProductInfo().getId() + "|" + film.getProductInfo() + "|" + film.getGenre();

            bufferedWriter.write(filmObject);
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }

    }

    @Override
    public Film findById(String id) {
        return null;
    }
}
