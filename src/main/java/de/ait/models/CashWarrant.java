package de.ait.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class CashWarrant {
    private String id;
    private  LocalDateTime dateTime;
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

    public CashWarrant(String userId, double sum) {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CashWarrant that = (CashWarrant) o;
        return Double.compare(that.sum, sum) == 0 && Objects.equals(id, that.id) && Objects.equals(dateTime, that.dateTime) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime, userId, sum);
    }
}
