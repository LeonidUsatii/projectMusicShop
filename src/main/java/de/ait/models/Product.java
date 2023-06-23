package de.ait.models;

import java.util.Objects;
import java.util.UUID;

public class Product implements Comparable<Product>{
    private String id;

    private Category category;

    private String title;

    private double price;

    private String releaseYear;

    public Product(String id, Category category, String title, double price,
                   String releaseYear) {

        if (id != null) {
            this.id = id;
        } else {
            System.err.println("Введите id товара");
        }

        if (category != null) {
            this.category = category;
        } else {
            System.err.println("Введите категорию товара");
        }

        if (title != null) {
            this.title = title;
        } else {
            System.err.println("Введите название");
        }

        if (price > 0) {
            this.price = price;
        } else {
            System.err.println("Введите корректную цену");
        }

        if (releaseYear != null) {
            this.releaseYear = releaseYear;
        } else {
            System.err.println("Введите корректную дату");
        }
    }

    public Product(Category category, String title, double price, String releaseYear) {

       // this.id = UUID.randomUUID().toString();

        if (category != null) {
            this.category = category;
        } else {
            System.err.println("Введите категорию товара");
        }

        if (title != null) {
            this.title = title;
        } else {
            System.err.println("Введите название");
        }

        if (price > 0) {
            this.price = price;
        } else {
            System.err.println("Введите корректную цену");
        }

        if (releaseYear != null) {
            this.releaseYear = releaseYear;
        } else {
            System.err.println("Введите корректную дату");
        }
    }

    public String getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", releaseYear='" + releaseYear + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        if(this.price != o.price) {
            return Double.compare(this.price, o.price);
        } else  if(!this.title.equals(o.title)) {
            return this.title.compareTo(o.title);
        } else if(!this.category.equals(o.category)){
            return this.category.compareTo(o.category);
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && Objects.equals(id, product.id) && category == product.category && Objects.equals(title, product.title) && Objects.equals(releaseYear, product.releaseYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, title, price, releaseYear);
    }
}