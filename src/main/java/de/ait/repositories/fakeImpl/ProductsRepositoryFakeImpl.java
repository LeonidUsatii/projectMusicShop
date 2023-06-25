package de.ait.repositories.fakeImpl;

import de.ait.models.Product;
import de.ait.repositories.products.ProductsRepository;

import java.util.List;

public class ProductsRepositoryFakeImpl implements ProductsRepository {
    @Override
    public List<Product> findAll() {

        Product product1 = new Product("Title1",20,"1998");
        Product product2 = new Product("Title2",10.0,"2020");
        Product product3 = new Product("Title3",15.0,"2020");

        return List.of(product1, product2, product3);
    }

    @Override
    public void save(Product model) {

    }

    @Override
    public Product findByTitle(String title) {
        List<Product> products = findAll();
        for (Product product : products) {
            if (product.getTitle().equals(title)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product updatedGood) {

    }

    @Override
    public void delete(Product deleteGood) {

    }
}
