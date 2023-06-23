package de.ait.services.OrdersService;

import de.ait.models.Order;

import java.util.List;

public interface OrdersService {
    String makeOrder(String email, String productTitle);

    String makeOrder(String email, String productTitle, String address);

    List<Order> getOrder();
}
