package com.momah.springbootjsp.web.controller;

import com.momah.springbootjsp.Utils.ResponseResolve;
import com.momah.springbootjsp.dto.CustomerDto;
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

    //get order by orderid, oustomerid, if is new order => set customerId
    @RequestMapping(value = "/orders/{id}/customer/{cid}", method = RequestMethod.GET)
    public String getOrder(@PathVariable("id")long id,@PathVariable("cid")long cid, Model model) {
        if(cid>0) {
            OrderDto orderDto = id > 0 ? orderService.get(id).getOrders().get(0) : new OrderDto(cid);
            model.addAttribute("order", orderDto);
            return "order";
        }
        else{
            return "/customers";
        }
    }

    //update / add order
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute OrderDto modelDto,Model model ){
        ResponseResolve responseResolve = orderService.addUpdate(modelDto);
        model.addAttribute("responseMessage",responseResolve.getDescroption());
        return "redirect:/customers/"+modelDto.getCustomerId();
    }
}
