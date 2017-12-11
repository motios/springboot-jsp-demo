package com.luwojtaszek.springbootjsp.dto;

import java.time.LocalDateTime;

public class OrderDto {

    private long orderId;
    private LocalDateTime date;
    private long customerId;
    private String productDescription;
    private double price;
    private int quantity;
    private double totalPrice;

    public OrderDto() {
    }

    public OrderDto(LocalDateTime date, String productDescription, double price, int quantity, long customerId) {
        this.setDate(date);
        this.setProductDescription(productDescription);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.setCustomerId(customerId);
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        setTotalPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        setTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private void setTotalPrice() {
        this.totalPrice = quantity*price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderDto{");
        sb.append("orderId=").append(orderId);
        sb.append(", date=").append(date);
        sb.append(", customerId=").append(customerId);
        sb.append(", productDescription='").append(productDescription).append('\'');
        sb.append(", price=").append(price);
        sb.append(", quantity=").append(quantity);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append('}');
        return sb.toString();
    }
}
