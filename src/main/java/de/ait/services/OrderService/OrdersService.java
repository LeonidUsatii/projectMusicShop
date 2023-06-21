package de.ait.services.OrderService;
import de.ait.models.Order;
import de.ait.services.EService;

public interface OrdersService extends EService<Order> {
    String makeOrder(String email, String goodTitle);
}
