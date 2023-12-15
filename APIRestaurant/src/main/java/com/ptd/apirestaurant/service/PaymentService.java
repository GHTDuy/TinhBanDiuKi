package com.ptd.apirestaurant.service;


import com.ptd.apirestaurant.entity.Order;
import com.ptd.apirestaurant.entity.OrderDetail;
import com.ptd.apirestaurant.entity.Payment;
import com.ptd.apirestaurant.reponsitory.OrderDetailRepository;
import com.ptd.apirestaurant.reponsitory.OrderRepository;
import com.ptd.apirestaurant.reponsitory.PayemntCustomRepository;
import com.ptd.apirestaurant.reponsitory.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    PayemntCustomRepository payemntCustomRepository;

    public String makePayment(int orderId){
        try {
            List<OrderDetail> listDetailOrder = orderDetailRepository.findByOrderId(orderId);

            if(listDetailOrder.size() == 0) return "You have not order food in this order";
            Double totalPrice = 0.0;
            for (OrderDetail o: listDetailOrder){
                totalPrice += o.getAmount()* o.getMenu().getPrice();
            }
            Payment payment = new Payment( null,totalPrice,orderRepository.findByOrderId(orderId),(short) 0);
            paymentRepository.save(payment);
            return "success";
        }catch (Exception exception){
            return exception.getMessage();
        }
    }

    public String confirmPayment(int idPayment){
        try {
            Payment payment = paymentRepository.findPaymentByPaymentId(idPayment);
            if(payment == null) return "Can not find the payment";
            payment.setIsSuccess((short) 1);
            paymentRepository.save(payment);
            return "success";
        }catch (Exception exception){
            return exception.getMessage();
        }
    }

    public  List<Payment> getAllPaymentToday(){
        return paymentRepository.getAllPaymentToday();
    }
    public  Payment getPaymentByOrderId(int orderId){
        Order order = orderRepository.findByOrderId(orderId);
        return paymentRepository.getPaymentByOrderId(order);
    }
    public Integer countPaymentToday(){
        return paymentRepository.countAllPaymentToday();
    }
    public List<Object[]> getListPayementInRange(Map<String, String> param){
        return payemntCustomRepository.totalPaymentInRange(param);
    }
}

