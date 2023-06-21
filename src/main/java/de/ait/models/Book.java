package de.ait.models;

public class Book {

    private Product productInfo;
    private String author;
    private GenreOfBook genreOfBook;

    public Book(Product productInfo, String author, GenreOfBook genreOfBook) {

        this.productInfo = productInfo;
public class Book extends Product{
    private String author;
    private String releaseYear;
    private GenreForBooks genreForBooks;
    public Book( String title, String author,double price,
                String releaseYear, GenreForBooks genreForBooks) {
        super();
>>>>>>> origin/master

        if(author != null) {
            this.author = author;
        } else {
            System.err.println("Введите автора книги");
        }

<<<<<<< HEAD
        this.genreOfBook = genreOfBook;
    }

    public Product getProductInfo() {
        return productInfo;
    }

    public GenreOfBook getGenreOfBook() {
        return genreOfBook;
    }

=======
        if(releaseYear != null) {
            this.releaseYear = releaseYear;
        } else {
            System.err.println("Введите корректную дату");
        }
        this.genreForBooks = genreForBooks;
    }
    public Book(String title){
        this.title = title;
    }

>>>>>>> origin/master
    public String getAuthor() {

        return author;
    }

<<<<<<< HEAD
=======
    public String getReleaseYear() {
        return releaseYear;
    }
    public GenreForBooks getGenre() {
        return genreForBooks;
    }
>>>>>>> origin/master
    @Override
    public String toString() {
        return "Book{" +
                "productInfo=" + productInfo +
                ", author='" + author + '\'' +
<<<<<<< HEAD
                ", genreOfBook=" + genreOfBook +
=======
                ", price=" + price +
                ", releaseYear=" + releaseYear +
                ", genre=" + genreForBooks +
>>>>>>> origin/master
                '}';
    }
}
