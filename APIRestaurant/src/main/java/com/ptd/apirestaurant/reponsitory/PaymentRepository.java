package com.ptd.apirestaurant.reponsitory;

import com.ptd.apirestaurant.entity.Order;
import com.ptd.apirestaurant.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    List<Payment> findPaymentByOrderId(Order order);
    Payment findPaymentByPaymentId(int idPayment);

    Payment getPaymentByOrderId(Order orderId);

    @Query("select p from Payment p join Order o on p.orderId.orderId = o.orderId where o.date = current date ")
    List<Payment> getAllPaymentToday();

    @Query("select count(p) from Payment p join Order o on o.orderId = p.orderId.orderId where o.date= current date ")
    Integer countAllPaymentToday();
}
