package com.luwojtaszek.springbootjsp.Utils;



import com.luwojtaszek.springbootjsp.dao.OrderCust;
import com.luwojtaszek.springbootjsp.dto.CustomerDto;
import com.luwojtaszek.springbootjsp.dto.OrderDto;

import java.util.ArrayList;
import java.util.List;

public class ResponseResolve {
    private int code;
    private String descroption;
    private List<CustomerDto> customers;
    private List<OrderDto> orders;

    public ResponseResolve() {
        init();
    }

    public ResponseResolve(int code, String descroption) {
        this();
        this.code = code;
        this.descroption = descroption;
    }

    private void init(){
        customers = new ArrayList<>() ;
        orders = new ArrayList<>();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescroption() {
        return descroption;
    }

    public void setDescroption(String descroption) {
        this.descroption = descroption;
    }

    public List<CustomerDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDto> customers) {
        this.customers = customers;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }
}
