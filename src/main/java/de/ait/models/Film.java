package de.ait.models;
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


    }

    @Override
    public String toString() {
        return "Film{" +
                "productInfo=" + productInfo +
                ", genre=" + genre +
                '}';
    }
}