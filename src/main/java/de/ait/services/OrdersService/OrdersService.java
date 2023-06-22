package de.ait.services.OrdersService;

public interface OrdersService {
    String makeOrder(String email, String goodTitle);
    String makeOrder(String email, String goodTitle, String address);
}
