package de.ait.repositories.orders;

import de.ait.models.Order;
import de.ait.repositories.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order> {
    @Override
    List<Order> findAll();

    @Override
    void save(Order model);

    @Override
    Order findById(String id);
}
