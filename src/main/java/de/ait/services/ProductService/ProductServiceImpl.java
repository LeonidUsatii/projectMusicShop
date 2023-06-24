package de.ait.services.ProductService;
import de.ait.models.Book;
import de.ait.models.Film;
import de.ait.models.Music;
import de.ait.models.Product;
import de.ait.repositories.books.BooksRepository;
import de.ait.repositories.films.FilmsRepository;
import de.ait.repositories.musics.MusicsRepository;
import de.ait.repositories.products.ProductsRepository;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;

    private final BooksRepository booksRepository;

    private final MusicsRepository musicsRepository;

    private final FilmsRepository filmsRepository;

    public ProductServiceImpl(ProductsRepository productsRepository, BooksRepository booksRepository,
                              MusicsRepository musicsRepository, FilmsRepository filmsRepository) {
        this.productsRepository = productsRepository;
        this.booksRepository = booksRepository;
        this.musicsRepository = musicsRepository;
        this.filmsRepository = filmsRepository;
    }

    @Override
    public List<Product> getProducts() {

        return productsRepository.findAll();
    }

    @Override
    public void changeGoodTitle(String oldTitle, String newTitle) {
        Product product = productsRepository.findByTitle(oldTitle);
        Book book = booksRepository.findByTitle(oldTitle);
        Music music = musicsRepository.findByTitle(oldTitle);
        Film film = filmsRepository.findByTitle(oldTitle);


        if(product != null) {
            product.setTitle(newTitle);
            productsRepository.update(product);
        }

        if(book != null) {
            book.setTitle(newTitle);
            booksRepository.update(book);
        }

        if(film != null) {
            film.setTitle(newTitle);
            filmsRepository.update(film);
        }

        if(music != null) {
            music.setTitle(newTitle);
            musicsRepository.update(music);
        }

    }

    @Override
    public void deleteGoodTitle(String oldTitle) {
        Product product = productsRepository.findByTitle(oldTitle);
        Book book = booksRepository.findByTitle(oldTitle);
        Music music = musicsRepository.findByTitle(oldTitle);
        Film film = filmsRepository.findByTitle(oldTitle);

        if(product != null) {
            productsRepository.delete(product);
        }
        if(book != null) {
            booksRepository.delete(book);
        }

        if(music != null) {
            musicsRepository.delete(music);
        }

        if(film != null) {
            filmsRepository.delete(film);
        }

    }

    @Override
    public List<Product> sortByPrice() {
        List<Product> products = productsRepository.findAll();
        return products.stream().sorted().toList();
    }

    @Override
    public List<Product> filterByValue(String value) {
        return null;
    }

}
