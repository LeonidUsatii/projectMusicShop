package de.ait.repositories.fakeImpl;

import de.ait.models.CashWarrant;
import de.ait.models.User;
import de.ait.repositories.CashWarrant.CashWarrantRepository;

import java.util.List;

public class CashWarrantRepositoryFakeImpl implements CashWarrantRepository {
    @Override
    public List<CashWarrant> findAll() {

        CashWarrant cash1 = new CashWarrant("userId1", 100);
        CashWarrant cash2 = new CashWarrant("userId2", 120);
        CashWarrant cash3 = new CashWarrant("userId3", 130);

        return List.of(cash1, cash2, cash3);
    }
    @Override
    public void save(CashWarrant model) {

    }
    @Override
    public CashWarrant findByTitle(String title) {
        return null;
    }
}
