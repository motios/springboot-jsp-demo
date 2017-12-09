package com.luwojtaszek.springbootjsp.service;


import com.luwojtaszek.springbootjsp.Utils.ResponseResolve;
import com.luwojtaszek.springbootjsp.dao.OrderCust;

public interface IOrder {
    ResponseResolve addUpdate(OrderCust order);
    ResponseResolve delete(OrderCust order);
    ResponseResolve get(long id);
    ResponseResolve getAll();
}
