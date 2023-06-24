package de.ait.repositories.products;
import de.ait.models.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsRepositoryTextFileImpl implements ProductsRepository {

    private String fileName;
    public ProductsRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Product> findAll() {

        List<Product> products = new ArrayList<>();

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = bufferedReader.readLine();

            while (line != null) {
                String[] parsed = line.split("\\|");
                String id  = parsed[0];
                Category category = Category.valueOf(parsed[1]);
                String title  = parsed[2];
                double price  = Double.parseDouble(parsed[3]);
                String releaseYear  = parsed[4];

                products.add(new Product(id, category, title, price, releaseYear)); // положили пользователя в список
                line = bufferedReader.readLine(); // считали следующую строку
            }
        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }

        return products;
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
            throw new IllegalArgumentException("Проблемы с файлом");
        }
    }

    @Override
    public Product findByTitle(String title) {
        List<Product> products = findAll();
        for (Product product : products) {
            if (product.getTitle().equals(title)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product updatedGood) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<Product> goods = findAll();

            for (Product oldGood : goods) {
                if (oldGood.getId().equals(updatedGood.getId())) {
                    oldGood.setTitle(updatedGood.getTitle());
                    oldGood.setPrice(updatedGood.getPrice());
                }
            }

            reader.close();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
                for (Product product : goods) {
                    writer.write(product.getId() + "|" + product.getCategory() + "|" + product.getTitle()
                            + "|" + product.getPrice() + "|" + product.getReleaseYear());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Ошибка при работе с файлом - " + e.getMessage());
        }
    }

    @Override
    public void delete(Product deleteGood) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<Product> goods = findAll();

            for (int i = 0; i < goods.size(); i++) {
                if (goods.get(i).getId().equals(deleteGood.getId())) {
                    goods.remove(i);
                }
            }

            reader.close();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
                for (Product product : goods) {
                    writer.write(product.getId() + "|" + product.getCategory() + "|" + product.getTitle()
                            + "|" + product.getPrice() + "|" + product.getReleaseYear());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Ошибка при работе с файлом - " + e.getMessage());
        }
    }
}
