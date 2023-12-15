package com.ptd.apirestaurant.service;

import com.ptd.apirestaurant.entity.OrderDetail;
import com.ptd.apirestaurant.entity.OrderDetailPK;
import com.ptd.apirestaurant.reponsitory.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    public String makeOrder(Map<Integer,Integer> listFood, int orderID){

        try {
            for(Map.Entry<Integer, Integer> entry : listFood.entrySet()) {
                OrderDetailPK orderDetailPK = new OrderDetailPK(entry.getKey(),orderID);
                OrderDetail order = new OrderDetail(orderDetailPK,entry.getValue());
                orderDetailRepository.save(order);
            }
            return "Success";
        }catch (Exception ex){
            return ex.getMessage();
        }

    }
    public List<OrderDetail> getOrderDetailByOrderId(int orderId){
        return orderDetailRepository.findByOrderId(orderId);
    }
}
