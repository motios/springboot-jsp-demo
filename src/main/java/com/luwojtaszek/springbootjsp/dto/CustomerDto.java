package com.luwojtaszek.springbootjsp.dto;

public class CustomerDto {
    public String email;
    public String fullName;
    public int numberOfOrders;
    public long id;

    public CustomerDto() {
    }

    public CustomerDto(String email, String fullName, int numberOfOrders, long id) {
        this.email = email;
        this.fullName = fullName;
        this.numberOfOrders = numberOfOrders;
        this.id =id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(int numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomerDto{");
        sb.append("email='").append(email).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", numberOfOrders=").append(numberOfOrders);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
