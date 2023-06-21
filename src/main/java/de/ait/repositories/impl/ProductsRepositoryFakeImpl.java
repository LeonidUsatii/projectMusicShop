package de.ait.repositories.impl;


import de.ait.models.Product;
import de.ait.repositories.ProductsRepository;

public class ProductsRepositoryFakeImpl implements ProductsRepository {
    @Override
    public void save(Product model) {

    }

    @Override
    public Product findById(String id) {
        return null;
    }


    @Override
    public Product findByTitle(String title) {
        if (title.equals("Бургер")) {
            return new Product(
                    "04c2490d-6af7-4ef5-a272-5a1ca861121b",
                    "Бургер", 100.0
            );
        }
        return null;
    }
}
