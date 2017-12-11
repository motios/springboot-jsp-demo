package com.luwojtaszek.springbootjsp.repository;


import com.luwojtaszek.springbootjsp.dao.OrderCust;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderCust, Long>{
    @Query("select COUNT(*) from OrderCust where customerId=:customerId")
    public int ordersCountByCustomerId(@Param("customerId") long customerId);

    @Query(" from OrderCust where customerId=:customerId")
    public List<OrderCust> getOrderByCustomerId(@Param("customerId") long customerId);

}
