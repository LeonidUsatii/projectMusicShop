package de.ait.repositories.CashWarrant;

import de.ait.models.CashWarrant;
import de.ait.models.Category;
import de.ait.models.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CashWarrantRepositoryTextFileImpl implements CashWarrantRepository {

    private String fileName;
    public CashWarrantRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<CashWarrant> findAll() {

        List<CashWarrant> products = new ArrayList<>();

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

                //products.add(new Product(id, category, title, price, releaseYear)); // положили пользователя в список
                line = bufferedReader.readLine(); // считали следующую строку
            }
        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }

        return products;
    }

    @Override
    public void save(CashWarrant product) {
        try (BufferedWriter bufferedWriter = new BufferedWriter
                (new FileWriter(fileName, true));) {

            String productObject = "";

//            productObject = product.getId() + "|" + product.getCategory() + "|" + product.getTitle()
//                    + "|" + product.getPrice() + "|" + product.getReleaseYear();

            bufferedWriter.write(productObject);
            bufferedWriter.newLine();

        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }
    }

    @Override
    public CashWarrant findByTitle(String title) {
        return null;
    }

//    @Override
//    public Product findByTitle(String title) {
//        List<Product> products = findAll();
//        for (Product product : products) {
//            if (product.getTitle().equals(title)) {
//                return product;
//            }
//        }
//        return null;
//    }
}
