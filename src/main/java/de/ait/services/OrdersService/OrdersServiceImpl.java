package de.ait.services.OrdersService;

import de.ait.models.Order;
import de.ait.models.Product;
import de.ait.models.User;
import de.ait.repositories.orders.OrderRepository;
import de.ait.repositories.products.ProductsRepository;
import de.ait.repositories.users.UsersRepository;

import java.time.LocalDateTime;
import java.util.UUID;


public class OrdersServiceImpl implements OrdersService {

    private UsersRepository usersRepository;
    private ProductsRepository productsRepository;
    private OrderRepository ordersRepository;

    public OrdersServiceImpl(UsersRepository usersRepository,
                             ProductsRepository productsRepository,
                             OrderRepository ordersRepository) {
        this.usersRepository = usersRepository;
        this.productsRepository = productsRepository;
        this.ordersRepository = ordersRepository;
    }

    @Override
    public String makeOrder(String email, String title) {
        User user = usersRepository.findByEmail(email);

        if (user == null) {
            throw new IllegalArgumentException("Пользователь не найден");
        }

        Product product = productsRepository.findByTitle(title);

        if (product == null) {
            throw new IllegalArgumentException("Товар не найден");
        }

        Order order = new Order(
                UUID.randomUUID().toString(),
                LocalDateTime.now(),
                product.getId(),
                user.getId()
        );

        ordersRepository.save(order);

        return "Квитанция № " + order.getId() + ", заказ был сделан на " + title + " в " + order.getDateTime();
    }
}
