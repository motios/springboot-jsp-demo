package com.momah.springbootjsp.service;


import com.momah.springbootjsp.Utils.ResponseResolve;
import com.momah.springbootjsp.dto.OrderDto;

public interface IOrder {
    ResponseResolve addUpdate(OrderDto order);
    ResponseResolve delete(OrderDto order);
    ResponseResolve get(long id);
    ResponseResolve getAll();
}
