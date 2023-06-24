package de.ait.repositories.books;

import de.ait.models.*;
import de.ait.repositories.books.BooksRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BooksRepositoryTextFileImpl implements BooksRepository {

    private final String fileName;

    public BooksRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();

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
                String author  = parsed[5];
                GenreOfBook genreOfBook = GenreOfBook.valueOf(parsed[6]);
                books.add(new Book(new Product(id, category, title, price, releaseYear), author, genreOfBook));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }

        return books;
    }

    @Override
    public void save(Book book) {
        try (BufferedWriter bufferedWriter = new BufferedWriter
                (new FileWriter(fileName, true));) {

            String bookObject = "";

            bookObject = book.getProductInfo().getId() + "|" + book.getProductInfo().getCategory()
                    + "|" + book.getProductInfo().getTitle() + "|" + book.getProductInfo().getPrice()
                    + "|" + book.getProductInfo().getReleaseYear()
                    + "|" + book.getAuthor() + "|" + book.getGenreOfBook();


            bufferedWriter.write(bookObject);
            bufferedWriter.newLine();

        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }
    }

    @Override
    public Book findByTitle(String title) {
        List<Book> books = findAll();
        for (Book book : books) {
            if (book.getProductInfo().getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void update(Book updatedGood) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            List<Book> goods = findAll();

            for (Book oldGood : goods) {
                if (oldGood.getProductInfo().getId().equals(updatedGood.getProductInfo().getId())) {
                    oldGood.setTitle(updatedGood.getProductInfo().getTitle());
                }
            }
            reader.close();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){

                for (Book book : goods) {
                    writer.write(book.getProductInfo().getId() + "|" + book.getProductInfo().getCategory()
                            + "|" + book.getProductInfo().getTitle() + "|" + book.getProductInfo().getPrice()
                            + "|" + book.getProductInfo().getReleaseYear()
                            + "|" + book.getAuthor() + "|" + book.getGenreOfBook());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Ошибка при работе с файлом - " + e.getMessage());
        }
    }

    @Override
    public void delete(Book deleteGood) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<Book> goods = findAll();

            for (int i = 0; i < goods.size(); i++) {
                if (goods.get(i).getProductInfo().getId().equals(deleteGood.getProductInfo().getId())) {
                    goods.remove(i);
                }
            }

            reader.close();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
                for (Book book : goods) {
                    writer.write(book.getProductInfo().getId() + "|" + book.getProductInfo().getCategory()
                            + "|" + book.getProductInfo().getTitle() + "|" + book.getProductInfo().getPrice()
                            + "|" + book.getProductInfo().getReleaseYear()
                            + "|" + book.getAuthor() + "|" + book.getGenreOfBook());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Ошибка при работе с файлом - " + e.getMessage());
        }
    }

}
