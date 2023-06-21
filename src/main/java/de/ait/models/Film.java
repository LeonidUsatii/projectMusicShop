package de.ait.models;

<<<<<<< HEAD
public class Film {
    private Product productInfo;

    private GenreOfFilm genre;

    public Film(Product productInfo, GenreOfFilm genre) {
        this.productInfo = productInfo;
        this.genre = genre;
    }

    public Product getProductInfo() {
        return productInfo;
    }

    public GenreOfFilm getGenre() {
        return genre;
=======
public class Film extends Product {
    private String releaseYear;
    private GenreForFilms genreForFilms;

    public Film(String id, String title, double price, String releaseYear, GenreForFilms genreForFilms) {
        super(id, title, price);
        this.releaseYear = releaseYear;
        this.genreForFilms = genreForFilms;
    }

    public Film(String releaseYear, GenreForFilms genreForFilms) {
        this.releaseYear = releaseYear;
        this.genreForFilms = genreForFilms;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public GenreForFilms getGenreForFilms() {
        return genreForFilms;
>>>>>>> origin/master
    }

    @Override
    public String toString() {
        return "Film{" +
<<<<<<< HEAD
                "productInfo=" + productInfo +
                ", genre=" + genre +
                '}';
=======
                "releaseYear='" + releaseYear + '\'' +
                ", genreForFilms=" + genreForFilms +
                ", id='" + id + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                "} " + super.toString();
>>>>>>> origin/master
    }
}
