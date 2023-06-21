package de.ait.models;

<<<<<<< HEAD
import java.util.UUID;

public class Product {
    private String id;

    private Category category;

    private String title;

    private double price;

    private String releaseYear;

    public Product( Category category, String title, double price, String releaseYear) {

        this.id = UUID.randomUUID().toString();

        if(category != null) {
            this.category = category;
        } else {
            System.err.println("Введите категорию товара");
        }

=======

public class Product {
    protected String id;
    protected double price;
    protected String title;

    public Product(String id, String title, double price) {
        this.id = id;
>>>>>>> origin/master
        if(title != null) {
            this.title = title;
        } else {
            System.err.println("Введите название книги");
        }
<<<<<<< HEAD

=======
>>>>>>> origin/master
        if (price > 0) {
            this.price = price;
        } else {
            System.err.println("Введите корректную цену");
        }

<<<<<<< HEAD
        if(releaseYear != null) {
            this.releaseYear = releaseYear;
        } else {
            System.err.println("Введите корректную дату");
        }
    }

=======
    }

    public Product() {

    }


>>>>>>> origin/master
    public String getId() {
        return id;
    }

<<<<<<< HEAD
    public Category getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

=======
>>>>>>> origin/master
    public double getPrice() {
        return price;
    }

<<<<<<< HEAD
    public String getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", releaseYear='" + releaseYear + '\'' +
                '}';
=======
    public String getTitle() {
        return title;
>>>>>>> origin/master
    }
}
