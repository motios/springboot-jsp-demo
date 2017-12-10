package com.luwojtaszek.springbootjsp.service;


import com.luwojtaszek.springbootjsp.Utils.CustomerHelperValidator;
import com.luwojtaszek.springbootjsp.Utils.ResponseResolve;
import com.luwojtaszek.springbootjsp.dao.Customer;
import com.luwojtaszek.springbootjsp.dao.OrderCust;
import com.luwojtaszek.springbootjsp.dto.CustomerDto;
import com.luwojtaszek.springbootjsp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomer {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderService orderService;
    private List<Customer> customers;

    @Override
    public ResponseResolve addUpdate(Customer customer){
        ResponseResolve responseResolve;
        try {
            responseResolve= CustomerHelperValidator.customerValidation(customer);
            //check if all is ok(no description and status 200)
            if(responseResolve.getDescroption().equals("") && responseResolve.getCode()== HttpStatus.OK.value()){
                customerRepository.save(customer);
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
    public ResponseResolve delete(Customer customer) {
        try {
            customerRepository.delete(customer);
            return new ResponseResolve(HttpStatus.OK.value(),"");
        }
        catch (Exception e){
            return new ResponseResolve(HttpStatus.BAD_REQUEST.value(),e.getMessage());
        }

    }

    @Override
    public ResponseResolve get(long id) {
        customers = new ArrayList<>();
        customers.add(customerRepository.findOne(id));
        return setCustomers(customers);
    }

    @Override
    public ResponseResolve getAll() {
        customers = new ArrayList<>();
        customers= (List<Customer>) customerRepository.findAll();
        return setCustomers(customers);
    }

    public boolean dataIsEmpty(){
        return ((List<Customer>) customerRepository.findAll()).size()==0;
    }


    private ResponseResolve setCustomers(List<Customer> customers){
        ResponseResolve responseResolve =  new ResponseResolve(HttpStatus.OK.value(),"");
        responseResolve.setCustomers(customersToDto(customers));
        return responseResolve;
    }

    public ResponseResolve setOrders(OrderCust order){
        return orderService.addUpdate(order);
    }

    private List<CustomerDto> customersToDto(List<Customer> customers){
        List<CustomerDto> customerDtoList= new ArrayList<>();
        for (Customer customer: customers) {
            CustomerDto customerDto=new CustomerDto();
            customerDto.setAge(customer.getAge());
            customerDto.setEmail(customer.getEmail());
            customerDto.setNumberOfOrders(getOrdersCountByCustomerId(customer.getCustomerId()));
            customerDto.setFirstName(customer.getFirstName());
            customerDto.setLastName(customer.getLastName());
            customerDto.setCustomerId(customer.getCustomerId());
            customerDtoList.add(customerDto);
            //customerDtoList.add(new CustomerDto(customer.getEmail(),,getOrdersCountByCustomerId(customer.getCustomerId()),customer.getFirstName(),customer.getLastName(),customer.getAge(),customer.getCustomerId()));
        }
        return customerDtoList;
    }

    private String setFullname(Customer customer){
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(customer.getFirstName()).append(" ").append(customer.getLastName()).toString();
    }

    public List<OrderCust> getAllOrders() {
        return orderService.getAll().getOrders();
    }

    private int getOrdersCountByCustomerId(long id){
        return orderService.getOrdersCountByCustomerId(id);
    }
}

