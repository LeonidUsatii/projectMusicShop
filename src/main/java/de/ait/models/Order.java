package de.ait.models;

import java.time.LocalDateTime;



public class Order {
    private final String id;
    private final LocalDateTime dateTime;

    private final String productId;
    private final String userId;

    public Order(String id, LocalDateTime dateTime, String productId, String userId) {

        this.id = id;
        this.dateTime = dateTime;
        this.productId = productId;
        this.userId = userId;
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


}
