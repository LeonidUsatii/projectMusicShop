package de.ait.services.OrdersService;

public interface OrdersService {
    String makeOrder(String email, String productTitle);
    String makeOrder(String email, String productTitle, String address);
}
