package de.ait.models;

import java.time.LocalDateTime;

public class Order {
    private  String id;

    private final LocalDateTime dateTime;

    private  String productId;

    private  String userId;

    public Order(String id, LocalDateTime dateTime, String productId, String userId) {

        if (id != null) {
            this.id = id;
        } else {
            System.err.println("Введите id");
        }
        this.dateTime = dateTime;

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

    public LocalDateTime getDateTime() {

        return dateTime;
    }

    public String getProductId() {
        return productId;
    }

    public String getUserId() {

        return userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", dateTime=" + dateTime +
                ", productId='" + productId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
