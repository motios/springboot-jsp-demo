package com.luwojtaszek.springbootjsp.web.controller;


import com.luwojtaszek.springbootjsp.dao.Customer;
import com.luwojtaszek.springbootjsp.dao.OrderCust;
import com.luwojtaszek.springbootjsp.dto.CustomerDto;
import com.luwojtaszek.springbootjsp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class CustomersController {
    @Autowired
    CustomerService customerService;

    //@GetMapping("/index.jsp")
    //@RequestMapping(value="/index.jsp",method=RequestMethod.GET)
    @RequestMapping("/")
    public String index(Model model){
       // Map<String, List<Customer>> model = new HashMap<>();
        if(customerService.dataIsEmpty()){
            addStaticData();
        }

        //Customer cust = null;
        /*for (Customer customer: customerService.getAll().getCustomers()){
            model.put(customer.getFirstName()+" " +customer.getLastname(), customer);
            cust=customer;
        }*/
        List<CustomerDto> custList = customerService.getAll().getCustomers();

        List<OrderCust> orders = customerService.getAllOrders();
        model.addAttribute("list",custList);
        //model.put("name", "Moti");
        return  "index";

    }

    private void addStaticData(){
        customerService.addUpdate(new Customer("test1@gmail.com","first1","last1",25));
        customerService.addUpdate(new Customer("test2@gmail.com","first2","last2",36));
        customerService.addUpdate(new Customer("test3@gmail.com","first3","last3",47));

        customerService.setOrders(new OrderCust(LocalDateTime.now(), "laptop",150.90,1,1));
        customerService.setOrders(new OrderCust(LocalDateTime.now(), "mouse",15.29,1,1));
        customerService.setOrders(new OrderCust(LocalDateTime.now(), "headset",5.87,2,1));

        customerService.setOrders(new OrderCust(LocalDateTime.now(), "desktop",159.29,1,2));
        customerService.setOrders(new OrderCust(LocalDateTime.now(), "monitor",115.45,1,2));

        customerService.setOrders(new OrderCust(LocalDateTime.now(), "mobile phone",890.29,1,3));
    }
}