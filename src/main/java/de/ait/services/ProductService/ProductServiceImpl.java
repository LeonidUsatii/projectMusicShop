package de.ait.services.ProductService;
import de.ait.models.Book;
import de.ait.models.Film;
import de.ait.models.Product;
import de.ait.repositories.products.ProductsRepository;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;

    public ProductServiceImpl(ProductsRepository productsRepository) {

        this.productsRepository = productsRepository;
    }

    @Override
    public List<Product> getProducts() {

        return productsRepository.findAll();
    }

    @Override
    public List<Product> sortByPrice() {
        List<Product> products = productsRepository.findAll();
        return products.stream().sorted().toList();
    }

}
