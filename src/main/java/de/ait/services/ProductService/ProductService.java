package de.ait.services.ProductService;

import de.ait.models.Category;
import de.ait.models.GenreOfBook;
import de.ait.models.Product;
import de.ait.services.EService;

import java.util.List;

public interface ProductService extends EService<Product> {

    List<Product> getProducts();

    void changeGoodTitle(String oldTitle, String newTitle);

    void deleteGoodTitle(String oldTitle);
}
