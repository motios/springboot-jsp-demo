package com.momah.springbootjsp.service;


import com.momah.springbootjsp.Utils.ResponseResolve;
import com.momah.springbootjsp.dto.CustomerDto;

public interface ICustomer {
    ResponseResolve addUpdate(CustomerDto customer);
    ResponseResolve delete(CustomerDto customer);
    ResponseResolve get(long id);
    ResponseResolve getAll();
}
