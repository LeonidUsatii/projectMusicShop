package de.ait.services.CashWarrantService;


import de.ait.models.CashWarrant;
import de.ait.models.DeliveryOffGoods;
import de.ait.repositories.CashWarrant.CashWarrantRepository;
import de.ait.repositories.DeliveryOffGoods.DeliveryOffGoodsRepository;
import de.ait.repositories.fakeImpl.CashWarrantRepositoryFakeImpl;
import de.ait.repositories.fakeImpl.DeliveryOffGoodsRepositoryFakeImpl;
import de.ait.services.CashWarrant.CashWarrantServiceImpl;
import de.ait.services.DeliveryOffGoods.DeliveryOffGoodsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CashWarrantServiceImplTest {
    private CashWarrantServiceImpl cashWarrantService;

    private CashWarrantRepository cashWarrantRepository;
    @BeforeEach
    void setUp() {
        this.cashWarrantService = new CashWarrantServiceImpl
                (new CashWarrantRepositoryFakeImpl());
    }

    @Test
    void getOrder() {
        List<CashWarrant> expectedCash = new ArrayList<>();

        CashWarrant cash1 = new CashWarrant("userId1", 100);
        CashWarrant cash2 = new CashWarrant("userId2", 120);
        CashWarrant cash3 = new CashWarrant("userId3", 130);

        expectedCash =  List.of(cash1, cash2, cash3);

        List<CashWarrant> actualCashWarrant = cashWarrantService.getOrder();
        assertEquals(expectedCash, actualCashWarrant);
    }
    @Test
    void getSumOfPrice() {
        List<CashWarrant> cashWarrants = new ArrayList<>();

        CashWarrant cash1 = new CashWarrant("userId1", 100);
        CashWarrant cash2 = new CashWarrant("userId2", 120);
        CashWarrant cash3 = new CashWarrant("userId3", 130);

        cashWarrants =  List.of(cash1, cash2, cash3);

        double expectedSumOfPrice = cashWarrants.stream()
                .map(CashWarrant::getSum)
                .reduce(0.0, (Double::sum));

        double actualSumOfPrice = cashWarrantService.getSumOfPrice();

        assertEquals(expectedSumOfPrice, actualSumOfPrice);

    }
}