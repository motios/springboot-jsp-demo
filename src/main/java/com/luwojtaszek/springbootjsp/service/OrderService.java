package com.luwojtaszek.springbootjsp.service;


import com.luwojtaszek.springbootjsp.Utils.OrderHelperValidator;
import com.luwojtaszek.springbootjsp.Utils.ResponseResolve;
import com.luwojtaszek.springbootjsp.dao.OrderCust;
import com.luwojtaszek.springbootjsp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrder {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public ResponseResolve addUpdate(OrderCust order) {
        ResponseResolve responseResolve;
        try {
            responseResolve= OrderHelperValidator.customerValidation(order);
            //check if all is ok(no description and status 200)
            if(responseResolve.getDescroption().equals("") && responseResolve.getCode()== HttpStatus.OK.value()){
                orderRepository.save(order);
            }
            return responseResolve;
        }
        catch (Exception e){
            responseResolve = new ResponseResolve();
            responseResolve.setDescroption(HttpStatus.INTERNAL_SERVER_ERROR + ". " + e.getMessage());
            responseResolve.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return responseResolve;
        }
    }

    @Override
    public ResponseResolve delete(OrderCust order) {
        return null;
    }

    @Override
    public ResponseResolve get(long id) {
        return null;
    }

    @Override
    public ResponseResolve getAll() {
        ResponseResolve responseResolve = new ResponseResolve();
        responseResolve.setOrders((List<OrderCust>)orderRepository.findAll());
        responseResolve.setCode(HttpStatus.OK.value());
        responseResolve.setDescroption("");
        return responseResolve;
    }

    public int getOrdersCountByCustomerId(long id){
        return orderRepository.findOrderByCustomerId(id);
    }
}
