package com.momah.springbootjsp.dto;

import java.time.LocalDateTime;

public class OrderDto {

    private long orderId;
    private String orderDate;
    private long customerId;
    private String productDescription;
    private double pruductPrice;
    private int pruductQuantity;
    private double totalPrice;



    public OrderDto() {
    }

    public OrderDto(String orderDate, String productDescription, double pruductPrice, int pruductQuantity, long customerId) {
        this.setOrderDate(orderDate);
        this.setProductDescription(productDescription);
        this.setPruductPrice(pruductPrice);
        this.setPruductQuantity(pruductQuantity);
        this.setCustomerId(customerId);
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
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

    public double getPruductPrice() {
        return pruductPrice;
    }

    public void setPruductPrice(double pruductPrice) {
        this.pruductPrice = pruductPrice;
        setTotalPrice();
    }

    public int getPruductQuantity() {
        return pruductQuantity;
    }

    public void setPruductQuantity(int pruductQuantity) {
        this.pruductQuantity = pruductQuantity;
        setTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private void setTotalPrice() {
        this.totalPrice = pruductQuantity * pruductPrice;
    }

    /*public void setOrderDate(String date){
        this.orderDate = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
    }*/

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderDto{");
        sb.append("orderId=").append(orderId);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", customerId=").append(customerId);
        sb.append(", productDescription='").append(productDescription).append('\'');
        sb.append(", pruductPrice=").append(pruductPrice);
        sb.append(", pruductQuantity=").append(pruductQuantity);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append('}');
        return sb.toString();
    }
}
