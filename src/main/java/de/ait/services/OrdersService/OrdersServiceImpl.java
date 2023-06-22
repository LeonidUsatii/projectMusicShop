package de.ait.services.OrdersService;

import de.ait.models.*;
import de.ait.repositories.CashWarrant.CashWarrantRepository;
import de.ait.repositories.DeliveryOffGoods.DeliveryOffGoodsRepository;
import de.ait.repositories.orders.OrderRepository;
import de.ait.repositories.products.ProductsRepository;
import de.ait.repositories.users.UsersRepository;

import java.time.LocalDateTime;
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
    public String makeOrder(String email, String title, boolean isDelivery) {
        User user = usersRepository.findByEmail(email);

        if (user == null) {
            throw new IllegalArgumentException("Пользователь не найден");
        }

        Product product = productsRepository.findByTitle(title);

        if (product == null) {
            throw new IllegalArgumentException("Товар не найден");
        }

//        if(isDelivery == true) {
//            DeliveryOffGoods deliveryOffGoods = new DeliveryOffGoods(
//                    UUID.randomUUID().toString(),
//
//            );
//        }

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
                + title + " в " + order.getDateTime();
    }
}
