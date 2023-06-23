package de.ait.repositories.deliveryOffGoods;

import de.ait.models.Category;
import de.ait.models.DeliveryOffGoods;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryOffGoodsRepositoryTextFileImpl implements DeliveryOffGoodsRepository {

    private final String fileName;
    public DeliveryOffGoodsRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<DeliveryOffGoods> findAll() {

        List<DeliveryOffGoods> products = new ArrayList<>();

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

//                products.add(new Product(id, category, title, price, releaseYear)); // положили пользователя в список
                line = bufferedReader.readLine(); // считали следующую строку
            }
        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }

        return products;
    }

//    @Override
//    public void save(DeliveryOffGoods model) {
//
//    }

    @Override
    public DeliveryOffGoods findByTitle(String title) {
        return null;
    }

    @Override
    public void save(DeliveryOffGoods delivery) {
        try (BufferedWriter bufferedWriter = new BufferedWriter
                (new FileWriter(fileName, true));) {

            String deliveryObject = "";

            deliveryObject = delivery.getId() + "|" + delivery.getAddress() + "|" + delivery.getProductId()
                    + "|" + delivery.getUserId() + "|" + delivery.getDeliveryDate();

            bufferedWriter.write(deliveryObject);
            bufferedWriter.newLine();

        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }
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
