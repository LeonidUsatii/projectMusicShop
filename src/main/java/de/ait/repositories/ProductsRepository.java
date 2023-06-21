package de.ait.repositories;

import de.ait.models.Product;



public interface ProductsRepository extends CrudRepository<Product> {
    // save(Good good);
    // Good findById(String id);

    Product findByTitle(String title);
}
