package de.ait.models;
public class Film implements Comparable <Film>{
    private final Product productInfo;

    private final GenreOfFilm genre;

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

    @Override
    public int compareTo(Film o) {
            return Double.compare(o.getProductInfo().getPrice(),this.productInfo.getPrice());
    }
}