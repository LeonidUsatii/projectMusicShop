package de.ait.models;

import java.util.Objects;

public class Book implements Comparable<Book>{

    private final Product productInfo;
    private String author;
    private final GenreOfBook genreOfBook;

    public Book(Product productInfo, String author, GenreOfBook genreOfBook) {

        this.productInfo = productInfo;

        if(author != null) {
            this.author = author;
        } else {
            System.err.println("Введите автора книги");
        }

        this.genreOfBook = genreOfBook;
    }

    public Product getProductInfo() {
        return productInfo;
    }

    public GenreOfBook getGenreOfBook() {
        return genreOfBook;
    }

    public String getAuthor() {

        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "productInfo=" + productInfo +
                ", author='" + author + '\'' +
                ", genreOfBook=" + genreOfBook +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return Double.compare(o.getProductInfo().getPrice(),this.productInfo.getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(productInfo, book.productInfo) && Objects.equals(author, book.author) && genreOfBook == book.genreOfBook;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productInfo, author, genreOfBook);
    }
}
