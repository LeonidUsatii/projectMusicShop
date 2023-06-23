package de.ait.services.CashWarrant;

import de.ait.models.DeliveryOffGoods;
import de.ait.repositories.cashWarrant.CashWarrantRepository;
import de.ait.repositories.deliveryOffGoods.DeliveryOffGoodsRepository;
import de.ait.repositories.orders.OrderRepository;
import de.ait.repositories.products.ProductsRepository;
import de.ait.repositories.users.UsersRepository;

import java.util.List;


public class CashWarrantServiceImpl implements CashWarrantService {

    private final UsersRepository usersRepository;
    private final ProductsRepository productsRepository;
    private final OrderRepository ordersRepository;

    private final DeliveryOffGoodsRepository deliveryOffGoodsRepository;

    private final CashWarrantRepository cashWarrantRepository;

    public CashWarrantServiceImpl(UsersRepository usersRepository, ProductsRepository productsRepository,
                                  OrderRepository ordersRepository, DeliveryOffGoodsRepository deliveryOffGoodsRepository,
                                  CashWarrantRepository cashWarrantRepository) {
        this.usersRepository = usersRepository;
        this.productsRepository = productsRepository;
        this.ordersRepository = ordersRepository;
        this.deliveryOffGoodsRepository = deliveryOffGoodsRepository;
        this.cashWarrantRepository = cashWarrantRepository;
    }


    @Override
    public List<DeliveryOffGoods> getOrder() {

        //return DeliveryOffGoodsRepository.findAll();
        return null;
    }
}
