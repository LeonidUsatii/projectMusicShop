package de.ait.repositories.fakeImpl;

import de.ait.models.DeliveryOffGoods;
import de.ait.models.Order;
import de.ait.repositories.orders.OrderRepository;

import java.util.List;

public class OrderRepositoryFakeImpl implements OrderRepository {
    @Override
    public Order findByTitle(String title) {
        return null;
    }
    @Override
    public List<Order> findAll() {
        Order order1 = new Order("docId1", "productId1", "userId1");
        Order order2 = new Order("docId2", "productId2", "userId2");
        Order order3 = new Order("docId3", "productId3", "userId3");

        return List.of(order1, order2, order3);

    }
    @Override
    public void save(Order model) {

    }
    @Override
    public Order findById(String id) {
        return null;
    }
}
