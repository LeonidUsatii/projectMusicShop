package de.ait.repositories.musics;

import de.ait.models.Film;
import de.ait.models.Music;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MusicsRepositoryTextFileImpl implements MusicsRepository {

    private String fileName;

    public MusicsRepositoryTextFileImpl(String fileName) {

        this.fileName = fileName;
    }


    @Override
    public List<Music> findAll() {
        return null;
    }

    @Override
    public void save(Music music) {
        try (BufferedWriter bufferedWriter = new BufferedWriter
                (new FileWriter(fileName, true));) {

            String musicObject = "";

            musicObject = music.getProductInfo().getId() + "|" + music.getProductInfo() + "|"
                    + music.getGenre() + "|" + music.getExecutor();


            bufferedWriter.write(musicObject);
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }
    }

    @Override
    public Music findById(String id) {
        return null;
    }
}
