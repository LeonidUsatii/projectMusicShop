package de.ait.services.ReviewService;


import de.ait.models.Review;
import de.ait.models.User;
import de.ait.repositories.fakeImpl.ProductsRepositoryFakeImpl;
import de.ait.repositories.fakeImpl.ReviewsRepositoryFakeImpl;
import de.ait.repositories.fakeImpl.UsersRepositoryFakeImpl;
import de.ait.repositories.products.ProductsRepository;
import de.ait.repositories.users.UsersRepository;
import de.ait.services.UserService.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReviewServiceImplTest {
    private ReviewServiceImpl reviewService;

    private ProductsRepository productsRepository;

    private UsersRepository usersRepository;

    @BeforeEach
    void setUp() {
        this.reviewService = new ReviewServiceImpl(new ReviewsRepositoryFakeImpl(),
                new ProductsRepositoryFakeImpl(), new UsersRepositoryFakeImpl());
    }

    @Test
    void getReview() {
        List<Review> expectedReviews = new ArrayList<>();

        Review review1 = new Review("docId1", "review1",
                "productId1", "userId");
        Review review2 = new Review("docId1", "review1",
                "productId1", "userId");
        Review review3 = new Review("docId1", "review1",
                "productId1", "userId");

        expectedReviews = List.of(review1, review2, review3);

        List<Review> actualReview = reviewService.getReview();
        assertEquals(expectedReviews,actualReview);
    }
}