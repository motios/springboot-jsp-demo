package com.luwojtaszek.springbootjsp.service;


import com.luwojtaszek.springbootjsp.Utils.ResponseResolve;
import com.luwojtaszek.springbootjsp.dao.OrderCust;
import com.luwojtaszek.springbootjsp.dto.OrderDto;

public interface IOrder {
    ResponseResolve addUpdate(OrderDto order);
    ResponseResolve delete(OrderDto order);
    ResponseResolve get(long id);
    ResponseResolve getAll();
}
