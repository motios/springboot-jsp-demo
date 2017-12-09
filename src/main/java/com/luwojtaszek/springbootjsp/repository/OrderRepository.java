package com.luwojtaszek.springbootjsp.repository;


import com.luwojtaszek.springbootjsp.dao.OrderCust;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderCust, Long>{
    @Query("select COUNT(*) from OrderCust where customerId=:customerId")
    public int findOrderByCustomerId(@Param("customerId") long customerId);
}
