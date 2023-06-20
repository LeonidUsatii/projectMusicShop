package de.ait.models;

import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private double price;
    private String releaseYear;
    private Genre genre;
    public Book(String title, String author, double price,
                String releaseYear, Genre genre) {
        if(title != null) {
            this.title = title;
        } else {
            System.err.println("Введите название книги");
        }
        if(author != null) {
            this.author = author;
        } else {
            System.err.println("Введите автора книги");
        }
        if (price > 0) {
            this.price = price;
        } else {
            System.err.println("Введите корректную цену");
        }
        if(releaseYear != null) {
            this.releaseYear = releaseYear;
        } else {
            System.err.println("Введите корректную дату");
        }
        this.genre = genre;
    }
    public Book (String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public double getPrice() {
        return price;
    }
    public String getReleaseYear() {
        return releaseYear;
    }
    public Genre getGenre() {
        return genre;
    }
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", releaseYear=" + releaseYear +
                ", genre=" + genre +
                '}';
    }
}
