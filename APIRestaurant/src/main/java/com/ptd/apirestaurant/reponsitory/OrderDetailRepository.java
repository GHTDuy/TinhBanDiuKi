package com.ptd.apirestaurant.reponsitory;


import com.ptd.apirestaurant.entity.OrderDetail;
import com.ptd.apirestaurant.entity.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {
    List<OrderDetail> findByOrderId(int orderId);
}
