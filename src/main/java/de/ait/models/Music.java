package de.ait.models;

import java.util.Objects;

public class Music implements Comparable<Music>{
    private Product productInfo;

    private GenreOfMusic genre;

    private String executor;

    public Music(Product productInfo, GenreOfMusic genre, String executor) {
        this.productInfo = productInfo;
        this.genre = genre;
        this.executor = executor;
    }

    public Product getProductInfo() {
        return productInfo;
    }

    public GenreOfMusic getGenre() {
        return genre;
    }

    public String getExecutor() {
        return executor;

    }

    @Override
    public String toString() {
        return "Music{" +
                "productInfo=" + productInfo +
                ", genre=" + genre +
                ", executor='" + executor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Music o) {
        return Double.compare(o.getProductInfo().getPrice(),this.productInfo.getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Music music = (Music) o;
        return Objects.equals(productInfo, music.productInfo) && genre == music.genre && Objects.equals(executor, music.executor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productInfo, genre, executor);
    }
}
