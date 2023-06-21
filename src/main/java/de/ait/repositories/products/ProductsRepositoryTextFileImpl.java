package de.ait.repositories.products;

import de.ait.models.Film;
import de.ait.models.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProductsRepositoryTextFileImpl implements ProductsRepository {

    private String fileName;
    public ProductsRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void save(Product product) {
        try (BufferedWriter bufferedWriter = new BufferedWriter
                (new FileWriter(fileName, true));) {

            String productObject = "";

            productObject = product.getId() + "|" + product.getCategory() + "|" + product.getTitle()
                    + "|" + product.getPrice() + "|" + product.getReleaseYear();

            bufferedWriter.write(productObject);
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }
    }

    @Override
    public Product findById(String id) {
        return null;
    }
}
