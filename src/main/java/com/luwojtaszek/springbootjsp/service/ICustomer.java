package com.luwojtaszek.springbootjsp.service;


import com.luwojtaszek.springbootjsp.Utils.ResponseResolve;
import com.luwojtaszek.springbootjsp.dao.Customer;
import com.luwojtaszek.springbootjsp.dto.CustomerDto;

public interface ICustomer {
    ResponseResolve addUpdate(CustomerDto customer);
    ResponseResolve delete(CustomerDto customer);
    ResponseResolve get(long id);
    ResponseResolve getAll();
}
