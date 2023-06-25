package de.ait.repositories.fakeImpl;

import de.ait.models.DeliveryOffGoods;
import de.ait.models.Review;
import de.ait.repositories.DeliveryOffGoods.DeliveryOffGoodsRepository;


import java.util.List;

public class DeliveryOffGoodsRepositoryFakeImpl implements DeliveryOffGoodsRepository {
    @Override
    public List<DeliveryOffGoods> findAll() {

        DeliveryOffGoods delivery1 = new DeliveryOffGoods("docId1", "address1",
                "productId1", "userId1", "deliveryDate1");
        DeliveryOffGoods delivery2 = new DeliveryOffGoods("docId1", "address2",
                "productId2", "userId2", "deliveryDate2");
        DeliveryOffGoods delivery3 = new DeliveryOffGoods("docId3", "address3",
                "productId3", "userId3", "deliveryDate3");

        return List.of(delivery1, delivery2, delivery3);
    }

    @Override
    public void save(DeliveryOffGoods model) {

    }

    @Override
    public DeliveryOffGoods findByTitle(String title) {
        return null;
    }
}
