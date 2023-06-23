package de.ait.models;

import java.time.LocalDateTime;

public class CashWarrant {
    private String id;
    private final LocalDateTime dateTime;

    private String userId;

    private double sum;

    public CashWarrant(String id, LocalDateTime dateTime, String userId, double sum) {

        if (id != null) {
            this.id = id;
        } else {
            System.err.println("Введите id");
        }

        this.dateTime = dateTime;

        if (userId != null) {
            this.userId = userId;
        } else {
            System.err.println("Введите userId товара");
        }

        if (sum > 0) {
            this.sum = sum;
        } else {
            System.err.println("Введите корректную стоимость");
        }

    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getUserId() {
        return userId;
    }

    public double getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "CashWarrant{" +
                "id='" + id + '\'' +
                ", dateTime=" + dateTime +
                ", userId='" + userId + '\'' +
                ", sum=" + sum +
                '}';
    }
}
