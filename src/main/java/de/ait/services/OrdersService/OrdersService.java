package de.ait.services.OrdersService;

public interface OrdersService {
    String makeOrder(String email, String goodTitle, boolean isDelivery);
}
