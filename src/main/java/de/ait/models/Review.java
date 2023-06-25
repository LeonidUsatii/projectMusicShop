package de.ait.models;

import java.util.Objects;

public class Review {

    private String id;
    private String review;

    private String productId;

    private String userId;

    public Review(String id, String review, String productId, String userId) {
        if (id != null) {
            this.id = id;
        } else {
            System.err.println("Введите id товара");
        }
        if (review != null) {
            this.review = review;
        } else {
            System.err.println("Введите отзыв");
        }

        if (productId != null) {
            this.productId = productId;
        } else {
            System.err.println("Введите productId");
        }

        if (userId != null) {
            this.userId = userId;
        } else {
            System.err.println("Введите userId");
        }

    }

    public String getId() {
        return id;
    }

    public String getReview() {
        return review;
    }

    public String getProductId() {
        return productId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", review='" + review + '\'' +
                ", productId='" + productId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review1 = (Review) o;
        return Objects.equals(id, review1.id) && Objects.equals(review, review1.review) && Objects.equals(productId, review1.productId) && Objects.equals(userId, review1.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, review, productId, userId);
    }
}
