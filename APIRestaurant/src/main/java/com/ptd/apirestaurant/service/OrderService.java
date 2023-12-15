package com.ptd.apirestaurant.service;


import com.ptd.apirestaurant.entity.*;
import com.ptd.apirestaurant.reponsitory.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    TableRepository tableRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    MenuRepository menuRepository;

    public Order addOrder(Order order) {
        order.setStatus("WAITING");
        Table table = tableRepository.findByTableId(order.getTableId().getTableId());
        table.setIsAvilable((short) 0);
        tableRepository.save(table);
        return orderRepository.save(order);
    }

    public String requestToChangeTable(int idOrder, int idTableToChange) {
        Order order = orderRepository.findByOrderId(idOrder);
        Table table = tableRepository.findByTableId(idTableToChange);
        if (table.getIsAvilable() == 0) return "This table is not available";
        else {
            try {
                order.setTableId(table);
                Table oldTable = tableRepository.findByTableId(order.getTableId().getTableId());
                oldTable.setIsAvilable((short) 1);
                table.setIsAvilable((short) 0);
                tableRepository.save(oldTable);
                tableRepository.save(table);
                orderRepository.save(order);
                return "Success";
            } catch (Exception ex) {
                return ex.getMessage();
            }
        }
    }

    public boolean finshOrder(int idOrder) {
        try {
            Order order = orderRepository.findByOrderId(idOrder);
            order.setStatus("FINISH");
            orderRepository.save(order);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public String deleteOrder(int orderId) {
        try {
            Order order = orderRepository.findByOrderId(orderId);
            if (order != null && order.getDisabled() == false) {
                List<Payment> payment = paymentRepository.findPaymentByOrderId(order);
                if (payment.size() == 0) {
                    order.setDisabled(true);
                    return "Delete success";
                } else return "The order had been payed";
            } else
                return "Cant find the order";
        } catch (Exception ex) {
            return ex.getMessage();
        }

    }

    public String acceptOrDennyOrder(int orderID,int type) {
        try {
            Order o = orderRepository.findByOrderId(orderID);
            if (o != null) {
                if(type == 1)
                    o.setStatus("ACCEPTED");
                else
                    o.setStatus("CANCELLED");
                if(orderRepository.save(o) != null)
                    return "success";
                else
                    return "fail";
            }
            return "Can not find the order";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public  List<Order> getAllOrderToday(){
        return orderRepository.getAllOrderToday();
    }

    public Double  getTotalPriceOfOrder(int orderID){
        Order order = orderRepository.findByOrderId(orderID);
        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(orderID);
        double totalPrice = 0.0;
        for(OrderDetail od : orderDetails) {
            Menu m = menuRepository.findMenuByProductId(od.getMenu().getProductId());
            totalPrice += od.getAmount() * m.getPrice();
        }
        return totalPrice;
    }
}
