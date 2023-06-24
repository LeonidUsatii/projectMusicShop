package de.ait.repositories.products;

import de.ait.models.Order;
import de.ait.models.Product;
import de.ait.repositories.CrudRepository;

import java.util.List;

public interface ProductsRepository extends CrudRepository<Product> {
    @Override
    List<Product> findAll();

    @Override
    void save(Product model);

    @Override
    Product findByTitle(String title);

    void update(Product updatedGood);

    void delete(Product deleteGood);
}
