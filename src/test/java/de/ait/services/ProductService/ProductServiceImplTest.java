package de.ait.services.ProductService;

import de.ait.models.Book;
import de.ait.models.GenreOfBook;
import de.ait.models.Product;
import de.ait.models.User;
import de.ait.repositories.fakeImpl.BookRepositoryFakeImpl;
import de.ait.repositories.fakeImpl.FilmsRepositoryFakeImpl;
import de.ait.repositories.fakeImpl.MusicsRepositoryFakeImpl;
import de.ait.repositories.fakeImpl.ProductsRepositoryFakeImpl;
import de.ait.repositories.films.FilmsRepositoryTextFileImpl;
import de.ait.services.BookService.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductServiceImplTest {
    private ProductServiceImpl productService;
    @BeforeEach
    void setUp() {
        this.productService = new ProductServiceImpl(new ProductsRepositoryFakeImpl(),
                new BookRepositoryFakeImpl(), new MusicsRepositoryFakeImpl(),
                new FilmsRepositoryFakeImpl());
    }
    @Test
    void getProducts() {
        List<Product> expectedProducts = new ArrayList<>();

        Product product1 = new Product("Title1",20,"1998");
        Product product2 = new Product("Title2",10.0,"2020");
        Product product3 = new Product("Title3",15.0,"2020");

        expectedProducts.add(product1);
        expectedProducts.add(product2);
        expectedProducts.add(product3);

        List<Product> actualProducts = productService.getProducts();

        assertEquals(expectedProducts, actualProducts);
    }

    @Test
    void sortByPrice() {
        List<Product> products = new ArrayList<>();

        Product product1 = new Product("Title1",20,"1998");
        Product product2 = new Product("Title2",10.0,"2020");
        Product product3 = new Product("Title3",15.0,"2020");

        products.add(product1);
        products.add(product2);
        products.add(product3);

        List<Product> expectedProducts = products.stream().sorted().toList();
        List<Product> actualProducts = productService.sortByPrice();
        assertEquals(expectedProducts, actualProducts);

    }

    @Test
    void findByTitle() {
        List<Product> products = new ArrayList<>();

        Product product1 = new Product("Title1",20,"1998");
        Product product2 = new Product("Title2",10.0,"2020");
        Product product3 = new Product("Title3",15.0,"2020");

        products.add(product1);
        products.add(product2);
        products.add(product3);

        String title = "Title1";

        Product actualProduct = productService.findByTitle(title);
        Product expectedProduct = null;

        for (Product product : products) {
            if (product.getTitle().equals(title)){
                expectedProduct = product;
            }
        }
        assertEquals(expectedProduct, actualProduct);
    }

}