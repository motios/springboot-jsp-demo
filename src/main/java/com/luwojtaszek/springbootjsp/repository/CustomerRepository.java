package com.luwojtaszek.springbootjsp.repository;


import com.luwojtaszek.springbootjsp.dao.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
