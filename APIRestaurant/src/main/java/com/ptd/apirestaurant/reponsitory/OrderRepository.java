package com.ptd.apirestaurant.reponsitory;

import com.ptd.apirestaurant.entity.Order;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    Order findByOrderId(int orderId);

    List<Order> findAll();

    @Modifying
    @Query(value = "insert into  restaurant_management.table(order_id,date,customer_id,table_id,employee_id,is_disabled,status) " +
            "VALUES (:id,:date,:cid,:tid,:eid,:isdis,:status)", nativeQuery = true)

    List <Order> insertattributes(@Param("id")int id, @Param("date") String date , @Param("cid")int cusid, @Param("tid") int tableid,@Param("eid") int employeeid, @Param("isdis") int isdis, @Param("status") String status);
}
