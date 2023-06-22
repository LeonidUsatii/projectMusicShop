package de.ait.repositories.orders;

import de.ait.models.Film;
import de.ait.models.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OrderRepositoryTextFileImpl implements OrderRepository {

    private final String fileName;

    public OrderRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Order> findAll() {
        return null;
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
