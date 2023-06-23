package de.ait.repositories.reviews;

import de.ait.models.DeliveryOffGoods;
import de.ait.models.Product;
import de.ait.models.Review;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewsRepositoryTextFileImpl implements ReviewsRepository {

    private final String fileName;

    public ReviewsRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Review> findAll() {

        List<Review> reviews = new ArrayList<>();

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = bufferedReader.readLine();

            while (line != null) {
                String[] parsed = line.split("\\|");
                String id  = parsed[0];
                String review = parsed[1];
                String productId  = parsed[2];
                String userId  = parsed[3];

                reviews.add(new Review(id, review, productId, userId));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }
        return reviews;
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
