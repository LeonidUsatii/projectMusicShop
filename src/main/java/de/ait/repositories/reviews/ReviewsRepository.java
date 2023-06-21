package de.ait.repositories.reviews;

import de.ait.models.Product;
import de.ait.models.Review;
import de.ait.repositories.CrudRepository;

import java.util.List;

public interface ReviewsRepository extends CrudRepository<Review> {
    @Override
    List<Review> findAll();

    @Override
    void save(Review model);

    @Override
    Review findById(String id);
}
