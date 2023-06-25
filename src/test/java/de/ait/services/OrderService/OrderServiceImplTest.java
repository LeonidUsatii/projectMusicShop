package de.ait.services.OrderService;

import de.ait.models.Order;
import de.ait.models.Review;
import de.ait.repositories.CashWarrant.CashWarrantRepository;
import de.ait.repositories.DeliveryOffGoods.DeliveryOffGoodsRepository;
import de.ait.repositories.books.BooksRepository;
import de.ait.repositories.fakeImpl.*;
import de.ait.repositories.films.FilmsRepository;
import de.ait.repositories.musics.MusicsRepository;
import de.ait.repositories.orders.OrderRepository;
import de.ait.repositories.products.ProductsRepository;
import de.ait.repositories.users.UsersRepository;
import de.ait.services.OrdersService.OrdersService;
import de.ait.services.OrdersService.OrdersServiceImpl;
import de.ait.services.ReviewService.ReviewServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderServiceImplTest {
    private OrdersServiceImpl ordersService;
    private UsersRepository usersRepository;
    private ProductsRepository productsRepository;
    private OrderRepository ordersRepository;
    private DeliveryOffGoodsRepository deliveryOffGoodsRepository;
    private CashWarrantRepository cashWarrantRepository;
    private BooksRepository booksRepository;
    private MusicsRepository musicsRepository;
    private FilmsRepository filmsRepository;

    @BeforeEach
    void setUp() {
        this.ordersService = new OrdersServiceImpl(new UsersRepositoryFakeImpl(),
                new ProductsRepositoryFakeImpl(), new OrderRepositoryFakeImpl(),
                new DeliveryOffGoodsRepositoryFakeImpl(), new CashWarrantRepositoryFakeImpl(),
                new BookRepositoryFakeImpl(), new MusicsRepositoryFakeImpl(),
                new FilmsRepositoryFakeImpl());
    }

    @Test
    void getUser() {
        List<Order> expectedOrders = new ArrayList<>();

        Order order1 = new Order("docId1", "productId1", "userId1");
        Order order2 = new Order("docId2", "productId2", "userId2");
        Order order3 = new Order("docId3", "productId3", "userId3");

        expectedOrders = List.of(order1, order2, order3);

        List<Order> actualOrder = ordersService.getOrder();
        assertEquals(expectedOrders,actualOrder);
    }
}