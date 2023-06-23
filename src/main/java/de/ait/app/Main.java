package de.ait.app;

import de.ait.models.*;

import de.ait.repositories.CashWarrant.CashWarrantRepository;
import de.ait.repositories.CashWarrant.CashWarrantRepositoryTextFileImpl;
import de.ait.repositories.DeliveryOffGoods.DeliveryOffGoodsRepository;
import de.ait.repositories.DeliveryOffGoods.DeliveryOffGoodsRepositoryTextFileImpl;
import de.ait.repositories.books.BooksRepository;
import de.ait.repositories.books.BooksRepositoryTextFileImpl;
import de.ait.repositories.films.FilmsRepository;
import de.ait.repositories.films.FilmsRepositoryTextFileImpl;
import de.ait.repositories.musics.MusicsRepository;
import de.ait.repositories.musics.MusicsRepositoryTextFileImpl;
import de.ait.repositories.orders.OrderRepository;
import de.ait.repositories.orders.OrderRepositoryTextFileImpl;
import de.ait.repositories.products.ProductsRepository;
import de.ait.repositories.products.ProductsRepositoryTextFileImpl;
import de.ait.repositories.reviews.ReviewsRepository;
import de.ait.repositories.reviews.ReviewsRepositoryTextFileImpl;
import de.ait.repositories.users.UsersRepository;
import de.ait.repositories.users.UsersRepositoryTextFileImpl;
import de.ait.services.BookService.BookService;
import de.ait.services.BookService.BookServiceImpl;
import de.ait.services.FilmService.FilmService;
import de.ait.services.FilmService.FilmServiceImpl;
import de.ait.services.MusicService.MusicService;
import de.ait.services.MusicService.MusicServiceImpl;
import de.ait.services.OrdersService.OrdersService;
import de.ait.services.OrdersService.OrdersServiceImpl;
import de.ait.services.ProductService.ProductService;
import de.ait.services.ProductService.ProductServiceImpl;
import de.ait.services.ReviewService.ReviewService;
import de.ait.services.ReviewService.ReviewServiceImpl;
import de.ait.services.UserService.UserService;
import de.ait.services.UserService.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UsersRepository usersRepository = new UsersRepositoryTextFileImpl("files/users.txt");
        UserService userService = new UserServiceImpl(usersRepository);

        ProductsRepository productsRepository = new ProductsRepositoryTextFileImpl("files/products.txt");
        ProductService productService = new ProductServiceImpl(productsRepository);

        BooksRepository booksRepository = new BooksRepositoryTextFileImpl("files/books.txt");
        BookService bookService = new BookServiceImpl(booksRepository, productsRepository);

        MusicsRepository musicsRepository = new MusicsRepositoryTextFileImpl("files/musics.txt");
        MusicService musicService = new MusicServiceImpl(musicsRepository, productsRepository);

        DeliveryOffGoodsRepository deliveryOffGoodsRepository = new
                DeliveryOffGoodsRepositoryTextFileImpl("files/delivery.txt");

        CashWarrantRepository cashWarrantRepository = new
                CashWarrantRepositoryTextFileImpl("files/cash.txt");

        ReviewsRepository reviewsRepository = new
                ReviewsRepositoryTextFileImpl("files/reviews.txt");
        ReviewService reviewService = new ReviewServiceImpl(reviewsRepository,
                productsRepository, usersRepository);

        FilmsRepository filmsRepository = new FilmsRepositoryTextFileImpl("files/films.txt");
        FilmService filmService = new FilmServiceImpl(filmsRepository, productsRepository);

        OrderRepository orderRepository = new OrderRepositoryTextFileImpl("files/orders.txt");
        OrdersService ordersService = new OrdersServiceImpl(usersRepository, productsRepository,
                orderRepository, deliveryOffGoodsRepository, cashWarrantRepository);

        while (true) {
            System.out.println();
            System.out.println("Приветствуем в нашем магазине, для совершения покупок, " +
                    "нужно авторизоваться.");

            System.out.println();

            System.out.println("1. Создать личный кабинет.");
            System.out.println("2. Просмотреть продукцию.");
            System.out.println("3. Совершить покупку.");
            System.out.println("4. Добавить отзыв.");
            System.out.println("5. Добавить новый товар в БД.");
            System.out.println("6. Отчёты.");
            System.out.println("0. Выход.");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    System.out.println("Авторизоваться:");

                    addUser(userService, scanner);
                    break;
                case 2:
                    System.out.println("Просмотреть товары:");

                    viewProducts(productService, bookService,
                            musicService, filmService, scanner);
                    break;
                case 3:
                    System.out.println("Купить товар");

                    buyProduct(ordersService, scanner);
                    break;
                case 4:
                    System.out.println("Добавить отзыв о товаре");

                    addReview(reviewService, scanner);
                    break;
                case 5:
                    System.out.println("Добавляем новые товары в магазин");

                    addProducts(bookService,
                            musicService, filmService, scanner);
                    break;
                case 6:
                    System.out.println("Отчёты");
                    break;
                case 0:
                    System.out.println("Выход");
                    System.exit(0);
                default:
                    System.out.println("Команда не распознана");
            }
        }
    }

    public static void addUser(UserService userService, Scanner scanner) {

        System.out.println("Введите имя: ");
        String firstName = scanner.nextLine();

        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();

        System.out.println("Введите email: ");
        String email = scanner.nextLine();

        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();

        userService.addUser(firstName, lastName, email, password);
    }

    public static void viewProducts(ProductService productService,
                                    BookService bookService,
                                    MusicService musicService,
                                    FilmService filmService,
                                    Scanner scanner) {
        System.out.println("1. Просмотреть всю продукцию");
        System.out.println("11. Сортировка продуктов по стоимости");

        System.out.println("2. Просмотреть книги");
        System.out.println("21. Сортировка книг по стоимости");
        System.out.println("22. Фильтр книг по автору");

        System.out.println("3. Просмотреть музыкальную продукцию");
        System.out.println("31. Сортировка музыки по стоимости");
        System.out.println("32. Фильтр музыки по исполнителю");

        System.out.println("4. Просмотреть фильмы");
        System.out.println("41. Сортировка фильмов по стоимости");
        System.out.println("42. Фильтр фильмов по жанру");

        int command = scanner.nextInt();
        scanner.nextLine();

        switch (command) {
            case 1:
                List<Product> products = productService.getProducts();
                System.out.println(products);
                break;
            case 11:
                List<Product> sortByPriceProduct = productService.sortByPrice();
                System.out.println(sortByPriceProduct);

                break;

            case 2:
                List<Book> books = bookService.getProducts();
                System.out.println(books);
                break;
            case 21:
                List<Book> sortByPriceBooks = bookService.sortByPrice();
                System.out.println(sortByPriceBooks);
                break;
            case 3:
                List<Music> music = musicService.getProducts();
                System.out.println(music);
                break;
            case 31:
                List<Music> sortByPriceMusic = musicService.sortByPrice();
                System.out.println(sortByPriceMusic);
              break;
            case 4:
                List<Film> films = filmService.getProducts();
                System.out.println(films);
                break;
        }
        System.out.println();
    }

    public static void addProducts(BookService bookService, MusicService musicService,
                                   FilmService filmService, Scanner scanner) {

        System.out.println("Выберите категорию товара: ");
        System.out.println("1. Книга");
        System.out.println("2. Музыка");
        System.out.println("3. Фильм");

        int command = scanner.nextInt();
        scanner.nextLine();

        Category category = null;

        switch (command) {
            case 1:
                category = Category.BOOK;
                break;
            case 2:
                category = Category.MUSIC;
                break;
            case 3:
                category = Category.FILM;
                break;
        }

        System.out.println("Введите название: ");
        String title = scanner.nextLine();

        System.out.println("Введите стоимость: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Введите дату выпуска: ");
        String releaseYear = scanner.nextLine();

        if (category == Category.BOOK) {
            System.out.println("Введите автора: ");
            String author = scanner.nextLine();

            System.out.println("Введите жанр книги: ");

            System.out.println("1. Детектив");
            System.out.println("2. Новелла");
            System.out.println("3. Поэзия");
            System.out.println("4. Фантастика");
            System.out.println("5. Обучение");
            System.out.println("6. Детская литература");

            command = scanner.nextInt();
            scanner.nextLine();
            GenreOfBook genreOfBook = null;

            switch (command) {
                case 1:
                    genreOfBook = GenreOfBook.DETECTIVE;
                    break;
                case 2:
                    genreOfBook = GenreOfBook.NOVEL;
                    break;
                case 3:
                    genreOfBook = GenreOfBook.POETRY;
                    break;
                case 4:
                    genreOfBook = GenreOfBook.FANTASY;
                    break;
                case 5:
                    genreOfBook = GenreOfBook.EDUCATION;
                    break;
                case 6:
                    genreOfBook = GenreOfBook.KIDS;
                    break;
            }
            bookService.addBook(category, title, price, releaseYear, author,
                    genreOfBook);

        } else if (category == Category.MUSIC) {
            System.out.println("Введите жанр музыки: ");

            System.out.println("1. Рок");
            System.out.println("2. Поп");
            System.out.println("3. Классика");
            System.out.println("4. Этническая");

            command = scanner.nextInt();
            scanner.nextLine();
            GenreOfMusic genreOfMusic = null;

            switch (command) {
                case 1:
                    genreOfMusic = GenreOfMusic.ROCK;
                    break;
                case 2:
                    genreOfMusic = GenreOfMusic.POP;
                    break;
                case 3:
                    genreOfMusic = GenreOfMusic.CLASSIC;
                    break;
                case 4:
                    genreOfMusic = GenreOfMusic.ETHNIC;
                    break;
            }
            System.out.println("Введите исполнителя: ");
            String executor = scanner.nextLine();

            musicService.addMusic(category, title, price, releaseYear,
                    genreOfMusic, executor);

        } else if (category == Category.FILM) {
            System.out.println("Введите жанр фильма: ");

            System.out.println("1. Комедия");
            System.out.println("2. Фантастика");
            System.out.println("3. Боевик");
            System.out.println("4. Триллер");

            command = scanner.nextInt();
            scanner.nextLine();
            GenreOfFilm genreOfFilm = null;

            switch (command) {
                case 1:
                    genreOfFilm = GenreOfFilm.COMEDY;
                    break;
                case 2:
                    genreOfFilm = GenreOfFilm.FANTASTIC;
                    break;
                case 3:
                    genreOfFilm = GenreOfFilm.ACTION;
                    break;
                case 4:
                    genreOfFilm = GenreOfFilm.THRILLER;
                    break;
            }
            filmService.addFilm(category, title, price, releaseYear, genreOfFilm);
        }
    }

    public static void buyProduct(OrdersService ordersService, Scanner scanner) {

        System.out.println("Для входа  в аккаунт, введите email:");

        String email = scanner.nextLine();

        System.out.println("Введите название товара:");

        String title = scanner.nextLine();

        System.out.println("1. С доставкой.");
        System.out.println("2. Без доставки.");

        int command = scanner.nextInt();
        scanner.nextLine();
        String order = null;

        switch (command) {
            case 1:
                System.out.println("Введите адрес доставки");
                String address = scanner.nextLine();
                order = ordersService.makeOrder(email, title, address);
                System.out.println(order);
                break;
            case 2:
                order = ordersService.makeOrder(email, title);
                System.out.println(order);
                break;
        }
    }

    public static void addReview(ReviewService reviewService, Scanner scanner) {
        System.out.println("Для входа  в аккаунт, введите email:");

        String email = scanner.nextLine();
        System.out.println("Введите название товара:");

        String title = scanner.nextLine();
        System.out.println("Напишите отзыв о товаре");

        String review = scanner.nextLine();
        reviewService.addReview(email, title, review);
    }
}
