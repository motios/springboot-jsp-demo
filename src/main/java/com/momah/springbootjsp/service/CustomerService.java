package com.momah.springbootjsp.service;


import com.momah.springbootjsp.Utils.CustomerHelperValidator;
import com.momah.springbootjsp.Utils.ResponseResolve;
import com.momah.springbootjsp.dao.Customer;
import com.momah.springbootjsp.dto.CustomerDto;
import com.momah.springbootjsp.dto.OrderDto;
import com.momah.springbootjsp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService extends AbstractService implements ICustomer {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderService orderService;
    private List<Customer> customers;

    @Override
    public ResponseResolve addUpdate(CustomerDto customerDto){
        ResponseResolve responseResolve;
        Customer customer = customerDtoToDao(customerDto);
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
            responseResolve.setDescroption("edd/update customer failed: " + e.getMessage());
            responseResolve.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return responseResolve;
        }

    }

    @Override
    public ResponseResolve delete(CustomerDto customerDto) {
        try {
            Customer customer = customerDtoToDao(customerDto);
            customerRepository.delete(customer);
            return OKResponseResolve();
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
        //convert customers dao to dto
        return setCustomers(customers);
    }

    //check if database is empty. for start use
    public boolean dataIsEmpty(){
        return ((List<Customer>) customerRepository.findAll()).size()==0;
    }


    //create Response result with customers list
    private ResponseResolve setCustomers(List<Customer> customers){
        ResponseResolve responseResolve =  OKResponseResolve();
        responseResolve.setCustomers(customersToDto(customers));
        return responseResolve;
    }

    //only for test program
    public ResponseResolve setOrders(OrderDto order){
        return orderService.addUpdate(order);
    }

    //convert customers dao to dto
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

    //set full name from first and last names
    private String setFullname(Customer customer){
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(customer.getFirstName()).append(" ").append(customer.getLastName()).toString();
    }

    //return all orders list
    public ResponseResolve getAllOrders() {
        return orderService.getAll();
    }

    //return number of orders by customer ID
    private int getOrdersCountByCustomerId(long id){
        return orderService.getOrdersCountByCustomerId(id);
    }

    //convert customer dto to Dao
    private Customer customerDtoToDao(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setLastName(customerDto.getLastName());
        customer.setFirstName(customerDto.getFirstName());
        customer.setEmail(customerDto.getEmail());
        customer.setAge(customerDto.getAge());
        customer.setCustomerId(customerDto.getCustomerId());
        return customer;
    }


    //return list of customer's order
    public ResponseResolve getOrdersByCustomerId(long id){
        return orderService.getOrdersByCustomerId(id);
    }

    //return order by order ID
    public ResponseResolve getOrderByOrderId(long id){
        return orderService.get(id);
    }
}

