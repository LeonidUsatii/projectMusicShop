package de.ait.services.DeliveryOffGoodsService;


import de.ait.models.DeliveryOffGoods;
import de.ait.models.User;
import de.ait.repositories.DeliveryOffGoods.DeliveryOffGoodsRepository;
import de.ait.repositories.fakeImpl.DeliveryOffGoodsRepositoryFakeImpl;
import de.ait.repositories.fakeImpl.UsersRepositoryFakeImpl;
import de.ait.services.DeliveryOffGoods.DeliveryOffGoodsServiceImpl;
import de.ait.services.UserService.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeliveryOffGoodsServiceImplTest {
    private DeliveryOffGoodsServiceImpl deliveryOffGoodsService;

    private DeliveryOffGoodsRepository deliveryOffGoodsRepository;
    @BeforeEach
    void setUp() {
        this.deliveryOffGoodsService = new DeliveryOffGoodsServiceImpl
                (new DeliveryOffGoodsRepositoryFakeImpl());
    }

    @Test
    void getOrder() {
        List<DeliveryOffGoods> expectedDelivery = new ArrayList<>();

        DeliveryOffGoods delivery1 = new DeliveryOffGoods("docId1", "address1",
                "productId1", "userId1", "deliveryDate1");
        DeliveryOffGoods delivery2 = new DeliveryOffGoods("docId1", "address2",
                "productId2", "userId2", "deliveryDate2");
        DeliveryOffGoods delivery3 = new DeliveryOffGoods("docId3", "address3",
                "productId3", "userId3", "deliveryDate3");

        expectedDelivery =  List.of(delivery1, delivery2, delivery3);

        List<DeliveryOffGoods> actualDelivery = deliveryOffGoodsService.getOrder();
        assertEquals(expectedDelivery,actualDelivery);
    }
}