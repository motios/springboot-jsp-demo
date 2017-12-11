package com.luwojtaszek.springbootjsp.web.controller;


import com.luwojtaszek.springbootjsp.dao.Customer;
import com.luwojtaszek.springbootjsp.dao.OrderCust;
import com.luwojtaszek.springbootjsp.dto.CustomerDto;
import com.luwojtaszek.springbootjsp.dto.OrderDto;
import com.luwojtaszek.springbootjsp.service.CustomerService;
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

    /*public CustomersController(){
        if(customerService.dataIsEmpty()){
            addStaticData();
        }
    }*/

    @RequestMapping(value= "/customers",method = RequestMethod.GET)
    public String index(Model model){
       // Map<String, List<Customer>> model = new HashMap<>();
        if(customerService.dataIsEmpty()){
            addStaticData();
        }

        List<CustomerDto> custList = customerService.getAll().getCustomers();
        List<OrderDto> orders = customerService.getAllOrders();
        model.addAttribute("list",custList);

        return  "index";

    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public String customers(@PathVariable("id")long id, Model model){
        CustomerDto customer = id>0 ? customerService.get(id).getCustomers().get(0): new CustomerDto();
        List<OrderDto> orders = customerService.getOrdersByCustomerId(id);
        model.addAttribute("customer", customer);
        model.addAttribute("orders", orders);
        return  "customer";
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute CustomerDto model){
        customerService.addUpdate(model);
        return "customers";
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public String orders(@PathVariable("id")long id, Model model) {
        OrderDto orderDto = id>0 ? customerService.getOrderByOrderId(id).getOrders().get(0): new OrderDto();
        model.addAttribute("order",orderDto);
        return "order";

    }

    private void addStaticData(){
        customerService.addUpdate(new CustomerDto("test1@gmail.com","first1","last1",25));
        customerService.addUpdate(new CustomerDto("test2@gmail.com","first2","last2",36));
        customerService.addUpdate(new CustomerDto("test3@gmail.com","first3","last3",47));

        customerService.setOrders(new OrderDto(LocalDateTime.now(), "laptop",150.90,1,1));
        customerService.setOrders(new OrderDto(LocalDateTime.now(), "mouse",15.29,1,1));
        customerService.setOrders(new OrderDto(LocalDateTime.now(), "headset",5.87,2,1));
        customerService.setOrders(new OrderDto(LocalDateTime.now(), "desktop",159.29,1,2));
        customerService.setOrders(new OrderDto(LocalDateTime.now(), "monitor",115.45,1,2));
        customerService.setOrders(new OrderDto(LocalDateTime.now(), "mobile phone",890.29,1,3));
    }


}
