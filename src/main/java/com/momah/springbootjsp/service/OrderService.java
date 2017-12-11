package com.momah.springbootjsp.service;


import com.momah.springbootjsp.Utils.OrderHelperValidator;
import com.momah.springbootjsp.Utils.ResponseResolve;
import com.momah.springbootjsp.dao.OrderCust;
import com.momah.springbootjsp.dto.OrderDto;
import com.momah.springbootjsp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService extends AbstractService implements IOrder {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public ResponseResolve addUpdate(OrderDto orderDto) {
        OrderCust order = orderDto2Dao(orderDto);
        ResponseResolve responseResolve;
        try {
            responseResolve= OrderHelperValidator.orderValidation(order);
            //check if all is ok(no description and status 200)
            if(responseResolve.getDescroption().equals("") && responseResolve.getCode()== HttpStatus.OK.value()){
                orderRepository.save(order);
            }
            return responseResolve;
        }
        catch (Exception e){
            responseResolve = new ResponseResolve();
            responseResolve.setDescroption("add/update order failed: "+ e.getMessage());
            responseResolve.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return responseResolve;
        }
    }

    @Override
    public ResponseResolve delete(OrderDto orderDto) {
        ResponseResolve responseResolve= null;
        try{
            OrderCust order = orderDto2Dao(orderDto);
            responseResolve =OKResponseResolve();
        }
        catch (Exception e){
            responseResolve.setCode(HttpStatus.NOT_FOUND.value());
            responseResolve.setDescroption("delete failed: "+e.getMessage());
        }
        return responseResolve;
    }

    @Override
    public ResponseResolve get(long id) {
        ResponseResolve responseResolve = OKResponseResolve();
        List<OrderCust> orderCusts = new ArrayList<>();
        orderCusts.add(orderRepository.findOne(id));
                responseResolve.setOrders(orderCust2OrderDto(orderCusts));
        return responseResolve;
    }

    @Override
    public ResponseResolve getAll() {
        ResponseResolve responseResolve = OKResponseResolve();
        responseResolve.setOrders(orderCust2OrderDto((List<OrderCust>)orderRepository.findAll()));
        return responseResolve;
    }

    //count of orders by customer ID
    public int getOrdersCountByCustomerId(long id){
        return orderRepository.ordersCountByCustomerId(id);
    }

    //orders by customer ID
    public ResponseResolve getOrdersByCustomerId(long id){
        ResponseResolve responseResolve = OKResponseResolve();
                responseResolve.setOrders(orderCust2OrderDto(orderRepository.getOrderByCustomerId(id)));
        return responseResolve;
    }

    //convert list of Dao orders to list of Dto orders
    private List<OrderDto> orderCust2OrderDto(List<OrderCust> orders){
        List<OrderDto> ordersDto = new ArrayList<>();
        for (OrderCust orderCust:orders) {
            OrderDto orderDto = new OrderDto();
            orderDto.setCustomerId(orderCust.getCustomerId());
            orderDto.setOrderDate(orderCust.getDate().toString());
            orderDto.setOrderId(orderCust.getOrderId());
            orderDto.setPruductPrice(orderCust.getPrice());
            orderDto.setProductDescription(orderCust.getProductDescroption());
            orderDto.setPruductQuantity(orderCust.getQuantity());
            ordersDto.add(orderDto);
        }
        return ordersDto;
    }

    //convert Dto to Dao
    private OrderCust orderDto2Dao(OrderDto orderDto){
        OrderCust orderCust = new OrderCust();
        orderCust.setCustomerId(orderDto.getCustomerId());
        orderCust.setDate(orderDto.getOrderDate());
        orderCust.setPrice(orderDto.getPruductPrice());
        orderCust.setProductDescroption(orderDto.getProductDescription());
        orderCust.setQuantity(orderDto.getPruductQuantity());
        orderCust.setOrderId(orderDto.getOrderId());
        return orderCust;
    }


}
