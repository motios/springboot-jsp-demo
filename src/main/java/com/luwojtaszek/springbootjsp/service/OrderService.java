package com.luwojtaszek.springbootjsp.service;


import com.luwojtaszek.springbootjsp.Utils.OrderHelperValidator;
import com.luwojtaszek.springbootjsp.Utils.ResponseResolve;
import com.luwojtaszek.springbootjsp.dao.OrderCust;
import com.luwojtaszek.springbootjsp.dto.OrderDto;
import com.luwojtaszek.springbootjsp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrder {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public ResponseResolve addUpdate(OrderDto orderDto) {
        OrderCust order = orderDto2Dao(orderDto);
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
    public ResponseResolve delete(OrderDto orderDto) {
        OrderCust order = orderDto2Dao(orderDto);
        return null;
    }

    @Override
    public ResponseResolve get(long id) {
        ResponseResolve responseResolve = new ResponseResolve();
        List<OrderCust> orderCusts = new ArrayList<>();
        orderCusts.add(orderRepository.findOne(id));
        responseResolve.setCode(HttpStatus.OK.value());
        responseResolve.setDescroption("");
        responseResolve.setOrders(orderCust2OrderDto(orderCusts));
        return responseResolve;
    }

    @Override
    public ResponseResolve getAll() {
        ResponseResolve responseResolve = new ResponseResolve();
        responseResolve.setOrders(orderCust2OrderDto((List<OrderCust>)orderRepository.findAll()));
        responseResolve.setCode(HttpStatus.OK.value());
        responseResolve.setDescroption("");
        return responseResolve;
    }

    public int getOrdersCountByCustomerId(long id){
        return orderRepository.ordersCountByCustomerId(id);
    }

    public List<OrderDto> getOrdersByCustomerId(long id){
        return orderCust2OrderDto(orderRepository.getOrderByCustomerId(id));
    }

    private List<OrderDto> orderCust2OrderDto(List<OrderCust> orders){
        List<OrderDto> ordersDto = new ArrayList<>();
        for (OrderCust orderCust:orders) {
            OrderDto orderDto = new OrderDto();
            orderDto.setCustomerId(orderCust.getCustomerId());
            orderDto.setDate(orderCust.getDate());
            orderDto.setOrderId(orderCust.getOrderId());
            orderDto.setPrice(orderCust.getPrice());
            orderDto.setProductDescription(orderCust.getProductDescroption());
            orderDto.setQuantity(orderCust.getQuantity());
            ordersDto.add(orderDto);
        }
        return ordersDto;
    }

    private OrderCust orderDto2Dao(OrderDto orderDto){
        OrderCust orderCust = new OrderCust();
        orderCust.setCustomerId(orderDto.getCustomerId());
        orderCust.setDate(orderDto.getDate());
        orderCust.setPrice(orderDto.getPrice());
        orderCust.setProductDescroption(orderDto.getProductDescription());
        orderCust.setQuantity(orderDto.getQuantity());
        orderCust.setOrderId(orderDto.getOrderId());
        return orderCust;
    }

}
