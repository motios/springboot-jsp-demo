package com.luwojtaszek.springbootjsp.dto;

public class CustomerDto {
    private String email;

    private String fullName;
    private int numberOfOrders;
    private String firstName;
    private String lastName;
    private int age;
    private long customerId;

    public CustomerDto() {
    }


    public CustomerDto(String email, String firstName, String lastName, int age) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public CustomerDto(String email, String fullName, int numberOfOrders, String firstName, String lastName, int age, long id) {
        this.email = email;
        this.fullName = fullName;
        this.numberOfOrders = numberOfOrders;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.customerId = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        setFullNameLocal(firstName, lastName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        setFullNameLocal(firstName, lastName);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    //set full name from 2 names
    private void setFullNameLocal(String first, String last){
        StringBuilder stringBuilder = new StringBuilder();
        this.fullName = stringBuilder.append(first).append(" ").append(last).toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomerDto{");
        sb.append("email='").append(email).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", numberOfOrders=").append(numberOfOrders);
        sb.append(", customerId=").append(customerId);
        sb.append('}');
        return sb.toString();
    }
}
