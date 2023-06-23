package de.ait.services.OrdersService;

import de.ait.models.*;


import de.ait.repositories.cashWarrant.CashWarrantRepository;
import de.ait.repositories.deliveryOffGoods.DeliveryOffGoodsRepository;
import de.ait.repositories.orders.OrderRepository;
import de.ait.repositories.products.ProductsRepository;
import de.ait.repositories.users.UsersRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


public class OrdersServiceImpl implements OrdersService {

    private final UsersRepository usersRepository;
    private final ProductsRepository productsRepository;
    private final OrderRepository ordersRepository;

    private final DeliveryOffGoodsRepository deliveryOffGoodsRepository;

    private final CashWarrantRepository cashWarrantRepository;

    public OrdersServiceImpl(UsersRepository usersRepository, ProductsRepository productsRepository,
                             OrderRepository ordersRepository, DeliveryOffGoodsRepository deliveryOffGoodsRepository,
                             CashWarrantRepository cashWarrantRepository) {
        this.usersRepository = usersRepository;
        this.productsRepository = productsRepository;
        this.ordersRepository = ordersRepository;
        this.deliveryOffGoodsRepository = deliveryOffGoodsRepository;
        this.cashWarrantRepository = cashWarrantRepository;
    }

    @Override
    public String makeOrder(String email, String productTitle) {
        User user = usersRepository.findByEmail(email);

        if (user == null) {
            throw new IllegalArgumentException("Пользователь не найден");
        }

        Product product = productsRepository.findByTitle(productTitle);

        if (product == null) {
            throw new IllegalArgumentException("Товар не найден");
        }

        Order order = new Order(
                UUID.randomUUID().toString(),
                LocalDateTime.now(),
                product.getId(),
                user.getId()
        );

        CashWarrant cashWarrant = new CashWarrant(
                UUID.randomUUID().toString(),
                LocalDateTime.now(),
                user.getId(),
                product.getPrice());

        ordersRepository.save(order);
        cashWarrantRepository.save(cashWarrant);

        return "Квитанция № " + order.getId() + ", заказ был сделан на "
                + productTitle + " в " + order.getDateTime();
    }

    @Override
    public String makeOrder(String email, String productTitle, String address) {
        User user = usersRepository.findByEmail(email);

        if (user == null) {
            throw new IllegalArgumentException("Пользователь не найден");
        }

        Product product = productsRepository.findByTitle(productTitle);

        if (product == null) {
            throw new IllegalArgumentException("Товар не найден");
        }

        Order order = new Order(
                UUID.randomUUID().toString(),
                LocalDateTime.now(),
                product.getId(),
                user.getId()
        );

        CashWarrant cashWarrant = new CashWarrant(
                UUID.randomUUID().toString(),
                LocalDateTime.now(),
                user.getId(),
                product.getPrice());

        DeliveryOffGoods deliveryOffGoods = new DeliveryOffGoods(
                UUID.randomUUID().toString(),
                address, product.getId(),
                user.getId(),
                LocalDateTime.now().plusDays(3).toString()
        );

        ordersRepository.save(order);
        cashWarrantRepository.save(cashWarrant);
        deliveryOffGoodsRepository.save(deliveryOffGoods);

        return "Квитанция № " + order.getId() + ", заказ был сделан на "
                + productTitle + " в " + order.getDateTime()  + " дата доставки "
                + LocalDateTime.now().plusDays(3);
    }
    @Override
    public List<Order> getOrder() {
        return ordersRepository.findAll();
    }
}
