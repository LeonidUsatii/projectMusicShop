package de.ait.repositories.orders;

import de.ait.models.Film;
import de.ait.models.Order;
import de.ait.models.User;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryTextFileImpl implements OrderRepository {

    private final String fileName;

    public OrderRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = bufferedReader.readLine();

            while (line != null) {
                String[] parsed = line.split("\\|");
                String id = parsed[0];
                LocalDateTime dateTime = LocalDateTime.parse(parsed[1]);
                String productId = parsed[2];
                String userId = parsed[3];
                orders.add(new Order(id, dateTime, productId, userId));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }

        return orders;
    }

    @Override
    public void save(Order order) {
        try (BufferedWriter bufferedWriter = new BufferedWriter
                (new FileWriter(fileName, true));) {

            String orderObject = "";

            orderObject = order.getId() + "|" + order.getDateTime()
                    + "|" + order.getUserId()
                    + "|" + order.getProductId();

            bufferedWriter.write(orderObject);
            bufferedWriter.newLine();

        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }
    }

    @Override
    public Order findByTitle(String title) {
        return null;
    }

    @Override
    public Order findById(String id) {
        return null;
    }
}
