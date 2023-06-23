package de.ait.models;

public class DeliveryOffGoods {
    private String id;

    private String address;

    private String productId;

    private String userId;

    private String deliveryDate;

    public DeliveryOffGoods(String id, String address, String productId,
                            String userId, String deliveryDate) {

        if (id != null) {
            this.id = id;
        } else {
            System.err.println("Введите id товара");
        }

        if (address != null) {
            this.address = address;
        } else {
            System.err.println("Введите адрес доставки товара");
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

        if (deliveryDate != null) {
            this.deliveryDate = deliveryDate;
        } else {
            System.err.println("Введите дату доставки товара");
        }
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getProductId() {
        return productId;
    }

    public String getUserId() {
        return userId;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public String toString() {
        return "DeliveryOffGoods{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", productId='" + productId + '\'' +
                ", userId='" + userId + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                '}';
    }

}
