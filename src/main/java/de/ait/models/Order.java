package de.ait.models;

import java.time.LocalDateTime;
import java.util.UUID;


public class Order { // заказ
    private String id;
    private LocalDateTime dateTime;
    private String goodId;
    private String userId;

    public Order(LocalDateTime dateTime, String goodId, String userId) {
        this.id = UUID.randomUUID().toString();
        this.dateTime = dateTime;
        this.goodId = goodId;
        this.userId = userId;
    }

    public String getId() {

        return id;
    }

    public LocalDateTime getDateTime() {

        return dateTime;
    }

    public String getGoodId() {

        return goodId;
    }

    public String getUserId() {

        return userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", dateTime=" + dateTime +
                ", goodId='" + goodId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
