package de.ait.models;

<<<<<<< HEAD
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
=======
public class Music extends Product{
    private String performer;
    private String albumTitle;

    public Music(String id, String title, double price, String performer, String albumTitle) {
        super(id, title, price);
        this.performer = performer;
        this.albumTitle = albumTitle;
    }

    public Music(String performer, String albumTitle) {
        this.performer = performer;
        this.albumTitle = albumTitle;
    }

    public String getPerformer() {
        return performer;
    }

    public String getAlbumTitle() {
        return albumTitle;
>>>>>>> origin/master
    }

    @Override
    public String toString() {
        return "Music{" +
<<<<<<< HEAD
                "productInfo=" + productInfo +
                ", genre=" + genre +
                ", executor='" + executor + '\'' +
                '}';
=======
                "performer='" + performer + '\'' +
                ", albumTitle='" + albumTitle + '\'' +
                ", id='" + id + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                "} " + super.toString();
>>>>>>> origin/master
    }
}
