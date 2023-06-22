package de.ait.services.ReviewService;

import de.ait.models.Review;
import de.ait.models.User;

import java.util.List;

public interface ReviewService {
    void addReview(String email, String productTitle, String review);

    List<Review> getReview();

}
