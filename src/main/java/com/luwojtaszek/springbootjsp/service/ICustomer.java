package com.luwojtaszek.springbootjsp.service;


import com.luwojtaszek.springbootjsp.Utils.ResponseResolve;
import com.luwojtaszek.springbootjsp.dao.Customer;

public interface ICustomer {
    ResponseResolve addUpdate(Customer customer);
    ResponseResolve delete(Customer customer);
    ResponseResolve get(long id);
    ResponseResolve getAll();
}
