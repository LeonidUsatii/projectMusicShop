package de.ait.repositories.fakeImpl;

import de.ait.models.CashWarrant;
import de.ait.models.Review;
import de.ait.repositories.reviews.ReviewsRepository;

import java.util.List;

public class ReviewsRepositoryFakeImpl implements ReviewsRepository {
    @Override
    public Review findByTitle(String title) {
        return null;
    }

    @Override
    public List<Review> findAll() {

        Review review1 = new Review("docId1", "review1",
                "productId1", "userId");
        Review review2 = new Review("docId1", "review1",
                "productId1", "userId");
        Review review3 = new Review("docId1", "review1",
                "productId1", "userId");


        return List.of(review1, review2, review3);
    }

    @Override
    public void save(Review review) {

    }
}
