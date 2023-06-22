package de.ait.repositories.reviews;

import de.ait.models.Product;
import de.ait.models.Review;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReviewsRepositoryTextFileImpl implements ReviewsRepository {

    private final String fileName;

    public ReviewsRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Review> findAll() {
        return null;
    }

    @Override
    public void save(Review review) {
        try (BufferedWriter bufferedWriter = new BufferedWriter
                (new FileWriter(fileName, true));) {

            String reviewObject = "";

            reviewObject = review.getId() + "|" + review.getReview()
                    + "|" + review.getProductId()
                    + "|" + review.getUserId();

            bufferedWriter.write(reviewObject);
            bufferedWriter.newLine();

        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }
    }

    @Override
    public Review findByTitle(String title) {
        return null;
    }

}
