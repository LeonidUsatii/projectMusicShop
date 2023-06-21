package de.ait.models;

public class Music {
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
}
