package com.luwojtaszek.springbootjsp;

import com.luwojtaszek.springbootjsp.dao.Customer;
import com.luwojtaszek.springbootjsp.dao.OrderCust;
import com.luwojtaszek.springbootjsp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringBootJspApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootJspApplication.class, args);

	}


}
