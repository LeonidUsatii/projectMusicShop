package de.ait.repositories.books;

import de.ait.models.Book;
import de.ait.models.GenreOfBook;
import de.ait.repositories.books.BooksRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BooksRepositoryTextFileImpl implements BooksRepository {

    private String fileName;

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
                //Book book = parseLine(line); // преобразуем пользователя в строку
                String[] parsed = line.split("\\|");
                String title  = parsed[0];
                String author  = parsed[1];
                double price  = Double.parseDouble(parsed[2]);
                String releaseYear  = parsed[3];
                GenreOfBook genreOfBook = GenreOfBook.valueOf(parsed[4]);
                //books.add(new Book(title, author, price, releaseYear, genreOfBook)); // положили пользователя в список
                line = bufferedReader.readLine(); // считали следующую строку
            }
        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }

        return books;
    }

    @Override
    public void save(Book book) {
        try (BufferedWriter bufferedWriter = new BufferedWriter
                (new FileWriter(fileName, true));) {

            String bookObject = "";

            bookObject = book.getProductInfo().getId() + "|" + book.getProductInfo() + "|" + book.getAuthor()
                    + "|" + book.getGenreOfBook();

            bufferedWriter.write(bookObject);
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }
    }

    @Override
    public Book findById(String id) {
        return null;
    }

}
