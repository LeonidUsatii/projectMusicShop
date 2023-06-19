package de.ait.models;

import java.time.LocalDate;

public class Book {
    private String title;
    private String author;

    private double price;

    private double rating;

    private LocalDate releaseYear;

    private Genre genre;

    public Book(String title, String author, double price, double rating, LocalDate releaseYear, Genre genre) {

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
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        } else {
            System.err.println("Рейтинг не указан");
        }

        this.releaseYear = releaseYear;

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

    public double getRating() {
        return rating;
    }

    public LocalDate getReleaseYear() {
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
                ", rating=" + rating +
                ", releaseYear=" + releaseYear +
                ", genre=" + genre +
                '}';
    }
}
