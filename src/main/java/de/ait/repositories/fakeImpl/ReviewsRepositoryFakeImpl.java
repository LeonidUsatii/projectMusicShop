package de.ait.repositories.fakeImpl;

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
        return null;
    }

    @Override
    public void save(Review review) {

    }
}
