package com.ptd.apirestaurant.reponsitory;

import com.ptd.apirestaurant.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    Order findByOrderId(int orderId);

    List<Order> findAll();


    @Query("select o from Order o where o.date = current date ")
    List<Order> getAllOrderToday();
}
