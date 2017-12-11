package com.momah.springbootjsp.web.controller;

import com.momah.springbootjsp.dto.OrderDto;
import com.momah.springbootjsp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id")long id, Model model) {
        OrderDto orderDto = id>0 ? orderService.get(id).getOrders().get(0): new OrderDto();
        model.addAttribute("order", orderDto);
        return "order";

    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute OrderDto model){
        orderService.addUpdate(model);
        return "customers";
    }
}
