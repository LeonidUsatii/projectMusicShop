package de.ait.repositories.musics;

import de.ait.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MusicsRepositoryTextFileImpl implements MusicsRepository {

    private String fileName;

    public MusicsRepositoryTextFileImpl(String fileName) {

        this.fileName = fileName;
    }


    @Override
    public List<Music> findAll() {

        List<Music> music = new ArrayList<>();

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
                GenreOfMusic genreOfMusic = GenreOfMusic.valueOf(parsed[5]);
                String executor = parsed[6];
                music.add(new Music(new Product(id, category, title, price, releaseYear), genreOfMusic,
                        executor));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }

        return music;
    }

    @Override
    public void save(Music music) {
        try (BufferedWriter bufferedWriter = new BufferedWriter
                (new FileWriter(fileName, true));) {
            String musicObject = "";

            musicObject = music.getProductInfo().getId() + "|" + music.getProductInfo().getCategory()
                    + "|" + music.getProductInfo().getTitle() + "|" + music.getProductInfo().getPrice()
                    + "|" + music.getProductInfo().getReleaseYear() + "|"
                    + music.getGenre() + "|" + music.getExecutor();

            bufferedWriter.write(musicObject);
            bufferedWriter.newLine();

        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }
    }

    @Override
    public Music findByTitle(String title) {
        List<Music> musics = findAll();
        for (Music music : musics) {
            if (music.getProductInfo().getTitle().equals(title)) {
                return music;
            }
        }
        return null;
    }

    @Override
    public void update(Music updatedGood) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<Music> goods = findAll();

            for (Music oldGood : goods) {
                if (oldGood.getProductInfo().getId().equals(updatedGood.getProductInfo().getId())) {
                    oldGood.getProductInfo().setTitle(updatedGood.getProductInfo().getTitle());
                    //oldGood.getProductInfo().setPrice(updatedGood.getProductInfo().getPrice());
                }
            }

            reader.close();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
                for (Music music : goods) {
                    writer.write(music.getProductInfo().getId() + "|" + music.getProductInfo().getCategory()
                            + "|" + music.getProductInfo().getTitle() + "|" + music.getProductInfo().getPrice()
                            + "|" + music.getProductInfo().getReleaseYear() + "|"
                            + music.getGenre() + "|" + music.getExecutor());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Ошибка при работе с файлом - " + e.getMessage());
        }
    }

    @Override
    public void delete(Music deleteGood) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<Music> goods = findAll();

            for (int i = 0; i < goods.size(); i++) {
                if (goods.get(i).getProductInfo().getId().equals(deleteGood.getProductInfo().getId())) {
                    goods.remove(i);
                }
            }

            reader.close();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
                for (Music music : goods) {
                    writer.write(music.getProductInfo().getId() + "|" + music.getProductInfo().getCategory()
                            + "|" + music.getProductInfo().getTitle() + "|" + music.getProductInfo().getPrice()
                            + "|" + music.getProductInfo().getReleaseYear() + "|"
                            + music.getGenre() + "|" + music.getExecutor());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Ошибка при работе с файлом - " + e.getMessage());
        }
    }
}
