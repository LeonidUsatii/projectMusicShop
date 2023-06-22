package de.ait.services.ReviewService;

import de.ait.models.Product;
import de.ait.models.Review;
import de.ait.models.User;
import de.ait.repositories.products.ProductsRepository;
import de.ait.repositories.reviews.ReviewsRepository;
import de.ait.repositories.users.UsersRepository;

import java.util.List;
import java.util.UUID;

public class ReviewServiceImpl implements ReviewService {

    private final ReviewsRepository reviewsRepository;

    private final ProductsRepository productsRepository;

    private final UsersRepository usersRepository;

    public ReviewServiceImpl(ReviewsRepository reviewsRepository, ProductsRepository productsRepository, UsersRepository usersRepository) {
        this.reviewsRepository = reviewsRepository;
        this.productsRepository = productsRepository;
        this.usersRepository = usersRepository;
    }


    @Override
    public void addReview(String email, String productTitle, String review) {

        User user = usersRepository.findByEmail(email);

        Product product = productsRepository.findByTitle(productTitle);

        Review myReview = new Review(
                UUID.randomUUID().toString(), review, product.getTitle(), user.getId());

        reviewsRepository.save(myReview);
    }

    @Override
    public List<Review> getReview() {

        return reviewsRepository.findAll();
    }




}
