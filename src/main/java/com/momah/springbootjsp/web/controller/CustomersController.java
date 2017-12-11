package com.momah.springbootjsp.web.controller;


import com.momah.springbootjsp.dto.CustomerDto;

import com.momah.springbootjsp.dto.OrderDto;
import com.momah.springbootjsp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class CustomersController {
    @Autowired
    private CustomerService customerService;

    //get all customers, set first data to db
    @RequestMapping(value= "/customers",method = RequestMethod.GET)
    public String getCustomers(Model model){
        //add data to memoryDB(first time on start)
        if(customerService.dataIsEmpty()){
            addStaticData();
        }
        List<CustomerDto> custList = customerService.getAll().getCustomers();
        model.addAttribute("list",custList);
        return  "index";
    }

    //get customer with orders
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public String getCustomer(@PathVariable("id")long id, Model model){
        CustomerDto customer = id>0 ? customerService.get(id).getCustomers().get(0): new CustomerDto();
        List<OrderDto> orders = customerService.getOrdersByCustomerId(id).getOrders();
        model.addAttribute("customer", customer);
        model.addAttribute("orders", orders);
        return  "customer";
    }

    //update/add customer
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute CustomerDto model){
        customerService.addUpdate(model);
        return "redirect:/customers";
    }

    //add data to memoryDB(first time on start)
    private void addStaticData(){
        //add customers
        customerService.addUpdate(new CustomerDto("test1@gmail.com","first1","last1",25));
        customerService.addUpdate(new CustomerDto("test2@gmail.com","first2","last2",36));
        customerService.addUpdate(new CustomerDto("test3@gmail.com","first3","last3",47));

        //add orders
        customerService.setOrders(new OrderDto(LocalDateTime.now().toString(), "laptop",150.90,2,1));
        customerService.setOrders(new OrderDto(LocalDateTime.now().toString(), "mouse",15.29,1,1));
        customerService.setOrders(new OrderDto(LocalDateTime.now().toString(), "headset",5.87,2,1));
        customerService.setOrders(new OrderDto(LocalDateTime.now().toString(), "desktop",159.29,7,2));
        customerService.setOrders(new OrderDto(LocalDateTime.now().toString(), "monitor",115.45,4,2));
        customerService.setOrders(new OrderDto(LocalDateTime.now().toString(), "mobile phone",890.29,2,3));
    }


}
