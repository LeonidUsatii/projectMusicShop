package de.ait.models;

import java.util.Objects;

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
        if(this.productInfo.getPrice() != o.productInfo.getPrice()) {
            return Double.compare(this.productInfo.getPrice(), o.getProductInfo().getPrice());
        } else  if(!this.productInfo.getTitle().equals(o.productInfo.getTitle())) {
            return this.productInfo.getTitle().compareTo(o.productInfo.getTitle());
        } else if(!this.genre.equals(o.getGenre())){
            return this.genre.compareTo(o.getGenre());
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(productInfo, film.productInfo) && genre == film.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productInfo, genre);
    }
}