package de.ait.repositories.fakeImpl;

import de.ait.models.Product;
import de.ait.repositories.products.ProductsRepository;

import java.util.List;

public class ProductsRepositoryFakeImpl implements ProductsRepository {
    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void save(Product model) {

    }

    @Override
    public Product findByTitle(String title) {
        return null;
    }
}
